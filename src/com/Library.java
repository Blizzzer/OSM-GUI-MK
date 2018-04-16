package com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public final class Library {
    public static String[] columns = { "Imię i nazwisko", "Płeć", "PESEL", "Ubezpieczenie", "Badanie" };
    public static void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);

        Component[] components = panel.getComponents();

        for(int i = 0; i < components.length; i++) {
            if(components[i].getClass().getName() == "javax.swing.JPanel") {
                setPanelEnabled((JPanel) components[i], isEnabled);
            }

            components[i].setEnabled(isEnabled);
        }
    }
    public static void tableUpdate(Vector<Patient> listaPacjentow, JTable table) {
        Object[][] data = new Object[listaPacjentow.size()][5];
        for(int i =0; i<listaPacjentow.size();i++){
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
}
