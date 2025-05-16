package ed02.SistemaBancario;

/**
 * Classe principal que representa uma conta genérica
 * Aqui ficam os métodos e atributos básicos que todas as contas usam
 */
public abstract class Conta {
    protected String cliente;
    protected double saldo;

    /**
     * Construtor que já define o nome do cliente e o saldo inicial
     */
    public Conta(String cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    /**
     * Adiciona dinheiro na conta
     */
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    /**
     * Retira dinheiro da conta, se tiver saldo suficiente
     */
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        }
    }

    /**
     * Transfere um valor da conta atual para outra conta
     */
    public void transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            destino.depositar(valor);
        }
    }

    /**
     * Retorna o valor atual do saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Cada tipo de conta vai mostrar o extrato de um jeito
     */
    public abstract void imprimirExtrato();

    /**
     * Cada tipo de conta aplica os juros de forma diferente
     */
    public abstract void aplicarJurosDiarios();
}

