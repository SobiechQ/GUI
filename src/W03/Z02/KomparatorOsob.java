package W03.Z02;

import java.util.Comparator;

public class KomparatorOsob implements Comparator<Osoba> {
    private Kryterium kryterium;
    public KomparatorOsob(Kryterium kryterium) {
        this.kryterium = kryterium;
    }

    @Override
    public int compare(Osoba o1, Osoba o2) {
        return switch (this.kryterium){
            case IMIE -> o1.getImie().compareTo(o2.getImie());
            case WIEK -> o1.getWiek()-o2.getWiek();
        };
    }
}
