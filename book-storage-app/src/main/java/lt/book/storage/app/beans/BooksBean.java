package lt.book.storage.app.beans;

import lt.book.storage.dto.BookDto;
import lt.book.storage.service.BookStorageService;
import lt.book.storage.service.impl.BookStorageServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class BooksBean {
    private List<BookBean> books = new ArrayList<BookBean>();
    private BookStorageService bookStorageService = new BookStorageServiceImpl();

    @PostConstruct
    public void init(){
        List<BookDto> bookDtos = bookStorageService.retriveBooks();
        for (BookDto bookDto : bookDtos) {
            BookBean bookBean = new BookBean();
            bookBean.setBookId(bookDto.getBookId());
            bookBean.setBookAuthor(bookDto.getBookAuthor());
            bookBean.setBookName(bookDto.getBookName());
            bookBean.setIsbn(bookDto.getIsbn());

            books.add(bookBean);
        }

    }



    public List<BookBean> getBooks() {
        return books;
    }

    public void setBooks(List<BookBean> books) {
        this.books = books;
    }


}
