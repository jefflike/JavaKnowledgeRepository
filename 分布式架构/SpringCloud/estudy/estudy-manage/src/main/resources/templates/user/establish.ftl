<!DOCTYPE HTML>
<html>
<head>
    <title>文件上传</title>
</head>

<body>
    <h1 th:inlines="text">文件上传</h1>

    <form action="${APP_PATH}/user/fileupload" method="post" enctype="multipart/form-data" method="post">
        <p>选择文件: <input type="file" name="fileName"/></p>
        <p><input type="submit" value="提交"/></p>
    </form>
</body>
</html>