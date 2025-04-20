import java.util.Random;

public class Jogo
{
    private Jogador jogador;
    private int numeroSecreto;

    /**
     * Construtor para receber um jogador e sorteia o número secreto.
     */
    public Jogo(Jogador jogador)
    {
        this.jogador = jogador;
        Random rand = new Random();
        numeroSecreto = rand.nextInt(100) + 1;
    }

    /**
     * Compara a tentativa com número secreto.
     * @return dica
     */
    public String jogar(int tentativa)
    {
        jogador.incrementarTentativas();

        if (tentativa > numeroSecreto)
        {
            return "menor";
        } else if (tentativa < numeroSecreto) {
            return "maior";
        } else {
            int pontos = 100 - jogador.getTentativas() * 10;
            jogador.atualizarPontuacao(Math.max(pontos, 0));
            return "acertou";
        }
    }
}
