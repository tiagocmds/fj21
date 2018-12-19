package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Connection;
import java.sql.Date;
import br.com.caelum.jdbc.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {

    private Connection connection;
    public ContatoDao(Connection connection) {
    	this.connection = connection;
    }
    public ContatoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contato contato) {
        String sql = "insert into contatos "
                + "(nome,email,endereco,dataNascimento)"
                + "values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(
                    contato.getDataNascimento().getTimeInMillis()));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void alterar(String n){
        
    }
    public void deletar(Contato contato){
        try{
        PreparedStatement stmt = this.connection.prepareStatement("delete from contatos where id ='" + contato.getId() + "'");
        stmt.execute();
        stmt.close();
        System.out.println("Contato Deletado");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Contato obter(String n) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where nome ='" + n + "'");
            ResultSet rs = stmt.executeQuery();
            Contato user = new Contato();
            
            
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
                user = contato;
            }
            rs.close();
            stmt.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto Contato
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                // adicionando o objeto à lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}