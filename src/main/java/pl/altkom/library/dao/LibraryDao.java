package pl.altkom.library.dao;

import java.util.List;
import pl.altkom.library.model.Book;

public interface LibraryDao {

	public void addBook(Book t);

	public void updateBook(Book t);

	public Book getBook(long id);

	public void removeBook(long id);

	public List<Book> getAllSortedBook(int atrybut, String s);
	
	public void setSort(int sort);

}
