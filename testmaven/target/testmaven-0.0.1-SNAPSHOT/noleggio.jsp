<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="general.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Noleggio</title>
</head>
<body>

	<form action="" method="get">

		<label>Cerca Libro : </label> <input type="text" name="titolo"
			placeholder="Cerca per titolo"> <input type="submit"
			value="Cerca">

	</form>
	<form action="sfoglia" method="get">
		<input type="submit" value="Sfoglia Catalogo">

	</form>

	
		
	

</body>
</html>