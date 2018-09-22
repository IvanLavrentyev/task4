<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-md-1"></div>
        <div class="col-md-10" style="margin-top: 20%">
            <div class="table-responsive">
                <h2 align="center">IN ORDER TO PROCEED PLEASE LOGIN</h2>
                    <hr>
                    <form id="form" action="${pageContext.request.contextPath}/login" method="post" onload="document.getElementById('form').reset()">



                        <td>
                            <div class="col-md-4" align="center">
                                <p><input type="text" id="login" placeholder="Please enter your login" name="login" value="${user.login}" size=25"/></p>
                            </div>
                        </td>

                        <td>
                            <div class="col-md-4" >
                                <p><input type="text" placeholder="Please enter your password" name="password" value="${user.password}" size=25"></p>
                            </div>
                        </td>


                        <td>
                            <input type="submit"class="btn btn-primary" name="Login" value="Login" />
                        </td>
                    </form>
                <hr>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    function clear() {
        var r = $('#login').value;
        alert(r);
    }
</script>
</html>
