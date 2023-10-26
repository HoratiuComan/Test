import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class IntAdaugaMotocicleta extends JFrame implements ItemListener, ActionListener{

    JComboBox<String> comboMarca, comboModel;
	JButton button1 = new JButton(); // crearea unu buton

	public static List<Masina> motociclete = new ArrayList<>();

    IntAdaugaMotocicleta(){

        this.setTitle("Meniu Adaugare Motocicleta"); // setam titlu
        this.setLayout(new FlowLayout(200, 300, 100));
        this.setSize(300, 300); // setam dimensiunile

        final String[] marci = {"Marca", "Kawaski", "Yamaha", "Suzuki", "Honda"};

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
		
		List<Masina> motociclete = new ArrayList<>();

        String Marca = comboMarca.getSelectedItem().toString();
		String Model = comboModel.getSelectedItem().toString();
		
		motociclete.add(new Masina(Marca, Model));
		//motociclete.add(new Masina("Porsche", "911"));
		//motociclete.add(new Masina("Tesla", "Model Y"));

		for (int i = 0; i < motociclete.size(); i++) {
			Masina masina = motociclete.get(i);
			System.out.println(masina);
		}
    }

	public static List<Masina> getMotociclete() {
        	return motociclete; 
    }

    public void itemStateChanged(ItemEvent e) {

        final String Kawasaki[] = { "Ninja", "gfd", "500", "ghjn", "gds" };
		final String Yamaha[] = { "YZF", "600", "950", "hfg", "dfh"};
		final String Suzuki[] = { "300", "R34", "aa", "fhgdc" };
		final String Honda[] = {"CBR ", "Civic", "gfd", "sdgf"};

        if (e.getSource() == comboMarca) {
			if (comboMarca.getSelectedItem().equals("Marca")) {
				comboModel.setEnabled(false);
			} else if (comboMarca.getSelectedItem().equals("Kawasaki")) {
				comboModel.setEnabled(true);
				comboModel.removeAllItems();
				for (int i = 0; i < Kawasaki.length; i++) {
					comboModel.addItem(Kawasaki[i]);
				}
			} else if (comboMarca.getSelectedItem().equals("Yamaha")) {
				comboModel.setEnabled(true);
				comboModel.removeAllItems();
				for (int i = 0; i < Yamaha.length; i++) {
					comboModel.removeItem(Yamaha[i]);
					comboModel.addItem(Yamaha[i]);
				}
			} else if (comboMarca.getSelectedItem().equals("Suzuki")) {
				comboModel.setEnabled(true);
				comboModel.removeAllItems();
				for (int i = 0; i < Suzuki.length; i++) {
					comboModel.addItem(Suzuki[i]);
				}
			}else if (comboMarca.getSelectedItem().equals("Honda")) {
				comboModel.setEnabled(true);
				comboModel.removeAllItems();
				for (int i = 0; i < Honda.length; i++) {
					comboModel.addItem(Honda[i]);
				}
			}
		}
    }	
}