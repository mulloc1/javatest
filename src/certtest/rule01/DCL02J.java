package certtest.rule01;

import java.util.Arrays;
import java.util.List;

// 향상된 for 문 중에 컬렉션의 요소를 수정하지 마라.
public class DCL02J {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[] {13, 14, 15});
        boolean first = true;

        System.out.println("Processing list...");
        for (final Integer i: list) {
            if (first) {
                first = false;
                i = new Integer(99);
            }
            System.out.println(" New item: " + i);
        }
        System.out.println("Modified list?");
        for (Integer i: list) {
            System.out.println("List item: " + i);
        }
    }
}

/*
for - each 문을 사용하다. 중간에 요소의 값을 바꿀려고 시도할 수 있다. 하지만 이는 정확하게 동작하지 않는다. (서로 다른 객체)
떄문에 해당 문제를 미연에 차단시키기 위해서 for - each 문의 요소에 final키워드르 붙인다.
 */
