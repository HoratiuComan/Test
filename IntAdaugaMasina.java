import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class IntAdaugaMasina extends JFrame implements ItemListener, ActionListener {
    JComboBox<String> comboMarca, comboModel;
    JTextField txtPret;
    JButton button1 = new JButton();

    public static List<Masina> motociclete = new ArrayList<>();

    IntAdaugaMasina() {
        this.setTitle("Meniu Adaugare Motociclete");
        this.setLayout(new FlowLayout(100, 200, 50));
        this.setSize(200, 100);

        final String[] marci = {"Marca", "Audi", "BMW", "Renault", "Volkswagen"};

        comboMarca = new JComboBox<String>(marci);
        comboMarca.addItemListener(this);

        comboModel = new JComboBox<String>();
        comboModel.addItemListener(this);
        comboModel.insertItemAt("Model", 0);
        comboModel.setSelectedIndex(0);
        comboModel.setEnabled(false);

        txtPret = new JTextField(7);

        button1.setText("Adauga");
        button1.addActionListener(this);

        this.add(comboMarca);
        this.add(comboModel);
        this.add(new JLabel("Pret:"));
        this.add(txtPret);
        this.add(button1);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        List<Masina> masini = ListaVehicule.getVehicule();

        String Marca = comboMarca.getSelectedItem().toString();
        String Model = comboModel.getSelectedItem().toString();
        String PretStr = txtPret.getText();

        if (Marca.equals("Marca") || Model.equals("Model") || PretStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "\"Selectati marca, modelul si introduceti pretul inainte de a adauga masina", "Eroare", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                float Pret = Float.parseFloat(PretStr);
                masini.add(new Masina(Marca, Model, Pret));
                JOptionPane.showMessageDialog(this, "Mașina a fost adăugată cu succes.", "Succes", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Introduceți un pret valid", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        }

        for (int i = 0; i < masini.size(); i++) {
            Masina masina = masini.get(i);
            System.out.println(masina);
        }
    }
    public static List<Masina> getMasini() {
        return motociclete;
    }

    public void itemStateChanged(ItemEvent e) {
        final String Audi[] = {"A3", "A4", "A5", "RS Q8", "TTs"};
        final String BMW[] = {"E36", "E60", "Z4", "X6", "I7"};
        final String Renault[] = {"Megane", "Senic", "Kangoo", "Talisman"};
        final String Volkswagen[] = {"Golf", "Passat", "Touareg", "Lupo"};

        if (e.getSource() == comboMarca) {
            if (comboMarca.getSelectedItem().equals("Marca")) {
                comboModel.setEnabled(false);
            } else if (comboMarca.getSelectedItem().equals("Audi")) {
                comboModel.setEnabled(true);
                comboModel.removeAllItems();
                for (int i = 0; i < Audi.length; i++) {
                    comboModel.addItem(Audi[i]);
                }
            } else if (comboMarca.getSelectedItem().equals("BMW")) {
                comboModel.setEnabled(true);
                comboModel.removeAllItems();
                for (int i = 0; i < BMW.length; i++) {
                    comboModel.removeItem(BMW[i]);
                    comboModel.addItem(BMW[i]);
                }
            } else if (comboMarca.getSelectedItem().equals("Renault")) {
                comboModel.setEnabled(true);
                comboModel.removeAllItems();
                for (int i = 0; i < Renault.length; i++) {
                    comboModel.addItem(Renault[i]);
                }
            } else if (comboMarca.getSelectedItem().equals("Volkswagen")) {
                comboModel.setEnabled(true);
                comboModel.removeAllItems();
                for (int i = 0; i < Volkswagen.length; i++) {
                    comboModel.addItem(Volkswagen[i]);
                }
            }
        }
    }
}