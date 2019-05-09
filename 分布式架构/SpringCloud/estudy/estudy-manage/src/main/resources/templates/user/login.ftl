<!DOCTYPE html>
<html>
<head>
    <!-- Meta -->
    <meta charset="utf-8" http-equiv="Content-Type" />
    <!-- End of Meta -->
    <!-- Page title -->
    <title>登录 -${websitemap.web.company}-${websitemap.web.title}</title>
    <!-- End of Page title -->
    <meta name="author" content="${websitemap.web.author}" />
    <meta name="keywords" content="${websitemap.web.keywords}" />
    <meta name="description" content="${websitemap.web.description}" />
    <link rel="shortcut icon" href="${APP_PATH}/favicon.ico" type="image/x-icon">
    <!-- Libraries -->
    <link type="text/css" href="${APP_PATH}/admin/css/login.css" rel="stylesheet" />
    <script type="text/javascript">
        function enterSubmit(event) {
            var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            if (keyCode == 13) {
                $("#loginForm").submit();
                return false;
            }
        }
    </script>
</head>
<body>
<div id="container">
    <div class="logo">
        <a href="http://demo1.inxedu.com/" target="_blank" title="好学在线教育软件 - 在线教育整体解决方案提供商">
            <img src="${APP_PATH}/admin/assets/logo.png" width="200" alt="好学在线教育软件 - 在线教育整体解决方案提供商" />
        </a>
    </div>
</div>

<div class="b-box">
    <div id="container">
        <div id="box">
            <h2>好学网后台管理系统</h2>
            <form action="${APP_PATH}/user/login" method="POST" id="loginForm">
                <p class="main">
                    <label>用户名: </label>
                    <input name="sysUser.loginName" onkeyup="enterSubmit(event)" value="${sysUser.loginName}" placeholder="输入用户名" />
                    <label>密码: </label>
                    <input type="password" onkeyup="enterSubmit(event)" name="sysUser.loginPwd" value="${sysUser.loginPwd}" placeholder="输入密码">
                </p>
                <p class="space">
                    <input type="submit" value="登录" class="login" />
                    <span>${message}</span>
                </p>
            </form>
        </div>
        <div class="login-foot">
            <span>
					Powered By <a target="_blank" href="http://www.inxedu.com/" style="color: #666;">${websitemap.web.company}</a>
				</span>
        </div>
    </div>
</div>
</body>
</html>