package cz.Bakterio.banka;

public class SingUp {
    public void main(){
        Ucet ucet = new Ucet();
        VytvoreniUctu vy = new VytvoreniUctu();
        System.out.println("VYTVOŘENÍ ÚČTU:");
        ucet.make(vy.jmeno(), vy.cislo());
        ucet.menu();
    }
}
