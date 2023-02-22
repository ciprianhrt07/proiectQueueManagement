import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimulationFrame {

    private JFrame frame;
    private JTextField numarServere;
    private JTextField textField_1;
    private JTextField timpMinimdeService;
    private JTextField timpMaximdeProcesare;
    private JTextField timpMinimdeProcesare;
    private JTextField timpMaximdeSimulare;
    private JLabel labelTimpMaximdeProcesare;
    private JLabel labelTimpMimimdeService;
    private JLabel labelTimpMaximdeService;
    private JLabel labelNumarDeServere;
    private JLabel labelNumardeClienti;
    private JTextField numarClienti;
    private JTextArea textAfisare;
    private JButton butonStart;
    private JButton butonTest1;
    private JButton butonTest2;
    private JButton butonTest3;

    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SimulationFrame window = new SimulationFrame();
                    //window.frame.setTitle("Queue management application");
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }




    /*
     * Create the application.
     */
    public SimulationFrame() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getNumarServere() {
        return numarServere;
    }

    public void setNumarServere(JTextField numarServere) {
        this.numarServere = numarServere;
    }

    public JTextField getTextField_1() {
        return textField_1;
    }

    public void setTextField_1(JTextField textField_1) {
        this.textField_1 = textField_1;
    }

    public JTextField getTimpMinimdeService() {
        return timpMinimdeService;
    }

    public void setTimpMinimdeService(JTextField timpMinimdeService) {
        this.timpMinimdeService = timpMinimdeService;
    }

    public JTextField getTimpMaximdeProcesare() {
        return timpMaximdeProcesare;
    }

    public void setTimpMaximdeProcesare(JTextField timpMaximdeProcesare) {
        this.timpMaximdeProcesare = timpMaximdeProcesare;
    }

    public JTextField getTimpMinimdeProcesare() {
        return timpMinimdeProcesare;
    }

    public void setTimpMinimdeProcesare(JTextField timpMinimdeProcesare) {
        this.timpMinimdeProcesare = timpMinimdeProcesare;
    }

    public JTextField getTimpMaximdeSimulare() {
        return timpMaximdeSimulare;
    }

    public void setTimpMaximdeSimulare(JTextField timpMaximdeSimulare) {
        this.timpMaximdeSimulare = timpMaximdeSimulare;
    }

    public JLabel getLabelTimpMaximdeProcesare() {
        return labelTimpMaximdeProcesare;
    }

    public void setLabelTimpMaximdeProcesare(JLabel labelTimpMaximdeProcesare) {
        this.labelTimpMaximdeProcesare = labelTimpMaximdeProcesare;
    }

    public JLabel getLabelTimpMimimdeService() {
        return labelTimpMimimdeService;
    }

    public void setLabelTimpMimimdeService(JLabel labelTimpMimimdeService) {
        this.labelTimpMimimdeService = labelTimpMimimdeService;
    }

    public JLabel getLabelTimpMaximdeService() {
        return labelTimpMaximdeService;
    }

    public void setLabelTimpMaximdeService(JLabel labelTimpMaximdeService) {
        this.labelTimpMaximdeService = labelTimpMaximdeService;
    }

    public JLabel getLabelNumarDeServere() {
        return labelNumarDeServere;
    }

    public void setLabelNumarDeServere(JLabel labelNumarDeServere) {
        this.labelNumarDeServere = labelNumarDeServere;
    }

    public JLabel getLabelNumardeClienti() {
        return labelNumardeClienti;
    }

    public void setLabelNumardeClienti(JLabel labelNumardeClienti) {
        this.labelNumardeClienti = labelNumardeClienti;
    }

    public JTextField getNumarClienti() {
        return numarClienti;
    }

    public void setNumarClienti(JTextField numarClienti) {
        this.numarClienti = numarClienti;
    }

    public  synchronized JTextArea getTextAfisare() {
        return textAfisare;
    }

    public  synchronized void setTextAfisare(String textAfisare) {
        this.textAfisare.setText(textAfisare);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Queue management application");
        frame.setBounds(100, 100, 843, 501);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        butonStart = new JButton("START");


        butonStart.setBounds(10, 383, 164, 31);
        frame.getContentPane().add(butonStart);

        numarServere = new JTextField();
        numarServere.setBounds(10, 295, 164, 31);
        frame.getContentPane().add(numarServere);
        numarServere.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 245, 164, 31);
        frame.getContentPane().add(textField_1);

        timpMinimdeService = new JTextField();
        timpMinimdeService.setColumns(10);
        timpMinimdeService.setBounds(10, 189, 164, 31);
        frame.getContentPane().add(timpMinimdeService);

        timpMaximdeProcesare = new JTextField();
        timpMaximdeProcesare.setColumns(10);
        timpMaximdeProcesare.setBounds(10, 137, 164, 31);
        frame.getContentPane().add(timpMaximdeProcesare);

        timpMinimdeProcesare = new JTextField();
        timpMinimdeProcesare.setColumns(10);
        timpMinimdeProcesare.setBounds(10, 85, 164, 31);
        frame.getContentPane().add(timpMinimdeProcesare);

        timpMaximdeSimulare = new JTextField();
        timpMaximdeSimulare.setColumns(10);
        timpMaximdeSimulare.setBounds(10, 32, 164, 31);
        frame.getContentPane().add(timpMaximdeSimulare);

        JLabel labelTimpMaximdeSimulare = new JLabel("Timp Maxim de Simulare");
        labelTimpMaximdeSimulare.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        labelTimpMaximdeSimulare.setBounds(10, 10, 164, 24);
        frame.getContentPane().add(labelTimpMaximdeSimulare);

        JLabel labelTimpminimdeProcesare = new JLabel("");
        labelTimpminimdeProcesare.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        labelTimpminimdeProcesare.setBounds(9, 63, 164, 24);
        frame.getContentPane().add(labelTimpminimdeProcesare);

        JLabel lblTi = new JLabel("Timp Minim de Procesare");
        lblTi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblTi.setBounds(10, 63, 164, 24);
        frame.getContentPane().add(lblTi);

        labelTimpMaximdeProcesare = new JLabel("Timp Maxim de Procesare");
        labelTimpMaximdeProcesare.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        labelTimpMaximdeProcesare.setBounds(10, 114, 164, 24);
        frame.getContentPane().add(labelTimpMaximdeProcesare);

        labelTimpMimimdeService = new JLabel("Timp Minim de Service");
        labelTimpMimimdeService.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        labelTimpMimimdeService.setBounds(10, 167, 164, 24);
        frame.getContentPane().add(labelTimpMimimdeService);

        labelTimpMaximdeService = new JLabel("Timp Maxim de Service");
        labelTimpMaximdeService.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        labelTimpMaximdeService.setBounds(10, 222, 164, 24);
        frame.getContentPane().add(labelTimpMaximdeService);

        labelNumarDeServere = new JLabel("Numar de servere");
        labelNumarDeServere.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        labelNumarDeServere.setBounds(10, 276, 164, 24);
        frame.getContentPane().add(labelNumarDeServere);

        labelNumardeClienti = new JLabel("Numar de Clienti");
        labelNumardeClienti.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        labelNumardeClienti.setBounds(10, 328, 164, 24);
        frame.getContentPane().add(labelNumardeClienti);

        numarClienti = new JTextField();
        numarClienti.setColumns(10);
        numarClienti.setBounds(10, 349, 164, 31);
        frame.getContentPane().add(numarClienti);

        textAfisare = new JTextArea();
        textAfisare.setBounds(205, 32, 595, 422);
        textAfisare.setEditable(false);
        textAfisare.setColumns(10);
        frame.getContentPane().add(textAfisare);

        butonTest1 = new JButton("T1");
        butonTest1.setBounds(10, 424, 52, 30);
        frame.getContentPane().add(butonTest1);

        butonTest2 = new JButton("T2");
        butonTest2.setBounds(72, 424, 52, 30);
        frame.getContentPane().add(butonTest2);

         butonTest3 = new JButton("T3");
        butonTest3.setBounds(134, 424, 52, 30);
        frame.getContentPane().add(butonTest3);


    }

    public JButton getButonStart() {
        return butonStart;
    }

    public void setButonStart(JButton butonStart) {
        this.butonStart = butonStart;
    }

    public void setTextAfisare(JTextArea textAfisare) {
        this.textAfisare = textAfisare;
    }



    public JButton getButonTest1() {
        return butonTest1;
    }

    public void setButonTest1(JButton butonTest1) {
        this.butonTest1 = butonTest1;
    }

    public JButton getButonTest2() {
        return butonTest2;
    }

    public void setButonTest2(JButton butonTest2) {
        this.butonTest2 = butonTest2;
    }

    public JButton getButonTest3() {
        return butonTest3;
    }

    public void setButonTest3(JButton butonTest3) {
        this.butonTest3 = butonTest3;
    }
}
