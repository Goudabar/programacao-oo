package ed02.SistemaBancario;


/**
 * Conta salário, que não aplica juros diários
 */
public class ContaSalario extends Conta {

    /**
     * Criar conta salário com nome do cliente e saldo inicial
     */
    public ContaSalario(String cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Salário ===");
        System.out.println("Cliente: " + cliente);
        System.out.println("Saldo: R$" + saldo);
    }

    @Override
    public void aplicarJurosDiarios() {
        // Conta salário não recebe juros.
    }
}
