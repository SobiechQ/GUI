package W07.Z09.Cennik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cennik {
    private static Cennik self;
    private final Map<String,CennikRecord> cennikRecords;
    private Cennik(Map<String,CennikRecord> cennikRecords){
        this.cennikRecords = cennikRecords;
    }

    /**
     * @return Instancja klasy Cennik będącej Singletonem
     */
    public static Cennik pobierzCennik(){
        if (Cennik.self == null)
            Cennik.self = new Cennik(new HashMap<>());
        return Cennik.self;
    }

    /**
     * @param cennikRecord wprowadza rekord do listy cennika
     */
    public void dodaj(CennikRecord cennikRecord) {
        Cennik.pobierzCennik().cennikRecords.putIfAbsent(cennikRecord.tytul(), cennikRecord);
//        Cennik.pobierzCennik().cennikRecords.add(cennikRecord);
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
     * @param cenaPakiet Cena przed przekroczeniem limitu dla kazdego klienta (niezaleznie od tego czy posiada abonament czy nie)
     * @param cenaBezPakiet Cena po przekroczeniu limitu dla każdego klienta (niezaleznie od tego czy posiada abonament czy nie)
     * @param maksLiczbUrzadzen Po ilu urzadzeniach zmiana ceny dla każdego klienta (niezaleznie od tego czy posiada abonament czy nie)
     */
    public void dodaj(String gatunek, String tytul, int cenaPakiet, int cenaBezPakiet, int maksLiczbUrzadzen){
        Cennik.pobierzCennik().dodaj(new CennikRecord(gatunek, tytul, cenaPakiet, cenaBezPakiet, maksLiczbUrzadzen));
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

    public Map<String,CennikRecord> getCennikRecords() {
        return Cennik.pobierzCennik().getCennikRecords();
    }
    public CennikRecord getRecordByKey(String key){
        return Cennik.pobierzCennik().getCennikRecords().get(key);
    }
}
