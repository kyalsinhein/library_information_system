package libraryinformationsystem;

public class Book {

    private String isbn;
    private String bookTitle;
    private String category;
    private String edition;
    private String authorName;
    private double price;

    public Book(String isbn, String bookTitle, String category, String edition, String authorName, double price) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.category = category;
        this.edition = edition;
        this.authorName = authorName;
        this.price = price;
    }

    public String getIsbn() { return isbn; }
    public String getBookTitle() { return bookTitle; }
    public String getCategory() { return category; }
    public String getEdition() { return edition; }
    public String getAuthorName() { return authorName; }
    public double getPrice() { return price; }

    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public void setCategory(String category) { this.category = category; }
    public void setEdition(String edition) { this.edition = edition; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }
    public void setPrice(double price) { this.price = price; }
}
