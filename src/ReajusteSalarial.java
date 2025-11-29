import java.util.Scanner;
import java.util.Locale; // Importação necessária para definir o padrão americano (ponto)

public class ReajusteSalarial {
    public static void main(String[] args) {
        // Configura o scanner para usar o padrão dos EUA (ponto para decimais)
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("=== SISTEMA DE REAJUSTE SALARIAL ===");
        System.out.print("Digite o salário atual do colaborador (ex: 1200.50): R$ ");

        // Lê o número. Graças ao Locale.US, o usuário deve usar PONTO (1200.50)
        double salarioAtual = scanner.nextDouble();

        int percentual;
        double taxaInflacao = 0.038; // 3.8%

        // Lógica de decisão das faixas salariais
        if (salarioAtual <= 280) {
            percentual = 20;
        } else if (salarioAtual < 700) {
            percentual = 15;
        } else if (salarioAtual < 1500) {
            percentual = 10;
        } else {
            percentual = 5;
        }

        // Cálculos financeiros
        double valorAumento = salarioAtual * (percentual / 100.0);
        double novoSalario = salarioAtual + valorAumento;

        // Cálculo do ganho real vs inflação
        double perdaInflacao = salarioAtual * taxaInflacao;
        double aumentoReal = valorAumento - perdaInflacao;

        // Saída de dados formatada
        System.out.println("\n------------------------------------------");
        System.out.println("        DETALHAMENTO DO REAJUSTE          ");
        System.out.println("------------------------------------------");
        System.out.printf("Salário antes do reajuste:          R$ %.2f%n", salarioAtual);
        System.out.println("Percentual de aumento aplicado:      " + percentual + "%");
        System.out.printf("Valor do aumento:                   R$ %.2f%n", valorAumento);
        System.out.printf("Novo salário após aumento:          R$ %.2f%n", novoSalario);
        System.out.println("------------------------------------------");
        System.out.printf("Inflação do período:                3.8%%%n");
        System.out.printf("Perda estimada pela inflação:       R$ %.2f%n", perdaInflacao);
        System.out.printf("Aumento REAL (descontada inflação): R$ %.2f%n", aumentoReal);
        System.out.println("------------------------------------------");

        scanner.close();
    }
}