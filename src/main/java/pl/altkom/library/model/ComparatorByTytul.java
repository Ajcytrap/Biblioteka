package pl.altkom.library.model;

import java.util.Comparator;

public class ComparatorByTytul implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        String tyt1 = o1.getTytul();
        String tyt2 = o2.getTytul();
        return tyt1.compareToIgnoreCase(tyt2);
    }

}
