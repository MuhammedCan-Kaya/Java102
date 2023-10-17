import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Kürt Mantolu Madonna", "Sabahattin Ali", 160, 1943));
        list.add(new Book("Hayvan Çiftliği", "George Orwell", 152, 1945));
        list.add(new Book("Satranç", "Stefan Zweig", 83, 1941));
        list.add(new Book("Küçük Prens", "Antonio de Saint-Exupery", 112, 1943));
        list.add(new Book("Şeker Portakalı", "Jose Mauro de Vasconcelos", 184, 1968));
        list.add(new Book("Dönüşüm", "Franz Kafka", 74, 1915));
        list.add(new Book("Simyacı", "Paulo Coelho", 188, 1988));
        list.add(new Book("İnsan Neyle Yaşar?", "Lev Tolstoy", 96, 1885));
        list.add(new Book("Kuyucaklı Yusuf", "Sabahattin Ali", 222, 1937));
        list.add(new Book("Fareler ve İnsanlar", "John Steinback", 125, 1937));

        Map <String,String> titleToAuthorMap = list.stream().collect(Collectors.toMap(Book::getBookName,Book::getAuthorName));
        titleToAuthorMap.forEach((title,author) -> System.out.println(title +  " - " + author));

        System.out.println("------------");
        System.out.println("Sayfa sayısı 100'den büyük olan kitaplar");
        System.out.println();
        List<Book> filteredList = list.stream().filter(book -> book.getPageNumber() > 100).collect(Collectors.toList());
        filteredList.stream().forEach(bookName -> System.out.println(bookName.getBookName()));
    }
}