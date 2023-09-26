import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> ts = new TreeSet<>();
        ts.add(new Book("Astronomi Hakkında","Ali",100,2000));
        ts.add(new Book("SpaceX'in Tarihi", "Burak", 80, 2015));
        ts.add(new Book("Zeytindalı Harekatı", "Cengiz", 60, 2018));
        ts.add(new Book("Cankutaran Olmanın Adımları", "Ceyda", 50, 2004));
        ts.add(new Book("Human Psychology", "Mehmet", 70, 2002));

        System.out.println("İsme Göre Sıralama:");
        for(Book i : ts){
            System.out.println(i.getName());
        }

        TreeSet<Book> ts2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getPageNumber(), o2.getPageNumber());
            }
        });
        ts2.add(new Book("Astronomi Hakkında","Ali",100,2000));
        ts2.add(new Book("SpaceX'in Tarihi", "Burak", 80, 2015));
        ts2.add(new Book("Zeytindalı Harekatı", "Cengiz", 60, 2018));
        ts2.add(new Book("Cankutaran Olmanın Adımları", "Ceyda", 50, 2004));
        ts2.add(new Book("Human Psychology", "Mehmet", 70, 2002));

        System.out.println("\nSayfa Sayısına Göre Sıralama:");
        for(Book i : ts2){
            System.out.println(i.getName());
        }
    }
}