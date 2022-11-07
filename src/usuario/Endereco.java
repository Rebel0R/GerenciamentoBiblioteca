package usuario;

public class Endereco {
	private String cidade;
	private String uf;
	private String logradouro;
	private int num;
	private String bairro;
	
	public Endereco(String cidade, String uf, String logradouro, int num, String bairro) {
		this.cidade = cidade;
		this.uf = uf;
		this.logradouro = logradouro;
		this.num = num;
		this.bairro = bairro;
	}
	
	public void ImprimirEndereco() {
		System.out.println("-- Cidade: "+this.cidade);
		System.out.println("-- UF: "+this.uf);
		System.out.println("-- Logradouro: "+this.logradouro);
		System.out.println("-- Número: "+this.num);
		System.out.println("-- Bairro: "+this.bairro);
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
}
