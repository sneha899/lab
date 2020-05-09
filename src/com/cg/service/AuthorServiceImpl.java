package com.cg.service;



import java.util.List;

import com.cg.bean.Author;
import com.cg.dao.AuthorDAOImpl;
import com.cg.exception.AuthorException;

//Service Class

public class AuthorServiceImpl implements AuthorService{

	AuthorDAOImpl dao = new AuthorDAOImpl();

		
		
	@Override
	public int addAuthor(Author author) throws AuthorException{
		boolean flag1=false,flag2=false;
		flag1=author.getFirstName().matches("[a-zA-Z]+");
		flag1=author.getMiddleName().matches("[a-zA-Z]+");
		flag1=author.getLastName().matches("[a-zA-Z]+");
		if(flag1==false)
		{
			throw new AuthorException("It should contain only characters firstname or middlename or lastname");
		}
		flag2=author.getPhoneNo().matches("[0-9]{10}");
		if(flag2==false) {
			throw new AuthorException("Invalid phone number");
		}
		return dao.addAuthor(author);
	}

	
	@Override
	public Author updateAuthor(Author author) throws AuthorException {
		String authorId=String.valueOf(author);
		boolean flag=authorId.matches("[0-9]{4}");
		if(!flag)
		{
		throw new AuthorException("Invalid flight number ");
		}
		return dao.updateAuthor(author);
	}

	
	
	@Override
	public boolean deleteAuthor(Integer id) throws AuthorException {
		String authorId=String.valueOf(id);
		boolean flag=authorId.matches("[0-9]{2}");
		if(!flag)
		{
		throw new AuthorException("Invalid flight number ");
		}
		return dao.deleteAuthor(dao.findAuthor(id));
	}
	
	@Override
	public Author findAuthor(Integer id)throws AuthorException 
	{
		String authorId=String.valueOf(id);
		boolean flag=authorId.matches("[0-9]{2}");
		if(!flag)
		{
		throw new AuthorException("Invalid flight number ");
		}
		return dao.findAuthor(id); 
	}

	@Override
	public List<Author> viewAuthor(){
		return dao.viewAuthor();
	}
}

