public class Book {
    private String bookName;
    private String authorName;
    private int pageNumber;
    private int releaseDate;

    public Book(){}

    public Book(String bookName, String authorName, int pageNumber, int releaseDate) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.pageNumber = pageNumber;
        this.releaseDate = releaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
