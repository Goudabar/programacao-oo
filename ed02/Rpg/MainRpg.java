package ed02.Rpg;

// Classe principal para o jogo RPG
public class MainRpg {
    public static void main(String[] args) {
        Guerreiro g = new Guerreiro("Thorgal");
        Mago m = new Mago("Merlino");
        Arqueiro a = new Arqueiro("Legolis");

        // Status inicial
        g.status();
        m.status();
        a.status();

        // guerreiro ataca o mago
        g.atacar(m);

        // Mago e arqueiro usam suas habilidades especiais
        m.usarHabilidadeEspecial();
        a.usarHabilidadeEspecial();

        // Status após ações
        g.status();
        m.status();
        a.status();
    }
}
