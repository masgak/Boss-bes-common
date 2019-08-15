package com.bosssoft.hr.train.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用于与字符串操作有关的接口
 * @author : wukeqiang
 * @date : 2019/8/15
 * @version : 1.0.0
 */
public class StringUtils {

    /**
     * 用于分割字符串
     * @param content'需要分割的字符串'
     * @param len‘字符串分割长度’
     * @return ‘分割后的字符数组’splitContent
     */
    public static String[] split(String content, int len) {
        if (content == null || ("").equals(content)) {
            return null;
        }
        int len2 = content.length();
        if (len2 <= len) {
            return new String[] { content };
        } else {
            int i = len2 / len + 1;
            System.out.println("i:" + i);
            String[] splitContent = new String[i];
            int j = 0;
            int begin = 0;
            int end = 0;
            while (j < i) {
                begin = j * len;
                end = (j + 1) * len;
                if (end > len2){
                    end = len2;
                }
                splitContent[j] = content.substring(begin, end);
                j = j + 1;
            }
            return splitContent;
        }
    }

    /**
     * 验证是不是EMAIL
     * @param '需要验证的邮箱账号'email
     * @return
     */
    public static boolean isEmail(String email) {
        boolean retval = false;
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        retval = matcher.matches();
        return retval;
    }

    /**
     * 验证是不是手机账号
     * @param '需要验证的手机账号'phone
     * @return
     */
    public static boolean isPhoneNum(String phone) {
        boolean retval = false;
        String check = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(phone);
        retval = matcher.matches();
        return retval;
    }

    /**
     * 验证字符串是否为汉字
     * @param '需要验证的字符串'character
     * @return 是汉字返回TRUE
     */

    public static boolean isLetterorDigit(String character) {
        if (("").equals(character) || character == null) {
            return false;
        }
        for (int i = 0; i < character.length(); i++) {
            if (!Character.isLetterOrDigit(character.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证字符串是否为空
     * @param ‘需要验证的字符串’param
     * @return
     */
    public static boolean empty(String param) {
        return param == null || param.trim().length() < 1;
    }

    /**
     * 字符串全文替换
     * @param '在该字符串内替换'content
     * @param '被替换的字符串'oldstr
     * @param '新字符串'newstr
     * @return
     */
    public static String replaceAll(String content, String oldstr, String newstr) {
        if (content == null || ("").equals(content.trim())) {
            return null;
        }
        StringBuffer sb = new StringBuffer(content);
        int begin = 0;
        begin = content.indexOf(oldstr);
        while (begin > -1) {
            sb = sb.replace(begin, begin + oldstr.length(), newstr);
            content = sb.toString();
            begin = content.indexOf(oldstr, begin + newstr.length());
        }
        return content;
    }

    /**
     * 将字符串中敏感字符进行替换
     * @param str
     * @return
     */
    public static String toHtml(String str) {
        String html = str;
        if (str == null || str.length() == 0) {
            return str;
        }
        html = replaceAll(html, "&", "&amp;");
        html = replaceAll(html, "<", "&lt;");
        html = replaceAll(html, ">", "&gt;");
        html = replaceAll(html, "\r\n", "\n");
        html = replaceAll(html, "\n", "<br>\n");
        html = replaceAll(html, "\t", "         ");
        html = replaceAll(html, " ", "&nbsp;");
        return html;
    }

    /**
     * 防SQL注入，若字符串中有sql关键字返回true
     *
     * @param str'需要检测的字符串'
     * @return '
     */
    public static boolean avoidSql(String str) {
        String sqlKey = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
        String[] keyNum = sqlKey.split("|");
        for (int i=0 ; i < keyNum.length ; i++ )
        {
            if (str.indexOf(keyNum[i])>=0)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 生成五位随机数
     * @return 加密值
     */
    public static String randomNum(){
        return (int) ((Math.random()*9+1)*100000)+"";
    }

}
