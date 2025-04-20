import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe para armazenar e mostrar ranking dos jogadores.
 */
public class Placar
{
    private ArrayList<Jogador> ranking;

    /**
     * Inicializa o ranking.
     */
    public Placar()
    {
        ranking = new ArrayList<>();
    }

    /*
     * Adiciona um jogador ao ranking.
     */
    public void adicionarJogador(Jogador j)
    {
        ranking.add(j);
    }

    /*
     * Exibe o ranking com nome e pontuação dos jogadores.
     */
    public void mostrarRanking()
    {
        System.out.println("\nRanking:");
        Collections.sort(ranking, Comparator.comparingInt(Jogador::getPontuacao).reversed());
        for (Jogador j : ranking)
        {
            System.out.println(j.getNome() + " - Pontuação: " + j.getPontuacao());
        }
    }
}
