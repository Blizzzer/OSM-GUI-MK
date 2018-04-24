package com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public final class Library {
    public static String[] columns = {"Imię i nazwisko", "Płeć", "PESEL", "Ubezpieczenie", "Badanie"};

    public static void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);

        Component[] components = panel.getComponents();

        for (int i = 0; i < components.length; i++) {
            if (components[i].getClass().getName() == "javax.swing.JPanel") {
                setPanelEnabled((JPanel) components[i], isEnabled);
            }

            components[i].setEnabled(isEnabled);
        }
    }

    public static void tableUpdate(Vector<Patient> listaPacjentow, JTable table) {
        Object[][] data = new Object[listaPacjentow.size()][5];
        for (int i = 0; i < listaPacjentow.size(); i++) {
            data[i] = listaPacjentow.get(i).getObjectArray();
        }

        table.setModel(createTableModel(data));

    }

    public static DefaultTableModel createTableModel(Object[][] data) {

        return new DefaultTableModel(data, columns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static void setWidth(JTable tablica) {
        int width = tablica.getWidth();
        tablica.getColumnModel().getColumn(0).setWidth(width / 4);
        tablica.getColumnModel().getColumn(1).setWidth(width / 8);
        tablica.getColumnModel().getColumn(2).setWidth(width / 4);
        tablica.getColumnModel().getColumn(3).setWidth(width / 4);
        tablica.getColumnModel().getColumn(4).setWidth(width / 8);
        tablica.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }


    /**
     * @param list
     * @param patient
     * @return true if list consists a given patient
     */
    public static boolean contains(List list, Patient patient) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (patient.equals(list.get(i))) {
                messegeWarning("przeszukiwaniu bazy danych, Pacjent został już wcześniej zarejestrowany");
                flag = true;
            }
        }
        return flag;
    }

    public static void messegeWarning(String warning) {
        JOptionPane.showMessageDialog(null,
                "Wprowadzono błędne dane " +
                        "\nProszę wprowadzić poprawne dane\nProblem polega na : " + warning,
                "Błąd", JOptionPane.WARNING_MESSAGE);
    }

    public static void outOfBoundsWarning() {
        JOptionPane.showMessageDialog(null,
                "UWAGA !!! " + "\nŻółte pola tekstowe sygnalizują wartości wychodzące poza normę",
                "Ostrzeżenie",
                JOptionPane.WARNING_MESSAGE);
    }


}
