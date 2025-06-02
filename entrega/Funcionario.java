import java.io.Serializable;

public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    String nome;
    char sexo;
    double salario;
    int dependentes;

    Funcionario(String nome, char sexo, double salario, int dependentes) {
        this.nome = nome;
        this.sexo = sexo;
        this.salario = salario;
        this.dependentes = dependentes;
    }

    public double impostoRenda() {
        double reducaoDep = 189.59 * dependentes;
        double impostoBruto;

        if (salario <= 1903.98) {
            impostoBruto = 0;
        } else if (salario <= 2826.65) {
            impostoBruto = (salario * 7.5 / 100 - 142.80);
        } else if (salario <= 3751.05) {
            impostoBruto = (salario * 15 / 100 - 354.80);
        } else if (salario <= 4664.68) {
            impostoBruto = (salario * 22.5 / 100 - 636.13);
        } else {
            impostoBruto = (salario * 27.5 / 100 - 869.36);
        }

        double impostoFinal = impostoBruto - reducaoDep;
        return Math.max(0, impostoFinal);
    }

    public String mostraFuncionario() {
        return "Nome: " + nome +
               ", Sexo: " + sexo +
               ", Salário: R$" + String.format("%.2f", salario) +
               ", Dependentes: " + dependentes +
               ", Imposto de Renda: R$" + String.format("%.2f", impostoRenda());
    }

    @Override
    public String toString() {
        return mostraFuncionario();
    }

    public char getSexo() {
        return sexo;
    }
}