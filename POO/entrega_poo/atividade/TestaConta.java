package entrega_poo.atividade;


public class TestaConta {

    public static void main(String[] args){
        Cliente eu = new Cliente("Felipe", "62994566196");
        Conta teste1 = new ContaCorrente(1,eu);
        Conta teste2 = new ContaPoupanca(2,eu);
    
    
        System.out.println("\nDepositos :  "); 
        teste1.depositar(500);
        teste2.depositar(500);
        
        System.out.println(teste1); 
        System.out.println(teste2); 
        
        System.out.println("Saque :  "); 
        
        teste1.sacar(100);
        teste2.sacar(100);
        
        System.out.println(teste1); 
        System.out.println(teste2); 
        
        
        System.out.println("\natualizarSaldo output :  ");
        
        ContaPoupanca teste3 = (ContaPoupanca) teste2;
        teste3.atualizaSaldo(5);
        
        System.out.println(teste3); 

        System.out.println("\ntransferencia output :  ");
        
        teste3.transferir(400, teste1);
        
        
        
        System.out.println(teste1);
        System.out.println(teste3);
        

        System.out.println("\nContaSalario output :  ");

        ContaSalario teste4 = new ContaSalario(3, eu);
        ContaSalario teste5 = new ContaSalario(4, eu);


        teste4.depositar(500);
        teste5.depositar(500);
        System.out.println(teste4);
        System.out.println(teste5);
        
        teste4.sacar(100);
        teste5.sacar(100);
        System.out.println(teste4);
        System.out.println(teste5);

        teste4.transferir(300, teste5);
        System.out.println(teste4);
        System.out.println(teste5);
        
        
    }

}
