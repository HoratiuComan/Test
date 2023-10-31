import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfata extends JFrame implements ActionListener{

    JButton button1 = new JButton(); // crearea unu buton
    JButton button2 = new JButton();
    JButton button3 = new JButton();

    public static List<Masina> masiniDinAltFisier = new ArrayList<>();

    Interfata(){

        button1.setBounds(100,100,250,100);
        button1.setText("Introducere vehicul");
        button1.addActionListener(this);


        button2.setBounds(100,250,250,100);
        button2.setText("Afisati masinile");
        button2.addActionListener(this);


        button3.setBounds(100,400,250,100);
        button3.setText("Vanzare masini");
        button3.addActionListener(this);


        this.setTitle("Parc Auto SRL");
        this.setLayout(null);
        this.setSize(500, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            System.out.println("Buton apasat!");
            new IntSelectareVehicul();
        }

        if(e.getSource() == button2){
                    System.out.println("Buton apasat!");
                     new IntVizualizareVehicule();

        }

        if(e.getSource() == button3){
                    System.out.println("Buton apasat!");
                     new IntVanzareVehicul();

        }
    }
}
