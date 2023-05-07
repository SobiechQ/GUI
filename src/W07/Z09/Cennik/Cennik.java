package W07.Z09.Cennik;

import W07.Z09.Gatunki.Film;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Singleton.
 * Prywatny konstruktor pozwala na pobiernie instancji tego obiektu tylko przez odpowiednie gettery.
 * Na zasadzie mapy indeksowanej po tytułach filmów trzyma kolenje rekordy cennika (klasy CennikRecord), zawieraące informacje o cenach i dostępnościach filmów.
 * @see CennikRecord
 * @see Cennik#pobierzCennik()
 */
public class Cennik {
    private static Cennik self;
    private final Map<String,CennikRecord> cennikRecords;
    private Cennik(Map<String,CennikRecord> cennikRecords){
        this.cennikRecords = cennikRecords;
    }

    /**
     * Metoda jako jedyna tworząca nowy obiekt klasy Cennik.
     * Jedyny sposób w Singletonie na uzyskanie dostępu do obiektu tej klasy.
     * @return Instancja klasy Cennik będącej Singletonem
     */
    public static Cennik pobierzCennik(){
        if (Cennik.self == null)
            Cennik.self = new Cennik(new HashMap<>());
        return Cennik.self;
    }

    /**
     * @param cennikRecord wprowadza rekord do listy cennika. Indeksowana po tytułach a wartości to recordy clasy CennikRecord
     */
    public void dodaj(CennikRecord cennikRecord) {
        Cennik.pobierzCennik().cennikRecords.putIfAbsent(cennikRecord.tytul(), cennikRecord);
    }
    /**
     * Tylko dla klientów z abonamentem. Darmowy dostęp.
     */
    public void dodaj(String gatunek, String tytul){
        Cennik.pobierzCennik().dodaj(new CennikRecord(gatunek, tytul));
    }
    /**
     * @param cenaBezAbo Cena dla klienta bez abonamentu. (Brak limitu urządzeń)
     * @param cenaAbo Cena dla klienta z abonamentem (Brak limitu urządzeń)
     */
    public void dodaj(String gatunek, String tytul, int cenaBezAbo, int cenaAbo){
        Cennik.pobierzCennik().dodaj(new CennikRecord(gatunek, tytul,cenaBezAbo, cenaAbo));
    }
    /**
     * @param maksLiczbUrzadzen Po ilu urzadzeniach zmiana ceny dla każdego klienta (niezaleznie od tego czy posiada abonament czy nie)
     * @param cenaPakiet Cena przed przekroczeniem limitu dla kazdego klienta (niezaleznie od tego czy posiada abonament czy nie)
     * @param cenaBezPakiet Cena po przekroczeniu limitu dla każdego klienta (niezaleznie od tego czy posiada abonament czy nie)
     */
    public void dodaj(String gatunek, String tytul, int maksLiczbUrzadzen, int cenaPakiet, int cenaBezPakiet){
        Cennik.pobierzCennik().dodaj(new CennikRecord(gatunek, tytul, maksLiczbUrzadzen, cenaPakiet, cenaBezPakiet));
    }
    /**
     * @param cenaPakietBezAbo Cena przed przekroczeniem limitu urzadzen dla klientow bez abonamentu
     * @param cenaBezPakietBezAbo Cena po wyjsciu poza limit maksLiczbaUrzadzan dla kientow bez abonamentu
     * @param maksLiczbUrzadzen Po ilu urzadzeniach zmiana ceny dla klientow bez abonamentu
     * @param cenaAbo Cena jesli klient ma abomanent (Brak limitu urządzeń)
     */
    public void dodaj(String gatunek, String tytul, int cenaPakietBezAbo, int cenaBezPakietBezAbo, int maksLiczbUrzadzen, int cenaAbo){
        Cennik.pobierzCennik().dodaj(new CennikRecord(gatunek, tytul, cenaPakietBezAbo, cenaBezPakietBezAbo, maksLiczbUrzadzen, cenaAbo));
    }

    /**
     * odpowiednio chroniony getter, który nawet dla nieistniejącego w cenniku filmu nie zwróci nigdy wartości null. Optional chroni przed NullPointerException
     * @param key Szukanie w mapie po obiekcie Film, a nie po tytule filmu (w Cenniku kluczem dla rekordu jest String tytuł filmu)
     * @return Optional object rekordu cennika. Pusty lub nie w zależności czy film występuje w cenniku
     */
    public Optional<CennikRecord> getRecordByKeyFilm(Film key){
        return Optional.ofNullable(Cennik.pobierzCennik().getCennikRecords().getOrDefault(key.getTytul(), null));
    }

    private Map<String,CennikRecord> getCennikRecords() {
        return Cennik.pobierzCennik().cennikRecords;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Cennik: ");
        for (String s : this.cennikRecords.keySet()) {
            output.append("\n\t").append(this.cennikRecords.get(s).toString());
        }
        return output.append('\n').toString();
    }
}
