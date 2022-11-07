package service;

import livro.Livro;
public class CadastroLivro {
	public Livro inserirLivro(String titulo, int anoLancamento, String editora, String autor, String codigoBarras, int qtdEstoque) {
		Livro lvr = new Livro(titulo, anoLancamento, editora, autor, codigoBarras, qtdEstoque);
		System.out.println("-- LIVRO CADASTRADO COM SUCESSO!");
		System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
		System.out.println("\t T�tulo: "+titulo+ "  Autor: "+autor);
		System.out.println("\t Editora: "+editora+ "  Ano de Lan�amento: "+anoLancamento);
		System.out.println("\t C�digo de Barras: "+codigoBarras +" Quantidade em Estoque: "+qtdEstoque);
		System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n");
		return lvr;
	}
}
