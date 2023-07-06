import java.util.Scanner;

// Klasa odpowiedzialna za pętlę wczytywania i wydawania reszty
public class App {
    private Kasa kasa;
    private Scanner scanner;

    public App(Kasa kasa) {
        this.kasa = kasa;
        scanner = new Scanner(System.in);
    }

    public void run() {
        String input = "";

        while (!input.equalsIgnoreCase("koniec")) {
            System.out.println("Podaj resztę do wydania (lub wpisz 'koniec' aby zakończyć):");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("koniec")) {
                break;
            }

            try {
                double reszta = Double.parseDouble(input);
                if (reszta <= 0) {
                    System.out.println("Podaj liczbę dodatnią, wieksza od 0.");
                } else {
                    kasa.wydajReszte(reszta);
                    kasa.wyswietlStanKasy();
                }
            } catch (NumberFormatException e) {
                System.out.println("Podaj poprawną liczbę.");
            }
        }
    }
}
