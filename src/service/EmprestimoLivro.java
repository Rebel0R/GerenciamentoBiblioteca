package service;


import livro.LivroEmprestado;

import livro.Livro;
import usuario.Usuario;

//não implementada
public class EmprestimoLivro {
	
	public LivroEmprestado emprestarLivro(String data, Livro livro, Usuario user) {
		LivroEmprestado empr = new LivroEmprestado(data, livro, user);
		livro.setQtdEstoque(livro.getQtdEstoque()-1);
		user.setQtdLivros(user.getQtdLivros()+1);
		System.out.println("-- EMPRÉSTIMO REALIZADO COM SUCESSO!");
		System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
		System.out.println("\t Nome: "+user.getNome()+ "  Doc Bib: "+user.getDocBibl());
		System.out.println("\t Título: "+livro.getTitulo()+ "  Autor: "+livro.getAutor());
		System.out.println("\t Editora: "+livro.getEditora()+" Cod de Barras: "+livro.getCodigoBarras());
		System.out.println("\t Data do Empréstimo: "+empr.getDataEmprestimo());
		System.out.println("\t Data de Devolução: "+empr.getDataDevolucao());
		System.out.println("-> LIVROS ENTREGUES EM ATRASO ACARRETARÃO MULTA <-");
		System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n\n");
		return empr;
	}
}
