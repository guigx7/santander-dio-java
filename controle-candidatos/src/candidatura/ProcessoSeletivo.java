package candidatura;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoCandidatos();
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"Guilherme", "Carlos", "Enrico", "Nader", "Marcelo", "Pedro", "Arthur", "Henrique", "Leonardo", "Andrey"};
        ArrayList<String> listaSelecionados = new ArrayList<>();
        ArrayList<String> listaAprovados = new ArrayList<>();
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

        if (listaSelecionados.size() != 0){
            if (listaSelecionados.size() == 1) {
                System.out.println(listaSelecionados.size() + " candidato selecionado para a vaga: " + listaSelecionados.toString().replace("[", "").replace("]", ".") + "\n");
            }
            else {
                System.out.println(listaSelecionados.size() + " candidatos selecionados para a vaga: " + listaSelecionados.toString().replace("[", "").replace("]", ".") + "\n");
            }

        }
        else {
            System.out.println("Nenhum candidato foi selecionado para a vaga.\n");
        }

        listaAprovados = entrarEmContato(listaSelecionados, listaAprovados);

        if (listaAprovados.size() != 0) {
            if (listaAprovados.size() == 1){
                System.out.println("\n" + listaAprovados.size() + " candidato aprovado: " + listaAprovados.toString().replace("[", "").replace("]", ".") + "\n");
            }
            else {
                System.out.println("\n" + listaAprovados.size() + " candidatos aprovados: " + listaAprovados.toString().replace("[", "").replace("]", ".") + "\n");
            }
        }
        else {
            System.out.println("\nNenhum candidato foi aprovado.");
        }
    }

    static double randomizarValorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1700.00, 2400.99);
    }

    static ArrayList<String> entrarEmContato(ArrayList<String> selecionados, ArrayList<String> aprovados){
        for (String selecionado : selecionados){
            Random random = new Random();
            int tentativas = 0;
            boolean atendeu = false;

            while (tentativas < 3 && !atendeu) {
                atendeu = random.nextBoolean();
                tentativas++;
                if (atendeu){
                    aprovados.add(selecionado);
                    System.out.println("Conseguimos contato com " + selecionado + " na " + tentativas + "º tentativa");
                }
                if (tentativas >= 3 && !atendeu){
                    System.out.println("Não conseguimos contato com " + selecionado + " após " + tentativas + " tentativas");
                }
            }
        }
        return aprovados;
    }
}
