package cz.Bakterio.banka;

import java.io.*;
import java.security.PublicKey;
import java.util.ArrayList;

public class Prihlaseni {
    public void prihlaseni(){
        Ucet blablahehe = new Ucet();
        System.out.println(blablahehe.rovnase + "\n Jaké je vyše jméno?");
        String jmeno = blablahehe.scannerStringNoOut();
        File soubor = new File(jmeno + ".txt");
        if(soubor.exists()){
            System.out.println("Vaše jméno bylo nalezeno");
            hledani(jmeno);
        } else {
            System.out.println("Vaše jméno jsme nenanšli, zkuste to znovu");
            prihlaseni();
        }
    }
    private void hledani(String jmeno){
        int cislo;
        int hodnota;

        File soubor = new File(jmeno + ".txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(soubor));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> data = new ArrayList<String>();
        String pomocnyString;
        try {
            while ((pomocnyString = reader.readLine()) != null) {
                data.add(pomocnyString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        cislo = Integer.parseInt(data.get(1));
        hodnota = Integer.parseInt(data.get(2));
        Ucet ucet = new Ucet();
        ucet.prihlaseni(jmeno, cislo, hodnota);
        ucet.menu();
    }
}
