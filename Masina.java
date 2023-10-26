public class Masina {
    
    private String marca;
    private String model;
    private int an;
    private float pret;
    private String culoare;

    public Masina(String marca, String model) {
        this.setMarca(marca);
        this.setModel(model);
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return marca + " " + model ;
    }
}