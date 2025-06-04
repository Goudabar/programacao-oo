package ed04;

import ed04.controller.ContatoController;
import ed04.model.*;
import ed04.view.ContatoView;

import java.util.Scanner;

/**
 * Classe principal que executa a aplicação de agenda.
 */
public class Main {
    public static void main(String[] args) {
        ContatoController controller = new ContatoController();
        ContatoView view = new ContatoView();
        Scanner scanner = view.getScanner();
        boolean executando = true;

        while (executando) {
            view.exibirMenu();
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> {
                    System.out.print("Tipo (F para Física, J para Jurídica): ");
                    String tipo = scanner.nextLine().toUpperCase();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    if (tipo.equals("F")) {
                        System.out.print("CPF (11 dígitos): ");
                        String cpf = scanner.nextLine();
                        controller.adicionar(new PessoaFisica(nome, telefone, email, cpf));
                    } else if (tipo.equals("J")) {
                        System.out.print("CNPJ (14 dígitos): ");
                        String cnpj = scanner.nextLine();
                        controller.adicionar(new PessoaJuridica(nome, telefone, email, cnpj));
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                }
                case "2" -> view.mostrarContatos(controller.listar());
                case "3" -> {
                    System.out.print("Digite o CPF ou CNPJ do contato a remover: ");
                    String chave = scanner.nextLine();
                    controller.remover(chave);
                }
                case "4" -> {
                    System.out.print("Digite o CPF ou CNPJ do contato a atualizar: ");
                    String chave = scanner.nextLine();
                    
                    // Verifica se o contato existe
                    boolean encontrado = false;
                    for (Contato c : controller.listar()) {
                        String chaveContato = "";
                        if (c instanceof PessoaFisica pf) {
                            chaveContato = pf.getCpf();
                        } else if (c instanceof PessoaJuridica pj) {
                            chaveContato = pj.getCnpj();
                        }
                        
                        if (chaveContato.equals(chave)) {
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Contato não encontrado.");
                        continue;
                    }
                    
                    System.out.print("Tipo (F para Física, J para Jurídica): ");
                    String tipo = scanner.nextLine().toUpperCase();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Contato novoContato;
                    if (tipo.equals("F")) {
                        System.out.print("CPF (11 dígitos): ");
                        String cpf = scanner.nextLine();
                        novoContato = new PessoaFisica(nome, telefone, email, cpf);
                    } else if (tipo.equals("J")) {
                        System.out.print("CNPJ (14 dígitos): ");
                        String cnpj = scanner.nextLine();
                        novoContato = new PessoaJuridica(nome, telefone, email, cnpj);
                    } else {
                        System.out.println("Tipo inválido.");
                        continue;
                    }
                    
                    boolean sucesso = controller.atualizar(chave, novoContato);
                    if (sucesso) {
                        System.out.println("Contato atualizado com sucesso.");
                    }
                }
                case "0" -> executando = false;
                default -> System.out.println("Opção inválida.");
            }
        }

        System.out.println("Encerrando...");
    }
}