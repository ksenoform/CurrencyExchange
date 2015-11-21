<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				<div class="col-sm-2" style="padding-bottom: 10px">
					<div class="thumbnail">
						<p>${currenc.dibsCode}</p>
						<p>${currenc.dibsName}</p>
						<p>
							<fmt:formatNumber value="${currenc.dibsRate}"
								minFractionDigits="4" />
						</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

	<div class="codeContainer">
		<form method="post">
			<div class="btn-group">
				<input type="submit" value="exchange" name="Exchange"
					class="btn btn-primary"> <input type="submit"
					value="manage currencies" name="Manage currencies"
					class="btn btn-primary">
			</div>
		</form>
	</div>
	
</body>
</html>
