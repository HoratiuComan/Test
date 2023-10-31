import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class IntVanzareVehicul extends JFrame {
    private List<Masina> masiniDinAltFisier;
    private JList<String> list;

    public IntVanzareVehicul() {
        this.setTitle("Vanzare Autovehicul");
        this.setLayout(new BorderLayout());
        this.setSize(350, 200);

        List<Masina> masiniDinAltFisier = ListaVehicule.getVehicule();

        String[] listaVehicule = new String[masiniDinAltFisier.size()];

        if (masiniDinAltFisier.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nu există mașini de vândut.", "Eroare", JOptionPane.ERROR_MESSAGE);

            return;
        }

        for (int i = 0; i < masiniDinAltFisier.size(); i++) {
            Masina masina = masiniDinAltFisier.get(i);
            listaVehicule[i] = "Marca: " + masina.getMarca() + " - Modelul: " + masina.getModel() +  "-Pretul: " + masina.getPret();
        }

        list = new JList<>(listaVehicule);
        JScrollPane scrollpane = new JScrollPane(list);
        getContentPane().add(scrollpane, BorderLayout.CENTER);

        JButton btnVinde = new JButton("Vinde");

        btnVinde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIdx = list.getSelectedIndex();
                if (selectedIdx >= 0 && selectedIdx < masiniDinAltFisier.size()) {

                    Masina masinaVanduta = masiniDinAltFisier.get(selectedIdx);
                    int confirmare = JOptionPane.showConfirmDialog(null, "Sigur doriți să vindeți vehiculul: " + masinaVanduta.getMarca() + " - " + masinaVanduta.getModel() + "?", "Confirmare vânzare", JOptionPane.YES_NO_OPTION);

                    if (confirmare == JOptionPane.YES_OPTION) {
                        masiniDinAltFisier.remove(selectedIdx);
                        refreshList();
                        JOptionPane.showMessageDialog(null, "Vehiculul a fost vândut cu succes.", "Succes", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selectați un vehicul înainte de a încerca să-l vindeți.", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(btnVinde, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private void refreshList() {
        String[] Vehicule = new String[masiniDinAltFisier.size()];
        for (int i = 0; i < masiniDinAltFisier.size(); i++) {
            Masina masina = masiniDinAltFisier.get(i);
            Vehicule[i] = "Marca: " + masina.getMarca() + " - Modelul: " + masina.getModel();
        }
        list.setListData(Vehicule);
    }
}
