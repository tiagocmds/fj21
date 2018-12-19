<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- cria o DAO -->
          <c:import url="cabecalho.jsp" />

          <table border=1>
          		<tr>
          			<th>NOME</th>
          			<th>EMAIL</th>
          			<th>ENDERE�O</th>
          			<th>NASCIMENTO</th>
          		</tr>
              <!-- percorre contatos montando as linhas da tabela -->
              <c:forEach var="contato" items="${contatos}">
                  <tr>
                      <td>${contato.nome}</td>
                      <td><c:if test="${not empty contato.email}">
                          <a href="mailto:${contato.email}">${contato.email}</a>
                      </c:if>

                      <c:if test="${empty contato.email}">
                          E-mail n�o informado
                      </c:if></td>
                      <td>${contato.endereco}</td>
                      <td><fmt:formatDate value="${contato.dataNascimento.time}"
          				pattern="dd/MM/yyyy" /></td>
          			<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
                  </tr>
              </c:forEach>
          </table>
	 <c:import url="rodape.jsp" />
</body>
</html>