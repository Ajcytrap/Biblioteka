package pl.altkom.library.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.altkom.library.model.Book;

public class LibraryDaoMemory implements LibraryDao {

	private List<Book> dane;
	
	
	
	public LibraryDaoMemory() {
		dane = new ArrayList();
	}

	@Override
	public synchronized void addBook(Book t) {
		// TODO Auto-generated method stub
		Book tmp = null;
		if (dane.size() != 0) {
			tmp = dane.get(dane.size()-1);
			t.setId(tmp.getId()+1);
			dane.add(t);
		} else {
			dane.add(t);
		}
	}

	@Override
	public synchronized void updateBook(Book t) {
		// TODO Auto-generated method stub
		dane.set((int)t.getId(), t);
	}

	@Override
	public synchronized Book getBook(long id) {
		// TODO Auto-generated method stub
		return dane.get((int)id);
	}

	@Override
	public synchronized void removeBook(long id) {
		// TODO Auto-generated method stub
		dane.remove((int)id);
	}

	@Override
	public synchronized List<Book> getAllSortedBook(int atrybut, String s) {
		// TODO Auto-generated method stub
		return dane;
	}

	@Override
	public void setSort(int sort) {
		// TODO Auto-generated method stub
		
	}

}
