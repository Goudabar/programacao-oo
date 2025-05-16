package ed02.Rpg;

// Classe que representa o mago
public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 100, 30);
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Bola de Fogo - Aumenta o dano do próximo ataque em 10
        System.out.println(nome + " lançou Bola de Fogo!");
        ataqueBase += 10;
    }
}
