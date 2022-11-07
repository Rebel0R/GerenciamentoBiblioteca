package service;

import livro.LivroEmprestado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DevolucaoLivro {
	//1 situa��o = data menor que a prevista pelo sistema -n gera multa
	//2 situa��o = data igual a prevista - n gera multa
	//3 situa��o = data maior que a prevista, ocasioando multa!
	//    multa com 1� dia de atraso = 2,00 nos demais � 1 real e a situa��o fica bloqueada 
	public void devolverLivro(String dataDev, LivroEmprestado lvrE) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		//2 situa��o = 2 datas s�o iguais
		double multa = 0;
		if(dataDev.equals(lvrE.getDataDevolucao())) {
			System.out.println("-- DEVOLU��O REALIZADA COM SUCESSO!");
			lvrE.getLivro().setQtdEstoque(lvrE.getLivro().getQtdEstoque()+1);
			lvrE.getUser().setQtdLivros(lvrE.getUser().getQtdLivros()-1);
			System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
			System.out.println("\t Nome: "+lvrE.getUser().getNome()+ " - Doc Bib: "+lvrE.getUser().getDocBibl());
			if(lvrE.getUser().getSitUsuario() == true) {
				System.out.println("\t Situa��o: LIBERADO");
			}else {
				System.out.println("\t Situa��o: BLOQUEADO");
			}
			System.out.println("\t T�tulo: "+lvrE.getLivro().getTitulo()+ " - Autor: "+lvrE.getLivro().getAutor());
			System.out.println("\t Editora: "+lvrE.getLivro().getEditora()+" - Cod de Barras: "+lvrE.getLivro().getCodigoBarras());
			System.out.println("\t Data de Devolu��o: "+dataDev);
			System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n\n");
			System.out.println("-- A Biblioteca Santo Humberto Ricardo agradesce sua devolu��o!");
		}
		try {
			Date dateDevReal = format.parse(dataDev);
			Date dateDevSist = format.parse(lvrE.getDataDevolucao());
			//situa��o 1
			if(dateDevReal.before(dateDevSist)) {
				System.out.println("-- DEVOLU��O ANTECIPADA REALIZADA COM SUCESSO!");
				lvrE.getLivro().setQtdEstoque(lvrE.getLivro().getQtdEstoque()+1);
				lvrE.getUser().setQtdLivros(lvrE.getUser().getQtdLivros()-1);
				System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
				System.out.println("\t Nome: "+lvrE.getUser().getNome()+ " - Doc Bib: "+lvrE.getUser().getDocBibl());
				if(lvrE.getUser().getSitUsuario() == true) {
					System.out.println("\t Situa��o: LIBERADO");
				}else {
					System.out.println("\t Situa��o: BLOQUEADO");
				}
				System.out.println("\t T�tulo: "+lvrE.getLivro().getTitulo()+ " - Autor: "+lvrE.getLivro().getAutor());
				System.out.println("\t Editora: "+lvrE.getLivro().getEditora()+" - Cod de Barras: "+lvrE.getLivro().getCodigoBarras());
				System.out.println("\t Data de Devolu��o: "+dataDev);
				System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n\n");
				System.out.println("-- A Biblioteca Santo Humberto Ricardo agradesce sua devolu��o!");
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
				//situa��o 3
				System.out.println("-- DEVOLU��O ATRASADA REALIAZADA COM SUCESSO!");
				lvrE.getLivro().setQtdEstoque(lvrE.getLivro().getQtdEstoque()+1);
				lvrE.getUser().setQtdLivros(lvrE.getUser().getQtdLivros()-1);
				lvrE.getUser().setSitUsuario(false);
				lvrE.getUser().setMulta(multa+lvrE.getUser().getMulta());
				System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
				System.out.println("\t Nome: "+lvrE.getUser().getNome()+ " - Doc Bib: "+lvrE.getUser().getDocBibl());
				if(lvrE.getUser().getSitUsuario() == true) {
					System.out.println("\t Situa��o: LIBERADO");
				}else {
					System.out.println("\t Situa��o: BLOQUEADO");
				}
				System.out.println("\t T�tulo: "+lvrE.getLivro().getTitulo()+ " - Autor: "+lvrE.getLivro().getAutor());
				System.out.println("\t Editora: "+lvrE.getLivro().getEditora()+" - Cod de Barras: "+lvrE.getLivro().getCodigoBarras());
				System.out.println("\t Data de Devolu��o: "+dataDev + " - Data de Devolu��o do Sistema: "+lvrE.getDataDevolucao());
				System.out.println("\t Dias em atraso: "+atraso);
				System.out.println("\t Valor da Multa aplicada R$: "+lvrE.getUser().getMulta());
				System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n\n");
				System.out.println("-- A Biblioteca Santo Humberto Ricardo agradesce sua devolu��o!");
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}
}
