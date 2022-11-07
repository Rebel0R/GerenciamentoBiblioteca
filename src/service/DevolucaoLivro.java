package service;

import livro.LivroEmprestado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DevolucaoLivro {
	//1 situação = data menor que a prevista pelo sistema -n gera multa
	//2 situação = data igual a prevista - n gera multa
	//3 situação = data maior que a prevista, ocasioando multa!
	//    multa com 1º dia de atraso = 2,00 nos demais é 1 real e a situação fica bloqueada 
	public void devolverLivro(String dataDev, LivroEmprestado lvrE) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		//2 situação = 2 datas são iguais
		double multa = 0;
		if(dataDev.equals(lvrE.getDataDevolucao())) {
			System.out.println("-- DEVOLUÇÃO REALIZADA COM SUCESSO!");
			lvrE.getLivro().setQtdEstoque(lvrE.getLivro().getQtdEstoque()+1);
			lvrE.getUser().setQtdLivros(lvrE.getUser().getQtdLivros()-1);
			System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
			System.out.println("\t Nome: "+lvrE.getUser().getNome()+ " - Doc Bib: "+lvrE.getUser().getDocBibl());
			if(lvrE.getUser().getSitUsuario() == true) {
				System.out.println("\t Situação: LIBERADO");
			}else {
				System.out.println("\t Situação: BLOQUEADO");
			}
			System.out.println("\t Título: "+lvrE.getLivro().getTitulo()+ " - Autor: "+lvrE.getLivro().getAutor());
			System.out.println("\t Editora: "+lvrE.getLivro().getEditora()+" - Cod de Barras: "+lvrE.getLivro().getCodigoBarras());
			System.out.println("\t Data de Devolução: "+dataDev);
			System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n\n");
			System.out.println("-- A Biblioteca Santo Humberto Ricardo agradesce sua devolução!");
		}
		try {
			Date dateDevReal = format.parse(dataDev);
			Date dateDevSist = format.parse(lvrE.getDataDevolucao());
			//situação 1
			if(dateDevReal.before(dateDevSist)) {
				System.out.println("-- DEVOLUÇÃO ANTECIPADA REALIZADA COM SUCESSO!");
				lvrE.getLivro().setQtdEstoque(lvrE.getLivro().getQtdEstoque()+1);
				lvrE.getUser().setQtdLivros(lvrE.getUser().getQtdLivros()-1);
				System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
				System.out.println("\t Nome: "+lvrE.getUser().getNome()+ " - Doc Bib: "+lvrE.getUser().getDocBibl());
				if(lvrE.getUser().getSitUsuario() == true) {
					System.out.println("\t Situação: LIBERADO");
				}else {
					System.out.println("\t Situação: BLOQUEADO");
				}
				System.out.println("\t Título: "+lvrE.getLivro().getTitulo()+ " - Autor: "+lvrE.getLivro().getAutor());
				System.out.println("\t Editora: "+lvrE.getLivro().getEditora()+" - Cod de Barras: "+lvrE.getLivro().getCodigoBarras());
				System.out.println("\t Data de Devolução: "+dataDev);
				System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n\n");
				System.out.println("-- A Biblioteca Santo Humberto Ricardo agradesce sua devolução!");
			}else {
				Calendar dataReal = Calendar.getInstance();
				dataReal.setTime(format.parse(dataDev));
				Calendar dataSist = Calendar.getInstance();
				dataSist.setTime(format.parse(lvrE.getDataDevolucao()));
				dataReal.add(Calendar.DATE, -dataSist.get(Calendar.DAY_OF_MONTH));
				int atraso = dataReal.get(Calendar.DAY_OF_MONTH);
				if(atraso == 1) {
					multa = atraso*2;
				}else if(atraso>1) {
					multa = 2 + atraso-1;
				}
				//situação 3
				System.out.println("-- DEVOLUÇÃO ATRASADA REALIAZADA COM SUCESSO!");
				lvrE.getLivro().setQtdEstoque(lvrE.getLivro().getQtdEstoque()+1);
				lvrE.getUser().setQtdLivros(lvrE.getUser().getQtdLivros()-1);
				lvrE.getUser().setSitUsuario(false);
				lvrE.getUser().setMulta(multa+lvrE.getUser().getMulta());
				System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
				System.out.println("\t Nome: "+lvrE.getUser().getNome()+ " - Doc Bib: "+lvrE.getUser().getDocBibl());
				if(lvrE.getUser().getSitUsuario() == true) {
					System.out.println("\t Situação: LIBERADO");
				}else {
					System.out.println("\t Situação: BLOQUEADO");
				}
				System.out.println("\t Título: "+lvrE.getLivro().getTitulo()+ " - Autor: "+lvrE.getLivro().getAutor());
				System.out.println("\t Editora: "+lvrE.getLivro().getEditora()+" - Cod de Barras: "+lvrE.getLivro().getCodigoBarras());
				System.out.println("\t Data de Devolução: "+dataDev + " - Data de Devolução do Sistema: "+lvrE.getDataDevolucao());
				System.out.println("\t Dias em atraso: "+atraso);
				System.out.println("\t Valor da Multa aplicada R$: "+lvrE.getUser().getMulta());
				System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n\n");
				System.out.println("-- A Biblioteca Santo Humberto Ricardo agradesce sua devolução!");
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}
}
