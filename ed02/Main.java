package ed02;

/**
 * Classe principal para testar o funcionamento do sistema
 */
public class Main {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente("Alice", 1000);
        ContaPoupanca cp = new ContaPoupanca("Bob", 1500);
        ContaSalario cs = new ContaSalario("Carlos", 1200);

        // Testar depósito, saque e transferência
        cc.depositar(200);
        cp.sacar(100);
        cs.transferir(cc, 300);

        // aplicar juros diários
        cc.aplicarJurosDiarios();
        cp.aplicarJurosDiarios();
        cs.aplicarJurosDiarios();

        // Mostrando extrato de cada conta
        cc.imprimirExtrato();
        cp.imprimirExtrato();
        cs.imprimirExtrato();
    }
}
