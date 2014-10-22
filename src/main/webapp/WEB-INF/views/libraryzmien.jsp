<%@include file="./includes/common.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="icon" href="<c:url value="/resources/pioro.jpg" />" type="image/x-icon">
</head>
<body>

	<form:form modelAttribute="book">
             <div style="background-color:greenyellow; color:black; margin:20px; padding:20px;">
		Tytul: <form:input path="tytul" />
		<br>
		Opis: <form:input path="opis" />
		<br>
                Autor - Imie: <form:input path="autor_imie" />
		<br>
                Autor - Nazwisko: <form:input path="autor_nazwisko" />
		<br>
                Autor - Pochodzenie: <form:input path="autor_pochodzenie" />
		<br>
		Ilosc: <form:input path="ilosc" />
		<br>
		Kategoria: <form:input path="kategoria" />
		<br>
		<input type="submit" value="Zmie&#324;" />
		<form:hidden path="id"/>
             </div>
	</form:form>
</body>
</html>