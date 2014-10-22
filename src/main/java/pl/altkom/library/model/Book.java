package pl.altkom.library.model;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class Book implements Serializable, Comparable {

    private long id;
    @NotEmpty (message="Pole nie moze byc puste")
    private String tytul;
    @NotEmpty (message="Pole nie moze byc puste")
    private String opis;
    @NotEmpty (message="Pole nie moze byc puste")
     @Pattern(regexp="[a-zA-Z]+", message="Pole nie może zawierać cyfr")
    private String autor_imie;
    @NotEmpty (message="Pole nie moze byc puste")
     @Pattern(regexp="[a-zA-Z]+", message="Pole nie może zawierać cyfr")
    private String autor_nazwisko;
    @NotEmpty (message="Pole nie moze byc puste")
     @Pattern(regexp="[a-zA-Z]+", message="Pole nie może zawierać cyfr")
    private String autor_pochodzenie;
    @Range (min=1, max=99, message="Wartość pomiędzy 1-99")
    private int ilosc;
    @NotEmpty (message="Pole nie moze byc puste")
    private String kategoria;
  

    public Book(long id, String tytul, String opis, String autor_imie, String autor_nazwisko, String autor_pochodzenie, int ilosc,
            String kategoria) {
        this.id = id;
        this.tytul = tytul;
        this.opis = opis;
        this.autor_imie = autor_imie;
        this.autor_nazwisko = autor_nazwisko;
        this.autor_pochodzenie = autor_pochodzenie;
        this.ilosc = ilosc;
        this.kategoria = kategoria;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getAutor_imie() {
        return autor_imie;
    }

    public void setAutor_imie(String autor_imie) {
        this.autor_imie = autor_imie;
    }

    public String getAutor_nazwisko() {
        return autor_nazwisko;
    }

    public void setAutor_nazwisko(String autor_nazwisko) {
        this.autor_nazwisko = autor_nazwisko;
    }
    public String getAutor_pochodzenie() {
        return autor_pochodzenie;
    }

    public void setAutor_pochodzenie(String autor_pochodzenie) {
        this.autor_pochodzenie = autor_pochodzenie;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public int compareTo(Object o) {
        return -1;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", tytul=" + tytul + ", opis=" + opis + ", autor_imie=" + autor_imie + ", autor_nazwisko=" + autor_nazwisko + ", autor_pochodzenie=" + autor_pochodzenie + ", ilosc=" + ilosc + ", kategoria=" + kategoria + '}';
    }

    
}
