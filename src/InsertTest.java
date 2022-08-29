import java.util.*;

public class InsertTest implements Testing {
    StopWatch stopWatch = new StopWatch();
    long loop_num;
    boolean flag = true;
    ArrayList<Integer> ranArray;

    private InsertTest() {
    }

    public InsertTest(int loop_num) {
        this.loop_num = loop_num;
        ranArray = new ArrayList<Integer>(loop_num);
        for (int i = 0; i < loop_num; i++) {
            ranArray.add(i, (int) (Math.random() * i));
        }
    }

    @Override
    public void arrayListTest() {
        Double    sum = 0.0;
        System.out.println("=========순차 추가 테스트 시작=========");
        for (int j = 0; j < 100; j++) {
            ArrayList arrayList = new ArrayList();
            System.gc();
            stopWatch.start();
            for (int i = 0; i < loop_num; i++)
                arrayList.add(i);
            stopWatch.stop();
            sum += stopWatch.getEndMS();
        }
        System.out.println("ArrayList " + (sum / 100));
        System.out.println("==================================\n");
        sum = 0.0;
        System.out.println("=========크기 지정 후 순차 추가 테스트 시작=========");
        for (int j = 0; j < 100; j++) {
            ArrayList arrayList = new ArrayList((int)loop_num);
            System.gc();
            stopWatch.start();
            for (int i = 0; i < loop_num; i++)
                arrayList.add(i, i);
            stopWatch.stop();
            sum += stopWatch.getEndMS();
        }
        System.out.println("ArrayList " + (sum / 100));
        System.out.println("==================================\n");
    }

    @Override
    public void linkedListTest() {
        Double     sum = 0.0;
        System.out.println("=========순차 추가 테스트 시작=========");
        for (int j = 0; j < 100; j++) {
            LinkedList linkedList = new LinkedList();
            System.gc();
            stopWatch.start();
            for (int i = 0; i < loop_num; i++)
                linkedList.add(i);
            stopWatch.stop();
            sum += stopWatch.getEndMS();
        }
        System.out.println("LinkedList " + sum / 100);
        System.out.println("==================================\n");
    }

    @Override
    public void vectorTest() {
        Double sum = 0.0;
        System.out.println("=========순차 추가 테스트 시작=========");
        for (int j = 0; j < 100; j++) {
            Vector vector = new Vector();
            System.gc();
            stopWatch.start();
            for (int i = 0; i < loop_num; i++)
                vector.add(i, i);
            stopWatch.stop();
            sum += stopWatch.getEndMS();
        }
        System.out.println("Vector " + sum / 100);
        System.out.println("==================================\n");
        sum = 0.0;
        System.out.println("=========크기 지정 후 순차 추가 테스트 시작=========");
        for (int j = 0; j < 100; j++) {
            Vector vector = new Vector((int)loop_num);
            System.gc();
            stopWatch.start();
            for (int i = 0; i < loop_num; i++)
                vector.add(i);
            stopWatch.stop();
            sum += stopWatch.getEndMS();
        }
        System.out.println("Vector " + sum / 100);
        System.out.println("==================================\n");
    }
}
