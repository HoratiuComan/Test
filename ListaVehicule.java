import java.util.ArrayList;
import java.util.List;

public class ListaVehicule {


    private static List<Masina> vehicule = new ArrayList<>();

    public static List<Masina> getVehicule() {
        return vehicule;
    }

    public static void adaugaVehicule(Masina masina) {
        vehicule.add(masina);
    }
}
