package cz.czechitas.citaty;

import java.util.*;
import cz.czechitas.citaty.zdroje.*;

public class CitacniSluzba {

    private ZdrojCitatu zdroj;

    public CitacniSluzba(ZdrojCitatu zdrojCitatu) {
        this.zdroj = zdrojCitatu;
    }

    public Citat getNahodnyCitat() {      //metoda muze neco vracet, tady vraci Citat
        int pocetCitatu = getPocetCitatu();

        Random random = new Random(); //generator nahodnych cisel
        int cisloCitatu = random.nextInt(zdroj.getCitaty().size());   //zdrojCitatu.getCitaty().size() = velikost seznamu zdrojCitatu, random.nextInt - vraci nahodne cislo od 0 po hranici-1 v zavorce, tady si nahodne vyberu index citatu a na dalsim radku uz pracuji s timto vybranym indexem

        Citat nahodnyCitat = zdroj.getCitaty().get(cisloCitatu);
        return nahodnyCitat;
    }

    public int getPocetCitatu() {    //pocita pocet citatu celkem
        int pocetCitatu = zdroj.getCitaty().size();
        return pocetCitatu;
    }

    public int getPocetAutoru() {
        int pocetAutoru =
    }
}
