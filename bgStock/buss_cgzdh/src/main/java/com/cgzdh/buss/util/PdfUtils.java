package com.cgzdh.buss.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Locale;
import java.util.Map;

public class PdfUtils {


    /**
     * 使用freemarker得到html内容
     * @param ftlPath 文件路径
     * @param ftlName 文件名称
     * @param params 参数
     * @return  html页面
     * @throws Exception
     */
    public  String useTemplate(String ftlPath, String ftlName, Object params) throws  Exception{
        try {

            Template tpl = getFreemarkerConfig(ftlPath).getTemplate(ftlName);

            StringWriter writer = new StringWriter();
            tpl.process(params, writer);
            writer.flush();
            String html = writer.toString();
            return html;
        }catch (Exception exception){
            throw new Exception("转换pdf过程中出错");
        }

    }

    /**
     * 获取Freemarker配置
     * @param templatePath 模板路径
     * @return Freemarker配置
     * @throws IOException
     */
    private static Configuration getFreemarkerConfig(String templatePath) throws IOException {
        freemarker.template.Version version = new freemarker.template.Version("2.3.23");
        Configuration config = new Configuration(version);
        config.setDirectoryForTemplateLoading(new File(templatePath));
        config.setEncoding(Locale.CHINA, "utf-8");
        return config;
    }

    /***
     *  添加中文支持
     * @return
     * @throws Exception
     */
    public static ITextRenderer getRender() throws Exception {

        ITextRenderer render = new ITextRenderer();

        String path = getPath();
        System.out.println(path);
        //添加字体，以支持中文
//        render.getFontResolver().addFont(path+ "/arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//        render.getFontResolver().addFont( path+ "/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        return render;
    }

    /**
     * 获取要写入PDF的内容
     * @param ftlPath
     * @param ftlName
     * @param params
     * @return
     * @throws Exception
     */
    public  String getPdfContent(String ftlPath, String ftlName, Object params) throws Exception {
        return useTemplate(ftlPath, ftlName, params);
    }

    /**
     * 获取类路径
     * @return
     */
    public static String getPath(){
        return PdfUtils.class.getResource("/").getPath().substring(1);
    }

    /**
     * 生成PDF到文件
     * @param ftlPath 模板文件路径（不含文件名）
     * @param ftlName 模板文件吗（不含路径）
     * @param data 数据
     * @param outputFile 目标文件（全路径名称）
     * @throws Exception
     */
    public  void generateToFile(String ftlPath,String ftlName, Map<String,Object> data,String outputFile) throws Exception {
        String html=getPdfContent(ftlPath, ftlName, data);
        OutputStream out = null;
        ITextRenderer render = null;
        out = new FileOutputStream(outputFile);
        render = getRender();
        render.setDocumentFromString(html);
        render.layout();
        render.createPDF(out);
        render.finishPDF();
        out.close();
    }

    /**
     * 生成PDF到输出流中（ServletOutputStream用于下载PDF）
     * @param ftlPath ftl模板文件的路径（不含文件名）
     * @param ftlName ftl模板文件的名称（不含路径）
     * @param data 输入到FTL中的数据
     * @return
     */
    public  OutputStream generateToOutputStream(String ftlPath, String ftlName, Map<String,Object> data, OutputStream out) throws Exception{
        String html= getPdfContent(ftlPath, ftlName, data);
        ITextRenderer render =  getRender();
        render.setDocumentFromString(html);
        render.layout();
        render.createPDF(out);
        render.finishPDF();
        return out;
    }


}
