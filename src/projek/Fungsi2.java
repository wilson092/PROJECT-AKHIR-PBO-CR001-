package projek;

public class Fungsi2 {

    private final Fungsi fungsi = Fungsi.getInstance();

    public double konversiLangsung(double jumlah, int asal, int tujuan) {

        double idr;

        // ke IDR
        switch (asal) {
            case 1 -> idr = jumlah;
            case 2 -> idr = jumlah * fungsi.kursUSD();
            case 3 -> idr = jumlah * fungsi.kursEUR();
            case 4 -> idr = jumlah * fungsi.kursMYR();
            default -> throw new IllegalArgumentException("Asal tidak valid");
        }

        // dari IDR
        return switch (tujuan) {
            case 1 -> idr;
            case 2 -> idr / fungsi.kursUSD();
            case 3 -> idr / fungsi.kursEUR();
            case 4 -> idr / fungsi.kursMYR();
            default -> throw new IllegalArgumentException("Tujuan tidak valid");
        };
    }
}
