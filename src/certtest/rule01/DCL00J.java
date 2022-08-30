package certtest.rule01;

// 클래스 초기화 주기 방
// DCL00J 를 Cycle이라 바꿔 생각하면 됨.
public class DCL00J {
    private final int balance;
    private static final DCL00J c = new DCL00J();
    private static final int deposit = (int) (Math.random() * 100);

    public DCL00J() {
        balance = deposit  - 10;
    }

    public static void main(String[] args) {
        System.out.println("The account balance is: " + c.balance);
    }
}

/*
해당 예제는 초기화의 순서에 따라 결과가 달라진다.
 */