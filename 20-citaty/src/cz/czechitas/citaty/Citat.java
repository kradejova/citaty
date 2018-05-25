package cz.czechitas.citaty;

public class Citat {

    private String autor;    //globalni promene*
    private String text;
    private Boolean oblibene;

    public Citat(String autor, String text) { //konstruktor, kazdy objekt citat ma od zacatku atribut autor a atribut jmeno
        this.autor = autor;   //this - v kazdem konkretnim citatu bude konkretni this.autor, *lokalni promene za rovnitkem, this.autor - globalni promene
        this.text = text;
    }

    public String getAutor() {      //geter, cesta, jak obejit privatni promenou
        return autor;
    }

    public String getText() { //geter, vrací text
        return text;
    }

    public void isOblibene(Boolean oblibene) {
        if (oblibene == true){
            return ;
        }

    }
}
