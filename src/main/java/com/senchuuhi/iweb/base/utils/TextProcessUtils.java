package com.senchuuhi.iweb.base.utils;

public class TextProcessUtils {

    //任意html，残缺不全也可以
    public static String parseHtml(String html, int length) {
        /*
         * <.*?>为正则表达式，其中的.表示任意字符，*?表示出现0次或0次以上，此方法可以去掉双头标签(双头针对于残缺的标签)
         * "<.*?"表示<尖括号后的所有字符，此方法可以去掉残缺的标签，及后面的内容
         * " "，若有多种此种字符，可用同一方法去除
         */

        html = html.replaceAll("<.*?>", "  ").replaceAll(" ", " ");
        html = html.replaceAll("<.*?", "");
        // 去除空格
        html = html.replaceAll(" ","");
        if(html.length() > length){
            html = html.substring(0, length);
        }
        return (html + "...");
    }

    //可以指定截取长度
    public static String parseHtml(String html) {

        return parseHtml(html, -1);
    }
}
