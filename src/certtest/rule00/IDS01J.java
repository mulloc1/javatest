package certtest.rule00;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 문자열 유효성을 검사하기 전 정규화를 해라.
public class IDS01J {
    public static void main(String args[]) {
        String s = "\uFE64" + "script" + "\uFE65";

        s = Normalizer.normalize(s, Normalizer.Form.NFKC);
        Pattern pattern = Pattern.compile("[<>]");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            throw new IllegalStateException();
        } else {
            System.out.println("invalid string");
        }
    }
}

/*
해당 예제는 애플리케이션이 입력받은 문자열에 대한 정규표현식을 검사할 때
정규화를 먼저하고 정규표현식을 처리해야 올바른 순서라고 이야기하고 있다.
 */