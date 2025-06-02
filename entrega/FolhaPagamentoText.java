import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FolhaPagamentoText {

    public static void main(String[] args) {
        String arquivoFuncionarios = "funcionarios.txt";
        List<Funcionario> funcionarios = new ArrayList<>();

        double impostoTotalFeminino = 0;
        double impostoTotalMasculino = 0;
        double impostoTotalGeral = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoFuncionarios))) {
            String linha;
            System.out.println("--- Relação de Funcionários ---");
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split("#");
                if (campos.length == 4) {
                    try {
                        String nome = campos[0];
                        char sexo = campos[1].charAt(0);
                        double salario = Double.parseDouble(campos[2]);
                        int dependentes = Integer.parseInt(campos[3]);

                        Funcionario funcionario = new Funcionario(nome, sexo, salario, dependentes);
                        funcionarios.add(funcionario);

                        System.out.println(funcionario.mostraFuncionario());

                        double impostoAtual = funcionario.impostoRenda();
                        impostoTotalGeral += impostoAtual;

                        if (Character.toUpperCase(sexo) == 'F') {
                            impostoTotalFeminino += impostoAtual;
                        } else if (Character.toUpperCase(sexo) == 'M') {
                            impostoTotalMasculino += impostoAtual;
                        }

                    } catch (NumberFormatException e) {
                        System.err.println("Erro de formato numérico na linha: " + linha + " - " + e.getMessage());
                    }
                } else {
                    System.err.println("Linha com formato inválido (número incorreto de campos): " + linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + arquivoFuncionarios + ": " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n--- Resumo de Impostos ---");
        System.out.println("Total de Imposto de Renda (Feminino): R$" + String.format("%.2f", impostoTotalFeminino));
        System.out.println("Total de Imposto de Renda (Masculino): R$" + String.format("%.2f", impostoTotalMasculino));
        System.out.println("Total de Imposto de Renda (Geral): R$" + String.format("%.2f", impostoTotalGeral));
    }
}