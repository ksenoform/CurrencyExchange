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

	<section class="container">
	<div class="row">
		<c:forEach items="${currencyRates}" var="rates">
			<form:form modelAttribute="currenc" class="form-horizontal"
				method="POST" commandName="marker">
				<fieldset>
					<div class="col-sm-10" style="padding-bottom: 16px">
						<div class="thumbnail">
							<table style="width: 100%">
								<tr>
									<td>${rates.dibsCode}</td>


									<c:forEach items="${rates.dibsRateList}" var="rate">
										<td><fmt:formatNumber value="${rate.dibsRate}"
												minFractionDigits="4" /></td>

										<section class="container">
										<form method="post">
											<div class="btn-group">
												<input type="submit" value="${rate.dibsDate}"
													name="${rate.dibsDate}" class="btn btn-primary">
											</div>
										</form>
										</section>
									</c:forEach>

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