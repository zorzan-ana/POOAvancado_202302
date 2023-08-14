import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExemploListasMap {
    public static void main(String[] args) {
        List<Double> listaExemplo = new ArrayList<>();
        listaExemplo.add(33.);
        listaExemplo.add(2.);
        double soma = 0;
        for (Double item : listaExemplo) {
            soma = soma + item;
        }
        Map<String, Integer> mapExemplo = new HashMap<>();
        mapExemplo.put("Chave 2", 44);
        mapExemplo.put("Chave 3", 33);
        mapExemplo.put("Chave 2", 4);
        int soma2 = mapExemplo.get("Chave 2") + mapExemplo.get("Chave 3");

    }
}
