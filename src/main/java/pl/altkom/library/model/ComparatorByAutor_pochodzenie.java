package pl.altkom.library.model;

import java.util.Comparator;

public class ComparatorByAutor_pochodzenie implements Comparator<Book> {
    
    @Override
    public int compare(Book o1, Book o2) {
        String ap1 = o1.getAutor_pochodzenie();
        String ap2 = o2.getAutor_pochodzenie();
        return ap1.compareToIgnoreCase(ap2);
    }

}
