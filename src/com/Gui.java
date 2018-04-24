package com;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

/**
 * Created by mpars on 29.03.2018.
 */
public class Gui extends JFrame implements ActionListener {

    //Declarations
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu aplikacjaM;
    private JMenuItem zamknijM;
    private JPanel mainPanel;
    private JPanel patientP;
    private JPanel listaP;
    private JScrollPane scrollPane;
    private JPanel examinationP;
    private JLabel imieL;
    private JLabel nazwiskoL;
    private JLabel peselL;
    private JLabel plecL;
    private JLabel ubezpieczenieL;
    private JLabel dataL;
    private JLabel liczbaErytrcytowL;
    private JLabel stezenieHemoglobinyL;
    private JLabel stezenieZelazaL;
    private JLabel erytrocytyNormaL;
    private JLabel hemoglobinaNormaL;
    private JLabel zelazoNormaL;
    private JLabel białyNapis1;
    private JLabel białyNapis2;
    private JLabel białyNapis3;
    private JLabel białyNapis4;
    private JTextField imieTF;
    private JTextField nazwiskoTF;
    private JTextField peselTF;
    private JTextField liczbaErytrocytowTF;
    private JTextField stezenieHemoglobinyTF;
    private JTextField stezenieZelazaTF;
    private ButtonGroup plecBG;
    private JRadioButton kobietaRB;
    private JRadioButton mezczyznaRB;
    private JComboBox ubezpieczenieCB;
    private JButton zapiszPacjentB;
    private JButton anulujPacjentB;
    private JButton zapiszBadanieB;
    private JButton anulujBadanieB;
    private JButton dodajListaB;
    private JButton usunListaB;
    private JDateChooser dataDC;
    private JTable tablica;

    private GridBagConstraints gbcPanels;
    private GridBagConstraints gbcPatient;
    private GridBagConstraints gbcExamination;
    private GridBagConstraints gbcLista;

    private String plec;

    public static Vector<Patient> listaPacjentow = new Vector<>();


    public Gui() {

        //General definitions - frame and main panel
        mainPanel = new JPanel();
        frame = new JFrame("Rejestracja wyników badań");
        frame.setContentPane(mainPanel);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(this);

        //Menu prepaing
        menuBar = new JMenuBar();
        aplikacjaM = new JMenu("Aplikacja");
        zamknijM = new JMenuItem("Zamknij ALT + F4");
        zamknijM.addActionListener(this);
        aplikacjaM.add(zamknijM);
        menuBar.add(aplikacjaM);
        frame.setJMenuBar(menuBar);


        //Setting general Constraints for Panels
        mainPanel.setLayout(new GridBagLayout());
        gbcPanels = new GridBagConstraints();
        gbcPanels.fill = GridBagConstraints.BOTH;
        /*gbcPanels.insets = new Insets(1,1,1,1);*/


        //Setting com.Patient Panel Constraints
        gbcPanels.weightx = 0.7;
        gbcPanels.weighty = 1;
        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;


        //Setting general constraints for components in patient panel
        patientP = new JPanel();
        patientP.setBorder(BorderFactory.createTitledBorder("Dane Pacjenta"));
        patientP.setLayout(new GridBagLayout());
        gbcPatient = new GridBagConstraints();
        gbcPatient.fill = GridBagConstraints.BOTH;
        gbcPatient.insets = new Insets(10, 10, 10, 5);
        gbcPatient.weightx = 1;
        gbcPatient.weighty = 1;
        gbcPatient.ipady = 5;


        //Setting individual patient's components
        imieL = new JLabel("Imię:");
        gbcPatient.gridx = 0;
        gbcPatient.gridy = 0;
        gbcPatient.gridwidth = 2;
        patientP.add(imieL, gbcPatient);

        imieTF = new JTextField();
        imieTF.addActionListener(this);
        gbcPatient.gridx = 2;
        gbcPatient.gridy = 0;
        patientP.add(imieTF, gbcPatient);
        imieTF.addActionListener(this);


        nazwiskoL = new JLabel("Nazwisko:");
        gbcPatient.gridx = 0;
        gbcPatient.gridy = 1;
        patientP.add(nazwiskoL, gbcPatient);

        nazwiskoTF = new JTextField();
        gbcPatient.gridx = 2;
        gbcPatient.gridy = 1;
        gbcPatient.gridwidth = 2;
        patientP.add(nazwiskoTF, gbcPatient);


        peselL = new JLabel("PESEL:");
        gbcPatient.gridx = 0;
        gbcPatient.gridy = 2;
        patientP.add(peselL, gbcPatient);

        peselTF = new JTextField();
        gbcPatient.gridx = 2;
        gbcPatient.gridy = 2;
        gbcPatient.gridwidth = 2;
        patientP.add(peselTF, gbcPatient);


        plecL = new JLabel("Płeć:");
        gbcPatient.gridx = 0;
        gbcPatient.gridy = 3;
        patientP.add(plecL, gbcPatient);

        plecBG = new ButtonGroup();

        kobietaRB = new JRadioButton("Kobieta", false);
        plecBG.add(kobietaRB);
        gbcPatient.ipadx = 10;
        gbcPatient.gridx = 2;
        gbcPatient.gridy = 3;
        gbcPatient.gridwidth = 1;
        kobietaRB.addActionListener(this);
        patientP.add(kobietaRB, gbcPatient);

        mezczyznaRB = new JRadioButton("Mężczyzna", false);
        plecBG.add(mezczyznaRB);
        gbcPatient.gridx = 3;
        gbcPatient.gridy = 3;
        mezczyznaRB.addActionListener(this);
        patientP.add(mezczyznaRB, gbcPatient);

        ubezpieczenieL = new JLabel("Ubezpieczenie:");
        gbcPatient.gridx = 0;
        gbcPatient.gridy = 4;
        gbcPatient.gridwidth = 2;
        patientP.add(ubezpieczenieL, gbcPatient);

        String[] ubezpieczeniaS = {"NFZ", "Prywatne", "Brak"};
        ubezpieczenieCB = new JComboBox(ubezpieczeniaS);
        ubezpieczenieCB.setSelectedItem(null);
        gbcPatient.gridx = 2;
        gbcPatient.gridy = 4;
        patientP.add(ubezpieczenieCB, gbcPatient);


        zapiszPacjentB = new JButton("Zapisz");
        gbcPatient.ipadx = 10;
        gbcPatient.gridx = 0;
        gbcPatient.gridy = 5;
        gbcPatient.gridwidth = 1;
        zapiszPacjentB.addActionListener(this);
        patientP.add(zapiszPacjentB, gbcPatient);

        anulujPacjentB = new JButton("Anuluj");
        anulujPacjentB.addActionListener(this);
        gbcPatient.gridx = 1;
        gbcPatient.gridy = 5;
        patientP.add(anulujPacjentB, gbcPatient);


        mainPanel.add(patientP, gbcPanels);  //Adding patient panel to main panel


        //Setting Constraints for examination panel
        gbcPanels.weightx = 0.7;
        gbcPanels.weighty = 1;
        gbcPanels.gridx = 0;
        gbcPanels.gridy = 1;


        //Setting examination panel constraint
        examinationP = new JPanel();
        examinationP.setBorder(BorderFactory.createTitledBorder("Badanie"));
        examinationP.setLayout(new GridBagLayout());
        gbcExamination = new GridBagConstraints();
        gbcExamination.fill = GridBagConstraints.BOTH;
        gbcExamination.insets = new Insets(10, 10, 10, 10);
        gbcExamination.weightx = 1;
        gbcExamination.weighty = 1;
        gbcExamination.ipady = 5;

        //Setting inndividual constraints for examination panel
        dataL = new JLabel("Data");
        gbcExamination.gridx = 0;
        gbcExamination.gridy = 0;
        gbcExamination.gridwidth = 2;
        examinationP.add(dataL, gbcExamination);

        dataDC = new JDateChooser(new Date());
        gbcExamination.gridx = 2;
        gbcExamination.gridy = 0;
        examinationP.add(dataDC, gbcExamination);

        liczbaErytrcytowL = new JLabel("Liczba erytrocytów:");
        gbcExamination.gridx = 0;
        gbcExamination.gridy = 1;
        examinationP.add(liczbaErytrcytowL, gbcExamination);

        liczbaErytrocytowTF = new JTextField();
        gbcExamination.gridx = 2;
        gbcExamination.gridy = 1;
        gbcExamination.gridwidth = 1;
        examinationP.add(liczbaErytrocytowTF, gbcExamination);

        erytrocytyNormaL = new JLabel("1/ul");
        gbcExamination.gridx = 3;
        gbcExamination.gridy = 1;
        examinationP.add(erytrocytyNormaL, gbcExamination);

        stezenieHemoglobinyL = new JLabel("Stężenie hemoglobiny");
        gbcExamination.gridx = 0;
        gbcExamination.gridy = 2;
        gbcExamination.gridwidth = 2;
        examinationP.add(stezenieHemoglobinyL, gbcExamination);

        stezenieHemoglobinyTF = new JTextField();
        gbcExamination.gridx = 2;
        gbcExamination.gridy = 2;
        gbcExamination.gridwidth = 1;
        examinationP.add(stezenieHemoglobinyTF, gbcExamination);

        hemoglobinaNormaL = new JLabel("mmol/l");
        gbcExamination.gridx = 3;
        gbcExamination.gridy = 2;
        examinationP.add(hemoglobinaNormaL, gbcExamination);

        stezenieZelazaL = new JLabel("Stężenie żelaza");
        gbcExamination.gridx = 0;
        gbcExamination.gridy = 3;
        gbcExamination.gridwidth = 2;
        examinationP.add(stezenieZelazaL, gbcExamination);

        stezenieZelazaTF = new JTextField();
        gbcExamination.gridx = 2;
        gbcExamination.gridy = 3;
        gbcExamination.gridwidth = 1;
        examinationP.add(stezenieZelazaTF, gbcExamination);

        zelazoNormaL = new JLabel("ug/dl");
        gbcExamination.gridx = 3;
        gbcExamination.gridy = 3;
        examinationP.add(zelazoNormaL, gbcExamination);

        zapiszBadanieB = new JButton("Zapisz");
        zapiszBadanieB.addActionListener(this);
        gbcExamination.gridx = 0;
        gbcExamination.gridy = 4;
        examinationP.add(zapiszBadanieB, gbcExamination);

        anulujBadanieB = new JButton("Anuluj");
        anulujBadanieB.addActionListener(this);
        gbcExamination.gridx = 1;
        gbcExamination.gridy = 4;
        examinationP.add(anulujBadanieB, gbcExamination);

        mainPanel.add(examinationP, gbcPanels);

        listaP = new JPanel();
        listaP.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów"));
        gbcPanels.weightx = 1;
        gbcPanels.gridheight = 2;
        gbcPanels.gridx = 1;
        gbcPanels.gridy = 0;


        //Adding table
        tablica = new JTable() {

            private static final long serialVersionUID = 1L;

            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(Library.columns);
        tablica.setModel(defaultTableModel);
        tablica.setRowHeight(30);
        //Library.setWidth(tablica);


        ListSelectionModel cellSelectionModel = tablica.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                int selectedRow = tablica.getSelectedRow();
                if (selectedRow != -1) {
                    Library.setPanelEnabled(examinationP, true);
                    if (listaPacjentow.get(selectedRow).getBadanie()) {
                        dataDC.setDate(listaPacjentow.get(selectedRow).getBadanieObject().getDate());
                        liczbaErytrocytowTF.setText(String.valueOf(listaPacjentow.get(selectedRow).getBadanieObject().getLiczbaErytrocytow()));
                        stezenieHemoglobinyTF.setText(String.valueOf(listaPacjentow.get(selectedRow).getBadanieObject().getStezenieHemoglobiny()));
                        stezenieZelazaTF.setText(String.valueOf(listaPacjentow.get(selectedRow).getBadanieObject().getStezenieZelaza()));
                    } else {
                        dataDC.setDate(new Date());
                        liczbaErytrocytowTF.setText("");
                        stezenieHemoglobinyTF.setText("");
                        stezenieZelazaTF.setText("");
                    }
                } else {
                    Library.setPanelEnabled(examinationP, false);
                }

                dodajListaB.setEnabled(false);

                //System.out.println("Selected: " + selectedRow);
            }

        });

        scrollPane = new JScrollPane(tablica, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        listaP.setLayout(new GridBagLayout());
        gbcLista = new GridBagConstraints();
        gbcLista.fill = GridBagConstraints.BOTH;
        gbcLista.insets = new Insets(5, 5, 5, 5);
        gbcLista.gridx = 0;
        gbcLista.gridy = 0;
        gbcLista.weightx = 1;
        gbcLista.weighty = 1;
        gbcLista.gridwidth = 6;
        listaP.add(scrollPane, gbcLista);

        dodajListaB = new JButton("Dodaj");
        dodajListaB.addActionListener(this);
        gbcLista.insets = new Insets(40, 5, 5, 5);
        gbcLista.gridx = 0;
        gbcLista.gridy = 1;
        gbcLista.weighty = 0.1;
        gbcLista.gridwidth = 1;
        listaP.add(dodajListaB, gbcLista);

        usunListaB = new JButton("Usuń");
        usunListaB.addActionListener(this);
        gbcLista.gridx = 1;
        gbcLista.gridy = 1;
        gbcLista.weighty = 0.1;
        gbcLista.gridwidth = 1;
        listaP.add(usunListaB, gbcLista);

        gbcLista.gridx = 2;
        gbcLista.gridwidth = 1;
        białyNapis1 = new JLabel("        ");
        listaP.add(białyNapis1, gbcLista);
        białyNapis2 = new JLabel("        ");
        gbcLista.gridx = 3;
        listaP.add(białyNapis2, gbcLista);
        białyNapis3 = new JLabel("        ");
        gbcLista.gridx = 4;
        listaP.add(białyNapis3, gbcLista);
        białyNapis4 = new JLabel("        ");
        gbcLista.gridx = 5;
        listaP.add(białyNapis4, gbcLista);

        mainPanel.add(listaP, gbcPanels);


        Library.setPanelEnabled(patientP, false);
        Library.setPanelEnabled(examinationP, false);


        frame.pack();
        frame.setSize(1446, 766);
        frame.setMinimumSize(new Dimension());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1350, 725));

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicked = e.getSource();
        //System.out.println(clicked.toString());
        //TODO make switch here if possible -> Object cliked.toString() ???!
        if (clicked == zamknijM)
            frame.dispose();

        if (clicked == mezczyznaRB) {
            plec = "M";
        }
        if (clicked == kobietaRB) {
            plec = "K";
        }
        if (clicked == zapiszPacjentB) {

            if (!(peselTF.getText().length() == 11 && org.apache.commons.lang3.StringUtils.isNumeric(peselTF.getText()))) {
                Library.messegeWarning("Pesel powinien mieć 11 cyfr");
            } else if (peselTF.getText().isEmpty()) {
                Library.messegeWarning("Pusta wartość pola tekstowego pesel");
            } else if (imieTF.getText().isEmpty()) {
                Library.messegeWarning("Pusta wartość pola tekstowego imię");
            } else if (nazwiskoTF.getText().isEmpty()) {
                Library.messegeWarning("Pusta wartość pola tekstowego nazwisko");
            } else if (plec == null) {
                Library.messegeWarning("Nie wybrano płci pacjenta");
            } else if (ubezpieczenieCB.getSelectedItem() == null) {
                Library.messegeWarning("Nie wybrano ubezpieczenia");
            } else {
                Patient patient = new Patient(imieTF.getText(), nazwiskoTF.getText(),
                        peselTF.getText(), plec, String.valueOf(ubezpieczenieCB.getSelectedItem()));

                if (!Library.contains(listaPacjentow, patient)) {
                    listaPacjentow.add(patient);
                    imieTF.setText("");
                    nazwiskoTF.setText("");
                    peselTF.setText("");
                    kobietaRB.setSelected(false);
                    mezczyznaRB.setSelected(false);
                    ubezpieczenieCB.setSelectedItem(null);
                }
                System.out.println(tablica.getWidth()); //to do wyznaczania szerokości wierszy

                Library.setPanelEnabled(patientP, false);
                Library.tableUpdate(listaPacjentow, tablica);
                //TODO: Clear TextFields after dropping the patient to the Table


            }
        }
        if (clicked == anulujPacjentB) {
            imieTF.setText("");
            nazwiskoTF.setText("");
            peselTF.setText("");
            kobietaRB.setSelected(false);
            mezczyznaRB.setSelected(false);
            ubezpieczenieCB.setSelectedItem(null);
        }
        if (clicked == anulujBadanieB) {
            dataDC.setDate(new Date());
            liczbaErytrocytowTF.setText("");
            stezenieHemoglobinyTF.setText("");
            stezenieZelazaTF.setText("");
        }
        if (clicked == zapiszBadanieB) {
            //TODO Check if dot or comma is puted -> catch error -> Warning Dialog

            // isNumeric() does not recognize double as a number so that i used remove method
            if (liczbaErytrocytowTF.getText().isEmpty() ||
                    !org.apache.commons.lang3.StringUtils.isNumeric(
                            org.apache.commons.lang3.StringUtils.remove(liczbaErytrocytowTF.getText(), ".")))
                Library.messegeWarning("Błędnie wypełniono pole tekstowe liczba Erytrocyów");
            else if (liczbaErytrocytowTF.getText().isEmpty() ||
                    !org.apache.commons.lang3.StringUtils.isNumeric(
                            org.apache.commons.lang3.StringUtils.remove(stezenieHemoglobinyTF.getText(), ".")))
                Library.messegeWarning("Błędnie wypełniono pole tekstowe Stężenie Hemoglobiny");
            else if (liczbaErytrocytowTF.getText().isEmpty() ||
                    !org.apache.commons.lang3.StringUtils.isNumeric(
                            org.apache.commons.lang3.StringUtils.remove(stezenieZelazaTF.getText(), ".")))
                Library.messegeWarning("Błędnie wypełniono pole tekstowe Stężenie żelaza");
            else {

                boolean warningFlag = false;
                if (plec.equals("K")) {
                    if (Long.parseLong(liczbaErytrocytowTF.getText()) < 3900000 || Long.parseLong(liczbaErytrocytowTF.getText()) > 5600000) {
                        liczbaErytrocytowTF.setBackground(Color.YELLOW);
                        warningFlag = true;
                    }
                    if (Double.parseDouble(stezenieHemoglobinyTF.getText()) < 6.8 || Double.parseDouble(stezenieHemoglobinyTF.getText()) > 9.3) {
                        stezenieHemoglobinyTF.setBackground(Color.YELLOW);
                        warningFlag = true;
                    }
                    if (Double.parseDouble(stezenieZelazaTF.getText()) < 50 || Double.parseDouble(stezenieZelazaTF.getText()) > 175) {
                        liczbaErytrocytowTF.setBackground(Color.YELLOW);
                        warningFlag = true;
                    }
                } else {
                    if (Long.parseLong(liczbaErytrocytowTF.getText()) < 4500000 || Long.parseLong(liczbaErytrocytowTF.getText()) > 6500000) {
                        liczbaErytrocytowTF.setBackground(Color.YELLOW);
                        warningFlag = true;
                    }
                    if (Double.parseDouble(stezenieHemoglobinyTF.getText()) < 7.4 || Double.parseDouble(stezenieHemoglobinyTF.getText()) > 10.5) {
                        stezenieHemoglobinyTF.setBackground(Color.YELLOW);
                        warningFlag = true;
                    }
                    if (Double.parseDouble(stezenieZelazaTF.getText()) < 50 || Double.parseDouble(stezenieZelazaTF.getText()) > 175) {
                        stezenieZelazaTF.setBackground(Color.YELLOW);
                        warningFlag = true;
                    }
                }
                if (warningFlag == true) {
                    Library.outOfBoundsWarning();
                    liczbaErytrocytowTF.setBackground(Color.WHITE);
                    stezenieHemoglobinyTF.setBackground(Color.WHITE);
                    stezenieZelazaTF.setBackground(Color.WHITE);
                }
                listaPacjentow.get(tablica.getSelectedRow()).setBadanieObject(new Badanie(dataDC.getDate(), Long.parseLong(liczbaErytrocytowTF.getText())
                        , Double.parseDouble(stezenieHemoglobinyTF.getText()), Double.parseDouble(stezenieZelazaTF.getText())));
                listaPacjentow.get(tablica.getSelectedRow()).setBadanie(true);
                Library.tableUpdate(listaPacjentow, tablica);
                System.out.println();
                dataDC.setDate(new Date());
                liczbaErytrocytowTF.setText("");
                stezenieHemoglobinyTF.setText("");
                stezenieZelazaTF.setText("");
                dodajListaB.setEnabled(true);
                usunListaB.setEnabled(true);
            }
        }
        if (clicked == dodajListaB) {
            Library.setPanelEnabled(patientP, true);
        }
        if (clicked == usunListaB) {
            if (tablica.getSelectedRow() != -1) {
                listaPacjentow.remove(tablica.getSelectedRow());
                Library.tableUpdate(listaPacjentow, tablica);
                dodajListaB.setEnabled(true);
                usunListaB.setEnabled(true);
                dataDC.setDate(new Date());
                liczbaErytrocytowTF.setText("");
                stezenieHemoglobinyTF.setText("");
                stezenieZelazaTF.setText("");
            }
        }


    }
}