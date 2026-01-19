package projek;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Fungsi {

    private double kursUSD = 16000;
    private double kursEUR = 16500;
    private double kursMYR = 3500;

    private static Fungsi instance;
    private Random random = new Random();

    private Fungsi() {
        mulaiRandomKurs();
    }

    public static synchronized Fungsi getInstance() {
        if (instance == null) {
            instance = new Fungsi();
        }
        return instance;
    }

    private void mulaiRandomKurs() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                kursUSD += randomNaikTurun();
                kursEUR += randomNaikTurun();
                kursMYR += randomNaikTurun();
            }
        }, 0, 300_000);
    }

    private double randomNaikTurun() {
        int nilai = random.nextInt(200) + 1;
        return random.nextBoolean() ? nilai : -nilai;
    }

    // ===== KURS ASLI (UNTUK HITUNG) =====
    public double kursUSD() { return kursUSD; }
    public double kursEUR() { return kursEUR; }
    public double kursMYR() { return kursMYR; }

    // ===== KURS TAMPILAN =====
    public double tampilUSD() { return Math.round(kursUSD); }
    public double tampilEUR() { return Math.round(kursEUR); }
    public double tampilMYR() { return Math.round(kursMYR); }
}
