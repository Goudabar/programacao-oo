package ed02.Rpg;

// Classe que representa o guerreiro
public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 150, 25);
    }

    @Override
    public void defender(int dano) {
        // Reduz o dano pela metade quando o guerreiro é atacado
        super.defender(dano / 2);
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Golpe Duplo: ataca com o dobro da força
        System.out.println(nome + " usou Golpe Duplo!");
        ataqueBase *= 2;
    }
}
