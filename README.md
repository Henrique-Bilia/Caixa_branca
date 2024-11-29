1 ERRO
na linha: Class.forName("com.mysql.Driver").newInstance();
Esse erro pode causar uma exceção ClassNotFoundException, impossibilitando a conexão com o banco de dados.

2 ERRO
Blocos cathc vazio
Nos métodos conectarBD e verificarUsuario, os blocos catch estão vazios:
Qualquer erro que ocorrer será ignorado, tornando difícila a identificação deles para melhorias futuras.

3 ERRO
Conexão com o banco de dados
No método verificarUsuario:
Esse erro pode causar o vazamento de recursos, causando a perda de conexões com o banco de dados.

4 ERRO
Concatenar strings na consulta SQL
No método verificarUsuario:
sql += "where login = '" + login + "'";
sql += " and senha = '" + senha + "'";
Pode háver usuários que podem inserir comandos SQL através dos valores de login e senha e acabar comprometendo a segurança do banco.

5 ERRO
Valor de retorno e inicialização inadequada
No método verificarUsuario:
public boolean result = false;
if (rs.next()) {
    result = true;
    nome = rs.getString("nome");
}

Pode confundir a lógica de negócio

6 ERRO

Ausência de validação dos parâmetros
No método verificarUsuario:

A falta de validação pode causar a passagem de valores nulos, o que pode causar uma falha nas consultas SQL


7 ERRO

Estrutura inadequada para separação de responsabilidades


Todo o código está contido na classe User, misturando lógica de conexão, manipulação de SQL e lógica de negócio.

O código se torna menos legível, mais difícil de manter e testar.



CÁLCULO DA COMPLEXIDADE CICLOMÁTICA:
M=15-13+2=4


GRAFO DE FLUXO:
https://lucid.app/lucidchart/be9da9df-4707-481d-8f9d-fbf1f2843558/edit?viewport_loc=-194%2C-405%2C3940%2C1937%2C0_0&invitationId=inv_0a214fb3-bf63-40b6-9dc7-c5421f4f528b
![image](https://github.com/user-attachments/assets/05edc921-d08e-49ee-a5da-c48202dcd1a5)


