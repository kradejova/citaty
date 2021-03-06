package cz.czechitas.citaty;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Pomocnik {

    /**
     * Metoda nacte radky ze souboru na dane ceste
     * 
     * @param soubor soubor ktery chceme cist
     * @return Seznam radku nebo prazdny seznam pokud nastala chyba
     */
    public List<String> nactiRadkySouboru(File soubor) {
        try {
            Path cesta = soubor.toPath();
            return Files.readAllLines(cesta);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    /**
     * Metoda zapise radky do souboru
     * @param radky seznam jednotlivych radku
     * @param soubor soubor ktery chceme zapisovat
     */
    public void zapisRadkyDoSouboru(List<String> radky, File soubor) {
        String obsah = String.join(System.lineSeparator(), radky);
        try {
            Path cesta = soubor.toPath();
            Files.write(cesta, obsah.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
