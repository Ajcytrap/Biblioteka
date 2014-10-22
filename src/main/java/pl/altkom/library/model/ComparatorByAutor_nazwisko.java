package pl.altkom.library.model;

import java.util.Comparator;

public class ComparatorByAutor_nazwisko implements Comparator<Book> {
    
    @Override
    public int compare(Book o1, Book o2) {
        String an1 = o1.getAutor_nazwisko();
        String an2 = o2.getAutor_nazwisko();
        return an1.compareToIgnoreCase(an2);
    }

}
