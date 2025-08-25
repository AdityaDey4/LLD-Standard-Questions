package LibraryManagement;

public class Book {
    private String name;
    private int totalAvailable;
    private String isbn;

    public Book(String name, int totalAvailable, String isbn) {
        this.name = name;
        this.totalAvailable = totalAvailable;
        this.isbn = isbn;

        Library.getInstance().addBook(this);
    }

    public String getName() {
        return this.name;
    }

    public boolean checkAvailablity() {
        return this.totalAvailable > 0;
    }

    public void reduceQuantity() {
        this.totalAvailable-=1;
    }

    public void increseQuantity() {
        this.totalAvailable+=1;
    }

    public String getIsbn() {
        return this.isbn;
    }
}
