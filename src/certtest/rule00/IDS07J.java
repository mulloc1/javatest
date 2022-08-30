package certtest.rule00;

import java.io.IOException;
import java.io.InputStream;

// Runtime.exec() 메서드에 전잘된 신뢰할 수 없는 데이터 검사
public class IDS07J {
    public static void main(String[] args) throws Exception {
        String dir = System.getProperty("dir");
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("cmd.exe /C dir " + dir);
        int result = proc.waitFor();
        if (result != 0) {
            System.out.println("process error: " + result);
        }
        InputStream in = (result == 0) ? proc.getInputStream() :
                proc.getErrorStream();
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char) c);
    }
}

/*
위 코드에서 System.getProperty를 통해 읽어오는 dir의 값에서
입력 검증을 하지 않으면 "dummy; echo bad" 같은 값이 들어왔을 때
; 뒤 명령어가 이상없이 실행되게 된다.
이를 방지하기 위해서 세가지의 방법이 존재한다.
1. 정규 표현식을 통해 dir 값의 유효성을 체크한다.
2. 사용자에게 옵션을 제공하여 해당 옵션 범위 내애서 입력하도록 한다.
3. 해당 dir을 통해 file을 오픈해 해당 file이 디렉터리인지 확인한다.
(isDirectory() 메서드 사용)

 */