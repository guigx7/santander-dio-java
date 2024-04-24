package candidatura;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoCandidatos();
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"Guilherme", "Carlos", "Enrico", "Nader", "Marcelo", "Pedro", "Arthur", "Henrique", "Leonardo", "Andrey"};
        ArrayList<String> listaSelecionados = new ArrayList<>();
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.00;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = randomizarValorPretendido();


            System.out.println("O candidato " + candidato + " solicitou este valor de salário: R$ " + String.format("%.2f", salarioPretendido));
            if (salarioBase >= Double.valueOf(salarioPretendido)) {
                listaSelecionados.add(candidato);
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga\n");
                candidatosSelecionados++;
            }
            else {
                System.out.println("O candidato " + candidato + " não foi selecionado para a vaga\n");
            }
            candidatoAtual++;
        }

        System.out.println(listaSelecionados.size() + " candidatos selecionados para a vaga: " + listaSelecionados.toString().replace("[", "").replace("]", "."));
    }

    static double randomizarValorPretendido(){
        double value = ThreadLocalRandom.current().nextDouble(1700.00, 2400.99);
        return value;
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
