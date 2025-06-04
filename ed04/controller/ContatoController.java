package ed04.controller;

import ed04.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador que gerencia os contatos da agenda.
 */
public class ContatoController {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionar(Contato contato) {
        if (!valido(contato)) {
            System.out.println("Contato inválido ou duplicado.");
            return;
        }
        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso.");
    }

    public void remover(String chave) {
        contatos.removeIf(c -> getChave(c).equals(chave));
    }

    public List<Contato> listar() {
        return contatos;
    }

    private boolean valido(Contato contato) {
        if (contato.getNome() == null || contato.getNome().length() < 3) return false;

        String chave = getChave(contato);
        if (chave.length() != 11 && chave.length() != 14) return false;

        return contatos.stream().noneMatch(c -> getChave(c).equals(chave));
    }

    private String getChave(Contato contato) {
        if (contato instanceof PessoaFisica pf) {
            return pf.getCpf();
        } else if (contato instanceof PessoaJuridica pj) {
            return pj.getCnpj();
        }
        return "";
    }

    /**
     * Atualiza um contato existente na lista.
     * @param chave CPF ou CNPJ do contato a ser atualizado
     * @param novoContato Contato com os novos dados
     * @return true se o contato foi atualizado com sucesso, false caso contrário
     */
    public boolean atualizar(String chave, Contato novoContato) {
        // Verifica se o novo contato é válido (exceto pela verificação de duplicidade)
        if (novoContato.getNome() == null || novoContato.getNome().length() < 3) {
            System.out.println("Dados de contato inválidos.");
            return false;
        }
        
        // Encontra o índice do contato na lista
        int index = -1;
        for (int i = 0; i < contatos.size(); i++) {
            if (getChave(contatos.get(i)).equals(chave)) {
                index = i;
                break;
            }
        }
        
        // Se não encontrou o contato
        if (index == -1) {
            System.out.println("Contato não encontrado.");
            return false;
        }
        
        // Verifica se a chave do novo contato é diferente da chave original
        String novaChave = getChave(novoContato);
        if (!novaChave.equals(chave) && !novaChave.isEmpty()) {
            // Verifica se a nova chave já existe em outro contato
            if (contatos.stream().anyMatch(c -> getChave(c).equals(novaChave))) {
                System.out.println("Já existe um contato com este CPF/CNPJ.");
                return false;
            }
        }
        
        // Atualiza o contato
        contatos.set(index, novoContato);
        System.out.println("Contato atualizado com sucesso.");
        return true;
    }
}