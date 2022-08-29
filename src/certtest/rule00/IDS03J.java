package certtest.rule00;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 정제되지 않은 사용자 입력을 기록하지 마라.
public class IDS03J {

    public static String sanitizeUser(String username) {
        return Pattern.matches("[A-Za-z0-9_]+", username)
            ? username : "unauthorized user";
    }

    public static void main(String args[]) {
        boolean loginSuccessful = true;
        String username = "username";

        if (loginSuccessful == true) {
            System.out.println("User login succeeded for: " + username);
        } else {
            System.out.println("User login failed for: " + username);
        }

        if (loginSuccessful) {
            System.out.println("User login succeeded for: " + sanitizeUser(username));
        } else {
            System.out.println("User login failed for: " + sanitizeUser(username));
        }

//        Logger sanLogger = new SanitizedTextLogger(new Logger("aaa", "aaa"));
//
//        if (loginSuccessful) {
//            sanLogger.severe("User login succeeded for: " + username);
//        } else {
//            sanLogger.severe("User login failed forL: " + username);
//        }
    }
}

/*
해당 예제는 log4j 취약점의 문제에 관련한 내용을 설명하고 있는 듯 하다.
사용자 입력에 대한 로그를 무차별적으로 저장하게 되면, 악의적인 사용자가 남긴 기록으로 인해서,
서버에서 그가 남긴 스크립트를 실행하는 등의 문제점이 발생할 수 있다.

이는 로그에 전송된 신뢰할 수 없는 입력을 유효성을 검사하고 삭제하여 예방할 수 있다.
 */
