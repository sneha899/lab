package com.cg.service;

import java.util.List;

import com.cg.bean.Author;
import com.cg.exception.AuthorException;

public interface AuthorService {
	public int addAuthor(Author author)throws AuthorException;
	public Author updateAuthor(Author author)throws AuthorException;
	public boolean deleteAuthor(Integer id) throws AuthorException;
	public Author findAuthor(Integer id)throws AuthorException;
	public List<Author> viewAuthor()throws AuthorException;
}
