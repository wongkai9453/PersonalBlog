//package com.system.test;
//
//import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;
//import org.pegdown.PegDownProcessor;
//
//import java.io.*;
//
///**
// * @author wk
// * @title: MarkDownTest
// * @projectName themsealf-system
// * @description: TODO
// * @date 2020/5/921:36
// */
//public class MarkDownTest {
//    public void generateHtml(File mdFile) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(mdFile), "UTF-8"));
//        String line = null;
//        String mdContent = "";
//        while ((line = br.readLine()) != null) {
//            mdContent += line + "\r\n";
//        }
//        PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
//        String htmlContent = pdp.markdownToHtml(mdContent);
//        System.out.println(htmlContent);
//    }
//
//
////    public static void main(String[] args) throws IOException {
////        MarkDownTest pageGenerator = new MarkDownTest();
////        pageGenerator.generateHtml(new File("E:\\20181125我的第一篇博客.md"));
////    }
//
//    public static void main(String[] args) {
//        AtxMarkdownToc.newInstance().genTocFile("E:\\2.md");
//    }
//}
