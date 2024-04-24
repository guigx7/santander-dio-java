import java.util.Scanner;

public class SimulacaoBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0;
        Boolean executa = true;

        while (executa){
            //Digita opcao
            int opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    // Depositar
                    double valorDeposito = scanner.nextDouble();
                    saldo += valorDeposito;
                    System.out.println("Saldo atual: " + saldo);
                    break;
                case 2:
                    // Sacar
                    double valorSaque = scanner.nextDouble();
                    if (valorSaque > saldo) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        saldo -= valorSaque;
                        System.out.println("Saldo atual: " + saldo);
                    }
                    break;
                case 3:
                    // Consultar Saldo
                    System.out.println("Saldo atual: " + saldo);
                    break;
                case 0:
                    // Encerrar
                    System.out.println("Programa encerrado.");
                    executa = false;
                    return; // Termina o programa
                default:
                    // Opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
