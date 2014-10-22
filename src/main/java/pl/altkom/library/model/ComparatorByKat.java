package pl.altkom.library.model;

import java.util.Comparator;

public class ComparatorByKat implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        String kat1 = o1.getKategoria();
        String kat2 = o2.getKategoria();
        return kat1.compareToIgnoreCase(kat2);
    }

}
