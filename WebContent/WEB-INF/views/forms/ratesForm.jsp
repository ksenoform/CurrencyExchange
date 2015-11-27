<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

	<h3>Choose Currency to management:</h3>

	<section class="container">
	<div class="row">
		<form:form modelAttribute="currenc" class="form-horizontal"  action="ofFormToMenagment">
			<c:forEach items="${currencyRates}" var="rates">

				<form:radiobutton path="hermit" value="${rates.dibsCode}"
					label="${rates.dibsCode}" />

			</c:forEach>
			
			<form method="post">
				<div class="btn-group">
					<input type="submit" value="Currencies" name="Currencies"
						class="btn btn-primary">
				</div>
			</form>
		</form:form>
	</div>
	</section>


</body>
</html>