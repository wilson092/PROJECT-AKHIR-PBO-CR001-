package projek;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.net.URL;

public class gui extends JFrame {

    
    private Fungsi dataKurs = Fungsi.getInstance();
    private Fungsi2 fungsi = new Fungsi2();

    private JTextField txtJumlah;
    private JComboBox<String> cbDari, cbKe;

    // komponen hasil
    private JLabel lblDariIcon, lblDariText;
    private JLabel lblKeIcon, lblKeText;
    private JLabel lblAngka;

    private static final int iconbenderaluas = 32;
    private static final int iconbenderatinggi = 20;

    private static final int tinggibendera = 120;
    private static final int luasbendera = 60;

    private DecimalFormat df = new DecimalFormat("#,##0.##");

    // WARNA
    private final Color BG_MAIN = new Color(242, 244, 247);
    private final Color BG_PANEL = new Color(235, 238, 242);
    private final Color BG_HASIL = new Color(250, 250, 250);
    private final Color BTN_COLOR = new Color(180, 205, 235);

    public gui() {
        setTitle("Konversi Mata Uang");
        setSize(640, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(BG_MAIN);

        UIManager.put("TabbedPane.contentBorderInsets",
                new Insets(10, 10, 10, 10));
        UIManager.put("TabbedPane.tabInsets",
                new Insets(8, 20, 8, 20));

        JTabbedPane tabPane = new JTabbedPane();
        tabPane.setBackground(BG_MAIN);
        tabPane.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        tabPane.addTab("Konversi", panelKonversi());
        tabPane.addTab("Info Kurs", panelInfoKurs());

        add(tabPane);
        setVisible(true);
    }

    //TAB KONVERSI 
    private JPanel panelKonversi() {
        JPanel root = new JPanel(new BorderLayout(20, 20));
        root.setBackground(BG_MAIN);
        root.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel kiri = new JPanel(new GridLayout(4, 2, 12, 12));
        kiri.setBackground(BG_PANEL);
        kiri.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Input Konversi"
        ));

        txtJumlah = new JTextField();
        txtJumlah.setHorizontalAlignment(JTextField.CENTER);

        cbDari = new JComboBox<>(new String[]{"IDR", "USD", "EUR", "MYR"});
        cbKe   = new JComboBox<>(new String[]{"IDR", "USD", "EUR", "MYR"});

        cbDari.setRenderer(new ikon());
        cbKe.setRenderer(new ikon());

        JButton btnKonversi = new JButton("Konversi");
        btnKonversi.setFont(new Font("Arial", Font.BOLD, 14));
        btnKonversi.setBackground(BTN_COLOR);
        btnKonversi.setFocusPainted(false);

        JLabel lblJumlah = new JLabel("Jumlah Uang", JLabel.CENTER);
        JLabel lblDari = new JLabel("Dari", JLabel.CENTER);
        JLabel lblKe = new JLabel("Ke", JLabel.CENTER);

        kiri.add(lblJumlah);
        kiri.add(txtJumlah);
        kiri.add(lblDari);
        kiri.add(cbDari);
        kiri.add(lblKe);
        kiri.add(cbKe);
        kiri.add(new JLabel());
        kiri.add(btnKonversi);

        JPanel kanan = new JPanel(new BorderLayout(15, 15));
        kanan.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        kanan.setBackground(BG_HASIL);

        JLabel lblJudul = new JLabel("Hasil Konversi", JLabel.CENTER);
        lblJudul.setFont(new Font("Arial", Font.BOLD, 16));
        lblJudul.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JPanel panelHasil = new JPanel();
        panelHasil.setLayout(new BoxLayout(panelHasil, BoxLayout.Y_AXIS));
        panelHasil.setBackground(BG_HASIL);
        panelHasil.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel barisDari = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        barisDari.setBackground(BG_HASIL);

        JPanel dariValue = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        dariValue.setBackground(BG_HASIL);

        lblDariIcon = new JLabel();
        lblDariText = new JLabel("-");
        lblDariText.setFont(new Font("Arial", Font.BOLD, 14));

        dariValue.add(lblDariIcon);
        dariValue.add(lblDariText);

        barisDari.add(new JLabel("Dari"));
        barisDari.add(dariValue);

        JPanel barisKe = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        barisKe.setBackground(BG_HASIL);

        JPanel keValue = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        keValue.setBackground(BG_HASIL);

        lblKeIcon = new JLabel();
        lblKeText = new JLabel("-");
        lblKeText.setFont(new Font("Arial", Font.BOLD, 14));

        keValue.add(lblKeIcon);
        keValue.add(lblKeText);

        barisKe.add(new JLabel("Ke"));
        barisKe.add(keValue);

        lblAngka = new JLabel("-", JLabel.CENTER);
        lblAngka.setFont(new Font("Arial", Font.BOLD, 24));
        lblAngka.setForeground(new Color(0, 130, 0));
        lblAngka.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        panelHasil.add(barisDari);
        panelHasil.add(barisKe);
        panelHasil.add(Box.createVerticalStrut(20));
        panelHasil.add(lblAngka);

        kanan.add(lblJudul, BorderLayout.NORTH);
        kanan.add(panelHasil, BorderLayout.CENTER);

        btnKonversi.addActionListener(e -> {
            try {
                double jumlah = Double.parseDouble(txtJumlah.getText());

                int asal = cbDari.getSelectedIndex() + 1;
                int tujuan = cbKe.getSelectedIndex() + 1;

                double hasil = fungsi.konversiLangsung(jumlah, asal, tujuan);

                String dari = cbDari.getSelectedItem().toString();
                String ke   = cbKe.getSelectedItem().toString();

                lblDariText.setText(dari);
                lblKeText.setText(ke);

                lblDariIcon.setIcon(loadFlag(dari.toLowerCase() + ".png"));
                lblKeIcon.setIcon(loadFlag(ke.toLowerCase() + ".png"));

                lblAngka.setText(df.format(hasil) + " " + ke);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Input tidak valid",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        root.add(kiri, BorderLayout.CENTER);
        root.add(kanan, BorderLayout.EAST);
        return root;
    }

    // INFO KURS
    private JPanel panelInfoKurs() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BG_MAIN);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel lblJudul = new JLabel("Daftar Kurs Mata Uang (ke IDR)", JLabel.CENTER);
        lblJudul.setFont(new Font("Arial", Font.BOLD, 18));

        JComboBox<String> cbKurs =
                new JComboBox<>(new String[]{"IDR", "USD", "EUR", "MYR"});

        JLabel lblBendera = new JLabel("", JLabel.CENTER);

        JLabel lblInfo = new JLabel("Pilih mata uang", JLabel.CENTER);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 14));

        cbKurs.addActionListener(e -> {
            String pilih = cbKurs.getSelectedItem().toString();
            switch (pilih) {
                case "IDR":
                    lblBendera.setIcon(loadFlagLarge("idr.png"));
                    lblInfo.setText("1 IDR = 1 IDR");
                    break;
                case "USD":
                    lblBendera.setIcon(loadFlagLarge("usd.png"));
                    lblInfo.setText("1 USD = " + dataKurs.tampilUSD() + " IDR");
                    break;
                case "EUR":
                    lblBendera.setIcon(loadFlagLarge("eur.png"));
                    lblInfo.setText("1 EUR = " + dataKurs.tampilEUR() + " IDR");
                    break;
                case "MYR":
                    lblBendera.setIcon(loadFlagLarge("myr.png"));
                    lblInfo.setText("1 MYR = " + dataKurs.tampilMYR() + " IDR");
                    break;
            }
        });

        JPanel tengah = new JPanel(new GridLayout(3, 1, 12, 12));
        tengah.setBackground(BG_MAIN);
        tengah.add(cbKurs);
        tengah.add(lblBendera);
        tengah.add(lblInfo);

        panel.add(lblJudul, BorderLayout.NORTH);
        panel.add(tengah, BorderLayout.CENTER);
        return panel;
    }

    // LOGO BENDERA
    private ImageIcon loadFlag(String fileName) {
        URL imgURL = getClass().getResource("/projek/img/" + fileName);
        if (imgURL == null) return null;

        ImageIcon icon = new ImageIcon(imgURL);
        Image img = icon.getImage().getScaledInstance(
                iconbenderaluas, iconbenderatinggi, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private ImageIcon loadFlagLarge(String fileName) {
        URL imgURL = getClass().getResource("/projek/img/" + fileName);
        if (imgURL == null) return null;

        ImageIcon icon = new ImageIcon(imgURL);
        Image img = icon.getImage().getScaledInstance(
                tinggibendera, luasbendera, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}
