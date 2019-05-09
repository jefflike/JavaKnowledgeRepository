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
<style>
    .sel_btn{
        height: 40px;
        line-height: 21px;
        padding: 0 11px;
        background: #bdbdbd;
        border-radius: 3px;
        display: inline-block;
        /*text-decoration: none;*/
        font-size: 20px;
        outline: none;
    }

    input{
        height: 20px;
    }
     input,textarea{
        padding: 4px 10px;
        line-height: 20px;
        position: relative;
        cursor: pointer;
        background: #fafafa;
        border: 1px solid #ddd;
        border-radius: 4px;
        overflow: hidden;
        display: inline-block;
	}
</style>
</head>
<body>
<form id="fom" name="submitForm" action="${APP_PATH}/teacher/saveTeacher" method="post">
	<div id="container">
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
                <tr>
                    <td class="ui_text_rt" width="80">讲师名称：&nbsp;&nbsp;</td>
                    <td class="ui_text_lt" width="200">
                        <input type="text" id="name" name="name" value="${eduTeacher.name}" class="a-upload" style="width: 295px"  />
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt">讲师资历：&nbsp;&nbsp;</td>
                    <td class="field"><textarea cols="40" rows="3" name="education" id="education"
                                                class="longinput">${eduTeacher.education}</textarea></td>
                </tr>
                <tr>

                    <td class="ui_text_rt">讲师专业：&nbsp;&nbsp;</td>
                    <td class="">
						<select name="parentId" id="parentId" class="ui_select01">
                            <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-请选择-</option>
							<#list subList as sub>
								<#if (sub.subjectId)==parentId>
                                    <option value="${sub.subjectId}" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sub.subjectName}</option>
								<#elseif (sub.subjectId)!=parentId>
                                    <option value="${sub.subjectId}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sub.subjectName}</option>
								<#else >
								</#if>
							</#list>
						</select>
                        <select name="subjectId" id="subjectId" class="ui_select01">
                            <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-请选择-</option>
						<#list subListChil as chil>
							<#if (chil.subjectId)==eduTeacher.subjectId>
                                <option value="${chil.subjectId}" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${chil.subjectName}</option>
							<#elseif (chil.subjectId)!=eduTeacher.subjectId>
                                <option value="${chil.subjectId}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${chil.subjectName}</option>
							<#else >
							</#if>
						</#list>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="ui_text_rt">讲师等级：&nbsp;&nbsp;</td>
                    <td class="">
                        <select name="isStar" id="isStar" class="ui_select01">
                            <option value="true">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-请选择-</option>
							<#if eduTeacher.isStar==false>
                                <option value="false" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;普通讲师</option>
                                <option value="true">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高级讲师</option>
							</#if>
						<#if eduTeacher.isStar==true>
                            <option value="false">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;普通讲师</option>
                            <option value="true" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高级讲师</option>
						</#if>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt">讲师排序：&nbsp;&nbsp;</td>
                    <td class="ui_text_lt">
                        <input type="text" id="sort" name="sort" value="${eduTeacher.sort}" class=""  style="width: 295px"/>
                    </td>
                </tr>

                <tr>
                    <td class="ui_text_rt">讲师简介：&nbsp;&nbsp;</td>
                    <td class="field"><textarea cols="40" rows="3" name="career" id="career"
                                                  class="longinput">${eduTeacher.career}</textarea></td>
                </tr>

                <tr>
                    <td class="ui_text_rt">头像上传：</td>
                    <td>
<#--
                        <input type="file" name="file" id="FileUpload"><br>
                        <a id="btn_uploadimg">上传图片</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id="btn_see">图片预览</a>
                        <p>
                            <img id="img" src="${eduTeacher.picPath}" style="height: 180px" width="180px">
						</p>
					</td>
					<input type="hidden" name="picPath" id="pic" value="${eduTeacher.picPath}">
-->
                <tr>
                    <td>上传图片</td>
                    <td>
                        <img id="img" src="${eduTeacher.picPath}" width="200px"><br>
                        <input type="file" name="file" id="FileUpload">
                    <#--<a id="btn_uploadimg">上传图片</a>-->
                    </td>
                    <input type="hidden" name="picPath" id="pic">
                </tr>
                </tr>
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="button" value="提交" class="ui_input_btn01" onclick="submitTea()"/>
						&nbsp;<a id="cancelbutton" type="button" value="返回" class="sel_btn" href="${APP_PATH}/teaList?page=1" style="height: 12px"  >返回</a>
                     </td>
				</tr>
			</table>
		</div>
	</div>
</form>

</body>

<#--图片上传-->
<script type="text/javascript">
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

	$("#btn_uploadimg").click(
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
                url: "/teacher/fileUpload",
                data: data,
                type: "Post",
                dataType: "json",
                cache: false,//上传文件无需缓存
                processData: false,//用于对data参数进行序列化处理 这里必须false
                contentType: false, //必须
                success: function (result) {
                    $("#img").attr("width", "200px");
                    $("#img").attr("style","display:none");
                    $("#pic").val(result);
                    $("#img").attr("src", result);
                    alert("上传成功!");
                },
                error: function(e){
                    alert(e);
                }
            });
        }
	);

    $("#FileUpload").change(
            function () {
                var fileObj = document.getElementById("FileUpload").files[0]; // js 获取文件对象
                if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
                    alert("请选择图片");
                    return;
                }
            });
    $("#btn_see").click(function () {
        $("#img").attr("style","display:visible");
    });

    function submitTea() {
		<#--${APP_PATH}/saveTeacher-->
		var data = {
		    name:$("#name").val(),
            education:$("#education").val(),
            subjectId:$("#subjectId").val(),
            isStar:$("#isStar").val(),
            sort:$("#sort").val(),
            career:$("#career").val(),
            picPath:$("#pic").val(),
			createTime:$("#createTime").val()
		};
		$.ajax({
			url: "/teacher/saveTeacher",
			data: data,
			type: "Post",
			dataType: "json",
			cache: false,
            success: function (result) {
			    if("success"==result){
                    alert("修改成功!");
                    $("#name").val("");
                    $("#education").val("");
                    $("#subjectId").val("");
                    $("#isStar").val("");
                    $("#sort").val("");
                    $("#career").val("");
                    $("#pic").val("");
                    $("#parentId").val("");
                    $("#createTime").val("");
                    $("#img").attr("src", "");
				}

            },
            error: function(e){
                alert("修改失败!");
            }
        });

    }

    $("#parentId").change(function () {
        var id = $(this).val();
        if(id==null){
            return ;
		}
		$.ajax({
            url: "/teacher/selectChi",
            data: {
                "parentId":id
			},
            type: "GET",
            dataType: "json",
            success: function (result) {
                var optionstring = "";
                for (var j = 0; j < result.length;j++) {
                    optionstring += "<option value=\"" + result[j].subjectId + "\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +result[j].subjectName + "</option>";
                    $("#subjectId").html("<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--请选择--</option> "+optionstring);
                }
            },
            error: function (msg) {
                alert("出错了！");
            }
		});
    });

</script>
</html>