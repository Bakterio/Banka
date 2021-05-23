package cz.Bakterio.banka;

import java.util.Scanner;

public class Uroky extends Ucet{
    public void urokMenu(String rovnase, int hodnota, double urok){
        System.out.println(rovnase + "\nVyberte: \n 1. Urocit \n 2. Nastavit urok");
        Scanner in = new Scanner(System.in);
        int vyber = in.nextInt();
        switch(vyber){
            case 1:
                urocit(rovnase, hodnota, urok);
            case 2:
                urocit(rovnase, hodnota, nastavitUrok());
        }
    }
    public void urocit(String rovnase, int hodnota, double urok) {
        System.out.println(rovnase + "\nKolik let budete úročit?");
        double castka = hodnota;
        Scanner scanner = new Scanner(System.in);
        int roky = scanner.nextInt();
        for (int x = 1; x < roky; x++) {
            castka = castka * urok;
        }
        System.out.println(rovnase + "\nPo zúročení budete mít " + castka + " Kč.");
        menu();
    }
    public double nastavitUrok(){
        System.out.println("Zadejte urok: ");
        Scanner in = new Scanner(System.in);
        double urok = in.nextDouble(); //1.8
        double jedna = urok / 100; // 0,018
        double celkova = jedna + 1; // 1,018
        return celkova;
    }
}
