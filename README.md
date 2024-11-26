# Caixa_branca
código análisado:

package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class User {
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();                         -Erro na classe do driver que geralmente é: com.mysql.cj.jdbc.Driver
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";              -Formato da conexão URL está incompleto pode estar faltando:useSSL=false
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {                                                              -Bloco está vázio
        }
        return conn;
    }
    public String nome = "";                                                                 -Variável está pública que desobedece o encapsulamento. Devia ter private com getters e setters.
    public boolean result = false;
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();                                                      -Esse método pode retornar null,causando NullPointerException ao usar conn.createStatement().
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";                                                 -Está vulnerável a SQL Injection por conta da concentração de strings.
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {                                                              -Bloco vazio
        }
        return result;
    }
}
// fim da class










CÁLCULO DA COMPLEXIDADE CICLOMÁTICA:
M=15-13+2=4

