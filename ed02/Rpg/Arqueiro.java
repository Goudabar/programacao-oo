package ed02.Rpg;

import java.util.Random;

// Classe que representa o arqueiro
public class Arqueiro extends Personagem {
    private Random random = new Random();

    public Arqueiro(String nome) {
        super(nome, 120, 20); // Vida e força inicial
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usou Chuva de Flechas!");
        // Ataca três vezes seguidas com chance de crítico
        for (int i = 0; i < 3; i++) {
            int dano = ataqueBase;
            if (random.nextDouble() < 0.3) {
                dano *= 2; // Crítico!
                System.out.println("Crítico!");
            }
            System.out.println("Flecha " + (i+1) + " causou " + dano + " de dano.");
        }
    }
}
