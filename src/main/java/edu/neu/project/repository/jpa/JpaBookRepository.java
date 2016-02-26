package edu.neu.project.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.neu.project.model.BookEntityModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserBookMapper;
import edu.neu.project.repository.BookRepository;


@Repository
public class JpaBookRepository implements BookRepository {
	
	@PersistenceContext
	 private EntityManager em;

	@Override
	public BookEntityModel getBookForBookId(String bookId) {
		
		System.out.println("bookId in JpaBookRepo::" + bookId);
		
		Query q = em.createNamedQuery("BookEntityModel.findBookId");
		q.setParameter("bookId", bookId);
		List<BookEntityModel> books = q.getResultList();
		if (books == null || books.size() == 0) {
			System.out.println("Books is null from DB");
			return null;
		}
		System.out.println("Books is not null drom DB");
		return books.get(0);
	}

	@Override
	public void persistBook(BookEntityModel book) {
		
		System.out.println("Inside book repo. Going to persist book");
		em.persist(book);
	}

	@Override
	public void persistBookMapper(UserBookMapper mapper) {
		
		System.out.println("Inside book repo. Going to persist bookMapper");
		em.persist(mapper);
		
	}

	@Override
	public List<String> getMappedBooks(User user) {
		
		if (user == null) {
			return null;
		}
		
		Query q = em.createNamedQuery("UserBookMapper.findMapper");
		q.setParameter("userId", user.getUserId());
		List<String> mappers = q.getResultList();
		if (mappers == null || mappers.size() == 0) {
			System.out.println("BookMappers is null from DB");
			return null;
		}
		System.out.println("BookMappers is not null drom DB");
		return mappers;
	}

	@Override
	public List<UserBookMapper> findIfMapperExists(User newUser, BookEntityModel book) {
		
		if (newUser == null || book == null) {
			return null;
		}
		
		Query q = em.createNamedQuery("UserBookMapper.findIfMapperExists");
		q.setParameter("userId", newUser.getUserId());
		q.setParameter("bookId", book.getBookId());
		List<UserBookMapper> mappers = q.getResultList();
		return mappers;
	}

}
