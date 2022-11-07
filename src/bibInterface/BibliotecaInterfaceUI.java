package bibInterface;

import java.util.ArrayList;
import java.util.Scanner;
import service.CadastroUsuario;
import service.CadastroLivro;
import service.EmprestimoLivro;
import service.DevolucaoLivro;
import service.PagamentoMulta;
import livro.LivroEmprestado;
import usuario.Usuario;
import livro.Livro;
import exceptions.CampoException;

public class BibliotecaInterfaceUI {
	
	private Scanner input = new Scanner(System.in);
	private CadastroUsuario cadUser = new CadastroUsuario();
	private EmprestimoLivro emprLvr = new EmprestimoLivro();
	private CadastroLivro cadLvr = new CadastroLivro();
	private DevolucaoLivro devLvr = new DevolucaoLivro();
	private PagamentoMulta pgMult = new PagamentoMulta();
	private ArrayList<Usuario> listUsers = new ArrayList<Usuario>();
	private ArrayList <Livro>listLvr = new ArrayList<Livro>();
	private ArrayList <LivroEmprestado>listEmpr = new ArrayList<LivroEmprestado>();
	
	public void preencherDados() {
		Usuario user1 = new Usuario("Ricardo Rebelo", "02/05/2000", "546876243", "14 991518326",
				"a2065770", "1234", "Ponta Grossa", "PR", "Rua João Chagas", 121, "Nova Rússia");
		Usuario user2 = new Usuario("João Carlos Neto", "14/08/1990", "456876982", "27 992518645", "a12151340", "2526", "Pontal", "SP", "Rua Ponta Negra", 45, "Centro");
		Livro livroHP1 = new Livro("Harry Potter e a Pedra Filosofal", 1990, "Rocco", "J. K. Rowlling", "001", 5);
		Livro livroPJO1 = new Livro("Percy Jackson e o Ladrão de Raios", 2008, "Intrinseca", "Rick Riordan", "002", 6);
		LivroEmprestado livroE1 = new LivroEmprestado("10/10/2022", livroHP1, user1);
		LivroEmprestado livroE2 = new LivroEmprestado("14/10/2022", livroPJO1, user1);
		this.listUsers.add(user1);
		this.listUsers.add(user2);
		this.listLvr.add(livroHP1);
		this.listLvr.add(livroPJO1);
		this.listEmpr.add(livroE1);
		this.listEmpr.add(livroE2);
	}
	//ok
	public void cadastrarUsuario(){
			System.out.println("- Informe o Nome: ");
			String nome = input.nextLine();
			System.out.println("- Informe o Data de Nascimento: ");
			String dataNasc = input.nextLine();
			System.out.println("- Informe o Documento: ");
			String documento = input.nextLine();
			System.out.println("- Informe o Telefone: ");
			String telefone = input.nextLine();
			System.out.println("- Informe o Documento da Biblioteca: ");
			String docBibl = input.nextLine();
			System.out.println("- Informe a Senha: ");
			String senha = input.nextLine();
			System.out.println("- Informe a Cidade: ");
			String cidade = input.nextLine();
			System.out.println("- Informe a UF: ");
			String uf = input.nextLine();
			System.out.println("- Informe o Logradouro: ");
			String logradouro = input.nextLine();
			System.out.println("- Informe o Número: ");
			int num = input.nextInt();
			input.nextLine();
			System.out.println("- Informe o Bairo: ");
			String bairro = input.nextLine();
			
			for(Usuario user : listUsers) {
				if(nome.equals(user.getNome()) ||documento.equals(user.getDocumento()) || telefone.equals(user.getTelefone()) || docBibl.equals(user.getDocBibl()) || num == user.getEnderecoPessoal().getNum()) {
					new CampoException().mensagemErroValoresIguais();
					return;
				}
			}
			
			if(nome == "" || dataNasc == "" || documento == "" || telefone == "" || docBibl == "" || senha == "" || cidade == "" || uf == "" || logradouro == ""|| bairro == "") {
				new CampoException().mensagemErroCampoVazio();
				return;
			}
			
			if(num<0) {
				new CampoException().mensagemErroCampoInvalido();
				return;
			}
			this.listUsers.add((cadUser.inserirUsuario(nome, dataNasc, documento, telefone, docBibl, senha, cidade, uf, logradouro, num, bairro)));

	}
	//ok
	public void cadastrarLivro() {
		System.out.println("- Informe o Título: ");
		String titulo = input.nextLine();
		System.out.println("- Informe o Ano de Lançamento: ");
		int anoLancamento = input.nextInt();
		input.nextLine();
		System.out.println("- Informe a Editora: ");
		String editora = input.nextLine();
		System.out.println("- Informe o Autor: ");
		String autor = input.nextLine();
		System.out.println("- Informe o Código de Barras: ");
		String codigoBarras = input.nextLine();
		System.out.println("- Informe a Quantidade no Estoque: ");
		int qtdEstoque = input.nextInt();
		
		for(Livro livro : listLvr) {
			if(titulo.equals(livro.getTitulo()) || codigoBarras.equals(livro.getCodigoBarras())) {
			    new CampoException().mensagemErroValoresIguais();
				return;
			}
		}
		
		if(titulo == "" || editora == "" || autor == "" || codigoBarras == "") {
			new CampoException().mensagemErroCampoVazio();
			return;
		}
		
		if(anoLancamento < 0 ||qtdEstoque < 0) {
			new CampoException().mensagemErroCampoInvalido();
			return;
		}
		
		this.listLvr.add((cadLvr.inserirLivro(titulo, anoLancamento, editora, autor, codigoBarras, qtdEstoque)));
		//lvrs[contLvr] = this.cadLvr.inserirLivro(titulo, anoLancamento, editora, autor, codigoBarras, qtdEstoque);
		//contLvr++;
	}
	//ok
	public void emprestarLivro() {
		//precisa do ID do usuario + senha + situação do usuario
		System.out.println("- Digite seu Documento da Biblioteca: ");
		String docBibUI = input.nextLine();
		System.out.println("- Digite sua Senha: ");
		String senhaBibUI = input.nextLine();
		
		for(Usuario usuario : listUsers) {
			if(docBibUI.equals(usuario.getDocBibl()) && senhaBibUI.equals(usuario.getSenha())) {
				if(usuario.getSitUsuario()==true && usuario.getQtdLivros()<=5) {
					System.out.println("- Digite o Código do Livro: ");
					String codBibUI = input.nextLine();
					for(Livro livro : listLvr) {
						if(codBibUI.equals(livro.getCodigoBarras()) && livro.getQtdEstoque()>0) {
							System.out.println("- Infome a data de Empréstimo: dd/mm/yyyy");
							String dataE = input.nextLine();
							this.listEmpr.add((emprLvr.emprestarLivro(dataE, livro, usuario)));
						}
					}
					
				}else {
					System.out.println("\tOPERAÇÃO INVÁLIDA!");
				}
			}
		}
	}
	//ok
	public void devolverLivro() {
		System.out.println("- Informe o Código do Livro: ");
		String codLvrUI = input.nextLine();
		System.out.println("- Digite seu Documento da Biblioteca: ");
		String docBibUI = input.nextLine();
		
		for(int i = 0; i < this.listEmpr.size(); i++) {
		    LivroEmprestado lvrE = this.listEmpr.get(i);
		    if(docBibUI.equals(lvrE.getUser().getDocBibl())) {
				 if(codLvrUI.equals(lvrE.getLivro().getCodigoBarras())) {
			 	 System.out.println("- Infome a data de Devolução: dd/mm/yyyy");
				 String dataDev = input.nextLine();
				 this.devLvr.devolverLivro(dataDev, lvrE);
				 this.listEmpr.remove(lvrE);
				 break;
                 }
			}
		 }
	}
	//ok
	public void pagarMulta() {
		//ID da bib + senha + situação (se estiver liberado não tem multa)
		System.out.println("- Digite seu Documento da Biblioteca: ");
		String docBibUI = input.nextLine();
		for(Usuario user : this.listUsers) {
			if(docBibUI.equals(user.getDocBibl())) {
				if(user.getSitUsuario()==false) {
					int opcao;
					System.out.println("SISTEMA DE PAGAMENTO DE MULTAS!");
					System.out.println("\t 1- Efetuar o pagamento total das multas");
					System.out.println("\t 2- Efetuar o pagamento parcial das multas");
					System.out.println("\t 0- Encerrar");
					System.out.println("Digite uma opção válida:");
					opcao = input.nextInt();
					
					switch(opcao) {
					     case 1:
					    	 System.out.println("-> Pagamento total selecionado!");
					    	 System.out.println("\tValor total R$: "+user.getMulta());
					    	 System.out.println("Informe o valor a ser quitado: ");
					    	 double valorPgT = input.nextDouble();
					    	 input.nextLine();
					    	 System.out.println("- Informe a data de Pagamento: dd/mm/yyyy");
							 String dataPT = input.nextLine();
					    	 this.pgMult.quitarMultaTotal(user, valorPgT, dataPT);
					    	 
					    	 break;
					     
					     case 2:
					    	 System.out.println("-> Pagamento parcial selecionado!");
					    	 System.out.println("\tValor total R$: "+user.getMulta());
					    	 System.out.println("Informe o valor a ser quitado: ");
					    	 double valorPgP = input.nextDouble();
					    	 input.nextLine();
					    	 System.out.println("- Informe a data de Pagamento: dd/mm/yyyy");
							 String dataPP = input.nextLine();
					    	 this.pgMult.quitarMultaParcial(user, valorPgP, dataPP);
					    	 break;
					    
					     case 0:
					    	 System.out.println("-> Sistema Encerrado!");
					    	 break;
					    
					     default:
					    	 System.out.println("Opção Inválida!");
					}
				}else {
					System.out.println("Situação de usuário LIBERADA!");
					System.out.println("Valor de multas: R$ "+user.getMulta());
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//new BibliotecaInterfaceUI().cadastrarUsuario();
		BibliotecaInterfaceUI bibUI = new BibliotecaInterfaceUI();
		bibUI.preencherDados();
		
		int op = -1;
		while(op != 0) {
			System.out.println("Sistema de Gerenciamento Biblioteca Santo Humberto Ricardo!");
			System.out.println("\t 1- CADASTRAR USUÁRIO");
			System.out.println("\t 2- CADASTRAR LIVRO");
			System.out.println("\t 3- EMPRESTAR LIVRO");
			System.out.println("\t 4- DEVOLVER LIVRO");
			System.out.println("\t 5- PAGAR MULTA");
			System.out.println("\t 6- VERIFICAR LISTA DE USUÁRIOS CADASTRADOS");
			System.out.println("\t 7- VERIFICAR LISTA DE LIVROS CADASTRADOS");
			System.out.println("\t 8- VERIFICAR LISTA DE LIVROS EMPRESTADOS");
			System.out.println("\t 0- DIGITE 0 PARA ENCERRAR O SISTEMA");
			System.out.println("Digite uma opção válida:");
			
			op = bibUI.input.nextInt();
			bibUI.input.nextLine();
			
			switch(op) {
				case 1:
					System.out.println("->CADASTRAR USUÁRIO SELECIONADO...");
			    	bibUI.cadastrarUsuario();
			    	break;
			    
			    case 2:
			    	System.out.println("->CADASTRAR LIVRO SELECIONADO...");
			    	bibUI.cadastrarLivro();
			    	break;
			    	
			    case 3:
			    	System.out.println("->EMPRESTAR LIVRO SELECIONADO...");
			    	bibUI.emprestarLivro();
			        break;
			    
			    case 4:
			    	System.out.println("->DEVOLVER LIVRO SELECIONADO...");
			    	bibUI.devolverLivro();
			        break;
			        
			    case 5:
			    	System.out.println("->PAGAR MULTA SELECIONADO...");
			    	bibUI.pagarMulta();
			        break;
			        
			    case 6:
			    	for(Usuario user : bibUI.listUsers) {
			    		user.imprimirDadosUsuario();
			    	}
			    	break;
			    	
			    case 7:
			    	for(Livro lvr : bibUI.listLvr) {
			    		lvr.imprimirDadosLivro();
			    	}
			    	break;
			    
			    case 8:
			    	for(LivroEmprestado lvrE : bibUI.listEmpr) {
			    		lvrE.imprimirLivroEmprestado();
			    	}
			    	break;
			   
			    case 0:
			    	System.out.println("Encerrando sistema...");
			        break;
			        
			    default:
			    	System.out.println("Opção Inválida");
			}
		}
		
		System.out.println("-- Programa Encerrado!");
		
	}

}
