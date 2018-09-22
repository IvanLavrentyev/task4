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
        <div class="col-md-10" style="margin-top: 10%">
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thread>
                        <tr class="active">
                            <th>Here you can change user name</th>
                            <th>Here you can change user login</th>
                            <th>Here you can change user password</th>
                            <th>Here you can change user role (admin or user)</th>

                            <th></th>
                        </tr>
                    </thread>
                    <tbody>
                    <form action="${pageContext.request.contextPath}/updateUser" method="post">
                        <td>
                            <div class="col-md-2">
                                <p><input type="text" name="newName" value="${user.name}" size=15"/></p>
                            </div>
                        </td>

                        <td>
                            <div class="col-md-2">
                                <p><input type="text" name="newLogin" value="${user.login}" size=15"/></p>
                            </div>
                        </td>

                        <td>
                            <div class="col-md-2">
                                <p><input type="text" name="newPassword" value="${user.password}" size=15"></p>
                            </div>
                        </td>

                        <td>
                            <div class="col-md-2">
                                <p><input type="text" name="newRole" value="${user.role}" size=15"></p>
                            </div>
                        </td>

                        <td>
                            <p><input type="submit"class="btn btn-primary" name="Save" value="Save"/>
                        </td>

                    </form>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
