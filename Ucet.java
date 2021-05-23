package cz.Bakterio.banka;

import java.io.*;
import java.util.Scanner;

public class Ucet {
    private int hodnota;
    private String predchoziTransakce;
    private String jmeno;
    public final String rovnase = "===========================================================";
    private int cislo;
    private double urok = 1.01888;

    public void main(){

    }
    public void make(String jmeno, int cislo){
        System.out.println(rovnase + "\nDobrý den uživateli " + jmeno + ". Číslo vačeho účtu je: " + cislo + ".");
        this.jmeno = jmeno;
        this.cislo = cislo;
    }
    public void prihlaseni(String jmeno, int cislo, int hodnota){
        System.out.println(rovnase + "\nDobrý den uživateli " + jmeno + ". Číslo vačeho účtu je: " + cislo + ".");
        this.jmeno = jmeno;
        this.cislo = cislo;
        this.hodnota = hodnota;
    }
    public void menu(){
        System.out.println(rovnase + "\nZvolte možnost: \n 1. vklad \n 2. výběr \n 3. zustatek \n 4. vypočítat úrok \n 5. ukončit");
        Scanner in = new Scanner(System.in);
        int vyber = in.nextInt();
        switch(vyber){
            case 1:
                vklad(scannerInt());
            case 2:
                vyber(scannerInt());
            case 3:
                zustatek();
            case 4:
                urok();
            case 5:
                zapis();
                System.exit(0);
            case 6:
                zapis();
            default:
                System.out.println("Chybně zadaná možnost!!!");
                menu();
        }
    }
    public void vklad(int castka){
        this.hodnota += castka;
        System.out.println(rovnase + "\nNa účet číslo " + cislo + " se přičetlo " + castka + " Kč. Niní je na účtě: " + hodnota + " Kč.\n" + rovnase + "\n + " + castka);
        menu();
    }
    public void vyber(int castka){
        this.hodnota -= castka;
        System.out.println(rovnase + "\nZ účtu číslo " + cislo + " se odečetlo " + castka + " Kč. Niní je na účtě: " + hodnota + " Kč.\n" + rovnase + "\n - " + castka);
        menu();
    }
    public void zustatek(){
        System.out.println(rovnase +"\nNa vašem účtu je " + hodnota + " Kč.");
        if (hodnota < 0){
            System.out.println(rovnase + "\nJste v kontokorentu!!!");
        }
        menu();
    }
    public void urok(){
        Uroky uroky = new Uroky();
        uroky.urokMenu(rovnase, hodnota, urok);
    }
    public int scannerInt (){
        System.out.println("Zadejte částku: ");
        Scanner in = new Scanner(System.in);
        int scanner = in.nextInt();
        return scanner;
    }
    public int scannerIntNoOut (){
        Scanner in = new Scanner(System.in);
        int scanner = in.nextInt();
        return scanner;
    }
        public String scannerStringNoOut (){
        Scanner in = new Scanner(System.in);
        String scanner = in.nextLine();
        return scanner;
    }
    public void zapis(){
        File informace = new File(jmeno + ".txt");
        try {
            informace.createNewFile();
            System.out.println("Soubor byl vytvořen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter out = null;
        BufferedWriter cistic = null;
        try {
            out = new BufferedWriter(new FileWriter(informace, true)); //true je že se nepřepisuje
            cistic = new BufferedWriter(new FileWriter(informace)); //true je že se nepřepisuje
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            cistic.write("");
            cistic.flush();
            out.write(jmeno);
            out.write("\n" + cislo);
            out.write("\n" + hodnota);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
