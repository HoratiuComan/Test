import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class IntAdaugaMotocicleta extends JFrame implements ItemListener, ActionListener {
    JComboBox<String> comboMarca, comboModel;
    JTextField txtPret;
    JButton button1 = new JButton();

    public static List<Masina> motociclete = new ArrayList<>();

    IntAdaugaMotocicleta() {
        this.setTitle("Meniu Adaugare Motociclete");
        this.setLayout(new FlowLayout(100, 200, 50));
        this.setSize(200, 100);

        final String[] marci = {"Marca", "Suzuki", "Kawasaki", "Yamaha", "Honda"};

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
            JOptionPane.showMessageDialog(this, "Selectati marca, modelul si introduceti pretul inainte de a adauga motocicleta", "Eroare", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                float Pret = Float.parseFloat(PretStr);
                masini.add(new Masina(Marca, Model, Pret));
                JOptionPane.showMessageDialog(this, "Motocicleta a fost adăugată cu succes.", "Succes", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Introduceti un pret valid", "Eroare", JOptionPane.ERROR_MESSAGE);
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
        final String Suzuki[] = {"HAYABUSA 25TH", "KATANA", "GSX-R125", "V-STROM 800", "V-STROM 1050DE"};
        final String Kawasaki[] = {"Ninja ZX-10R", "Z400", "Z650", "Z900", "Versys 1000 S"};
        final String Yamaha[] = {"XSR700 Legacy", "Senic", "R1M", "MT-900"};
        final String Honda[] = {"PCX125", "CB 750 Hornet", "NC 750 X", "FIREBLADE SP"};

        if (e.getSource() == comboMarca) {
            if (comboMarca.getSelectedItem().equals("Marca")) {
                comboModel.setEnabled(false);
            } else if (comboMarca.getSelectedItem().equals("Suzuki")) {
                comboModel.setEnabled(true);
                comboModel.removeAllItems();
                for (int i = 0; i < Suzuki.length; i++) {
                    comboModel.addItem(Suzuki[i]);
                }
            } else if (comboMarca.getSelectedItem().equals("Kawasaki")) {
                comboModel.setEnabled(true);
                comboModel.removeAllItems();
                for (int i = 0; i < Kawasaki.length; i++) {
                    comboModel.removeItem(Kawasaki[i]);
                    comboModel.addItem(Kawasaki[i]);
                }
            } else if (comboMarca.getSelectedItem().equals("Yamaha")) {
                comboModel.setEnabled(true);
                comboModel.removeAllItems();
                for (int i = 0; i < Yamaha.length; i++) {
                    comboModel.addItem(Yamaha[i]);
                }
            } else if (comboMarca.getSelectedItem().equals("Honda")) {
                comboModel.setEnabled(true);
                comboModel.removeAllItems();
                for (int i = 0; i < Honda.length; i++) {
                    comboModel.addItem(Honda[i]);
                }
            }
        }
    }
}