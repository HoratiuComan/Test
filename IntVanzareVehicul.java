import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class IntVanzareVehicul extends JFrame {

    public IntVanzareVehicul() {
        this.setTitle("Vanzare Autovehicul");
        this.setLayout(new BorderLayout()); // Utilizați BorderLayout pentru a aranja componentele
        this.setSize(300, 200);

        List<Masina> masiniDinAltFisier = IntAdaugaMasina.getMasini();
        masiniDinAltFisier.add(new Masina("BMW","Seria 7"));
        masiniDinAltFisier.add(new Masina("Audi","80"));
        masiniDinAltFisier.add(new Masina("Skoda","Fabia"));
        System.out.println("Numar de masini: " + masiniDinAltFisier.size());

        String[] listaMasini = new String[masiniDinAltFisier.size()];
        for (int i = 0; i < masiniDinAltFisier.size(); i++) {
            Masina masina = masiniDinAltFisier.get(i);
            listaMasini[i] = "Marca: " + masina.getMarca() + "- Modelul: " + masina.getModel();
        }

        JList<String> list = new JList<>(listaMasini);
        JScrollPane scrollpane = new JScrollPane(list);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
