package dao;

import model.Usuario;
import database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public UsuarioDAO() {

    }

    // Método para inserir um novo usuário
    public void inserirUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, tipo) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTipo());
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTipo(rs.getString("tipo"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void deletarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
