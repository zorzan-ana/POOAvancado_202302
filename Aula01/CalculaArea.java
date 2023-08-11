import java.util.Scanner;

public class CalculaArea {
    public static void main(String[] args) {
        String mensagemInicial = """
                ----------------------------------------
                           Seja bem vindo!!!!
                ----------------------------------------
                Com qual tipo de forma geométrica você quer trabalhar hoje?
                1 - Quadrado
                2 - Retângulo
                0 - Sair
                """;
        Scanner lerTeclado = new Scanner(System.in);
        int opcao;
        FormaGeometrica forma;
        do {
            forma = null;
            System.out.println(mensagemInicial);
            // var opcao = lerTeclado.nextInt();
            opcao = lerTeclado.nextInt();
            lerTeclado.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("--- Saindo ---");
                    // System.exit(0);
                    break;
                case 1:
                    forma = new Quadrado();
                    break;
                case 2:
                    forma = new Retangulo();
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
            if (forma != null) {
                System.out.println("Informe a primeira medida:");
                forma.setMedida01(lerTeclado.nextDouble());
                if (forma instanceof Retangulo) {
                    System.out.println("Informe a segunda medida:");
                    Retangulo retangulo = (Retangulo) forma;
                    retangulo.setMedida02(lerTeclado.nextDouble());
                }
                System.out.println("A área da forma " + forma.getClass() + ": " + forma.calculaArea());
            }

        } while (opcao != 0);
        // } while (true);
    }
}