<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="post" commandName="currenciesAdd" class="form-horizontal" action="AfterMenageForm">
        <fieldset>
            <div>
                <label> Currencies code </label>
                <div>
                    <form:input path="code" type="text"
                        class="form:input-large" />
                </div>
            </div>
             <div>
                <label> Currencies name </label>
                <div>
                    <form:input path="name" type="text"
                        class="form:input-large" />
                </div>
            </div>
             <div>
                <label> Currencies value </label>
                <div>
                    <form:input path="value" type="text"
                        class="form:input-large" />
                </div>
            </div>
            <div>
                <input type="submit" id="btnOK" class="btn btn-primary"
                    name="OK" value="Ok" />
            </div>
            <div>
                <input type="submit" class="btn btn-primary"
                    name="Main Page" value="Main Page" />
            </div>
        </fieldset>
    </form:form>	
    
</body>
</html>