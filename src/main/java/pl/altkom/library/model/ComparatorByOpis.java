package pl.altkom.library.model;

import java.util.Comparator;

public class ComparatorByOpis implements Comparator<Book> {
    
    @Override
    public int compare(Book o1, Book o2) {
        String opi1 = o1.getOpis();
        String opi2 = o2.getOpis();
        return opi1.compareToIgnoreCase(opi2);
    }

}
