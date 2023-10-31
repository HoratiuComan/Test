public class Motocicleta extends Masina {
    private double capacitate;

    public Motocicleta(String marca, String model, int an, float pret, double capacitate) {
        super(marca, model, an, pret); // Apelați constructorul clasei părinte (Masina)
        this.setCapacitate(capacitate);
    }

    public double getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(double capacitate) {
        this.capacitate = capacitate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + capacitate; // Apelați metoda toString() a clasei părinte și adăugați capacitatea
    }
}
