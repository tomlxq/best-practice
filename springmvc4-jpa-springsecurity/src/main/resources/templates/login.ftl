


    <title>Login</title>

    <link href="css/base.css" rel="stylesheet">



    <div class="col-md-6 col-md-offset-2">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                Invalid UserName and Password.
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                You have been logged out.
            </div>
        </c:if>
    </div>

    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <h2>User Login Form</h2>
            <form:form id="loginForm" method="post" action="${rootURL}login" modelattribute="user" class="form-horizontal" role="form" cssstyle="width: 800px; margin: 0 auto;">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">UserName*</label>
                    <div class="col-sm-4">
                        <input type="text" id="username" name="username" class="form-control" placeholder="UserName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password*</label>
                    <div class="col-sm-4">
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-4">
                        <input type="submit" class="btn btn-primary" value="Login">
                    </div>
                </div>

            </form:form>
        </div>
    </div>

    <script src="js/base.js"></script>
    <script src="js/app.js"></script>
