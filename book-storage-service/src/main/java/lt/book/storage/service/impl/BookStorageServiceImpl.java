package lt.book.storage.service.impl;


import lt.book.storage.domain.dao.BookStorageDao;
import lt.book.storage.domain.dao.impl.BookStorageDaoImpl;
import lt.book.storage.domain.entity.BookStorageEntity;
import lt.book.storage.dto.BookDto;
import lt.book.storage.service.BookStorageService;


import java.util.ArrayList;
import java.util.List;


public class BookStorageServiceImpl implements BookStorageService {

    BookStorageDao bookDao = new BookStorageDaoImpl();


    public void addOrEdit(BookDto book) {
        BookStorageEntity bookStorageEntity = new BookStorageEntity();
        bookStorageEntity.setBookId(book.getBookId());
        bookStorageEntity.setBookAuthor(book.getBookAuthor());
        bookStorageEntity.setBookName(book.getBookName());
        bookStorageEntity.setIsbn(book.getIsbn());
        bookDao.saveOrUpdate(bookStorageEntity);
    }

    public void removeBook(Integer id) {
        bookDao.delete(id);
    }

    public BookDto findByID(Integer id) {
        BookStorageEntity entity = bookDao.findById(id);

        BookDto dto = new BookDto();

        dto.setBookId(entity.getBookId());
        dto.setBookAuthor(entity.getBookAuthor());
        dto.setIsbn(entity.getIsbn());
        dto.setBookName(entity.getBookName());

        return dto;
    }

    public List<BookDto> retriveBooks() {
        List<BookDto> result = new ArrayList<BookDto>();

        List<BookStorageEntity> books = bookDao.getAllBooks();
        for (BookStorageEntity book : books) {
            BookDto dto = new BookDto();
            dto.setBookAuthor(book.getBookAuthor());
            dto.setBookName(book.getBookName());
            dto.setIsbn(book.getIsbn());
            dto.setBookId(book.getBookId());
            result.add(dto);
        }

        return result;

    }




}