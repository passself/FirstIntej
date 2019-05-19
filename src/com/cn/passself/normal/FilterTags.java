package com.cn.passself.normal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterTags {

    public static List getContext(String html) {
        List resultList = new ArrayList();
        Pattern p = Pattern.compile("<em>([^</em>]*)");//匹配<title>开头，</title>结尾的文档
        Matcher m = p.matcher(html );//开始编译
        while (m.find()) {
            resultList.add(m.group(1));//获取被匹配的部分
        }
        return resultList;
    }

    public static void main(String[] args) {
        String content = "<em>新华网</em>专访<em>华夏</em><em>信</em>财李彬：<em>金融</em>的圣经是《巴赛尔协议》";
        List resultList = getContext(content);
        for (Iterator iterator = resultList.iterator(); iterator.hasNext();) {
            String context = (String) iterator.next();
            System.out.println(context);
        }

        System.out.println("dsad"+deleteHtmlTag(content,"em"));
        System.out.println("-->"+replaceAllTag(content));
        System.out.println("11-->"+deleteHtmlTag(content));
        System.out.println("112-->"+fiterHtmlTag(content,"em"));
        System.out.println("1123-->"+content.replace("<em>","").replaceAll("</em>",""));
    }

    public static String filterAllTag(String content,String tag){
        return content.replaceAll("<"+tag+" .*?>", "");
    }

    public static String replaceAllTag(String content){
        return content.replaceAll("<em .*?>", "");
    }


    public static String deleteHtmlTag(String content,String tag){
        //String regEx_script="<"+tag+"[^>]*?>[\\s\\S]*?<\\/\"+tag+\">"; //定义script的正则表达式
        String regEx_style="<"+tag+"[^>]*?>[\\s\\S]*?<\\/"+tag+">";
        Pattern p_html=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(content);
        return  m_html.replaceAll(""); //过滤html标签
    }

    public static String deleteHtmlTag(String content){
        //String regEx_script="<em[^>]*?>[\\s\\S]*?<\\/em>"; //定义script的正则表达式
        String regEx_style="<em[^>]*?>[\\s\\S]*?<\\/em>";
        Pattern p_html=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(content);
        return  m_html.replaceAll(""); //过滤html标签
    }

    public static String fiterHtmlTag(String str, String tag) {
        String regxp = "<\\s*" + tag + "\\s+([^>]*)\\s*>";
        Pattern pattern = Pattern.compile(regxp);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1) {
            matcher.appendReplacement(sb, "");
            result1 = matcher.find();
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}



