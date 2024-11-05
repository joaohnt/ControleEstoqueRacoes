package dao;

import database.DatabaseConnection;
import model.Racao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RacaoDAO {

    // Método para inserir uma nova ração
    public void inserirRacao(Racao racao) throws SQLException {
        String sql = "INSERT INTO racao (nome, tipo) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, racao.getNome());
            stmt.setString(2, racao.getTipo());
            stmt.executeUpdate();
        }
    }

    // Método para listar todas as rações
    public List<Racao> listarRacoes() throws SQLException {
        List<Racao> racoes = new ArrayList<>();
        String sql = "SELECT * FROM racao";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Racao racao = new Racao();
                racao.setId(rs.getInt("id"));
                racao.setNome(rs.getString("nome"));
                racao.setTipo(rs.getString("tipo"));
                racoes.add(racao);
            }
        }
        return racoes;
    }

    // Método para atualizar uma ração existente
    public void atualizarRacao(Racao racao) throws SQLException {
        String sql = "UPDATE racao SET nome = ?, tipo = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, racao.getNome());
            stmt.setString(2, racao.getTipo());
            stmt.setInt(3, racao.getId());
            stmt.executeUpdate();
        }
    }

    // Método para deletar uma ração
    public void deletarRacao(int id) throws SQLException {
        String sql = "DELETE FROM racao WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
