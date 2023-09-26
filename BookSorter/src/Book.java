import java.util.Comparator;
public class Book implements Comparable<Book>{
    String name;
    String author;
    int pageNumber;
    int releaseDate;

    public Book(){}

    public Book(String name, String author, int pageNumber, int releaseDate){
        this.name = name;
        this.pageNumber = pageNumber;
        this.releaseDate = releaseDate;
        this.author = author;
    }

    @Override
    public int compareTo(Book anotherBook) {
        return this.name.compareTo(anotherBook.getName());
    }

    public String getName() {
        return name;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
