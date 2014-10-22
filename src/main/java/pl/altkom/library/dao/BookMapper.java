package pl.altkom.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.altkom.library.model.Book;

public class BookMapper implements RowMapper<Book> {
	public Book mapRow(ResultSet row, int rowNum) throws SQLException {
		Book book = new Book();
		book.setId(row.getLong("ID"));
		book.setTytul(row.getString("tytul"));
		book.setOpis(row.getString("opis"));
                book.setAutor_imie(row.getString("autor_imie"));
                book.setAutor_nazwisko(row.getString("autor_nazwisko"));
                book.setAutor_pochodzenie(row.getString("autor_pochodzenie"));
		book.setIlosc(row.getInt("ilosc"));
		book.setKategoria(row.getString("kategoria"));
		return book;
	}
}
