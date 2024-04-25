import java.util.Scanner;

public class ControleSimplesDeSaques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double limiteDiario = scanner.nextDouble();
        double valorSaque;
        double totalSaque = 0;

        while (true) {
            valorSaque = scanner.nextDouble();
            totalSaque += valorSaque;

            if (valorSaque == 0) {
                System.out.println("Transacoes encerradas.");
                break;
            }
            else if (totalSaque > limiteDiario){
                System.out.println("Limite diario de saque atingido. Transacoes encerradas.");
                break;
            }
            else {
                System.out.println("Saque realizado. Limite restante: " + (limiteDiario - totalSaque));
            }
        }
    }
}
