package com.company.Felulet;

import com.company.Logika.SakkTabla;

import javax.swing.*;
import java.awt.*;

public class SakkFelulet extends JFrame {

    private SakkTabla tabla;

    private Container foAblak;
    private JPanel pnlJatekTabla;

    public SakkFelulet() {
        this.tabla = new SakkTabla();
        this.initComponents();

        this.sakkTablaMegjelenit();
    }

    private void initComponents(){

        this.setTitle("Sakk 1.0");

        int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setSize(width, height);

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);

        this.foAblak = this.getContentPane();
        this.foAblak.setLayout(new BorderLayout(10,10));

        this.pnlJatekTabla = new JPanel();
        this.pnlJatekTabla.setLayout(new GridLayout(9,9));

        this.foAblak.add(BorderLayout.CENTER, this.pnlJatekTabla);



        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void sakkTablaMegjelenit(){
        this.pnlJatekTabla.removeAll();

        for (int i = 0; i < 8; i++) {
            JLabel hivatkozasABC = new JLabel();
            hivatkozasABC.setText(String.format("%s.", (char)(i+65)));
            hivatkozasABC.setHorizontalAlignment((SwingConstants.CENTER));
            hivatkozasABC.setVerticalAlignment((SwingConstants.CENTER));
            this.pnlJatekTabla.add(hivatkozasABC);
        }

        for (int i = 0; i < 8; i++) {
            JLabel hivatkozas123 = new JLabel();
            hivatkozas123.setText(String.format("%d.", (8-i)));
            hivatkozas123.setHorizontalAlignment((SwingConstants.CENTER));
            hivatkozas123.setVerticalAlignment((SwingConstants.CENTER));
            this.pnlJatekTabla.add(hivatkozas123);



            for (int j = 0; j < 8; j++) {
                JButton btn = new JButton();
                Mezo m = new Mezo(i,j, tabla.getErtek(i, j));
                this.pnlJatekTabla.add(m);
            }
        }

        this.revalidate();
        this.repaint();
    }
}
