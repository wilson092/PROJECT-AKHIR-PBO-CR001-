package projek;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ikon extends JLabel implements ListCellRenderer<String> {

    public ikon() {
        setOpaque(true);
        setIconTextGap(10);
        setFont(new Font("Arial", Font.BOLD, 13));
    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends String> list,
            String value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        if (isSelected) {
            setBackground(new Color(180, 200, 230));
        } else {
            setBackground(Color.WHITE);
        }

        setForeground(Color.BLACK);
        setText(value);

        switch (value) {
            case "IDR":
                setIcon(loadIcon("idr.png"));
                break;
            case "USD":
                setIcon(loadIcon("usd.png"));
                break;
            case "EUR":
                setIcon(loadIcon("eur.png"));
                break;
            case "MYR":
                setIcon(loadIcon("myr.png"));
                break;
            default:
                setIcon(null);
        }

        return this;
    }

    private ImageIcon loadIcon(String fileName) {
        URL imgURL = getClass().getResource("/projek/img/" + fileName);

        if (imgURL == null) {
            System.out.println("Gambar tidak ditemukan: " + fileName);
            return null;
        }

        ImageIcon icon = new ImageIcon(imgURL);
        Image img = icon.getImage().getScaledInstance(24, 16, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}
