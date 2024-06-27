import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class StartPanelGUI {

  private static JTextField textFieldEinsatz = new JTextField();
  private static JTextField textFieldR = new JTextField();
  private static JTextField textFieldL = new JTextField();
  private static JTextField textFieldAugenzahl = new JTextField();
  private static JTextField textFieldAnzahlWuerfeL = new JTextField();
  private static JTextField textFieldAnzahlWuerfeR = new JTextField();
  private static Schiedsrichter schiedsrichter;

  public static void main(String[] args) {
    schiedsrichter = new Schiedsrichter();

    // StartFrame
    JFrame frame = new JFrame();
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setSize(1920, 1080);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setAlwaysOnTop(true);

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

    // Exit Button
    JButton exitButton = new JButton();
    startPanel.add(exitButton);
    exitButton.setBounds(880, 900, 170, 90);
    exitButton.setVisible(true);
    ImageIcon exitButtn = new ImageIcon("ExitButton.png");
    Image imgEBtn = exitButtn.getImage();
    Image exButton = imgEBtn.getScaledInstance(170, 90, Image.SCALE_SMOOTH);
    ImageIcon newEBtn = new ImageIcon(exButton);
    exitButton.setIcon(newEBtn);
    exitButton.setHorizontalTextPosition(JButton.CENTER);
    exitButton.setVerticalTextPosition(JButton.CENTER);
    exitButton.setContentAreaFilled(false);
    exitButton.setBorderPainted(false);
    exitButton.setFocusPainted(false);

    // App Icon
    ImageIcon appIcon = new ImageIcon("icon.png");
    frame.setIconImage(appIcon.getImage());

    // Starthintergrund
    ImageIcon backgroundImageStart = new ImageIcon("starthintergrund.png");
    JLabel backgroundLabelStart = new JLabel(backgroundImageStart);
    backgroundLabelStart.setBounds(0, 0, 1920, 1080);
    backgroundLabelStart.setVisible(true);
    startPanel.add(backgroundLabelStart);

    // rechts gewinnt links verliert Screen
    ImageIcon winR = new ImageIcon("rechtsGewinnt.png");
    JLabel winRLabel = new JLabel(winR);
    winRLabel.setBounds(0, 0, 1290, 1080);
    winRLabel.setVisible(false);
    startButton.add(winRLabel);

    //links gewinnt rechts verliert Screen
    ImageIcon winL = new ImageIcon("linksGewinnt.png");
    JLabel winLlabel = new JLabel(winL);
    winLlabel.setBounds(0, 0, 1290, 1080);
    winLlabel.setVisible(false);
    startButton.add(winLlabel);

    // Textfield Konto Links
    textFieldL.setText(
      "Konto : " + schiedsrichter.getSpieler1().getVermoegen()
    );
    textFieldL.setOpaque(false);
    textFieldL.setForeground(new Color(255, 255, 255));
    textFieldL.setFont(new FontUIResource("Bahnschrift", 3, 20));
    textFieldL.setBounds(290, 10, 150, 30);
    textFieldL.setEditable(false);
    textFieldL.setVisible(false);
    startPanel.add(textFieldL);

    // Textfield Konto Rechts
    textFieldR.setText(
      "Konto : " + schiedsrichter.getSpieler2().getVermoegen()
    );
    textFieldR.setBounds(1500, 10, 150, 30);
    textFieldR.setOpaque(false);
    textFieldR.setForeground(new Color(255, 255, 255));
    textFieldR.setFont(new FontUIResource("Bahnschrift", 3, 20));
    textFieldR.setEditable(false);
    textFieldR.setVisible(false);
    startPanel.add(textFieldR);

    // Textfield Einsatz Topf
    textFieldEinsatz.setText(
      "Einsatz : " + schiedsrichter.getTopf1().getEinsatz()
    );
    textFieldEinsatz.setOpaque(false);
    textFieldEinsatz.setForeground(new Color(255, 255, 255));
    textFieldEinsatz.setFont(new FontUIResource("Bahnschrift", 3, 20));
    textFieldEinsatz.setBounds(900, 930, 150, 30);
    textFieldEinsatz.setEditable(false);
    textFieldEinsatz.setVisible(false);
    startPanel.add(textFieldEinsatz);

    // Textfield Anzahl Wuerfe Links
    textFieldAnzahlWuerfeL.setText("Würfe : ");
    textFieldAnzahlWuerfeL.setOpaque(false);
    textFieldAnzahlWuerfeL.setForeground(new Color(255, 255, 255));
    textFieldAnzahlWuerfeL.setFont(new FontUIResource("Bahnschrift", 3, 20));
    textFieldAnzahlWuerfeL.setBounds(10, 900, 150, 30);
    textFieldAnzahlWuerfeL.setEditable(false);
    textFieldAnzahlWuerfeL.setVisible(false);
    startPanel.add(textFieldAnzahlWuerfeL);

    // Textfield Anzahl Wuerfe Rechts
    textFieldAnzahlWuerfeR.setText("Würfe : ");
    textFieldAnzahlWuerfeR.setBounds(1740, 900, 150, 30);
    textFieldAnzahlWuerfeR.setOpaque(false);
    textFieldAnzahlWuerfeR.setForeground(new Color(255, 255, 255));
    textFieldAnzahlWuerfeR.setFont(new FontUIResource("Bahnschrift", 3, 20));
    textFieldAnzahlWuerfeR.setEditable(false);
    textFieldAnzahlWuerfeR.setVisible(false);
    startPanel.add(textFieldAnzahlWuerfeR);

    // Textfield Augenzahl
    textFieldAugenzahl.setText("Augenzahl : 0 ");
    textFieldAugenzahl.setBounds(900, 30, 160, 30);
    textFieldAugenzahl.setOpaque(false);
    textFieldAugenzahl.setForeground(new Color(255, 255, 255));
    textFieldAugenzahl.setFont(new FontUIResource("Bahnschrift", 3, 20));
    textFieldAugenzahl.setEditable(false);
    textFieldAugenzahl.setVisible(false);
    startPanel.add(textFieldAugenzahl);

    // Wuerfelbutton
    JButton wuerfelButton = new JButton();
    wuerfelButton.setBounds(1240, 800, 205, 105);
    wuerfelButton.setContentAreaFilled(false);
    wuerfelButton.setBorderPainted(false);
    wuerfelButton.setFocusPainted(false);

    JButton wuerfelButtonL = new JButton();
    wuerfelButtonL.setBounds(470, 800, 205, 105);
    wuerfelButtonL.setContentAreaFilled(false);
    wuerfelButtonL.setBorderPainted(false);
    wuerfelButtonL.setFocusPainted(false);

    // Hintergrund des Wuerfelbuttons
    ImageIcon rollDice = new ImageIcon("rollDice.png");
    Image imgRDice = rollDice.getImage();
    Image rDice = imgRDice.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
    ImageIcon newRDice = new ImageIcon(rDice);
    wuerfelButton.setIcon(newRDice);
    wuerfelButton.setHorizontalTextPosition(JButton.CENTER);
    wuerfelButton.setVerticalTextPosition(JButton.CENTER);

    startPanel.add(wuerfelButton);

    // Hintergrund des linken WuerfelButtons
    ImageIcon rollDiceL = new ImageIcon("rollDice.png");
    Image imgLDice = rollDiceL.getImage();
    Image lDice = imgLDice.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
    ImageIcon newLDice = new ImageIcon(lDice);
    wuerfelButtonL.setIcon(newLDice);
    wuerfelButtonL.setHorizontalTextPosition(JButton.CENTER);
    wuerfelButtonL.setVerticalTextPosition(JButton.CENTER);
    startPanel.add(wuerfelButtonL);

    // Rechte Seite Buttons
    JButton spielerbuttonR1 = new JButton("Spieler 2 ");
    spielerbuttonR1.setBounds(1780, 10, 100, 30);
    spielerbuttonR1.setVisible(false);

    JButton coinButtonR2 = new JButton(" 1000 Coins ");
    coinButtonR2.setBounds(1780, 50, 100, 30);
    coinButtonR2.setVisible(false);

    JButton coinButtonR3 = new JButton(" 200 Coins ");
    coinButtonR3.setBounds(1780, 90, 100, 30);
    coinButtonR3.setVisible(false);

    JButton coinButtonR4 = new JButton(" 100 Coins ");
    coinButtonR4.setBounds(1780, 130, 100, 30);
    coinButtonR4.setVisible(false);

    JButton coinButtonR5 = new JButton(" All In ");
    coinButtonR5.setBounds(1780, 170, 100, 30);
    coinButtonR5.setVisible(false);

    JButton dEndButtonR = new JButton("Wuerfel abgeben");
    dEndButtonR.setBounds(1780, 210, 100, 30);
    dEndButtonR.setVisible(false);

    startPanel.add(spielerbuttonR1);
    startPanel.add(coinButtonR2);
    startPanel.add(coinButtonR3);
    startPanel.add(coinButtonR4);
    startPanel.add(coinButtonR5);
    startPanel.add(dEndButtonR);

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

    JButton dEndButtonL = new JButton("Wuerfel abgeben");
    dEndButtonL.setBounds(10, 210, 100, 30);
    dEndButtonL.setVisible(false);

    startPanel.add(spielerbuttonL1);
    startPanel.add(coinButtonL2);
    startPanel.add(coinButtonL3);
    startPanel.add(coinButtonL4);
    startPanel.add(coinButtonL5);
    startPanel.add(dEndButtonL);

    // Spielhintergrund
    ImageIcon backgroundImage = new ImageIcon("hintergrund.png");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    backgroundLabel.setBounds(0, 0, 1920, 1080);
    backgroundLabel.setVisible(false);
    startPanel.add(backgroundLabel);

    //Button für den Start in den Spieler vs Computer Modus
    cpButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          spielerbuttonL1.setVisible(true);
          startButton.setVisible(false);
          backgroundLabel.setVisible(true);
          backgroundLabelStart.setVisible(false);
          wuerfelButton.setVisible(false);
          textFieldR.setVisible(true);
          textFieldL.setVisible(true);
          textFieldEinsatz.setVisible(true);
          textFieldAnzahlWuerfeL.setVisible(true);
          textFieldAnzahlWuerfeR.setVisible(true);
          textFieldAugenzahl.setVisible(true);
          zButton.setVisible(true);
          cpButton.setVisible(false);
          exitButton.setVisible(false);

          schiedsrichter = new Schiedsrichter(true);
        }
      }
    );

    // Popups wenn Startbutton ( 2 Spieler ) gedrückt
    startButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent a) {
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
          exitButton.setVisible(false);
          resetZButton();

          if (schiedsrichter.getSpieler1().getDarfWuerfeln() == true) {
            spielerbuttonR1.setVisible(false);
            spielerbuttonL1.setVisible(true);
          } else {
            spielerbuttonR1.setVisible(true);
            spielerbuttonL1.setVisible(false);
          }
        }
      }
    );

    // Rechte Seite popup der Conbutton, wenn button spielerLButtonR1 gedrückt
    spielerbuttonR1.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent b) {
          coinButtonR2.setVisible(true);
          coinButtonR3.setVisible(true);
          coinButtonR4.setVisible(true);
          coinButtonR5.setVisible(true);
          dEndButtonR.setVisible(true);
        }
      }
    );
    //Aktionen des WuerfelButtons auf der rechten Seite
    wuerfelButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent w) {
          schiedsrichter.getSpieler2().wuerfeln();
          int augenzahl =
            schiedsrichter.getWuerfel1().getPunkte() +
            schiedsrichter.getWuerfel2().getPunkte();
          updateAugenzahl();
          updateWurfanzahlR();

          if (augenzahl == 0) {
            spielerbuttonR1.setVisible(false);
            coinButtonR2.setVisible(false);
            coinButtonR4.setVisible(false);
            coinButtonR5.setVisible(false);
            coinButtonR3.setVisible(false);
            dEndButtonR.setVisible(false);

            spielerbuttonL1.setVisible(true);
            textFieldAugenzahl.setText("Augenzahl : 7");

            schiedsrichter.Auswerten();
            schiedsrichter.spielStarten();
            updateEinsatzGUI();
            updateVermoegenS1();
            updateVermoegenS2();
          }
        }
      }
    );
    //Aktionen des WuerfelButtons auf der linken Seite
    wuerfelButtonL.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent w) {
          schiedsrichter.getSpieler1().wuerfeln();
          int augenzahl =
            schiedsrichter.getWuerfel1().getPunkte() +
            schiedsrichter.getWuerfel2().getPunkte();
          updateAugenzahl();
          updateWurfanzahlL();
          if (augenzahl == 0) {
            spielerbuttonL1.setVisible(false);
            coinButtonL2.setVisible(false);
            coinButtonL4.setVisible(false);
            coinButtonL5.setVisible(false);
            coinButtonL3.setVisible(false);
            dEndButtonL.setVisible(false);

            spielerbuttonL1.setVisible(true);
            textFieldAugenzahl.setText("Augenzahl: 7");

            schiedsrichter.Auswerten();
            schiedsrichter.spielStarten();
            updateEinsatzGUI();
            updateVermoegenS2();
            updateVermoegenS1();
          }
        }
      }
    );

    //Der Zurückbutton sorgt dafür, dass der Startscreen angezeigt wird, wo man wieder die verschiedenen Modi auswählen kann
    zButton.addActionListener(
      new ActionListener() {
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
          cpButton.setVisible(true);
          dEndButtonR.setVisible(false);
          dEndButtonL.setVisible(false);
          exitButton.setVisible(true);
        }
      }
    );

    // Linke Seite popup der Conbutton, wenn button spielerLButtonL1 gedrückt
    spielerbuttonL1.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          coinButtonL2.setVisible(true);
          coinButtonL3.setVisible(true);
          coinButtonL4.setVisible(true);
          coinButtonL5.setVisible(true);
          dEndButtonL.setVisible(true);
        }
      }
    );

    coinButtonL2.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          schiedsrichter.getSpieler1().einsatzSetzen(1000);
          updateVermoegenS1();
          updateEinsatzGUI();
        }
      }
    );

    coinButtonR2.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          schiedsrichter.getSpieler2().einsatzSetzen(1000);
          updateVermoegenS2();
          updateEinsatzGUI();
        }
      }
    );

    coinButtonR3.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          schiedsrichter.getSpieler2().einsatzSetzen(200);
          updateVermoegenS2();
          updateEinsatzGUI();
        }
      }
    );

    coinButtonL3.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          schiedsrichter.getSpieler1().einsatzSetzen(200);
          updateVermoegenS1();
          updateEinsatzGUI();
        }
      }
    );

    coinButtonR4.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          schiedsrichter.getSpieler2().einsatzSetzen(100);
          updateVermoegenS2();
          updateEinsatzGUI();
        }
      }
    );

    coinButtonL4.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          schiedsrichter.getSpieler1().einsatzSetzen(100);
          updateVermoegenS1();
          updateEinsatzGUI();
        }
      }
    );

    coinButtonL5.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          schiedsrichter
            .getSpieler1()
            .einsatzSetzen(schiedsrichter.getSpieler1().getVermoegen());
          updateVermoegenS1();
          updateEinsatzGUI();
        }
      }
    );

    coinButtonR5.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          schiedsrichter
            .getSpieler2()
            .einsatzSetzen(schiedsrichter.getSpieler2().getVermoegen());
          updateVermoegenS2();
          updateEinsatzGUI();
        }
      }
    );

    dEndButtonR.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          if (
            schiedsrichter.getNichtBeginner() == schiedsrichter.getSpieler2()
          ) {
            schiedsrichter.Auswerten();
          } else {
            schiedsrichter.getSpieler2().durchgangBeenden();
            spielerbuttonR1.setVisible(false);
            spielerbuttonL1.setVisible(true);
            coinButtonR2.setVisible(false);
            coinButtonR3.setVisible(false);
            coinButtonR4.setVisible(false);
            coinButtonR5.setVisible(false);
            dEndButtonR.setVisible(false);
          }
        }
      }
    );

    dEndButtonL.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          if (
            schiedsrichter.getNichtBeginner() == schiedsrichter.getSpieler1()
          ) {
            schiedsrichter.Auswerten();
          } else {
            schiedsrichter.getSpieler1().durchgangBeenden();
            spielerbuttonL1.setVisible(false);
            spielerbuttonR1.setVisible(true);
            coinButtonL2.setVisible(false);
            coinButtonL3.setVisible(false);
            coinButtonL4.setVisible(false);
            coinButtonL5.setVisible(false);
            dEndButtonL.setVisible(false);
          }
        }
      }
    );

    exitButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent c) {
          System.exit(0);
        }
      }
    );

    startPanel.setVisible(true);
    frame.add(startPanel);
    frame.setVisible(true);
  }

  //Update Methoden :
  public static void updateEinsatzGUI() {
    int currentValue = schiedsrichter.getTopf1().getEinsatz();
    textFieldEinsatz.setText("Einsatz : " + currentValue);
  }

  public static void updateVermoegenS1() {
    int currentValue = schiedsrichter.getSpieler1().getVermoegen();
    textFieldL.setText("Konto : " + currentValue);
  }

  public static void updateVermoegenS2() {
    int currentValue = schiedsrichter.getSpieler2().getVermoegen();
    textFieldR.setText("Konto : " + currentValue);
  }

  public static void resetZButton() {
    schiedsrichter.gameReset();
    updateEinsatzGUI();
    updateVermoegenS1();
    updateVermoegenS2();
    schiedsrichter.spielStarten();
  }

  public static void updateAugenzahl() {
    int currentValue =
      schiedsrichter.getWuerfel1().getPunkte() +
      schiedsrichter.getWuerfel2().getPunkte();
    textFieldAugenzahl.setText("Augenzahl : " + currentValue);
  }

  public static void updateWurfanzahlL() {
    int currentValue = schiedsrichter.getSpieler1().getWurfAnzahl();
    textFieldAnzahlWuerfeL.setText("Wuerfe : " + currentValue);
  }

  public static void updateWurfanzahlR() {
    int currentValue = schiedsrichter.getSpieler2().getWurfAnzahl();
    textFieldAnzahlWuerfeR.setText("Wuerfe : " + currentValue);
  }

  // Getter / Setter Methoden

  public Schiedsrichter getSchiedsrichter() {
    return this.schiedsrichter;
  }

  public void setSchiedsrichter(Schiedsrichter schiedsrichter) {
    this.schiedsrichter = schiedsrichter;
  }
}