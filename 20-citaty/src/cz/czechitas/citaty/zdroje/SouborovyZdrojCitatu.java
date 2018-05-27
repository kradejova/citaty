package cz.czechitas.citaty.zdroje;

import java.io.*;
import java.util.*;
import cz.czechitas.citaty.*;

//SouborovyZdrojCitatu je implementaci ZdrojCitatu, musi umet to, co ZdrojCitatu,
//ZdrojCitatu - jina ikona (menu vlevo) - je to interface, kazdy zdrojCitatu musi mit metodu getCitaty(), ktera vraci seznam citatu
public class SouborovyZdrojCitatu implements ZdrojCitatu {

    private List<Citat> citaty;
    private File soubor;

    public SouborovyZdrojCitatu(File soubor) {   //konstruktor, File soubor - parametr
        this.soubor = soubor;
        citaty = nactiCitatyZeSouboru(soubor);

    }

    //private nejde volat na objektu
    private List<Citat> nactiCitatyZeSouboru(File zdrojovySoubor) {
        List<Citat> citaty = new ArrayList<>();
        Pomocnik honzik = new Pomocnik();

        List<String> radky = honzik.nactiRadkySouboru(zdrojovySoubor);

        for (int i = 0; i < radky.size(); i = i + 3) {
            String autor = radky.get(i);        //na i + 3 radku je jmeno autora
            String textCitatu = radky.get(i + 2);   //na i+2 radku je text citatu
            
            Boolean jeOblibeny = false;
            if (radky.get(i + 1).equals("1")) {
                jeOblibeny = true;
            }
            Citat nactenyCitat = new Citat(autor, textCitatu, jeOblibeny); //mam vytvoreny citat, ale nenacitam ho k tem ostatnim do seznamu

            citaty.add(nactenyCitat);       //vlozim nacteny citat do seznamu na radku 20 (ctr+klik na citaty -> zjistim ten dany seznam)

        }

        return citaty;
    }

    //public jde volat na objektu
    @Override        //znacka - vyznam: je to metoda, ktera je implementovana z toho rozhrani
    public List<Citat> getCitaty() {
        return citaty;
    }

}
