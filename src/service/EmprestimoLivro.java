package service;


import livro.LivroEmprestado;

import livro.Livro;
import usuario.Usuario;

//n�o implementada
public class EmprestimoLivro {
	
	public LivroEmprestado emprestarLivro(String data, Livro livro, Usuario user) {
		LivroEmprestado empr = new LivroEmprestado(data, livro, user);
		livro.setQtdEstoque(livro.getQtdEstoque()-1);
		user.setQtdLivros(user.getQtdLivros()+1);
		System.out.println("-- EMPR�STIMO REALIZADO COM SUCESSO!");
		System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
		System.out.println("\t Nome: "+user.getNome()+ "  Doc Bib: "+user.getDocBibl());
		System.out.println("\t T�tulo: "+livro.getTitulo()+ "  Autor: "+livro.getAutor());
		System.out.println("\t Editora: "+livro.getEditora()+" Cod de Barras: "+livro.getCodigoBarras());
		System.out.println("\t Data do Empr�stimo: "+empr.getDataEmprestimo());
		System.out.println("\t Data de Devolu��o: "+empr.getDataDevolucao());
		System.out.println("-> LIVROS ENTREGUES EM ATRASO ACARRETAR�O MULTA <-");
		System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n\n");
		return empr;
	}
}
