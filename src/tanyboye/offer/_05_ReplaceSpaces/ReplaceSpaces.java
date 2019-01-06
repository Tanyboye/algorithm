package tanyboye.offer._05_ReplaceSpaces;

/**
 * @author: chengbg
 * @date: 2019/1/6
 * 请实现一个函数，把字符串中的每个空格替换成“%20”。
 * 例如，输入“We are happy!”，则输出“We%20are%20happy!”
 **/
public class ReplaceSpaces {
    public static String replace(String s) {
        //String str = s.replaceAll(" ", "%20");
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (' ' == (s.charAt(i))) {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        String str = stringBuilder.toString();
        return str;
    }

    public static void main(String[] args) {
        String s = "We are happy!";
        String str = replace(s);
        System.out.println(str);
    }
}
