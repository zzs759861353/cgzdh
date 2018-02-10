package com.cgzdh.buss.util;

import com.cgzdh.buss.constant.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author v_bbojiang
 */
public final class HttpClientHelper {

	private static PoolingHttpClientConnectionManager connectionManager;

	static {
		Registry<ConnectionSocketFactory> r = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", SSLConnectionSocketFactory.getSocketFactory()).build();

		HttpClientHelper.connectionManager = new PoolingHttpClientConnectionManager(r);
		HttpClientHelper.connectionManager.setMaxTotal(300);
		HttpClientHelper.connectionManager.setDefaultMaxPerRoute(30);

		new IdleConnectionMonitorThread(HttpClientHelper.connectionManager).start();
	}

	private CloseableHttpClient httpClient;

	private HttpClientHelper() {
		httpClient = HttpClients.custom().setConnectionManager(HttpClientHelper.connectionManager).build();
	}

	public static HttpClientHelper create() {
		return new HttpClientHelper();
	}

	/**
	 * @param params
	 *            http body内容
	 * @param url
	 *            http url
	 * @param retryNumber
	 *            失败重试次数
	 * @return success:http response String fail:null
	 */
	public String execute(String params, String url, int retryNumber, String charset) {

		HttpPost request = new HttpPost(url);
		request.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

		if (!params.isEmpty()) {
			HttpEntity entity  = new StringEntity(params, charset);
			request.setEntity(entity);
		}
		
		String result = HttpHelper.execute(httpClient, request);

		if (result == null && retryNumber > 0) {
			return execute(params, url, retryNumber - 1);
		}

		return result;
	}

	public String execute(String params, String url, int retryNumber) {
		return execute(params, url, retryNumber, Constants.CHARSET);
	}

	public String execute(String params, String url) {
		return execute(params, url, 0);
	}

	public String execute(List<NameValuePair> params, String url, int retryNumber) {
		return execute(URLEncodedUtils.format(params, Constants.CHARSET), url, retryNumber);
	}

	public String execute(Map<String, String> params, String url) {
		return execute(HttpHelper.generateBody(params), url, 0);
	}
	public String executeForGET(String url, int retryNumber, String charset) {

		HttpGet request = new HttpGet(url);
		request.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

		String result = HttpHelper.execute(httpClient, request);

		if (result == null && retryNumber > 0) {
			return executeForGET(url,  retryNumber,  charset);
		}

		return result;
	}
	/**
	 * 该线程用于清理过期和空闲的连接
	 */
	private static class IdleConnectionMonitorThread extends Thread {

		private final HttpClientConnectionManager connMgr;
		private volatile boolean shutdown;

		public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
			super();
			this.connMgr = connMgr;
		}

		@Override
		public void run() {
			try {
				while (!shutdown) {
					synchronized (this) {
						wait(6000);
						// 关闭失效连接
						connMgr.closeExpiredConnections();
						// 关闭空闲超过30秒的连接
						connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
					}
				}
			} catch (InterruptedException ex) {
			}
		}
	}

}
