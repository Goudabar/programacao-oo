package ed02.Rpg;

// Classe que representa o mago
public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 100, 30);
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " lançou Bola de Fogo!");
        // Dano em área: atinge 2 inimigos
        int dano = 20;
        System.out.println("Atingiu todos os inimigos com " + dano + " de dano!");
    }
}
