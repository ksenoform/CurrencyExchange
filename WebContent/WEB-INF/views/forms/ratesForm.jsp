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
		<c:forEach items="${currencyRates}" var="rates">
			<form:form modelAttribute="currenc" class="form-horizontal"
				method="POST" commandName="marker">
				<fieldset>
					<div class="col-sm-3" style="padding-bottom: 16px">
						<div class="thumbnail">
							<table style="width: 100%">
								<tr>
									<section class="container">
									<form method="post">
										<div class="btn-group">
											<input type="submit" value="${rates.dibsCode}"
												name="${rates.dibsCode}" class="btn btn-primary">
										</div>
									</form>
									</section>
								</tr>
							</table>
						</div>
					</div>
				</fieldset>
			</form:form>
		</c:forEach>
	</div>
	</section>



</body>
</html>