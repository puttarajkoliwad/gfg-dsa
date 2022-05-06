// This code is for testing. It does not relate to this course/any of the content in this course.

public class InfinityLoop {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while(true) {
            Thread.sleep(10000);
            System.out.println("Waiting: "+i++);
        }
    }
}
