package ed04.view;

import ed04.model.Contato;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pela interface textual com o usuário.
 */
public class ContatoView {
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("=== AGENDA DE CONTATOS ===");
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Listar contatos");
        System.out.println("3 - Remover contato");
        System.out.println("4 - Atualizar contato");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void mostrarContatos(List<Contato> contatos) {
        System.out.printf("%-20s %-15s %-25s\n", "Nome", "Telefone", "Email");
        for (Contato contato : contatos) {
            System.out.printf("%-20s %-15s %-25s\n",
                    contato.getNome(), contato.getTelefone(), contato.getEmail());
        }
    }

    public Scanner getScanner() {
        return scanner;
    }
}