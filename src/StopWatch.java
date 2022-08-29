public class StopWatch {

    StringBuffer    currentName;
    boolean         threadFlag=false;
    long            startTime;
    long            endTime;

    public StopWatch() {
        currentName = new StringBuffer();
        startTime = System.nanoTime();
    }

    public StopWatch(boolean threadFlag) {
        changeMessage("", true, true);
    }

    public StopWatch(String message) {
        changeMessage(message, false, true);
    }

    public StopWatch(String message, boolean threadFlag) {
        changeMessage(message, threadFlag, true);
    }

    public void start() {
        startTime = System.nanoTime();
        endTime = 0;
    }

    public void stop() {
        endTime = System.nanoTime() - startTime;
    }

    public void changeMessage(String message, boolean threadFlag, boolean resetFlag) {
        StringBuffer threadName = new StringBuffer();
        this.threadFlag = threadFlag;
        if (threadFlag) {
            threadName.append("ThreadName=")
                    .append(Thread.currentThread().getName());
        }
        currentName.append("[").append(message)
                .append(threadName).append("] ");
        if (resetFlag) {
            start();
        }
    }

    public double getEndMS() {
        if (endTime == 0) stop();
        return endTime / 1000000.0;
    }

    public double getEndNano() {
        if (endTime == 0) stop();
        return endTime;
    }

    public String toString() {
        StringBuffer temp = new StringBuffer();

        if (endTime == 0) stop();
        temp.append("end Time: ")
                .append(endTime / 1000000.0)
                .append("ms ");
        return temp.toString();
    }
}
