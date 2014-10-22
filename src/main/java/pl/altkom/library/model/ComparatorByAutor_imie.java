package pl.altkom.library.model;

import java.util.Comparator;

public class ComparatorByAutor_imie implements Comparator<Book> {
    
    @Override
    public int compare(Book o1, Book o2) {
        String ai1 = o1.getAutor_imie();
        String ai2 = o2.getAutor_imie();
        return ai1.compareToIgnoreCase(ai2);
    }

}
