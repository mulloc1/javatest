package certtest.rule00;

// 숨겨진 양식 필드의 내용을 신뢰하지 마라.
public class IDS14J {
    public static void main(String[] args) {

    }
}

/*
HTML에서 hidden 필드가 존재하게 되는데, 이는 사용자가 해당 필드에 대한 값을 지정할 수 없게 하는 역할을 한다.
다만 HttpRequest.method.GET을 사용할 때 공격자가 url 창에서 해당 히든 필드에 대한 값을 지정할 수 있기 때문에,
서버 측에서는 히든 필드에 대한 값을 무조건 신뢰해서는 안된다.
 */