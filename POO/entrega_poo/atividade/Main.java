package entrega_poo.atividade;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Conta> contas = new ArrayList<>();

        while (true) {
            String numeroContaStr = JOptionPane.showInputDialog("Digite o número da conta (0 para sair):");
            int numeroConta = Integer.parseInt(numeroContaStr);
            if (numeroConta == 0) break;

            String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
            Cliente cliente = new Cliente(nomeCliente, telefone);

            String saldoStr = JOptionPane.showInputDialog("Digite o saldo inicial:");
            double saldo = Double.parseDouble(saldoStr);

            String tipoContaStr = JOptionPane.showInputDialog("Digite o tipo da conta:\n1 - Corrente\n2 - Salário\n3 - Poupança");
            int tipoConta = Integer.parseInt(tipoContaStr);

            Conta conta = null;

            switch (tipoConta) {
                case 1:
                    conta = new ContaCorrente(numeroConta, cliente);
                    conta.depositar(saldo);
                    break;
                case 2:
                    conta = new ContaSalario(numeroConta, cliente);
                    conta.depositar(saldo);
                    break;
                case 3:
                    conta = new ContaPoupanca(numeroConta, cliente);
                    conta.depositar(saldo);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo inválido. Conta não cadastrada.");
                    continue;
            }

            contas.add(conta);
            JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");
        }

        // Mostrar todas as contas
        StringBuilder sb = new StringBuilder("Contas cadastradas:\n\n");
        for (Conta c : contas) {
            sb.append(c.toString()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
