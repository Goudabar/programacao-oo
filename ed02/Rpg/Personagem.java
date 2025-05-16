package ed02.Rpg;

// Classe para personagens do jogo
abstract class Personagem {
    protected String nome;
    protected int hp;
    protected int ataqueBase;

    public Personagem(String nome, int hp, int ataqueBase) {
        this.nome = nome;
        this.hp = hp;
        this.ataqueBase = ataqueBase;
    }

    // Método para atacar outro personagem
    public void atacar(Personagem inimigo) {
        inimigo.defender(ataqueBase);
    }

    // Método para sofrer dano
    public void defender(int dano) {
        this.hp -= dano;
    }

    // Cada classe terá sua própria habilidade especial
    public abstract void usarHabilidadeEspecial();

    // Mostra o status atual do personagem
    public void status() {
        System.out.println(nome + " | HP: " + hp + " | Ataque: " + ataqueBase);
    }
}