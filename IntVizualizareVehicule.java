import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class IntVizualizareVehicule extends JFrame {

    public IntVizualizareVehicule() {
        this.setTitle("Vehicule Disponibile");
        this.setLayout(new BorderLayout()); // Utilizați BorderLayout pentru a aranja componentele
        this.setSize(350, 200);

        List<Masina> masiniDinAltFisier =  ListaVehicule.getVehicule();

        String[] listaVehicule = new String[masiniDinAltFisier.size()];

        if (masiniDinAltFisier.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nu exista masini in parc", "Eroare", JOptionPane.ERROR_MESSAGE);

            return;
        }

        for (int i = 0; i < masiniDinAltFisier.size(); i++) {
            Masina masina = masiniDinAltFisier.get(i);
            listaVehicule[i] = "Marca: " + masina.getMarca() + "- Modelul: " + masina.getModel() +  "-Pretul: " + masina.getPret();
        }

        JList<String> list = new JList<>(listaVehicule);
        JScrollPane scrollpane = new JScrollPane(list);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
