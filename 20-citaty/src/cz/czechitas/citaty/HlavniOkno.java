package cz.czechitas.citaty;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
//import cz.czechitas.citaty.zdroje.*;
import cz.czechitas.citaty.zdroje.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JMenuBar menuHlavni;
    JMenu menuSoubor;
    JMenuItem menuOtevritSoubor;
    JMenuItem menuUlozitSoubor;
    JMenu menuZobrazit;
    JCheckBoxMenuItem menuPouzeOblibene;
    JButton btnNahodnyCitat;
    JButton btnAutoruvCitat;
    JButton btnNahodnyOblibenyCitat;
    JCheckBox chckOblibeny;
    JLabel labAutorTitle;
    JLabel labAutor;
    JLabel labCitatTitle;
    JScrollPane scrollPane1;
    JTextArea txtCitat;
    JLabel labPocetCitatuCelkemTitle;
    JLabel labPocetCitatuCelkem;
    JLabel labPocetAutoruTitle;
    JLabel labPocetAutoru;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;
    Citat aktualniCitat;
    ZdrojCitatu zdrojCitatu; //ZdrojCitatu - interface, StatickyZdrojCitatu - ma ty citaty v sobe zabudovane, SouborovyZdrojCitatu - nacita citaty ze souboru,
    CitacniSluzba citacniSluzba;

    public HlavniOkno() {   //konstruktor pro tridu Hlavni okno, nastavujeme zde pocet citatu a pocet autoru
        initComponents();

        nastavCitacniSluzbu(new StatickyZdrojCitatu());

        int pocetCitatu = citacniSluzba.getPocetCitatu();
        labPocetCitatuCelkem.setText(String.valueOf(pocetCitatu));

        labPocetAutoru.setText(String.valueOf(citacniSluzba.getPocetAutoru()));
    }

    private void stisknutoBtnNahodnyCitat(ActionEvent e) {    //kliknuti na tlac. Nahodny citat
        aktualniCitat = citacniSluzba.getNahodnyCitat();   //nahodne vybrany citat
        aktualizujHodnotyVeFormulari();
    }

    private void menuOtevritSoubor(ActionEvent e) {
        JFileChooser vyberovyDialog = new JFileChooser(); //JFileChooser - komponenta swingu pro vyber souboru
        int vysledek = vyberovyDialog.showOpenDialog(this); // this = hlavni okno, int vysledek = navratova hodnota programu,
        if (vysledek == JFileChooser.APPROVE_OPTION) {   //APPROVE_OPTION je enum
            File soubor = vyberovyDialog.getSelectedFile();
            nastavCitacniSluzbu(new SouborovyZdrojCitatu(soubor));
            if (citacniSluzba.existujeOblibenyCitat()) {
                btnNahodnyOblibenyCitat.setEnabled(true);
            } else {
                btnNahodnyOblibenyCitat.setEnabled(false);
            }
            labAutor.setText("");
            txtCitat.setText("");
            aktualniCitat = null;
            btnAutoruvCitat.setEnabled(false);
            labPocetAutoru.setText(String.valueOf(citacniSluzba.getPocetAutoru()));
            chckOblibeny.setSelected(false);
        }

    }

    private void nastavCitacniSluzbu(ZdrojCitatu zdroj) {
        zdrojCitatu = zdroj;
        citacniSluzba = new CitacniSluzba(zdroj);
        labPocetCitatuCelkem.setText(String.valueOf(citacniSluzba.getPocetCitatu()));
    }

    private void poStisknutiBtnAutoruvCitat(ActionEvent e) {
        aktualniCitat = citacniSluzba.getNahodnyCitatOdAutora(aktualniCitat);
        aktualizujHodnotyVeFormulari();
    }

    private void kliknutiNaChckOblibeny(ActionEvent e) {
        aktualniCitat.setOblibene(!aktualniCitat.isOblibene()); //nastavim opacnou hodnotu pri kliknuti na checkbox než tam před kliknutím byla
        if (citacniSluzba.existujeOblibenyCitat()) {
            btnNahodnyOblibenyCitat.setEnabled(true);
        } else {
            btnNahodnyOblibenyCitat.setEnabled(false);
        }
    }

    private void poStisknutiBtnNahodnyOblibenyCitat(ActionEvent e) {
        aktualniCitat = citacniSluzba.getNahodnyOblibenyCitat();
        aktualizujHodnotyVeFormulari();
    }

    private void aktualizujHodnotyVeFormulari() {
        labAutor.setText(aktualniCitat.getAutor()); //zobrazeni v labAutor autora nahodne vybraneho citatu
        txtCitat.setText(aktualniCitat.getText());  //zobrazeni v labText textu nahodne vybraneho citatu
        btnAutoruvCitat.setEnabled(true);
        chckOblibeny.setSelected(aktualniCitat.isOblibene());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        menuHlavni = new JMenuBar();
        menuSoubor = new JMenu();
        menuOtevritSoubor = new JMenuItem();
        menuUlozitSoubor = new JMenuItem();
        menuZobrazit = new JMenu();
        menuPouzeOblibene = new JCheckBoxMenuItem();
        btnNahodnyCitat = new JButton();
        btnAutoruvCitat = new JButton();
        btnNahodnyOblibenyCitat = new JButton();
        chckOblibeny = new JCheckBox();
        labAutorTitle = new JLabel();
        labAutor = new JLabel();
        labCitatTitle = new JLabel();
        scrollPane1 = new JScrollPane();
        txtCitat = new JTextArea();
        labPocetCitatuCelkemTitle = new JLabel();
        labPocetCitatuCelkem = new JLabel();
        labPocetAutoruTitle = new JLabel();
        labPocetAutoru = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prohl\u00ed\u017ee\u010d cit\u00e1t\u016f");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "insets rel,hidemode 3",
                // columns
                "[fill]" +
                        "[left]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[grow,fill]",
                // rows
                "[fill]" +
                        "[]" +
                        "[]" +
                        "[grow]" +
                        "[]" +
                        "[]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //======== menuHlavni ========
        {

            //======== menuSoubor ========
            {
                menuSoubor.setText("Soubor");

                //---- menuOtevritSoubor ----
                menuOtevritSoubor.setText("Otev\u0159\u00edt");
                menuOtevritSoubor.addActionListener(e -> menuOtevritSoubor(e));
                menuSoubor.add(menuOtevritSoubor);

                //---- menuUlozitSoubor ----
                menuUlozitSoubor.setText("Ulo\u017eit");
                menuSoubor.add(menuUlozitSoubor);
            }
            menuHlavni.add(menuSoubor);

            //======== menuZobrazit ========
            {
                menuZobrazit.setText("Zobrazit");

                //---- menuPouzeOblibene ----
                menuPouzeOblibene.setText("Pouze Obl\u00edben\u00e9");
                menuZobrazit.add(menuPouzeOblibene);
            }
            menuHlavni.add(menuZobrazit);
        }
        setJMenuBar(menuHlavni);

        //---- btnNahodnyCitat ----
        btnNahodnyCitat.setText("N\u00e1hodn\u00fd cit\u00e1t");
        btnNahodnyCitat.addActionListener(e -> stisknutoBtnNahodnyCitat(e));
        contentPane.add(btnNahodnyCitat, "cell 0 0 2 1");

        //---- btnAutoruvCitat ----
        btnAutoruvCitat.setText("N\u00e1hodn\u00fd od autora");
        btnAutoruvCitat.setEnabled(false);
        btnAutoruvCitat.addActionListener(e -> poStisknutiBtnAutoruvCitat(e));
        contentPane.add(btnAutoruvCitat, "cell 2 0 2 1");

        //---- btnNahodnyOblibenyCitat ----
        btnNahodnyOblibenyCitat.setText("N\u00e1hodn\u00fd obl\u00edben\u00fd cit\u00e1t");
        btnNahodnyOblibenyCitat.setEnabled(false);
        btnNahodnyOblibenyCitat.addActionListener(e -> poStisknutiBtnNahodnyOblibenyCitat(e));
        contentPane.add(btnNahodnyOblibenyCitat, "cell 4 0");

        //---- chckOblibeny ----
        chckOblibeny.setText("Obl\u00edben\u00fd");
        chckOblibeny.addActionListener(e -> kliknutiNaChckOblibeny(e));
        contentPane.add(chckOblibeny, "cell 5 0");

        //---- labAutorTitle ----
        labAutorTitle.setText("Autor");
        contentPane.add(labAutorTitle, "cell 0 1,alignx center,growx 0");
        contentPane.add(labAutor, "cell 2 1 4 1,alignx left,growx 0");

        //---- labCitatTitle ----
        labCitatTitle.setText("Citat");
        contentPane.add(labCitatTitle, "cell 0 2,alignx center,growx 0");

        //======== scrollPane1 ========
        {

            //---- txtCitat ----
            txtCitat.setLineWrap(true);
            txtCitat.setColumns(60);
            txtCitat.setRows(20);
            txtCitat.setEditable(false);
            scrollPane1.setViewportView(txtCitat);
        }
        contentPane.add(scrollPane1, "cell 1 2 5 2,grow");

        //---- labPocetCitatuCelkemTitle ----
        labPocetCitatuCelkemTitle.setText("Cit\u00e1t\u016f celkem:");
        contentPane.add(labPocetCitatuCelkemTitle, "cell 0 5");

        //---- labPocetCitatuCelkem ----
        labPocetCitatuCelkem.setText("0");
        contentPane.add(labPocetCitatuCelkem, "cell 1 5,alignx left,growx 0");

        //---- labPocetAutoruTitle ----
        labPocetAutoruTitle.setText("| Celkem Autor\u016f:");
        contentPane.add(labPocetAutoruTitle, "cell 2 5");

        //---- labPocetAutoru ----
        labPocetAutoru.setText("0");
        contentPane.add(labPocetAutoru, "cell 3 5");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
