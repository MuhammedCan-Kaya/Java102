import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // We are creating the original list.
        ArrayList<Integer> originalList = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            originalList.add(i);
        }

        // We are creating all sublist.
        int chunkSize = 2500;
        ArrayList<Integer> list1 = new ArrayList<>(originalList.subList(0, chunkSize));
        ArrayList<Integer> list2 = new ArrayList<>(originalList.subList(chunkSize, 2 * chunkSize));
        ArrayList<Integer> list3 = new ArrayList<>(originalList.subList(2 * chunkSize, 3 * chunkSize));
        ArrayList<Integer> list4 = new ArrayList<>(originalList.subList(3 * chunkSize, originalList.size()));

        // We are creating ArrayLists that can hold even and odd numbers.
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        // We are starting all threads.
        Thread t1 = new Thread(new NumberProcessor(list1,oddNumbers,evenNumbers));
        Thread t2 = new Thread(new NumberProcessor(list2,oddNumbers,evenNumbers));
        Thread t3 = new Thread(new NumberProcessor(list3,oddNumbers,evenNumbers));
        Thread t4 = new Thread(new NumberProcessor(list4,oddNumbers,evenNumbers));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // We ensure that all threads are worked one by one.
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tek Sayılar: " + oddNumbers);
        System.out.println("Çift Sayılar: " + evenNumbers);
    }
}