package lt.book.storage.service;

import lt.book.storage.dto.BookDto;

import java.util.List;

/**
 * Created by Ala on 3/25/2016.
 */
public interface BookStorageService {
    void addOrEdit(BookDto book);
    void removeBook(Integer id);
    BookDto findByID(Integer id);
    List<BookDto> retriveBooks();
}
