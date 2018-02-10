package com.cgzdh.buss.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;

public class FilePathUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(FilePathUtil.class);
	/**
	 * 获取pdf文件存放目录
	 * */
	public static String getPdfPath() {
		boolean iscompress = false;
		String path = "";
		try {
			path = FilePathUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
			LOGGER.debug("excel模版path={}", path);
			path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
			LOGGER.debug("excel模版path={}", path);
			path = java.net.URLDecoder.decode(path, "UTF-8");// 转换处理中文及空格
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf("file:\\") > -1) {
				path = path.substring("file:".length());
			}
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf("file:/") > -1) {
				path = path.substring("file:".length());
			}
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf(".war") > -1) {
				path = path.substring(0, path.indexOf(".war") + ".war".length());
				LOGGER.debug("excel模版path={}", path);
				path = new File(path).getParentFile().getAbsolutePath();
				LOGGER.debug("excel模版path={}", path);
				iscompress = true;
			}
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf(".jar") > -1) {
				path = path.substring(0, path.indexOf(".jar") + ".jar".length());
				path = new File(path).getParentFile().getAbsolutePath();
				iscompress = true;
			}
			LOGGER.debug("excel模版path={}", path);

		} catch (java.io.UnsupportedEncodingException e) {
			path = FilePathUtil.class.getClass().getResource("/").getPath() + "/";
			LOGGER.debug("excel模版CompanyApplyRestController=path={}", path);
		}
		String pdfPath;
		if (iscompress) {
			pdfPath = path + "/cademo/pdf/";
		} else {
			pdfPath = path.replace("target/classes/", "src/main/resources/cademo/pdf/");
		}
		LOGGER.debug("pdf文件目录pdfPath={}", pdfPath);
		return pdfPath;
	}
	
	/**
	 * 获取pdf压缩zip包时的路径文件存放目录
	 * */
	public static String getZipPath() {
		boolean iscompress = false;
		String path = "";
		try {
			path = FilePathUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
			LOGGER.debug("excel模版path={}", path);
			path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
			LOGGER.debug("excel模版path={}", path);
			path = java.net.URLDecoder.decode(path, "UTF-8");// 转换处理中文及空格
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf("file:\\") > -1) {
				path = path.substring("file:".length());
			}
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf("file:/") > -1) {
				path = path.substring("file:".length());
			}
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf(".war") > -1) {
				path = path.substring(0, path.indexOf(".war") + ".war".length());
				LOGGER.debug("excel模版path={}", path);
				path = new File(path).getParentFile().getAbsolutePath();
				LOGGER.debug("excel模版path={}", path);
				iscompress = true;
			}
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf(".jar") > -1) {
				path = path.substring(0, path.indexOf(".jar") + ".jar".length());
				path = new File(path).getParentFile().getAbsolutePath();
				iscompress = true;
			}
			LOGGER.debug("excel模版path={}", path);

		} catch (java.io.UnsupportedEncodingException e) {
			path = FilePathUtil.class.getClass().getResource("/").getPath() + "/";
			LOGGER.debug("excel模版CompanyApplyRestController=path={}", path);
		}
		String pdfPath;
		if (iscompress) {
			pdfPath = path + "/zip/";
		} else {
			pdfPath = path.replace("target/classes/", "src/main/resources/zip/");
		}
		LOGGER.debug("pdf文件目录pdfPath={}", pdfPath);
		return pdfPath;
	}
	
	/**
	 * 获取pdf压缩zip包时的路径文件存放目录
	 * */
	public static String getConfigPath() {
		boolean iscompress = false;
		String path = "";
		try {
			path = FilePathUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
			LOGGER.debug("excel模版path={}", path);
			path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
			LOGGER.debug("excel模版path={}", path);
			path = java.net.URLDecoder.decode(path, "UTF-8");// 转换处理中文及空格
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf("file:\\") > -1) {
				path = path.substring("file:".length());
			}
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf("file:/") > -1) {
				path = path.substring("file:".length());
			}
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf(".war") > -1) {
				path = path.substring(0, path.indexOf(".war") + ".war".length());
				LOGGER.debug("excel模版path={}", path);
				path = new File(path).getParentFile().getAbsolutePath();
				LOGGER.debug("excel模版path={}", path);
				iscompress = true;
			}
			LOGGER.debug("excel模版path={}", path);
			if (path.indexOf(".jar") > -1) {
				path = path.substring(0, path.indexOf(".jar") + ".jar".length());
				path = new File(path).getParentFile().getAbsolutePath();
				iscompress = true;
			}
			LOGGER.debug("excel模版path={}", path);

		} catch (java.io.UnsupportedEncodingException e) {
			path = FilePathUtil.class.getClass().getResource("/").getPath() + "/";
			LOGGER.debug("excel模版CompanyApplyRestController=path={}", path);
		}
		String pdfPath;
		if (iscompress) {
			pdfPath = path + "/cademo/";
		} else {
			pdfPath = path.replace("target/classes/", "src/main/resources/cademo/");
		}
		LOGGER.debug("pdf文件目录config={}", pdfPath);
		return pdfPath;
	}
	
}
