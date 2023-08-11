
public class CastingTiposPrimitivos {
    public static void main(String[] args) {
        int numeroInteiro = 100;
        long numeroLong = numeroInteiro; // cast implícito de int para long
        double numeroDouble = numeroInteiro; // cast implícito de int para double
        double numeroDouble2 = numeroLong; // cast implícito de long para double

        double numeroDoublePI = 3.14159265359; 
        float numeroFloatPI = (float) numeroDoublePI; // cast explícito de double para float
        int numeroInteiroPI = (int) numeroDoublePI; // cast explícito de double para int 
        System.out.println("PI em double: " + numeroDoublePI + "\nPI em float: " + 
                            numeroFloatPI + "\nPI em int: " + numeroInteiroPI);
    }
}