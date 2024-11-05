import service.EstoqueService;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    private static EstoqueService estoqueService = new EstoqueService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Ração");
            System.out.println("2 - Adicionar Lote");
            System.out.println("3 - Adicionar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Atualizar Usuário");
            System.out.println("6 - Deletar Usuário");
            System.out.println("7 - Listar Rações");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o Enter

            switch (opcao) {
                case 1:
                    adicionarRacao();
                    break;
                case 2:
                    adicionarLote();
                    break;
                case 3:
                    adicionarUsuario();
                    break;
                case 4:
                    listarUsuarios();
                    break;
                case 5:
                    atualizarUsuario();
                    break;
                case 6:
                    deletarUsuario();
                    break;
                case 7:
                    listarRacoes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarRacao() {
        System.out.print("Nome da Ração: ");
        String nome = scanner.nextLine();
        System.out.print("Tipo da Ração: ");
        String tipo = scanner.nextLine();
        estoqueService.adicionarRacao(nome, tipo);
    }

    private static void adicionarLote() {
        System.out.print("ID da Ração: ");
        int racaoId = scanner.nextInt();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Data de Entrada (yyyy-mm-dd): ");
        String dataStr = scanner.next();
        Date dataEntrada = Date.valueOf(dataStr);
        estoqueService.adicionarLote(racaoId, quantidade, dataEntrada);
    }

    private static void adicionarUsuario() {
        System.out.print("Nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Tipo do Usuário: ");
        String tipo = scanner.nextLine();
        estoqueService.adicionarUsuario(nome, tipo);
    }

    private static void listarUsuarios() {
        estoqueService.listarUsuarios();
    }

    private static void atualizarUsuario() {
        System.out.print("ID do Usuário a Atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir o Enter
        System.out.print("Novo Nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo Tipo: ");
        String novoTipo = scanner.nextLine();
        estoqueService.atualizarUsuario(id, novoNome, novoTipo);
    }

    private static void deletarUsuario() {
        System.out.print("ID do Usuário a Deletar: ");
        int id = scanner.nextInt();
        estoqueService.deletarUsuario(id);
    }

    private static void listarRacoes() {
        System.out.println("Listando Rações:");
        estoqueService.listarRacoes();
    }


}
