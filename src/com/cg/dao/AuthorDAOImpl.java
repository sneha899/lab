package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.bean.Author;

public class AuthorDAOImpl implements AuthorDAO{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager manager = factory.createEntityManager();
	
	//method for adding an author
	@Override
	public int addAuthor(Author author) {
		try {
			manager.getTransaction().begin();
			manager.persist(author);
			manager.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return author.getAuthorId();
	}

     //method for deleting an author
	@Override
	public boolean deleteAuthor(Author author) {
		try {
			manager.remove(author);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//method for updating an author
	
	@Override
	public Author updateAuthor(Author author) {
		try {
			Author temp = findAuthor(author.getAuthorId());
			temp.setFirstName(author.getFirstName());
			temp.setLastName(author.getLastName());
			temp.setMiddleName(author.getMiddleName());
			temp.setPhoneNo(author.getPhoneNo());
			return temp;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//method for finding an author
	
	@Override
	public Author findAuthor(Integer id) {
		return manager.find(Author.class, id);
	}
	@Override
	public List<Author> viewAuthor(){
		return (List<Author>) manager.getReference(Author.class, 1);
	}

}
