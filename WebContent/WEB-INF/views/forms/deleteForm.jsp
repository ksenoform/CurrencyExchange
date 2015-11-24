<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <form:form method="post" commandName="currenciesName" class="form-horizontal" action="AfterMenageForm">
        <fieldset>
            <div>
                <label> Code currencies to delete </label>
                <div>
                    <form:input path="hermit" type="text"
                        class="form:input-large" />
                </div>
            </div>
            <div>
                <input type="submit" id="btnOK" class="btn btn-primary"
                    name="deleteOK" value="Ok" />
            </div>
            <div>
                <input type="submit" class="btn btn-primary"
                    name="Main Page" value="Main Page" />
            </div>
        </fieldset>
    </form:form>

</body>
</html>