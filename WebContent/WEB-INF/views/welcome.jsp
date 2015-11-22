<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Hello</title>
</head>
<body>

	<section class="container">
		<div class="row">
			<c:forEach items="${currencyRates}" var="currenc">
				<form:form modelAttribute="currenc" class="form-horizontal">
					<fieldset>
						<div class="col-sm-4" style="padding-bottom: 12px">
							<div class="thumbnail">
							<table style="width:100%">
								<tr>
									<td>${currenc.dibsCode}</td>
									<td>${currenc.dibsName}</td>

									<td><fmt:formatNumber value="${currenc.dibsRate}"
											minFractionDigits="4" /></td>

									<td>
										<form method="post">
											<div class="btn-group">
												<input type="submit" value="${currenc.dibsCode}"
													name="exchange" class="btn btn-primary">
											</div>
										</form>
									</td>
								</tr>
								</table>
							</div>
						</div>
					</fieldset>
				</form:form>
			</c:forEach>
		</div>
	</section>
    <section class="container">
		<form method="post">
			<div class="btn-group">
				<input type="submit" value="manage currencies"
					name="exchange" class="btn btn-primary">
			</div>
		</form>
	</section>

</body>
</html>
