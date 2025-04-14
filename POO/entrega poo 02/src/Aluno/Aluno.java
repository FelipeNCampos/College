package src.Aluno;

public class Aluno {
    private String nome;
    private int matricula;
    private int anoIngresso;

    public Aluno(String nome, int matricula, int anoIngresso) {
        this.nome = nome;
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
}
