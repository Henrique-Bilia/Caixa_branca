package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável que gerencia a conexão do banco de dados e verifica usuários.
 * Contém métodos para conectar o banco de dados e autenticar um usuário com base em login e senha.
 */
public class User {

    /**
     * Estabelece uma conexão com o banco de dados.
     *
     * @return Objeto Connection que interage com o banco de dados ou null se ocorrer um erro.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // URL de conexão ao banco
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            // Estabelece a conexão
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Exceção capturada, mas não tratada (melhorar com logs)
        }
        return conn;
    }

    /**
     * Armazena o nome do usuário autenticado se encontrado no banco de dados.
     */
    public String nome = "";

    /**
     * Armazena o resultado da verificação de login indicando se o usuário foi encontrado.
     */
    public boolean result = false;

    /**
     * Verifica se o usuário com o login e senha dados existe no banco de dados.
     *
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @return true se o usuário foi encontrado false caso não.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD(); // Obtém a conexão com o banco
        // Monta a instrução SQL
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";
        try {
            // Cria a declaração SQL
            Statement st = conn.createStatement();
            // Executa a consulta
            ResultSet rs = st.executeQuery(sql);
            // Verifica se o resultado possui registros
            if (rs.next()) {
                // Usuário encontrado
                result = true;
                nome = rs.getString("nome"); // Armazena o nome do usuário
            }
        } catch (Exception e) {
            // Exceção capturada, mas não tratada (melhorar com logs)
        }
        return result;
    }
}
// Fim da classe User
