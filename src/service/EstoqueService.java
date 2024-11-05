package service;

import dao.RacaoDAO;
import dao.LoteDAO;
import dao.UsuarioDAO;
import model.Racao;
import model.Lote;
import model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class EstoqueService {
    private RacaoDAO racaoDAO = new RacaoDAO();
    private LoteDAO loteDAO = new LoteDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void adicionarRacao(String nome, String tipo) {
        Racao racao = new Racao();
        racao.setNome(nome);
        racao.setTipo(tipo);
        try {
            racaoDAO.inserirRacao(racao);
            System.out.println("Ração adicionada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarLote(int racaoId, int quantidade, java.sql.Date dataEntrada) {
        Lote lote = new Lote();
        lote.setRacaoId(racaoId);
        lote.setQuantidade(quantidade);
        lote.setDataEntrada(dataEntrada);
        try {
            loteDAO.inserirLote(lote);
            System.out.println("Lote adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarUsuario(String nome, String tipo) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setTipo(tipo);
        try {
            usuarioDAO.inserirUsuario(usuario);
            System.out.println("Usuário adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> listarUsuarios() {
        try {
            return usuarioDAO.listarUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void atualizarUsuario(int id, String novoNome, String novoTipo) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(novoNome);
        usuario.setTipo(novoTipo);
    }

    public void deletarUsuario(int id) {
        try {
            usuarioDAO.deletarUsuario(id);
            System.out.println("Usuário deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void listarRacoes() {
        try {
            List<Racao> racoes = racaoDAO.listarRacoes();
            if (racoes.isEmpty()) {
                System.out.println("Nenhuma ração encontrada.");
            } else {
                for (Racao racao : racoes) {
                    System.out.println("ID: " + racao.getId() + " | Nome: " + racao.getNome() + " | Tipo: " + racao.getTipo());
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar rações: " + e.getMessage());
        }
    }

}
