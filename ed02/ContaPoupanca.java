package ed02;

/**
 * Conta poupança - aplica 0.08% de juros ao dia
 */
public class ContaPoupanca extends Conta {

    /**
     * Cria a conta poupança com nome do cliente e saldo inicial
     */
    public ContaPoupanca(String cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        System.out.println("Cliente: " + cliente);
        System.out.println("Saldo: R$" + saldo);
    }

    @Override
    public void aplicarJurosDiarios() {
        saldo += saldo * 0.0008;
    }
}
