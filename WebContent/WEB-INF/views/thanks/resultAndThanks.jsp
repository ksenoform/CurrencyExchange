<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><fmt:formatNumber value="${afterChange}" minFractionDigits="4" /></h3>
	
	<form method="post">
            <div class="btn-group">
                <input type="submit" value="Main Page"
                    name="Manage currencies" class="btn btn-primary">
            </div>
        </form>
</body>
</html>