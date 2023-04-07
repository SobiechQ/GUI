package W05.Z03;

import java.util.Objects;

public class Osoba {
    private String name;
    private int wiek = (int) (Math.random()*10);

    public Osoba(String name) {
        this.name = name;
    }
    public Osoba(String name, int wiek) {
        this.name = name;
        this.wiek = wiek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return getWiek() == osoba.getWiek() && Objects.equals(getName(), osoba.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWiek());
    }

    public String getName() {
        return name;
    }

    public int getWiek() {
        return wiek;
    }
}
