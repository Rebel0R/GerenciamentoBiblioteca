package usuario;

public class Usuario {
	
	private String nome;
	private String dataNasc;
	private String documento;
	private Endereco enderecoPessoal;
	private String telefone;
	private String docBibl;
	private String senha;
	private double multa;
	private int qtdLivros;
	private boolean sitUsuario;
	
	public Usuario(String nome, String dataNasc, String documento, String telefone,
			String docBibl, String senha, String cidade, String uf, String logradouro, int num, String bairro) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.documento = documento;
		this.telefone = telefone;
		this.docBibl = docBibl;
		this.senha = senha;
		this.multa = 0.0;
		this.qtdLivros = 0;
		this.enderecoPessoal = new Endereco(cidade, uf, logradouro, num, bairro);
		this.sitUsuario = true;
	} 
	
	public void imprimirDadosUsuario() {
		System.out.println("--- DADOS ---");
		System.out.println("-- Nome: " +this.nome);
		System.out.println("-- Data de nascimento: " +this.dataNasc);
		System.out.println("-- Telefone: " +this.telefone);
		System.out.println("-- Documento: "+this.documento);
		System.out.println("-- Documento da Biblioteca: " +this.docBibl);
		this.enderecoPessoal.ImprimirEndereco();
		if(this.sitUsuario == true) {
			System.out.println("-- Situação: LIBERADO");
		}else {
			System.out.println("-- Situação: BLOQUEADO");
		}
	}
	
	public void alterarDadosUsuario(String nome, String dataNasc, String documento, Endereco enderecoPessoal, String telefone,
			String docBibl, String senha, String cidade, String uf, String logradouro, int num, String bairro) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.documento = documento;
		this.telefone = telefone;
		this.docBibl = docBibl;
		this.senha = senha;
		this.enderecoPessoal = new Endereco(cidade, uf, logradouro, num, bairro);
		System.out.println("-- DADOS ALTERADOS COM SUCESSO!\n");
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Endereco getEnderecoPessoal() {
		return enderecoPessoal;
	}

	public void setEnderecoPessoal(Endereco enderecoPessoal) {
		this.enderecoPessoal = enderecoPessoal;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDocBibl() {
		return docBibl;
	}

	public void setDocBibl(String docBibl) {
		this.docBibl = docBibl;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	public int getQtdLivros() {
		return qtdLivros;
	}

	public void setQtdLivros(int qtdLivros) {
		this.qtdLivros = qtdLivros;
	}

	public boolean getSitUsuario() {
		return sitUsuario;
	}

	public void setSitUsuario(boolean sitUsuario) {
		this.sitUsuario = sitUsuario;
	}




		
}
