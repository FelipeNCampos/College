
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LerFuncionariosObjetos {

    public static void main(String[] args) {
        String arquivoObjetos = "funcionarios.dat";

        double impostoTotalFeminino = 0;
        double impostoTotalMasculino = 0;
        double impostoTotalGeral = 0;

        System.out.println("--- Relação de Funcionários (Lidos do Arquivo de Objetos) ---");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoObjetos))) {
            while (true) {
                try {
                    Funcionario funcionario = (Funcionario) ois.readObject();
                    
                    System.out.println(funcionario.mostraFuncionario());

                    double impostoAtual = funcionario.impostoRenda();
                    impostoTotalGeral += impostoAtual;

                    if (Character.toUpperCase(funcionario.getSexo()) == 'F') {
                        impostoTotalFeminino += impostoAtual;
                    } else if (Character.toUpperCase(funcionario.getSexo()) == 'M') {
                        impostoTotalMasculino += impostoAtual;
                    }

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro de I/O ao ler o arquivo " + arquivoObjetos + ": " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Classe Funcionario não encontrada ao ler o objeto: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n--- Resumo de Impostos (Lidos do Arquivo de Objetos) ---");
        System.out.println("Total de Imposto de Renda (Feminino): R$" + String.format("%.2f", impostoTotalFeminino));
        System.out.println("Total de Imposto de Renda (Masculino): R$" + String.format("%.2f", impostoTotalMasculino));
        System.out.println("Total de Imposto de Renda (Geral): R$" + String.format("%.2f", impostoTotalGeral));
    }
}