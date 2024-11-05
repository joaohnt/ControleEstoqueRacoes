package dao;

import database.DatabaseConnection;
import model.Lote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoteDAO {

    // Método para inserir um novo lote
    public void inserirLote(Lote lote) throws SQLException {
        String sql = "INSERT INTO lote (quantidade, data_entrada, racao_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, lote.getQuantidade());
            stmt.setDate(2, lote.getDataEntrada());
            stmt.setInt(3, lote.getRacaoId());
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os lotes
    public List<Lote> listarLotes() throws SQLException {
        String sql = "SELECT * FROM lote";
        List<Lote> lotes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Lote lote = new Lote();
                lote.setId(rs.getInt("id"));
                lote.setQuantidade(rs.getInt("quantidade"));
                lote.setDataEntrada(rs.getDate("data_entrada"));
                lote.setRacaoId(rs.getInt("racao_id"));
                lotes.add(lote);
            }
        }
        return lotes;
    }
}
