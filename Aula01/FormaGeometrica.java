public abstract class FormaGeometrica {
    private double medida01;
    private String cor;

    public FormaGeometrica() {
        this("Nenhuma cor definida");
    }

    public FormaGeometrica(String cor) {
        this.cor = cor;
    }

    public abstract double calculaArea();

    public double getMedida01() {
        return medida01;
    }
    public void setMedida01(double medida01) {
        this.medida01 = medida01;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
}
