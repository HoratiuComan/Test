import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class IntAdaugaMasina extends JFrame implements ItemListener, ActionListener{

    JComboBox<String> comboMarca, comboModel;
	JButton button1 = new JButton(); // crearea unu buton

	public static List<Masina> masini = new ArrayList<>();

    IntAdaugaMasina(){

        this.setTitle("Meniu Adaugare Masini"); // setam titlu
        this.setLayout(new FlowLayout(200, 300, 100));
        this.setSize(300, 300); // setam dimensiunile

        final String[] marci = {"Marca", "Audi", "BMW", "Renault", "Volkswagen"};

        comboMarca = new JComboBox<String>(marci);
        comboMarca.addItemListener(this);

        comboModel = new JComboBox<String>();
        comboModel.addItemListener(this);
        comboModel.insertItemAt("Model", 0);
        comboModel.setSelectedIndex(0);
        comboModel.setEnabled(false);

        button1.setText("Adauga"); // da un nume butonului
        button1.addActionListener(this); // executarea unei comenzi in urma apasarii butonului

        this.add(comboMarca);
        this.add(comboModel);
		this.add(button1); // adauga butonul
        this.pack();
        this.setVisible(true); // face vizibila fereastra
    }


	public void actionPerformed(ActionEvent e)
    {
		
		List<Masina> masini = new ArrayList<>();

        String Marca = comboMarca.getSelectedItem().toString();
		String Model = comboModel.getSelectedItem().toString();
		
		masini.add(new Masina(Marca, Model));
		//masini.add(new Masina("Porsche", "911"));
		//masini.add(new Masina("Tesla", "Model Y"));

		for (int i = 0; i < masini.size(); i++) {
			Masina masina = masini.get(i);
			System.out.println(masina);
		}
    }

	public static List<Masina> getMasini() {
        	return masini; 
    }

    public void itemStateChanged(ItemEvent e) {

        final String Audi[] = { "A3", "A4", "A5", "RS Q8", "TT" };
		final String BMW[] = { "550d", "E36", "E90", "X7", "Seria 6"};
		final String Renault[] = { "Megane", "Senic", "Talisman", "Kangoo" };
		final String Volkswagen[] = {"Golf ", "Passat", "Touareg", "Tiguan"};

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
			}else if (comboMarca.getSelectedItem().equals("Volkswagen")) {
				comboModel.setEnabled(true);
				comboModel.removeAllItems();
				for (int i = 0; i < Volkswagen.length; i++) {
					comboModel.addItem(Volkswagen[i]);
				}
			}
		}
    }	
}