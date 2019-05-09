<!DOCTYPE html>
<html>
<head>
<title>信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${APP_PATH}/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="${APP_PATH}/style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${APP_PATH}/scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="${APP_PATH}/scripts/jquery/jquery-1.4.4.min.js"></script>
<script src="${APP_PATH}/scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
<script type="text/javascript" src="${APP_PATH}/scripts/artDialog/artDialog.js?skin=default"></script>
    <#--jquery的cdn-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="${APP_PATH}/jquery/jquery.form.js"></script>

<#--bootstrap的cdn-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<form id="submitForm" name="submitForm" action="/teacher/saveTeacher" method="post">
	<div id="container">
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="80">讲师名称： </td>
					<td class="ui_text_lt">
                        <div class="form-group">
                        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="讲师名称" name="name" style="width: 500px">
						</div>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">讲师资历： </td>
					<td class="ui_text_lt">
                        <div class="form-group">
                        <input type="text" class="form-control" placeholder="讲师资历" name="education" style="width: 500px">
						</div>
					</td>
				</tr>
                <tr>
                    <td class="ui_text_rt">专业ID： </td>
                    <td class="ui_text_lt">
                        <div class="form-group">
                        <input type="text" class="form-control" placeholder="讲师专业" name="subjectId" style="width: 500px">
						</div>
					</td>
                </tr>
                <tr>
                    <td class="ui_text_rt">讲师等级： </td>
                    <td class="ui_text_lt">
                        <div class="form-group">
                        <#--<input type="text" class="form-control" placeholder="讲师等级" name="is_star" style="width: 500px">-->
                            <label class="radio-inline">
                                <input type="radio" name="isStar" id="inlineRadio1" value="1"> 高级讲师
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="isStar" id="inlineRadio2" value="2"> 首席讲师
                            </label>
						</div>
					</td>
                </tr>
                <tr>
                    <td class="ui_text_rt">讲师排序： </td>
                    <td class="ui_text_lt">
                        <div class="form-group">
                        <input type="text" class="form-control" placeholder="讲师排序" name="sort" style="width: 500px">
						</div>
					</td>
                </tr>
                <tr>
                    <td class="ui_text_rt">讲师简介： </td>
                    <td class="ui_text_lt">
                        <div class="form-group">
						<textarea class="form-control" name="career" style="width: 500px"></textarea>
						</div>
					</td>
                </tr>

                <tr>
                    <td>上传图片</td>
                    <td>
						<img id="img" src="http://192.168.31.7/group1/M00/00/00/wKgfB1vG7yqANS13AAGlrZGQU_M667.jpg" width="200px"><br><#--<input type="file" id="imgs" name="imgs">-->
                        <input type="file" name="file" id="FileUpload">
                        <#--<a id="btn_uploadimg">上传图片</a>-->
					</td>
					<input type="hidden" name="picPath" id="pic">
                </tr>
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="submit" value="提交" class="ui_input_btn01"/>
						&nbsp;<input id="cancelbutton" type="button" value="取消" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>

</body>

<#--图片上传-->
<script type="text/javascript">
/*	$("#btn_uploadimg").click(
	    function () {
            var fileObj = document.getElementById("FileUpload").files[0]; // js 获取文件对象
            if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
                alert("请选择图片");
                return;
            }
            var formFile = new FormData();
            formFile.append("action", "UploadVMKImagePath");
            formFile.append("file", fileObj); //加入文件对象

            var data = formFile;
            $.ajax({
                url: "/teacher/saveTeacherImg",
                data: data,
                type: "Post",
                dataType: "json",
                cache: false,//上传文件无需缓存
                processData: false,//用于对data参数进行序列化处理 这里必须false
                contentType: false, //必须
                success: function (result) {
                    $("#img").attr("width", "200px");
                    $("#img").attr("src", result);
                },
                error: function(e){
                    alert(e);
                }
            });
        }
	);*/
	$("#FileUpload").change(
		function () {
			var fileObj = document.getElementById("FileUpload").files[0]; // js 获取文件对象
			if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
				alert("请选择图片");
				return;
			}
			var formFile = new FormData();
			formFile.append("action", "UploadVMKImagePath");
			formFile.append("file", fileObj); //加入文件对象

			var data = formFile;
			$.ajax({
				url: "/teacher/saveTeacherImg",
				data: data,
				type: "Post",
				dataType: "json",
				cache: false,//上传文件无需缓存
				processData: false,//用于对data参数进行序列化处理 这里必须false
				contentType: false, //必须
				success: function (result) {
					$("#img").attr("width", "200px");
					$("#img").attr("src", result);
					$("#pic").attr("value", result);
				},
				error: function (e) {
					alert(e);
				}
			});
		}
	);

/*	$("submitbutton").click(
	    function () {

        }
	)*/

</script>
</html>