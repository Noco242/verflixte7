import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanelGUI {
  public static void main(String[] args) {
    // StartFrame
    JFrame frame = new JFrame();
    frame.setSize(1920, 1080);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // StartPanel
    JPanel startPanel = new JPanel();
    startPanel.setSize(1920, 1080);
    startPanel.setLayout(null);

    // StartButton ( 2 Spieler )
    JButton startButton = new JButton("2 Spieler");
    startPanel.add(startButton);
    startButton.setBounds(790, 440, 350, 90);
    startButton.setFont(new FontUIResource("Bahnschrift", 3, 50));
    startButton.setVisible(true);

    // Computer Modus Button
    JButton cpButton = new JButton("Computer");
    startPanel.add(cpButton);
    cpButton.setBounds(790, 550, 350, 90);
    cpButton.setFont(new FontUIResource("Bahnschrift", 3, 50));
    cpButton.setVisible(true);

    // App Icon
    ImageIcon appIcon = new ImageIcon("icon.png");
    frame.setIconImage(appIcon.getImage());

    // Starthintergrund
    ImageIcon backgroundImageStart = new ImageIcon("starthintergrund.png");
    JLabel backgroundLabelStart = new JLabel(backgroundImageStart);
    backgroundLabelStart.setBounds(0, 0, 1920, 1080);
    backgroundLabelStart.setVisible(true);
    startPanel.add(backgroundLabelStart);

    // Textfield Konto RLinks
    JTextField textFieldL = new JTextField("Konto :");
    textFieldL.setOpaque(false);
    textFieldL.setForeground(new Color(255,255,255));
    textFieldL.setFont(new FontUIResource("Bahnschrift", 3, 20));
    textFieldL.setBounds(290, 10, 150, 30);
    textFieldL.setEditable(false);
    textFieldL.setVisible(false);
    startPanel.add(textFieldL);

    // Textfield Konto Rechts
    JTextField textFieldR = new JTextField("Konto :");
    textFieldR.setBounds(1500, 10, 100, 30);
    textFieldR.setEditable(false);
    textFieldR.setVisible(false);
    startPanel.add(textFieldR);

    // Textfield Einsatz Topf
    JTextField textFieldEinsatz = new JTextField("Einsatz : ");
    textFieldEinsatz.setBounds(900, 930, 100, 30);
    textFieldEinsatz.setEditable(false);
    textFieldEinsatz.setVisible(false);
    startPanel.add(textFieldEinsatz);

    // Textfield Anzahl Wuerfe Links
    JTextField textFieldAnzahlWuerfeL = new JTextField(" Anzahl Würfe");
    textFieldAnzahlWuerfeL.setBounds(10, 900, 100, 30);
    textFieldAnzahlWuerfeL.setEditable(false);
    textFieldAnzahlWuerfeL.setVisible(false);
    startPanel.add(textFieldAnzahlWuerfeL);

    // Textfield Anzahl Wuerfe Rechts
    JTextField textFieldAnzahlWuerfeR = new JTextField(" Anzahl Würfe");
    textFieldAnzahlWuerfeR.setBounds(1780, 900, 100, 30);
    textFieldAnzahlWuerfeR.setEditable(false);
    textFieldAnzahlWuerfeR.setVisible(false);
    startPanel.add(textFieldAnzahlWuerfeR);

    // Textfield Augenzahl
    JTextField textFieldAugenzahl = new JTextField("Augenzahl : ");
    textFieldAugenzahl.setBounds(900, 30, 100, 30);
    textFieldAugenzahl.setEditable(false);
    textFieldAugenzahl.setVisible(false);
    startPanel.add(textFieldAugenzahl);

    // Wuerfelbutton
    JButton wuerfelButton = new JButton();
    wuerfelButton.setText("Wuerfeln");
    wuerfelButton.setBounds(1500, 900, 100, 30);
    startPanel.add(wuerfelButton);

    // Rechte Seite Buttons
    JButton spielerbuttonR1 = new JButton();
    spielerbuttonR1.setBounds(1780, 10, 100, 30);
    spielerbuttonR1.setText("Spieler 2 ");
    spielerbuttonR1.setVisible(false);

    JButton coinButtonR2 = new JButton();
    coinButtonR2.setText(" 1000 Coins ");
    coinButtonR2.setBounds(1780, 50, 100, 30);
    coinButtonR2.setVisible(false);

    JButton coinButtonR3 = new JButton();
    coinButtonR3.setText(" 200 Coins ");
    coinButtonR3.setBounds(1780, 90, 100, 30);
    coinButtonR3.setVisible(false);

    JButton coinButtonR4 = new JButton();
    coinButtonR4.setText(" 100 Coins ");
    coinButtonR4.setBounds(1780, 130, 100, 30);
    coinButtonR4.setVisible(false);

    JButton coinButtonR5 = new JButton();
    coinButtonR5.setText(" All In ");
    coinButtonR5.setBounds(1780, 170, 100, 30);
    coinButtonR5.setVisible(false);

    startPanel.add(spielerbuttonR1);
    startPanel.add(coinButtonR2);
    startPanel.add(coinButtonR3);
    startPanel.add(coinButtonR4);
    startPanel.add(coinButtonR5);

    // ZurückButton
    JButton zButton = new JButton("Zurück");
    zButton.setBounds(10, 950, 100, 30);
    zButton.setVisible(false);
    startPanel.add(zButton);

    // Linke Seite Buttons
    JButton spielerbuttonL1 = new JButton();
    spielerbuttonL1.setBounds(10, 10, 100, 30);
    spielerbuttonL1.setText("Spieler 1 ");
    spielerbuttonL1.setVisible(false);

    JButton coinButtonL2 = new JButton();
    coinButtonL2.setText(" 1000 Coins ");
    coinButtonL2.setBounds(10, 50, 100, 30);
    coinButtonL2.setVisible(false);

    JButton coinButtonL3 = new JButton();
    coinButtonL3.setText(" 200 Coins ");
    coinButtonL3.setBounds(10, 90, 100, 30);
    coinButtonL3.setVisible(false);

    JButton coinButtonL4 = new JButton();
    coinButtonL4.setText(" 100 Coins ");
    coinButtonL4.setBounds(10, 130, 100, 30);
    coinButtonL4.setVisible(false);

    JButton coinButtonL5 = new JButton();
    coinButtonL5.setText(" All In ");
    coinButtonL5.setBounds(10, 170, 100, 30);
    coinButtonL5.setVisible(false);

    startPanel.add(spielerbuttonL1);
    startPanel.add(coinButtonL2);
    startPanel.add(coinButtonL3);
    startPanel.add(coinButtonL4);
    startPanel.add(coinButtonL5);

    // Spielhintergrund
    ImageIcon backgroundImage = new ImageIcon("hintergrund.png");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    backgroundLabel.setBounds(0, 0, 1920, 1080);
    backgroundLabel.setVisible(false);
    startPanel.add(backgroundLabel);

    // Wuerfel1 Bild
    ImageIcon dice1 = new ImageIcon("D:/EGK/GUI/dice1.png");
    Image img = dice1.getImage();
    Image newImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon newDice1 = new ImageIcon(newImg);
    JLabel dice1Label = new JLabel(newDice1);
    dice1Label.setBounds(780, 430, 100, 100);
    dice1Label.setVisible(false);
    startPanel.add(dice1Label);

    cpButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        spielerbuttonR1.setVisible(true);
        spielerbuttonL1.setVisible(true);
        startButton.setVisible(false);
        backgroundLabel.setVisible(true);
        backgroundLabelStart.setVisible(false);
        wuerfelButton.setVisible(true);
        textFieldR.setVisible(true);
        textFieldL.setVisible(true);
        textFieldEinsatz.setVisible(true);
        textFieldAnzahlWuerfeL.setVisible(true);
        textFieldAnzahlWuerfeR.setVisible(true);
        textFieldAugenzahl.setVisible(true);
        zButton.setVisible(true);
        cpButton.setVisible(false);
      }
    });

    // Popups wenn Startbutton gedrückt
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent a) {
        spielerbuttonR1.setVisible(true);
        spielerbuttonL1.setVisible(true);
        startButton.setVisible(false);
        backgroundLabel.setVisible(true);
        backgroundLabelStart.setVisible(false);
        wuerfelButton.setVisible(true);
        textFieldR.setVisible(true);
        textFieldL.setVisible(true);
        textFieldEinsatz.setVisible(true);
        textFieldAnzahlWuerfeL.setVisible(true);
        textFieldAnzahlWuerfeR.setVisible(true);
        textFieldAugenzahl.setVisible(true);
        zButton.setVisible(true);
        cpButton.setVisible(false);
      }
    });

    // Rechte Seite popup der Conbutton, wenn button spielerLButtonR1 gedrückt
    spielerbuttonR1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent b) {
        coinButtonR2.setVisible(true);
        coinButtonR3.setVisible(true);
        coinButtonR4.setVisible(true);
        coinButtonR5.setVisible(true);
      }
    });

    wuerfelButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent w) {
        dice1Label.setVisible(true);
        startPanel.setComponentZOrder(dice1Label, 0);
      }
    });

    zButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent d) {
        zButton.setVisible(false);
        spielerbuttonR1.setVisible(false);
        spielerbuttonL1.setVisible(false);
        startButton.setVisible(true);
        backgroundLabel.setVisible(true);
        backgroundLabelStart.setVisible(true);
        wuerfelButton.setVisible(false);
        textFieldR.setVisible(false);
        textFieldL.setVisible(false);
        textFieldEinsatz.setVisible(false);
        textFieldAnzahlWuerfeL.setVisible(false);
        textFieldAnzahlWuerfeR.setVisible(false);
        textFieldAugenzahl.setVisible(false);
        coinButtonR2.setVisible(false);
        coinButtonR3.setVisible(false);
        coinButtonR4.setVisible(false);
        coinButtonR5.setVisible(false);
        coinButtonL2.setVisible(false);
        coinButtonL3.setVisible(false);
        coinButtonL4.setVisible(false);
        coinButtonL5.setVisible(false);
        dice1Label.setVisible(false);
        cpButton.setVisible(true);
      }
    });

    // Linke Seite popup der Conbutton, wenn button spielerLButtonL1 gedrückt
    spielerbuttonL1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent c) {
        coinButtonL2.setVisible(true);
        coinButtonL3.setVisible(true);
        coinButtonL4.setVisible(true);
        coinButtonL5.setVisible(true);
      }
    });

    startPanel.setVisible(true);
    frame.add(startPanel);
    frame.setVisible(true);

  }
}