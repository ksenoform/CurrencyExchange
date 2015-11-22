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
<title>Manage form</title>
</head>
<body>

	<section>
	<h3>This form using for managed currency</h3>
	</section>

	<section class="container">
	<div class="row">
		<c:forEach items="${currencyRates}" var="currenc">
			<form:form modelAttribute="currenc" class="form-horizontal">
				<fieldset>
					<div class="col-sm-4" style="padding-bottom: 12px">
						<div class="thumbnail">
							<table style="width: 50%">
								<tr>
									<td>${currenc.dibsCode}</td>
									<td>${currenc.dibsName}</td>
								</tr>
							</table>
						</div>
					</div>
				</fieldset>
			</form:form>
		</c:forEach>
	</div>
	</section>

	<form method="post">
		<div class="btn-group">
			<input type="submit" value="Add currencies" name="Add currencies"
				class="btn btn-primary">
		</div>
		<div class="btn-group">
			<input type="submit" value="Delete currencies"
				name="Delete currencies" class="btn btn-primary">
		</div>
		<div class="btn-group">
			<input type="submit" value="Rates" name="Rates"
				class="btn btn-primary">
		</div>
	</form>

</body>
</html>