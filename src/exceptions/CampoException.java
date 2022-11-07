package exceptions;

public class CampoException{
	
	public void mensagemErroCampoVazio() {
		System.out.println("\tERRO! CAMPOS OBRIGATÓRIOS NÃO INSERIDOS!");
	}
	
	public void mensagemErroCampoInvalido() {
		System.out.println("\tERRO! CAMPOS INVÁLIDOS!");
	}
	
	public void mensagemErroValoresIguais() {
		System.out.println("\tOBJETO JÁ EXISTENTE!");
	}

}
