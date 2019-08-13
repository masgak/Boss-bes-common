import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * 用于分割字符串，返回分割后的字符数组
     * @param content “需要分割的字符串”
     * @param len “分割长度”
     * @return “分割后的字符数组”
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
            String[] str = new String[i];
            int j = 0;
            int begin;
            int end;
            while (j < i) {
                begin = j * len;
                end = (j + 1) * len;
                if (end > len2){
                    end = len2;
                }
                str[j] = content.substring(begin, end);
                // System.out.println(strA[j]+"<br/>");
                j = j + 1;
            }
            return str;
        }
    }

    /**
     * 验证是不是EMAIL
     * @param email “传入验证字符串”
     * @return retval ”返回验证结果“
     */
    public static boolean isEmail(String email) {
        boolean retval;
        String check = "^([a-z0-9A-Z]+[-|_.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        retval = matcher.matches();
        return retval;
    }

    /**
     * 验证是否为数字或字母
     * @param str “传入需要验证的字符串”
     * @return "返回验证结果"
     */
    public static boolean isLetterOrDigit(String str) {
        //正则表达式
        java.util.regex.Pattern p ;
        // 操作的字符串
        java.util.regex.Matcher m ;
        boolean value = true;
        try {
            p = java.util.regex.Pattern.compile("[^0-9A-Za-z]");
            m = p.matcher(str);
            if (m.find()) {
                value = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
