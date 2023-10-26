import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class IntAdaugaCamion extends JFrame implements ItemListener, ActionListener{

    JComboBox<String> comboMarca, comboModel;
	JButton button1 = new JButton(); // crearea unu buton

	public static List<Masina> camioane = new ArrayList<>();

    IntAdaugaCamion(){

        this.setTitle("Meniu Adaugare Camioane"); // setam titlu
        this.setLayout(new FlowLayout(200, 300, 100));
        this.setSize(300, 300); // setam dimensiunile

        final String[] marci = {"Volvo", "MAN", "Scania", "Suzuki", "Honda"};

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
		
		List<Masina> camioane = new ArrayList<>();

        String Marca = comboMarca.getSelectedItem().toString();
		String Model = comboModel.getSelectedItem().toString();
		
		camioane.add(new Masina(Marca, Model));
		//camioane.add(new Masina("Porsche", "911"));
		//camioane.add(new Masina("Tesla", "Model Y"));

		for (int i = 0; i < camioane.size(); i++) {
			Masina masina = camioane.get(i);
			System.out.println(masina);
		}
    }

	public static List<Masina> getCamioane() {
        	return camioane; 
    }

    public void itemStateChanged(ItemEvent e) {

        final String Volvo[] = { "Ninja", "gfd", "500", "ghjn", "gds" };
		final String MAN[] = { "YZF", "600", "950", "hfg", "dfh"};
		final String Scania[] = { "300", "R34", "aa", "fhgdc" };
		final String Honda[] = {"CBR ", "Civic", "gfd", "sdgf"};

        if (e.getSource() == comboMarca) {
			if (comboMarca.getSelectedItem().equals("Marca")) {
				comboModel.setEnabled(false);
			} else if (comboMarca.getSelectedItem().equals("Volvo")) {
				comboModel.setEnabled(true);
				comboModel.removeAllItems();
				for (int i = 0; i < Volvo.length; i++) {
					comboModel.addItem(Volvo[i]);
				}
			} else if (comboMarca.getSelectedItem().equals("MAN")) {
				comboModel.setEnabled(true);
				comboModel.removeAllItems();
				for (int i = 0; i < MAN.length; i++) {
					comboModel.removeItem(MAN[i]);
					comboModel.addItem(MAN[i]);
				}
			} else if (comboMarca.getSelectedItem().equals("Scania")) {
				comboModel.setEnabled(true);
				comboModel.removeAllItems();
				for (int i = 0; i < Scania.length; i++) {
					comboModel.addItem(Scania[i]);
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