import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class IntSelectareVehicul extends JFrame implements ItemListener, ActionListener{

    JComboBox<String>  comboTipVehicul;
	JButton button1 = new JButton(); // crearea unu buton

	public static List<Masina> masini = new ArrayList<>();

     IntSelectareVehicul()
     {

        this.setTitle("Meniu selectare tip vehicul"); // setam titlu
        this.setLayout(new FlowLayout(200, 300, 100));
        this.setSize(300, 300); // setam dimensiunile

        final String[] tipVehicul = {"Masina", "Motocicleta", "Camion"};

        comboTipVehicul = new JComboBox<String>(tipVehicul);
        comboTipVehicul.addItemListener(this);

        button1.setText("Urmatorul pas"); // da un nume butonului
        button1.addActionListener(this); // executarea unei comenzi in urma apasarii butonului

        this.add(comboTipVehicul);
		this.add(button1); // adauga butonul
        this.pack();
        this.setVisible(true); // face vizibila fereastra
    }


	public void actionPerformed(ActionEvent e)
    {
		
		// int pt fiecare tip //
        if (comboTipVehicul.getSelectedItem().equals("Masina"))
        {
            new IntMasina();
        }


        if (comboTipVehicul.getSelectedItem().equals("Motocicleta"))
        {
            new IntMotocicleta();
        }
    

        if (comboTipVehicul.getSelectedItem().equals("Camion"))
        {
            new IntCamion();
        }
    }

     public void itemStateChanged(ItemEvent e) {

     }

}
