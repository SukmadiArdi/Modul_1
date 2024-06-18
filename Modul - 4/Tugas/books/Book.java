package books;

import java.util.ArrayList;

public class Book {

    public static ArrayList<Book> arr_bookList = new ArrayList<>();
    public static ArrayList<Book> arr_borrowedBook = new ArrayList<>();
    private String bookId;
    private String title;
    private String author;
    private String category;
    private int stock;
    private int duration;


    public Book() {

    }

    public Book(String category) {
        this.category = category;
    }

    public Book(String bookId, int stock, int duration) {
        this.bookId = bookId;
        this.stock = stock;
        this.duration = duration;

    }

    public Book(String bookId, String title, String author, String category, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;

    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}