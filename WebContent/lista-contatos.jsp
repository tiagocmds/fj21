<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.*, br.com.caelum.jdbc.dao.*, br.com.caelum.jdbc.modelo.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border= 1>
					<tr>
						<td><b>NOME</b></td>
						<td><b>EMAIL</b></td>
						<td><b>ENDERE�O</b></td>
						<td><b>NASCIMENTO</b></td>
					</tr>	
                      <%
                      ContatoDao dao = new ContatoDao();
                      List<Contato> contatos = dao.getLista();

                      for (Contato contato : contatos ) {
                      %>
                          <tr>
                              <td><%=contato.getNome() %></td> 
                              <td><%=contato.getEmail() %></td>
                              <td><%=contato.getEndereco() %></td>
                              <td><%=contato.getDataNascimento().getTime() %></td>
                          </tr>
                      <%
                      }
                      %>
                      <br>
                  </table>
</body>
</html>