package service;

import usuario.Usuario;

public class CadastroUsuario {
	
	public Usuario inserirUsuario(String nome, String dataNasc, String documento, String telefone,
			String docBibl, String senha, String cidade, String uf, String logradouro, int num, String bairro){
		
		Usuario user = new Usuario(nome, dataNasc, documento, telefone, docBibl, senha, cidade, uf, logradouro, num, bairro);
		System.out.println("-- USUÁRIO CADASTRADO COM SUCESSO!");
		System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
		System.out.println("\t Nome: "+nome+ "  Data Nasc: "+dataNasc);
		System.out.println("\t Telefone: "+telefone+ "  Documento: "+documento);
		System.out.println("\t Documento da Biblioteca: "+docBibl);
		if(user.getSitUsuario() == true) {
			System.out.println("\t Situação: LIBERADO");
		}else {
			System.out.println("\t Situação: BLOQUEADO");
		}
		System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n");
		return user;
	}
}
