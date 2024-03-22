package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {

    public static void main(String[] args) {
        ControlVacunas DatosVacuna = new ControlVacunas("vacunas");

        // Creamos botones, cuadros de texto
        JFrame frame = new JFrame("Control de Vacunas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(null);

        JLabel cuiLabel = new JLabel("CUI:");
        cuiLabel.setBounds(15, 10, 80, 25);
        frame.add(cuiLabel);

        JTextField cuiText = new JTextField();
        cuiText.setBounds(105, 10, 160, 25);
        frame.add(cuiText);

        JLabel PimeraDosisLabel = new JLabel("Primera Dosis:");
        PimeraDosisLabel.setBounds(15, 40, 1200, 25);
        frame.add(PimeraDosisLabel);

        JTextField PrimeraDosisText = new JTextField();
        PrimeraDosisText.setBounds(105, 40, 160, 25);
        frame.add(PrimeraDosisText);

        JLabel SegundaDosisLabel = new JLabel("Segunda Dosis:");
        SegundaDosisLabel.setBounds(15, 70, 120, 25);
        frame.add(SegundaDosisLabel);

        JTextField SegundaDosisText = new JTextField();
        SegundaDosisText.setBounds(105, 70, 160, 25);
        frame.add(SegundaDosisText);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.setBounds(10, 100, 100, 25);
        frame.add(guardarButton);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(120, 100, 100, 25);
        frame.add(buscarButton);

        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setBounds(10, 130, 350, 60);
        frame.add(resultadoArea);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cui = cuiText.getText();
                String PrimerVacuna = PrimeraDosisText.getText();
                String SegundaVacuna = SegundaDosisText.getText();
                Vacuna vacuna = new Vacuna(PrimerVacuna, SegundaVacuna);
                DatosVacuna.addVacuna(cui, vacuna);
                JOptionPane.showMessageDialog(frame, "Vacuna guardada con éxito");
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cui = cuiText.getText();
                Vacuna vacuna = DatosVacuna.getVacuna(cui);
                if (vacuna != null) {
                    resultadoArea.setText(vacuna.toString());
                } else {
                    resultadoArea.setText("No se encontró vacuna con CUI " + cui);
                }
            }
        });

        frame.setVisible(true);
    }
}