public class Masina {

    private String marca;
    private String model;
    private int an;
    private float pret;
    private String culoare;

    public Masina(String marca, String model, float pret) {
        this.setMarca(marca);
        this.setModel(model);
        this.setAn(an);
        this.setPret(pret);
        this.setCuloare(culoare);
    }


    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public int getAn(){
        return an;
    }

    public float getPret(){
        return pret;
    }

    public String getCuloare(){
        return culoare;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public void setAn(int an){
        this.an = an;
    }

    public void setPret(float pret){
        this.pret = pret;
    }

    public void setCuloare(String culoare){
        this.culoare = culoare;
    }

    @Override
    public String toString() {
        return marca + " " + model + " " +an + " " + pret +" " + culoare;
    }
}