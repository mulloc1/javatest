import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class InsertTest2 implements Testing{
    StopWatch stopWatch = new StopWatch();
    int       loop_num;
    ArrayList<Integer> ranArray;

    private InsertTest2() {
    }

    public InsertTest2(int loop_num) {
        this.loop_num = loop_num;
        ranArray = new ArrayList<Integer>(loop_num);
        for (int i = 0; i < loop_num; i++) {
            ranArray.add(i, (int) (Math.random() * loop_num));
        }
    }

    @Override
    public void arrayListTest() {
        Double sum;

        sum = 0.0;
        System.out.println("=========랜덤 추가 테스트 시작=========");
        for (int i = 0; i < 100; i++) {
            ArrayList arrayList = new ArrayList();
            System.gc();
            for (int j = 0; j < loop_num; j++)
                arrayList.add(j);
            stopWatch.start();
            for (int j = 0; j < loop_num; j++)
                arrayList.add(ranArray.get(j), j);
            stopWatch.stop();
            sum += stopWatch.getEndMS();
        }
        System.out.println("ArrayList " + (sum / 100));
        System.out.println("==================================\n");
    }

    @Override
    public void linkedListTest() {
        Double sum;

        sum = 0.0;
        System.out.println("=========랜덤 추가 테스트 시작=========");
        for (int i = 0; i < 100; i++) {
            LinkedList linkedList = new LinkedList();
            System.gc();
            for (int j = 0; j < loop_num; j++)
                linkedList.add(j);
            stopWatch.start();
            for (int j = 0; j < loop_num; j++)
                linkedList.add(ranArray.get(j), j);
            stopWatch.stop();
            sum += stopWatch.getEndMS();
        }
        System.out.println("linkedList " + (sum / 100));
        System.out.println("==================================\n");
    }

    @Override
    public void vectorTest() {
        Double sum;

        sum = 0.0;
        System.out.println("=========랜덤 추가 테스트 시작=========");
        for (int i = 0; i < 100; i++) {
            Vector vector = new Vector();
            System.gc();
            for (int j = 0; j < loop_num; j++)
                vector.add(j);
            stopWatch.start();
            for (int j = 0; j < loop_num; j++)
                vector.add(ranArray.get(j), j);
            stopWatch.stop();
            sum += stopWatch.getEndMS();
        }
        System.out.println("Vector " + (sum / 100));
        System.out.println("==================================\n");
    }
}
