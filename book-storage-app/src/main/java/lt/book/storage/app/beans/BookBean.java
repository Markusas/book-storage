package lt.book.storage.app.beans;

import lt.book.storage.dto.BookDto;
import lt.book.storage.service.BookStorageService;
import lt.book.storage.service.impl.BookStorageServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class BookBean {
    private String bookName;
    private String bookAuthor;
    private String isbn;
    private int bookId;

    BookStorageService bookService = new BookStorageServiceImpl();

    private void resetFields() {
        bookName = null;
        bookAuthor = null;
        isbn = null;
    }

    public void addBook() {
        BookDto bookDto = new BookDto();
        bookDto.setBookAuthor(bookAuthor);
        bookDto.setBookName(bookName);
        bookDto.setIsbn(isbn);
        bookService.addOrEdit(bookDto);
        resetFields();
    }

    public void removeBook(ActionEvent event) {
        BookDto book = (BookDto) event.getComponent().getAttributes().get("book");
        bookService.removeBook(book.getBookId());
        resetFields();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}