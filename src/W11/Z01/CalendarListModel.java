package W11.Z01;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarListModel extends AbstractListModel<String> {
    private final LocalDate currentDate;

    public CalendarListModel() {
        currentDate = LocalDate.now();
    }

    @Override
    public int getSize() {
        return currentDate.lengthOfMonth();
    }

    @Override
    public String getElementAt(int index) {
        LocalDate date = currentDate.withDayOfMonth(index + 1);
        String dayOfMonth = String.valueOf(date.getDayOfMonth());
        Locale locale = new Locale("PL");
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
        return dayOfMonth + " - " + dayOfWeek;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalendarListModel::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame(LocalDate.now().getMonth().getValue() + "." + LocalDate.now().getYear());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JList<String> calendarList = new JList<>(new CalendarListModel());
        calendarList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        calendarList.setSelectedIndex(LocalDate.now().getDayOfMonth() - 1);

        JScrollPane scrollPane = new JScrollPane(calendarList);

        frame.getContentPane().add(scrollPane);
        frame.setSize(240,180);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

/*
    JList<String> calendarList = new JList<>(new CalendarListModel()); - Tworzy nowy obiekt JList o typie elementów String i przypisuje
    go do zmiennej calendarList. Jako argument konstruktora JList podawany jest nowy obiekt CalendarListModel,
    który jest naszym własnym modelem danych.

    calendarList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); - Ustawia tryb zaznaczania elementów listy na
    SINGLE_SELECTION, co oznacza, że użytkownik będzie mógł zaznaczyć tylko jeden element na liście naraz.

    calendarList.setSelectedIndex(LocalDate.now().getDayOfMonth() - 1); - Ustawia zaznaczony indeks
    na liście. W tym przypadku, używając LocalDate.now().getDayOfMonth() - 1,
    pobieramy bieżący dzień miesiąca i odejmujemy 1, ponieważ indeksy listy zaczynają się od 0.
    To oznacza, że lista zostanie automatycznie przewinięta do zaznaczonego dnia miesiąca przy starcie programu
 */
