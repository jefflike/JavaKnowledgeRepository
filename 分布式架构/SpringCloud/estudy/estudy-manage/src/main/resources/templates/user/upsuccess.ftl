<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${APP_PATH}/scripts/jquery/jquery-1.7.1.js"></script>
<link href="${APP_PATH}/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="${APP_PATH}/style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${APP_PATH}/scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="${APP_PATH}/scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="${APP_PATH}/scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="${APP_PATH}/style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="${APP_PATH}/scripts/artDialog/artDialog.js?skin=default"></script>
<title>信息管理系统</title>
<script type="text/javascript">

</script>
<style>

</style>
</head>
<body>
	<form id="submitForm" name="submitForm" action="" method="post">
        <input type="hidden" name="page" value="${resPag.pageno}" id=""/>
        <input type="hidden" name="userId" value="${eduUser.userId}" id=""/>

		<div id="container">
			<div class="">
				<div class="">
					<div id="box_border">
						<div id="box_top">修改成功</div>
					</div>
				</div>
			</div>
			<div class="">
				<div class="">
					<table class="" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
                            <a href="${APP_PATH}/userList?page=${pageno}" class="edit" style="color: #000EFF">返回</a>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>

<script type="text/javascript">
    function jumpFirst() {
        $("#submitForm").attr("action","${APP_PATH}/doUpdatePass").submit;
    }

</script>
</body>
</html>
