package ed02.SistemaBancario;


/**
 * Conta corrente, que aplica 0.1% de juros ao dia
 */
public class ContaCorrente extends Conta {

    /**
     * Cria a conta corrente com nome do cliente e saldo inicial
     */
    public ContaCorrente(String cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        System.out.println("Cliente: " + cliente);
        System.out.println("Saldo: R$" + saldo);
    }

    @Override
    public void aplicarJurosDiarios() {
        saldo += saldo * 0.001;
    }
}
