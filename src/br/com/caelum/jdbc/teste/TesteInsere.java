package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.modelo.Contato;
import java.util.Calendar;
import br.com.caelum.jdbc.dao.ContatoDao;

public class TesteInsere {
    
    public static void main(String[] args){
    Contato contato = new Contato();
    
    contato.setNome("Tiago222");
    contato.setEmail("tiago.cmds@gmail.com");
    contato.setEndereco("Qnl 19 Conjunto C Casa 14");
    contato.setDataNascimento(Calendar.getInstance());
    
    ContatoDao dao = new ContatoDao();
    
    dao.adiciona(contato);
    
    System.out.println("Gravado");
    }
}
