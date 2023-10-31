public class Camion extends Masina {
    private int caiPutere;

    public Camion(String marca, String model, int an, float pret, int caiPutere) {
        super(marca, model, an, pret); // Apelați constructorul clasei părinte (Masina)
        this.setCaiPutere(caiPutere);
    }

    public int getCaiPutere() {
        return caiPutere;
    }

    public void setCaiPutere(int caiPutere) {
        this.caiPutere = caiPutere;
    }

    @Override
    public String toString() {
        return super.toString() + " " + caiPutere; // Apelați metoda toString() a clasei părinte și adăugați caiPutere
    }
}
