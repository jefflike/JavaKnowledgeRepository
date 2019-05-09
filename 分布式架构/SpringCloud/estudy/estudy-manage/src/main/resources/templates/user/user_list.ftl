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
<#--bootstrap的cdn-->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>信息管理系统</title>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<form id="submitForm" name="submitForm" action="" method="post">
        <input type="hidden" name="page" value="${resPag.pageno}" id=""/>
        <input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
                            <input type="text" name="param" value="${eduUserParam.param}" id="param" placeholder="邮箱/昵称/姓名" style="height: 26px"/>
                            <input type="text" name="createTime" value="${eduUserParam.createTime}" id="" placeholder="开始注册时间" style="height: 26px"/>
                            <input type="text" name="lastSystemTime" value="${eduUserParam.lastSystemTime}" id="" placeholder="结束注册时间" style="height: 26px"/>

                            <select name="isAvalible" id="" class="ui_select01">
                                <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-状态--</option>

                                <#if (eduUserParam.isAvalible!=null)>
                                    <#if (eduUserParam.isAvalible=="0")>
                                            <option value="0" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;冻结</option>
                                            <option value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正常</option>
                                    <#elseif (eduUserParam.isAvalible=="1")>
                                            <option value="1" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正常</option>
                                            <option value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;冻结</option>
                                    <#else>
                                    </#if>
                                <#elseif (eduUserParam.isAvalible==null)>
                                    <option value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正常</option>
                                    <option value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;冻结</option>
                                <#else >
                                </#if>
                            </select>

                            <input type="submit" value="查找学员" class="ui_input_btn01" onclick="search();"/>
                            <input type="button" value="清空" class="ui_input_btn01" id="addBtn" />
                            <input type="button" value="导出" class="ui_input_btn01" onclick="exportExcel();"/>
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
							<th>姓名</th>
							<th>电话</th>
							<th>邮件</th>
							<th>年龄</th>
							<th>昵称</th>
							<th>性别</th>
                            <th>状态</th>
							<th>操作</th>
						</tr>
							<#--<tr>-->
								<#list eduUsers as user>
									<tr>
                                    <td>
										<input type="checkbox" name="IDCheck" value="${user.userId}" class="acb" />
									</td>
                                    <td>${user.userName}</td>
                                    <td>${user.mobile}</td>
                                    <td>${user.email}</td>
                                    <td>${user.age}</td>
                                    <td>${user.showName}</td>
                                    <td>
										<#if (user.sex==false)>女
										<#elseif (user.sex==true)>男<#else></#if>
									</td>
                                    <td>
										<#if (user.isAvalible==false)>冻结
										<#elseif (user.isAvalible==true)>正常<#else></#if>
                                    <td>
                                        <a href="${APP_PATH}/user/updatePass?userId=${user.userId}&page=${resPag.pageno}" class="edit" style="color: #000EFF">修改密码</a>
                                        <a href="${APP_PATH}/user/updateStatus?userId=${user.userId}&page=${resPag.pageno}" style="color: #000EFF">
											<#if (user.isAvalible==false)><span style="color: #00B83F">解冻</span>
											<#elseif (user.isAvalible==true)><span style="color: #990000">冻结</span><#else></#if>
										</a>
                                        <a href="javascript:del('14458579642011');" style="color: #000EFF">操作日志</a>
                                    </td>
                                    </tr>
								</#list>

							<#--</tr>-->
						
					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						共有
						<span class="ui_txt_bold04">${resPag.totalsize}</span>
						条记录，当前第
						<span class="ui_txt_bold04">${resPag.pageno}
						/
						${resPag.totalno}</span>
						页
					</div>
					<div class="ui_frt">
						<!--    如果是第一页，则只显示下一页、尾页 -->
						    <#--<a class="ui_input_btn01" href="#"  onclick="jumpFirst();">首页</a>-->
							<input type="submit" value="首页" class="ui_input_btn01" id="firstPage" onclick="jumpFirst();"/>
							<input type="button" value="上一页" class="ui_input_btn01" id="prePage"  onclick="jumpPrePage();"/>
							<input type="button" value="下一页" class="ui_input_btn01"  id="nextPage" onclick="jumpNextPage();" />
							<input type="button" value="尾页" class="ui_input_btn01" id="lastPage" onclick="jumpLastPage();" />
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01"  value="${resPag.pageno}"/>页
							 <input type="button" class="ui_input_btn01" value="跳转" onclick="jumpInputPage(9);" />
					</div>
				</div>
			</div>
		</div>
	</form>

<script type="text/javascript">
    function jumpFirst() {
        $("#submitForm").attr("action","${APP_PATH}/user/getUserList?page=1").submit;
    }

    /** 模糊查询用户  **/
    function search() {
        $("#submitForm").attr("action","${APP_PATH}/user/getUserList").submit();
    }

    function jumpPrePage() {
        var pageno = ${resPag.pageno};
        if(pageno<=1){
            $("#submitForm").attr("action","${APP_PATH}/user/getUserList?page="+1).submit();
        }else{
            $("#submitForm").attr("action","${APP_PATH}/user/getUserList?page="+(pageno-1)).submit();
        }
    }
    function jumpNextPage() {
        var pageno = ${resPag.pageno};
        var pageto = ${resPag.totalno};
        if(pageno>=pageto){
            $("#submitForm").attr("action","${APP_PATH}/user/getUserList?page="+pageto).submit();
        }else{
            $("#submitForm").attr("action","${APP_PATH}/user/getUserList?page="+(pageno+1)).submit();
        }
    }

    function jumpLastPage() {
        $("#submitForm").attr("action","${APP_PATH}/user/getUserList?page=${resPag.totalno}").submit();
    }

    /** Excel导出  **/
    function exportExcel() {
        if (confirm('您确定要导出吗？')) {
            var allIDCheck = "";
            $("input[name='IDCheck']:checked").each(function (index,demo) {
                allIDCheck += $(demo).val() + ",";
            });
            if(allIDCheck.length>0) {
                allIDCheck = allIDCheck.substring(0, allIDCheck.length-1);
                // 赋给隐藏域
                $("#allIDCheck").val(allIDCheck);
                if(confirm("您确定要导出这些记录吗？")){
                    // 提交form
                    $("#submitForm").attr("action", "${APP_PATH}/user/exportExcel").submit();
                }
            }
        }
    }
</script>
</body>
</html>
