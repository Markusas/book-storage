package lt.book.storage.domain.dao.impl;

import lt.book.storage.domain.dao.BookStorageDao;
import lt.book.storage.domain.entity.BookStorageEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;


public class BookStorageDaoImpl implements BookStorageDao {

    private EntityManager em = Persistence.createEntityManagerFactory("books").createEntityManager();

    public void saveOrUpdate(BookStorageEntity book) {
        em.getTransaction().begin();

        if (book.getBookId() == null) {
            em.persist(book);

        } else {
            em.merge(book);
        }
        em.getTransaction().commit();
    }

    public void delete(Integer id) {
        BookStorageEntity entity = em.find(BookStorageEntity.class, id);
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public BookStorageEntity findById(Integer id) {
        BookStorageEntity entity = em.find(BookStorageEntity.class, id);
        return entity;

    }

    public List<BookStorageEntity> getAllBooks() {
        return em.createQuery("from BookStorageEntity book").getResultList();
    }

}

