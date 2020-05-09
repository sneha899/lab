package com.cg.dao;

import java.util.List;

import com.cg.bean.Author;

public interface AuthorDAO {
	public int addAuthor(Author author);
	public boolean deleteAuthor(Author author);
	public Author updateAuthor(Author author);
	public Author findAuthor(Integer id);
	public List<Author> viewAuthor();
}
