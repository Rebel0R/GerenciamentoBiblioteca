package livro;

import usuario.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class LivroEmprestado {
	private String dataEmprestimo;
	private String dataDevolucao;
	private Livro livro;
	private Usuario user;
	
	public LivroEmprestado(String dataEmprestimo, Livro livro, Usuario user) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
	    try {
            calendar.setTime(format.parse(dataEmprestimo));
        } catch (ParseException e) {
            e.printStackTrace();
        }
		calendar.add(Calendar.DAY_OF_MONTH, 7); //+7 dias para a devolução
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = format.format(calendar.getTime()); 
		this.livro = livro;
		this.user = user;
	}
	
	public void imprimirLivroEmprestado() {
		livro.imprimirDadosLivro();
		System.out.println("Usuario: "+user.getNome() + "Doc Biblioteca: "+user.getDocBibl());
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	
	public String getCodigoBarrasLivroE() {
		return this.livro.getCodigoBarras();
	}
	
	public String getDocBibE() {
		return this.user.getDocBibl();
	}
}
