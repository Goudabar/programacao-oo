package ed03.login;

public class ProgramaLogin {
    public static void main(String[] args) {
        Administrador admin = new Administrador("admin", "admin123");
        Visitante guest = new Visitante("guest", "qualquer");
        Cliente joao = new Cliente("joao", "segredo123");

        admin.exibirLogin();
        System.out.println("Autenticação com 'admin123': " + admin.autenticar("admin123"));
        System.out.println("Autenticação com 'errada': " + admin.autenticar("errada"));
        admin.alterarSenha("novaSenha123");
        admin.bloquearUsuario();
        admin.registrarLog("Exclusão de conta");
        System.out.println();

        guest.exibirLogin();
        System.out.println();

        joao.exibirLogin();
        System.out.println("Autenticação com 'segredo123': " + joao.autenticar("segredo123"));
        System.out.println("Autenticação com '12345': " + joao.autenticar("12345"));
    }
}