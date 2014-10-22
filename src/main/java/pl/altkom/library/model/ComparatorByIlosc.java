package pl.altkom.library.model;

import java.util.Comparator;

public class ComparatorByIlosc implements Comparator<Book>  {
    
    @Override
    public int compare(Book o1, Book o2) {
        Double il1 = new Double(o1.getIlosc());
        Double il2 = new Double(o2.getIlosc());

        return il1.compareTo(il2);
    }

}
