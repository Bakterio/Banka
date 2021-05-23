package cz.Bakterio.banka;

public class Spoustec {
    public static void main(String[] args) {
        spoustec();
    }
    public static void spoustec() {
        Ucet ucet = new Ucet();
        System.out.println(ucet.rovnase + "\nVítejte v naší bance... Co chcete udělat? (1 pro přihlášení, 2 pro vytvoření ůčtu)");
        switch (ucet.scannerIntNoOut()) {
            case 1:
                Prihlaseni log = new Prihlaseni();
                log.prihlaseni();
            case 2:
                SingUp sing = new SingUp();
                sing.main();
            default:
                System.out.println("Zdali jste špatnou možnost, zkuste znovu...");
                spoustec();
        }
    }
}