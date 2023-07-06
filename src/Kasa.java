import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Kasa {
    private Map<BigDecimal, Integer> kasa;

    public Kasa() {
        kasa = new LinkedHashMap<>();
        kasa.put(new BigDecimal("5.0"), 1);
        kasa.put(new BigDecimal("2.0"), 3);
        kasa.put(new BigDecimal("1.0"), 5);
        kasa.put(new BigDecimal("0.5"), 10);
        kasa.put(new BigDecimal("0.2"), 20);
        kasa.put(new BigDecimal("0.1"), 200);
        kasa.put(new BigDecimal("0.05"), 100);
        kasa.put(new BigDecimal("0.02"), 100);
        kasa.put(new BigDecimal("0.01"), 10000);
    }

    public void wydajReszte(double reszta) {
        BigDecimal resztaDecimal = BigDecimal.valueOf(reszta);

        for (Map.Entry<BigDecimal, Integer> entry : kasa.entrySet()) {
            BigDecimal nominal = entry.getKey();
            int nominalCount = entry.getValue();

            if (nominal.compareTo(resztaDecimal) <= 0 && nominalCount > 0) {
                int ilosc = resztaDecimal.divide(nominal, 0, BigDecimal.ROUND_DOWN).intValue();
                if (ilosc > nominalCount) {
                    ilosc = nominalCount;
                }

                System.out.println(ilosc + " x " + nominal + " zł");
                resztaDecimal = resztaDecimal.subtract(nominal.multiply(BigDecimal.valueOf(ilosc)));
                nominalCount -= ilosc;
                kasa.put(nominal, nominalCount);

                if (resztaDecimal.compareTo(BigDecimal.ZERO) == 0) {
                    break;
                }
            }
        }
    }

    public void wyswietlStanKasy() {
        System.out.println("\nAktualny stan kasy drobnych:");
        for (Map.Entry<BigDecimal, Integer> entry : kasa.entrySet()) {
            BigDecimal nominal = entry.getKey();
            int nominalCount = entry.getValue();
            System.out.println(nominal + " zł: " + nominalCount + " szt.");
        }
    }
}
