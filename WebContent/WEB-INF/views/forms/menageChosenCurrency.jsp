<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${currentCode.dibsCode}</h3>

	<section class="container">
	<div class="row">
		<form:form modelAttribute="currenc" class="form-horizontal"
			action="ofFormOneCurrency">
			<c:forEach items="${currentCode.dibsRateList}" var="rates">
				<table style="width: 50%" border="1">
					<tr>
						<td><form:radiobutton path="hermit" value="${rates.dibsDate}"
								label="${rates.dibsDate}" /></td>
								
						<td><fmt:formatNumber value="${rates.dibsRate}"
								minFractionDigits="4" /></td>
					</tr>
				</table>

			</c:forEach>

			<form method="post">
				<div class="btn-group">
					<input type="submit" value="Delete Rate" name="Delete Rate"
						class="btn btn-primary">
				</div>
				<div class="btn-group">
                    <input type="submit" value="Set as Active" name="Set as Active"
                        class="btn btn-primary">
                </div>
				<div>
                    <form:input path="hermit" type="text"
                        class="form:input-large" />
                </div>
				<div class="btn-group">
					<input type="submit" value="Add Rate" name="Add Rate"
						class="btn btn-primary">
				</div>
				<div class="btn-group">
					<input type="submit" value="Main Page" name="Main Page"
						class="btn btn-primary">
				</div>
			</form>
		</form:form>
	</div>
	</section>

</body>
</html>