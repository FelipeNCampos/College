package entrega_poo.atividade;



public class ContaCorrente extends Conta{
    private double taxa = 0.5;

    ContaCorrente(int numero, Cliente dono){
        super(numero, dono);
    }

    public void transferir(double value, Conta conta){
        if (value > 0  && this.getSaldo() >= value){
            this.sacar(value);
            conta.depositar(value);
        }
    }


    @Override
    public void sacar(double valor) {
		saldo = saldo - valor - this.taxa;
	}

	@Override
	public void depositar(double valor) {
		saldo = saldo + valor - this.taxa;
	}

}
