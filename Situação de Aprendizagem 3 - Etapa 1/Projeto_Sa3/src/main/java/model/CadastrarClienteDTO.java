package model;

public class CadastrarClienteDTO
{
	String matricula;
	String nome;
	String endereco;
	String modalidade;

	public CadastrarClienteDTO()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public CadastrarClienteDTO(String matricula, String nome, String endereco, String modalidade)
	{
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.modalidade = modalidade;
	}

	public String getMatricula()
	{
		return matricula;
	}

	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getEndereco()
	{
		return endereco;
	}

	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}

	public String getModalidade()
	{
		return modalidade;
	}

	public void setModalidade(String modalidade)
	{
		this.modalidade = modalidade;
	}

}
