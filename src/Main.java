// Klasa główna programu
public class Main {
    public static void main(String[] args) {
        Kasa kasa = new Kasa();
        App resztaLoop = new App(kasa);
        resztaLoop.run();
    }
}
