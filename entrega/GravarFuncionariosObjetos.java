
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GravarFuncionariosObjetos {

    public static void main(String[] args) {
        String arquivoTexto = "funcionarios.txt";
        String arquivoObjetos = "funcionarios.dat";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoTexto))) {
            String linha;
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
                    } catch (NumberFormatException e) {
                        System.err.println("Erro de formato numérico na linha: " + linha + " ao ler para serialização.");
                    }
                } else {
                    System.err.println("Linha com formato inválido (número incorreto de campos): " + linha + " ao ler para serialização.");
                }
            }
            System.out.println("Dados dos funcionários lidos do arquivo de texto com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de texto " + arquivoTexto + ": " + e.getMessage());
            e.printStackTrace();
            return;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivoObjetos))) {
            for (Funcionario f : funcionarios) {
                oos.writeObject(f);
            }
            System.out.println("Objetos de funcionários gravados com sucesso em " + arquivoObjetos);
        } catch (IOException e) {
            System.err.println("Erro ao gravar os objetos no arquivo " + arquivoObjetos + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}