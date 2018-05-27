package cz.czechitas.citaty;

import javax.swing.text.*;

public class Citat {

    private String autor;    //globalni promene*
    private String text;
    private Boolean oblibene;

    //atribut Boolean oblibene se tyka citatu, ktere uz oblibenost maji urcenou pri vytvoreni
    public Citat(String autor, String text, Boolean oblibene) { //konstruktor, kazdy objekt citat ma od zacatku atribut autor a atribut jmeno
        this.autor = autor;   //this - v kazdem konkretnim citatu bude konkretni this.autor, *lokalni promene za rovnitkem, this.autor - globalni promene
        this.text = text;
        this.oblibene = oblibene;
    }

    public Citat(String autor, String text) {
        this.autor = autor;
        this.text = text;
        this.oblibene = false;
    }

    public String getAutor() {      //geter, cesta, jak obejit privatni promenou
        return autor;
    }

    public String getText() { //geter, vrací text
        return text;
    }

    public Boolean isOblibene(){
        return oblibene;
    }

    public void setOblibene(Boolean oblibene) {
        this.oblibene = oblibene;
    }


}
