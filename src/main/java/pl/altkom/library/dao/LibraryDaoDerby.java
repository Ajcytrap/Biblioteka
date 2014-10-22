package pl.altkom.library.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.altkom.library.model.ComparatorByAutor_imie;
import pl.altkom.library.model.ComparatorByAutor_nazwisko;
import pl.altkom.library.model.ComparatorByIlosc;
import pl.altkom.library.model.ComparatorByKat;
import pl.altkom.library.model.ComparatorByTytul;
import pl.altkom.library.model.ComparatorByOpis;
import pl.altkom.library.model.Book;
import pl.altkom.library.model.ComparatorByAutor_pochodzenie;


@Repository
public class LibraryDaoDerby implements LibraryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private int sort = 0;

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public void addBook(Book t) {
        try {
            String sql = "INSERT INTO books(tytul,opis,autor_imie,autor_nazwisko,autor_pochodzenie,ilosc,kategoria) values(?,?,?,?,?,?,?)";
			// String sql1 =
            // "select id FROM books order by id desc FETCH FIRST ROW ONLY;";

            // jdbcTemplate.execute(sql1);
            jdbcTemplate.update(sql, new Object[]{t.getTytul(), t.getOpis(),
                t.getAutor_imie(), t.getAutor_nazwisko(), t.getAutor_pochodzenie(), t.getIlosc(), t.getKategoria()});
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void updateBook(Book t) {
        String SQL = "update books set tytul = ?, opis = ?, autor_imie = ?, autor_nazwisko = ?, autor_pochodzenie = ?, ilosc = ?, kategoria = ? where id = ?";
        jdbcTemplate.update(SQL, t.getTytul(), t.getOpis(),t.getAutor_imie(), t.getAutor_nazwisko(), t.getAutor_pochodzenie(),
                t.getIlosc(), t.getKategoria(), t.getId());
        return;
    }

    @Override
    public Book getBook(long id) {
        String SQL = "select * from books where id = ?";
        Book book = jdbcTemplate.queryForObject(SQL, new Object[]{id},
                new BookMapper());
        return book;
    }

    @Override
    public void removeBook(long id) {
        String SQL = "delete from books where id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public List<Book> getAllSortedBook(int atrybut, String s) {
        String sql = "select * FROM books";
        List<Book> books = jdbcTemplate.query(sql, new BookMapper());
        List<Book> tmp = new ArrayList();
        if (atrybut != 0) {
            if (atrybut == 1) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getTytul().matches(s)) {
                        tmp.add(books.get(i));
                    }
                }
            }
            if (atrybut == 3) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getAutor_imie().matches(s)) {
                        tmp.add(books.get(i));
                    }
                }
            }
             if (atrybut == 4) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getAutor_nazwisko().matches(s)) {
                        tmp.add(books.get(i));
                    }
                }
            }
              if (atrybut == 5) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getAutor_pochodzenie().matches(s)) {
                        tmp.add(books.get(i));
                    }
                }
            }
            if (atrybut == 7) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getKategoria().matches(s)) {
                        tmp.add(books.get(i));
                    }
                }
            }
            books = tmp;
        }

        if (sort == 1) {
            Collections.sort(books, new ComparatorByTytul());
        }
        if (sort == 2) {
            Collections.sort(books, new ComparatorByOpis());
        }
        if (sort == 3) {
            Collections.sort(books, new ComparatorByAutor_imie());
        }
         if (sort == 4) {
            Collections.sort(books, new ComparatorByAutor_nazwisko());
            }
         if (sort == 5) {
            Collections.sort(books, new ComparatorByAutor_pochodzenie());
        }
        if (sort == 6) {
            Collections.sort(books, new ComparatorByIlosc());
        }
        if (sort == 7) {
            Collections.sort(books, new ComparatorByKat());
        }

        return books;
    }

}
