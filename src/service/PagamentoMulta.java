package service;

import usuario.Usuario;
public class PagamentoMulta {

	public void quitarMultaTotal(Usuario user, double valorPg, String data) {
		if(valorPg<user.getMulta()) {
			new PagamentoMulta().quitarMultaParcial(user, valorPg, data);
		}else {
			double troco = valorPg - user.getMulta();
			double multaPg = user.getMulta();
			user.setMulta(0.0);
			user.setSitUsuario(true);
			System.out.println("-- MULTA PAGA COM SUCESSO!");
			System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
			System.out.println("\t Data: "+data);
			System.out.println("\t Nome: "+user.getNome() +"  Doc Biblioteca: "+user.getDocBibl());
			if(user.getSitUsuario() == true) {
				System.out.println("\t Situação: LIBERADO");
			}else {
				System.out.println("\t Situação: BLOQUEADO");
			}
			System.out.println("\t Valor da Multa Toal R$: "+ multaPg + "Troco R$: "+troco);
			System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
			System.out.println("-- A Biblioteca Santo Humberto Ricardo agradesce!\n");
		}
	}
	
	public void quitarMultaParcial(Usuario user, double valorPg, String data) {
		if(valorPg <= user.getMulta()) {
			user.setMulta(user.getMulta()-valorPg);
			if(user.getMulta()!=0) {
				user.setSitUsuario(false);
			}else {
				user.setSitUsuario(true);
			}
			System.out.println("-- MULTA PARCIAL PAGA COM SUCESSO!");
			System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
			System.out.println("\t Data: "+data);
			System.out.println("\t Nome: "+user.getNome() +"  Doc Biblioteca: "+user.getDocBibl());
			if(user.getSitUsuario() == true) {
				System.out.println("\t Situação: LIBERADO");
			}else {
				System.out.println("\t Situação: BLOQUEADO");
			}
			System.out.println("\t Valor Pago R$: "+ valorPg + "Valor Multa Restante R$: "+user.getMulta());
			System.out.println("\t-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
			System.out.println("-- O usuário terá sua situação LIBERADA mediante o pagamento total da multa!");
		}
	}
}
