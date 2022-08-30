package certtest.rule00;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//유효성 검사 전에 문자열 수정을 수행한다.
public class IDS11J {
    public static String filterString(String str) {
        String s = Normalizer.normalize(str, Normalizer.Form.NFKC);
        s = s.replaceAll("[\\p{Cn}]", "");

        Pattern pattern = Pattern.compile("<script>");
        Matcher matchar = pattern.matcher(s);
        if (matchar.find()) {
            throw new IllegalStateException("Invalid input");
        }
        return (s);
    }

    public static void main(String[] args) {
        String maliciousInput = "<scr" + "\uFDEF" + "ipt>";
        String sb = filterString(maliciousInput);
        System.out.println(sb);
    }
}

/*
유효성 검사 이후 문자열 수정이 발생하면 공격자가 유효성 검사를 우회할 수 있는 여지가 생긴다.
가령 XSS(교차 사이트 스크립팅) 및 기타 취약성을 피하기 위해서 HTML 입력에서 script
태그를 감지하지 못하게 중간에 !를 붙인다. <script>"<scr!ipt>"<script><script>
만일 태크 사이에 있는 !를 먼저 제거하지 않고 유효성 검사를 하고 이후에 !를 지우면 입력에
해당 태그가 생겨나게 된다.
 */