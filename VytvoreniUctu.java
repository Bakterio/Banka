package cz.Bakterio.banka;

import java.util.Scanner;

public class VytvoreniUctu {
    public String jmeno(){
        System.out.println("Zadejte své jméno: ");
        Scanner in = new Scanner(System.in);
        String jmeno = in.nextLine();
        return jmeno;
    }
    public int cislo(){
        System.out.println("Zadejte číslo svého účtu: ");
        Scanner in = new Scanner(System.in);
        int cislo = in.nextInt();
        return cislo;
    }
}
