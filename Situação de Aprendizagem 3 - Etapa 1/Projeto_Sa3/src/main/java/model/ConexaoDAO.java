package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoDAO
{

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/sa3shoeshappy";
    private static String USER = "root"; //usuário do BD
    private static String PASS = "#Mav20222rh2";//senha do BD

    //Connection classe responsavel por manter conexão aberta ou encerrar a conexão no banco
    //espera um retorno do tipo connection
    public static Connection conectaBD()
    {
        //conexão externa
        //utizado para captar exceções
        try
        {
            //tentativa para executar a conexão externa com o BD
            Class.forName(DRIVER);//será realizada uma busca pela classe Driver mannager
            return DriverManager.getConnection(URL, USER, PASS);//se encontrar vai dar o retorno do tipo connection e bate com o que a classe espera
        }
        //classnotfoundexception procurar classe para iniciar a conexao
        catch (ClassNotFoundException | SQLException erro)//caso não encontre a classe ou conexão
        {
            //se der errado cai aqui
            throw new RuntimeException("Erro na conexão: " + erro);//Impressão do erro

        }
    }
    
    public void testeConexao()
    {
    	try
    	{
    		Connection con = conectaBD();
    		System.out.println(con);
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }

    //consultou, excluiu, criou, depois tenho que fechar a conexão
    public static void encerrarConexao(Connection conexao)
    {
        if (conexao != null)//se conexao for diferente de nulo
        {
            //conexao externa
            try
            {
                conexao.close();//encerra a conexão
            }
            catch (SQLException erro)
            {
                erro.printStackTrace();
            }
        }
    }

    //tenho que sobrecarregar por mais duas vezes para encerrar a conexão, prepare statement e result set	
    //segunda sobrecarga
    public static void encerrarConexao(Connection conexao, PreparedStatement stmt)
    {
        encerrarConexao(conexao);
        if (conexao != null)//se conexao for diferente de nulo
        {
            //conexao externa
            try
            {
                if (stmt != null)
                {
                    stmt.close();
                }
            }
            catch (SQLException erro)
            {
                erro.printStackTrace();
            }
        }
    }

    //segunda sobrecarga
    public static void encerrarConexao(Connection conexao, PreparedStatement stmt, ResultSet rs)
    {
        encerrarConexao(conexao, stmt);
        if (conexao != null)//se conexao for diferente de nulo
        {
            //conexao externa
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
            }
            catch (SQLException erro)
            {
                erro.printStackTrace();
            }
        }
    }

}
