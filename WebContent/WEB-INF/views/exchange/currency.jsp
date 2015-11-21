<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form modelAttribute="enteredAmount" class="form-horizontal">
		<fieldset>
			<div>
				<label> How much to change </label>
				<div>
					<form:input id="amount" path="amount" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div>
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Change money" />
			</div>
		</fieldset>
	</form:form>
</body>
</html>