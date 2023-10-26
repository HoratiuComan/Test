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


        button1.setBounds(100,100,250,100); // setare dimensiuni
        button1.setText("Introducere vehicul"); // da un nume butonului
        button1.addActionListener(this); // executarea unei comenzi in urma apasarii butonului


        button2.setBounds(100,250,250,100); // setare dimensiuni
        button2.setText("Afisati masinile"); // da un nume butonului
        button2.addActionListener(this); // executarea unei comenzi in urma apasarii butonului


        button3.setBounds(100,400,250,100); // setare dimensiuni
        button3.setText("Afisati masinile"); // da un nume butonului
        button3.addActionListener(this); // executarea unei comenzi in urma apasarii butonului


        this.setTitle("Parc Auto Horatiu SRL"); // setam titlu
        this.setLayout(null); 
        this.setSize(500, 700); // setare dimensiunile 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // iesirea din program



        this.add(button1); // adauga butonul
        this.add(button2); // adauga butonul
        this.add(button3);
        this.setVisible(true); // face vizibila fereastra
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            System.out.println("Buton apasat!");
            new IntSelectareVehicul();
        }

        if(e.getSource() == button2){
                    System.out.println("Buton apasat!");
                     new IntVizualizareMasini();
                 
        }
        

          if(e.getSource() == button3){
                    System.out.println("Buton apasat!");
                     new IntVanzareVehicul();
                 
        }
        
        
    }
}
