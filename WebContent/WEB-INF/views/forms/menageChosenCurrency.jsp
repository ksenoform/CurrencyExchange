<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section class="container">
	<h3>${currentCode.dibsCode}</h3>

	<form:form modelAttribute="currenc" class="form-horizontal"
		action="ofFormOneCurrency">
		<c:forEach items="${currentCode.dibsRateList}" var="rates">
			<div>
				<table style="width: 100%">
					<tr>
						<td><fmt:formatNumber value="${currentCode.dibsRate}"
								minFractionDigits="4" /></td>
						<form:radiobutton path="hermit" value="${rates.dibsDate}"
							label="${rates.dibsDate}" />
					</tr>
				</table>

			</div>
		</c:forEach>
		<form method="post">
			<div class="btn-group">
				<input type="submit" value="Add Rate" name="Add Rate"
					class="btn btn-primary">
			</div>
			<div class="btn-group">
				<input type="submit" value="Delete Rate" name="Delete Rate"
					class="btn btn-primary">
			</div>
		</form>
	</form:form> </section>
</body>
</html>