package candidatura;

public class ProcessoSeletivo {
    public static void main(String[] args) {

        analisarCandidato(1200.00);
        analisarCandidato(2900.00);
        analisarCandidato(2000.00);

    }

    static void analisarCandidato(double salarioPretendido) {

        double salarioBase = 2000.00;

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO.");
        }
        else if (salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA.");
        }
        else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }
}
