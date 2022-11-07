package livro;

public class Livro {
	private String titulo;
	private int anoLancamento;
	private String editora;
	private String autor;
	private String codigoBarras;
	private int qtdEstoque;
	
	public Livro(String titulo, int anoLancamento, String editora, String autor, String codigoBarras, int qtdEstoque) {
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.editora = editora;
		this.autor = autor;
		this.codigoBarras = codigoBarras;
		this.qtdEstoque = qtdEstoque;
	}
	
	public void imprimirDadosLivro() {
		System.out.println("--- DADOS ---");
		System.out.println("-- Nome: " +this.titulo + "- Autor: " +this.autor);
		System.out.println("-- Ano de Lançamento: " +this.anoLancamento + "- Editora: " +this.editora);
		System.out.println("-- Código de Barras: "+this.codigoBarras + "- Quantidade em Estoque: "+this.qtdEstoque);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
	
	
}
