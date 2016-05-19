package lt.book.storage.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookStorageEntity {
    private String bookName;
    private String bookAuthor;
    private String isbn;
    private Integer bookId;

    @Column(name = "ISBN")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    @Column(name = "BOOK_NAME")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Column(name = "AUTOR_NAME")
    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
