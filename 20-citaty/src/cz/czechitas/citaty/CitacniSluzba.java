package cz.czechitas.citaty;

import java.util.*;
import cz.czechitas.citaty.zdroje.*;

public class CitacniSluzba {

    private ZdrojCitatu zdroj;

    public CitacniSluzba(ZdrojCitatu zdrojCitatu) {
        this.zdroj = zdrojCitatu;
    }

    public Citat getNahodnyCitat() {      //metoda muze neco vracet, tady vraci Citat

        Random random = new Random(); //generator nahodnych cisel
        int cisloCitatu = random.nextInt(zdroj.getCitaty().size());   //zdrojCitatu.getCitaty().size() = velikost seznamu zdrojCitatu, random.nextInt - vraci nahodne cislo od 0 po hranici-1 v zavorce, tady si nahodne vyberu index citatu a na dalsim radku uz pracuji s timto vybranym indexem

        Citat nahodnyCitat = zdroj.getCitaty().get(cisloCitatu);
        return nahodnyCitat;
    }

    public Citat getNahodnyCitatOdAutora(Citat citat) {

        List<Citat> vyberCitatu = new ArrayList<>();   //prazdny seznam

        List<Citat> seznamVsechCitatu = zdroj.getCitaty();

        for (Citat c : seznamVsechCitatu) {    //Citat c je ten, ktery prochazim v tom for cyklu, mohl by se misto c jmenovat treba xyz
            if (c.getAutor().equals(citat.getAutor())) {
                vyberCitatu.add(c);   //citat.add() - tohle bylo špatně, protože na tride citat neni definovana metoda add, ta je definovana na seznamu
            }
        }

        Random random = new Random(); //generator nahodnych cisel
        int cisloCitatu = random.nextInt(vyberCitatu.size());   //zdrojCitatu.getCitaty().size() = velikost seznamu zdrojCitatu, random.nextInt - vraci nahodne cislo od 0 po hranici-1 v zavorce, tady si nahodne vyberu index citatu a na dalsim radku uz pracuji s timto vybranym indexem

        Citat nahodnyCitat = vyberCitatu.get(cisloCitatu);
        return nahodnyCitat;

    }

    public Citat getNahodnyOblibenyCitat() {
        List<Citat> vyberOblibenehoCitatu = new ArrayList<>();

        List<Citat> seznamVsechOblibenychCitatu = zdroj.getCitaty();
        for (Citat c : seznamVsechOblibenychCitatu) {
            if (c.isOblibene()) {
                vyberOblibenehoCitatu.add(c);
            }
        }

        Random random = new Random();
        int cisloCitatu = random.nextInt(vyberOblibenehoCitatu.size());   //zdrojCitatu.getCitaty().size() = velikost seznamu zdrojCitatu, random.nextInt - vraci nahodne cislo od 0 po hranici-1 v zavorce, tady si nahodne vyberu index citatu a na dalsim radku uz pracuji s timto vybranym indexem

        Citat nahodnyCitat = vyberOblibenehoCitatu.get(cisloCitatu);
        return nahodnyCitat;

    }

    public Boolean existujeOblibenyCitat() {
        for (Citat c : zdroj.getCitaty()) {
            if (c.isOblibene()) {
                return true;
            }
        }
        return false;
    }

    public int getPocetCitatu() {    //pocita pocet citatu celkem
        int pocetCitatu = zdroj.getCitaty().size();
        return pocetCitatu;
    }

    public int getPocetAutoru() {     //pocita pocet autoru
        Set<String> jmena = new HashSet<>();
        for (Citat c : zdroj.getCitaty()) {
            jmena.add(c.getAutor());

        }
        return jmena.size();
    }

}
