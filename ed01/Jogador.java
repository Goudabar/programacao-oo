/**
 * Classe que representa um jogador.
 */
public class Jogador
{
    private String nome;
    private int tentativas;
    private int pontuacao;

    /**
     * Construtor que recebe o nome do jogador.
     * @param nome Nome do jogador
     */
    public Jogador(String nome)
    {
        this.nome = nome;
        this.tentativas = 0;
        this.pontuacao = 0;
    }

    /**
     * Retorna o nome do jogador.
     * @return nome do jogador
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * Retorna o número de tentativas.
     * @return tentativas feitas
     */
    public int getTentativas()
    {
        return tentativas;
    }

    /**
     * Retorna a pontuação atual.
     * @return pontuação do jogador
     */
    public int getPontuacao()
    {
        return pontuacao;
    }

    /**
     * Soma 1 ao numero de tentativas.
     */
    public void incrementarTentativas()
    {
        tentativas++;
    }

    /**
     * Adiciona pontos à pontuação atual.
     */
    public void atualizarPontuacao(int valor)
    {
        pontuacao += valor;
    }
}
