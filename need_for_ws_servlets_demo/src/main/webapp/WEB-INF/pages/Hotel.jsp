<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome *** </title>
</head>
<body>
<ol>
<c:forEach var="hotel" items="${hotellist}">
  <li>
  ${hotel}
  </li>
</c:forEach>
</ol>
</body>
</html>