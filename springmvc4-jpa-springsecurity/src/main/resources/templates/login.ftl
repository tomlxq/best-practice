<title>Login</title>

<link href="/static/css/base.css" rel="stylesheet">


<div class="col-md-6 col-md-offset-2">
<#if param??&&param.error??>
    <div class="alert alert-danger">
        Invalid UserName and Password.
    </div>
</#if>
<#if param??&&param.logout??>

    <div class="alert alert-success">
        You have been logged out.
    </div>
</#if>
</div>

<div class="row">
    <div class="col-md-6 col-md-offset-2">
        <h2>User Login Form</h2>
        <form id="loginForm" method="post" action="/login" modelattribute="user" class="form-horizontal"
                   role="form" cssstyle="width: 800px; margin: 0 auto;">
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

        </form>
    </div>
</div>

<script src="/static/js/base.js"></script>
<script src="/static/js/app.js"></script>
