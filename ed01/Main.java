import java.util.Scanner;

/**
 * Classe principal do jogo
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Placar placar = new Placar();

        while (true)
        {
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            Jogador jogador = new Jogador(nome);
            Jogo jogo = new Jogo(jogador);

            System.out.println("Tente adivinhar o número entre 1 e 100!");

            boolean acertou = false;
            while (!acertou)
            {
                System.out.print("Digite sua tentativa: ");
                int tentativa = scanner.nextInt();

                String resultado = jogo.jogar(tentativa);

                if (resultado.equals("maior"))
                {
                    System.out.println("O número é maior!");
                } else if (resultado.equals("menor")) {
                    System.out.println("O número é menor!");
                } else {
                    acertou = true;
                    System.out.println("Parabéns! Você acertou!");
                    System.out.println("Tentativas: " + jogador.getTentativas());
                    System.out.println("Pontuação: " + jogador.getPontuacao());
                }
            }

            placar.adicionarJogador(jogador); /*  Adiciona o jogador  */
            
            placar.mostrarRanking(); /*  Mostra o ranking completo.  */
            
            System.out.print("Deseja adicionar outro jogador? (s/n): ");
            scanner.nextLine();
            String continuar = scanner.nextLine();
            
            if (!continuar.equalsIgnoreCase("s"))
            {
                break;
            }
            /*  Permite adicionar outro jogador ou encerrar o console  */
        }
        
        scanner.close();
    }
}
