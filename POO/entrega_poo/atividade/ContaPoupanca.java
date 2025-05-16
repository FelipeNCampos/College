package entrega_poo.atividade;

public class ContaPoupanca extends Conta{

    ContaPoupanca(int conta, Cliente dono){
        super(conta, dono);
    }

    public void transferir(double value, Conta conta){
        if (value > 0 && value <= this.getSaldo()){
            this.sacar(value);
            conta.depositar(value);
        }
    }
    
    public void atualizaSaldo(double percentual){
        double temp = 100+percentual;
        double novo = this.getSaldo() * temp/100;
        this.setSaldo(novo);
    }

}
