package W07.Z09.Cennik;

/**
 * @param cenaPakietBezAbo Cena przed przekroczeniem limitu urzadzen dla klientow bez abonamentu
 * @param cenaBezPakietBezAbo Cena po wyjsciu poza limit maksLiczbaUrzadzan dla klientow bez abonamentu
 * @param maksLiczbUrzadzen Po ilu urzadzeniach zmiana ceny
 * @param cenaPakietAbo Cena przed przekroczeniem limitu urzadzen dla klientow z abonamentem
 * @param cenaBezPakietAbo Cena po wyjsciu poza limit maksLiczbaUrzadzan dla klientow z abonamentem
 * @param czyMoznaPozaAbonamentem flaga decydująca czy klienci nie posiadający abonamentu mają dostęp do filmu
 */
public record CennikRecord(String gatunek, String tytul,
                           int cenaPakietBezAbo, int cenaBezPakietBezAbo, int maksLiczbUrzadzen, int cenaPakietAbo, int cenaBezPakietAbo, boolean czyMoznaPozaAbonamentem) {

    /**
     * @param cenaPakietBezAbo Cena przed przekroczeniem limitu urzadzen dla klientow bez abonamentu
     * @param cenaBezPakietBezAbo Cena po wyjsciu poza limit maksLiczbaUrzadzan dla kientow bez abonamentu
     * @param maksLiczbUrzadzen Po ilu urzadzeniach zmiana ceny dla klientow bez abonamentu
     * @param cenaAbo Cena jesli klient ma abomanent (Brak limitu urządzeń)
     */
    public CennikRecord(String gatunek, String tytul, int cenaPakietBezAbo, int cenaBezPakietBezAbo, int maksLiczbUrzadzen, int cenaAbo) {
        this(gatunek, tytul, cenaPakietBezAbo, cenaBezPakietBezAbo, maksLiczbUrzadzen, cenaAbo, cenaAbo, true);
    }

    /**
     * @param maksLiczbUrzadzen Po ilu urzadzeniach zmiana ceny dla każdego klienta (niezaleznie od tego czy posiada abonament czy nie)
     * @param cenaPakiet Cena przed przekroczeniem limitu dla kazdego klienta (niezaleznie od tego czy posiada abonament czy nie)
     * @param cenaBezPakiet Cena po przekroczeniu limitu dla każdego klienta (niezaleznie od tego czy posiada abonament czy nie)
     */
    public CennikRecord(String gatunek, String tytul,int maksLiczbUrzadzen, int cenaPakiet, int cenaBezPakiet) {
        this(gatunek, tytul, cenaBezPakiet, cenaPakiet, maksLiczbUrzadzen, cenaBezPakiet, cenaPakiet, true);
    }


    /**
     * @param cenaBezAbo Cena dla klienta bez abonamentu. (Brak limitu urządzeń)
     * @param cenaAbo Cena dla klienta z abonamentem (Brak limitu urządzeń)
     */
    public CennikRecord(String gatunek, String tytul, int cenaBezAbo, int cenaAbo) {
        this(gatunek, tytul, cenaBezAbo, cenaBezAbo, Integer.MAX_VALUE, cenaAbo, cenaAbo, true);
    }


    /**
     * Tylko dla klientów z abonamentem. Darmowy dostęp.
     */
    public CennikRecord(String gatunek, String tytul) {
        this(gatunek, tytul, 0, 0, Integer.MAX_VALUE, 0, 0, false);
    }

    @Override
    public String toString() {
        return "Film: (" +
                "gatunek: " + gatunek +
                ", tytul: " + tytul +
                ", cenaPakietBezAbo: " + cenaPakietBezAbo +
                ", cenaBezPakietBezAbo: " + cenaBezPakietBezAbo +
                ", maksLiczbUrzadzen: " + maksLiczbUrzadzen +
                ", cenaPakietAbo: " + cenaPakietAbo +
                ", cenaBezPakietAbo: " + cenaBezPakietAbo +
                ", czyMoznaPozaAbonamentem: " + czyMoznaPozaAbonamentem +
                ')';
    }

}
