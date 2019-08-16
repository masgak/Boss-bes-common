package com.bosssoft.hr.train.utils;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * 用于与加密解密以及文件格式转换有关的接口
 * @author : wukeqiang
 * @date : 2019/8/15
 * @version : 1.0.0
 */
public class EncodeUtils {
    /**
     * md5加密
     * @param s'需要加密的字符串'
     * @return
     */
    public final static String md5(String s) {
        char []hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] btInput = s.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char []str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * base64加密
     * @param str‘需要加密的字符串’
     * @return
     */
    public static String base64Encode(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = Base64.encodeBase64String(b);
        }
        return s;
    }

    /**
     * base64解密 加盐
     * @param str‘需要加密的字符串’
     * @return
     */
    public static String base64Decode(String str) {
        String s = null;
        byte[] b = Base64.decodeBase64(str);
        try {
            s = new String(b, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 数据导出excel时，根据不同的客户端请求浏览器转换文件名，以防止出现乱码
     * @param req ‘网络端请求’
     * @param fileName '导出文件名'
     * @return String ‘新生成的文件名’
     * @throws UnsupportedEncodingException
     */
    public static String transferFileName(HttpServletRequest req, String fileName) throws UnsupportedEncodingException {
        String exportFileName = "";
        if (isFirefoxBrowse(req)) {
            //火狐浏览器
            exportFileName = new String(fileName.getBytes(), "ISO8859-1");
        } else {
            //其他浏览器
            exportFileName = URLEncoder.encode(fileName, "UTF8");
        }
        return exportFileName;
    }

    /**
     * 判断客户端请求是否是火狐浏览器
     * @param req‘文件请求’
     * @return boolean
     */
    public static boolean isFirefoxBrowse(HttpServletRequest req) {
        String browseName = "Firefox";
        String userAgent = req.getHeader("USER-AGENT");
        //火狐浏览器
        if (userAgent.indexOf(browseName) != -1) {
            return true;
        } else {
            //其他浏览器
            return false;
        }
    }
}
