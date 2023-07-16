package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class CadastrarClienteDAO
{
	// CRUD INSERIR
	public void inserirCliente(CadastrarClienteDTO dto)
	{
		String create = "INSERT INTO clientes (nome, endereco, modalidade) values (?,?,?)";
		try
		{
			// abrir conexao
			Connection con = ConexaoDAO.conectaBD();
			// preparar conexao
			PreparedStatement pstmt = con.prepareStatement(create);
			// substituir os parametros
			pstmt.setString(1, dto.getNome());
			pstmt.setString(2, dto.getEndereco());
			pstmt.setString(3, dto.getModalidade());
			// executar query
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	// CRUD PESQUISAR
	public ArrayList<CadastrarClienteDTO> listarClientes()
	{
		ArrayList<CadastrarClienteDTO> clientes = new ArrayList<>();
		String read = "SELECT * FROM clientes ORDER BY matricula";
		try
		{
			// abrir conexao
			Connection con = ConexaoDAO.conectaBD();
			// preparar conexao
			PreparedStatement pstmt = con.prepareStatement(read);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				String matricula = rs.getString(1);
				String nome = rs.getString(2);
				String endereco = rs.getString(3);
				String modalidade = rs.getString(4);

				clientes.add(new CadastrarClienteDTO(matricula, nome, endereco, modalidade));
			}

		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}

		return clientes;
	}

	// CRUD SELECIONAR CLIENTE
	public void selecionarCliente(CadastrarClienteDTO dto)
	{
		String alterar = "SELECT * FROM clientes WHERE matricula = ?";
		try
		{
			// abrir conexao
			Connection con = ConexaoDAO.conectaBD();
			// preparar conexao
			PreparedStatement pstmt = con.prepareStatement(alterar);
			pstmt.setString(1, dto.getMatricula());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				dto.setMatricula(rs.getString(1));
				dto.setNome(rs.getString(2));
				dto.setEndereco(rs.getString(3));
				dto.setModalidade(rs.getString(4));
			}
			con.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	// EDITAR CLIENTE
	public void editarCliente(CadastrarClienteDTO dto)
	{
		String create = "UPDATE clientes set nome = ?, endereco = ?, modalidade = ? WHERE matricula = ?";
		try
		{
			// abrir conexao
			Connection con = ConexaoDAO.conectaBD();
			// preparar conexao
			PreparedStatement pstmt = con.prepareStatement(create);
			pstmt.setString(1, dto.getNome());
			pstmt.setString(2, dto.getEndereco());
			pstmt.setString(3, dto.getModalidade());
			pstmt.setString(4, dto.getMatricula());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	// DELETAR CLIENTE
		public void deletarCliente(CadastrarClienteDTO dto)
		{
			String delete = "DELETE FROM clientes WHERE matricula = ?";
			try
			{
				// abrir conexao
				Connection con = ConexaoDAO.conectaBD();
				// preparar conexao
				PreparedStatement pstmt = con.prepareStatement(delete);
				pstmt.setString(1, dto.getMatricula());
				pstmt.executeUpdate();
				con.close();
			} catch (Exception e)
			{
				System.out.println(e);
			}
		}
}
