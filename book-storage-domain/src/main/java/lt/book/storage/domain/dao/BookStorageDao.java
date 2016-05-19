package lt.book.storage.domain.dao;

import lt.book.storage.domain.entity.BookStorageEntity;

import java.util.List;


public interface BookStorageDao {
    void saveOrUpdate(BookStorageEntity book);
    void delete(Integer id);
    BookStorageEntity findById(Integer id);
    List<BookStorageEntity> getAllBooks();


}
