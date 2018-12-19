package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class RemoveContatoLogic implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		long id = Long.parseLong(req.getParameter("id"));
		System.out.println("Teste");
		
		Contato contato = new Contato();
		contato.setId(id);
		
		ContatoDao dao = new ContatoDao();
		dao.deletar(contato);
		
		System.out.println("Excluindo contato...");
		
		return "mvc?logica=ListaContatosLogic";
	}

}
