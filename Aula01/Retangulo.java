public class Retangulo extends FormaGeometrica{
    private double medida02;

    @Override
    public double calculaArea() {
        return this.getMedida01() * this.medida02;
    }
    
    public double getMedida02() {
        return medida02;
    }

    public void setMedida02(double medida02) {
        this.medida02 = medida02;
    }
    
}
