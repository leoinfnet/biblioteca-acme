<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="/static/css/style.css" rel="stylesheet">
</head>
<body>
<c:import url="../template/header.jsp" />
<h1>
    Clientes
</h1>

<c:if test="${removidoComSucesso}">
<h3> Cliente removido com sucesso: ${cliente.cpf } - ${cliente.nome} </h3>
</c:if>
<hr />
<br/>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>CPF</th>
        <th>NOME</th>
        <th>SOBRENOME</th>
        <th>ACOES</th>
    </tr>
    </thead>
    <tbody>
      <c:forEach items="${clientes}" var="cliente">
          <tr>
              <td>${cliente.id}</td>
              <td>${cliente.cpf}</td>
              <td>${cliente.nome}</td>
              <td>${cliente.sobrenome}</td>

              <td><a href="<c:url value="/clientes/deletar/${cliente.id}"></c:url>"> EXCLUIR </a>

              </td>
          </tr>

      </c:forEach>
    </tbody>
</table>
</body>
</html>