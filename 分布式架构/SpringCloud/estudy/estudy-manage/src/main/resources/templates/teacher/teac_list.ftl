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
                            <input type="text" name="name" value="${param.name}" id="param" placeholder="讲师名称" style="height: 26px"/>

                            <select name="isStar" id="isStar" class="ui_select01">
                                <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--请选择--</option>

                            <#if (param.isStar!=null)>
                                <#if (param.isStar==1)>
                                    <option value=1 selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;普通讲师</option>
                                    <option value="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高级讲师</option>
                                <#elseif (param.isStar==2)>
                                    <option value="2" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高级讲师</option>
                                    <option value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;普通讲师</option>
                                <#else>
                                </#if>
                            <#elseif (param.isStar==null)>
                                <option value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;普通讲师</option>
                                <option value="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高级讲师</option>
                            <#else >
                            </#if>
                            </select>

                            <input type="text" name="createTime" value="${param.createTime}" id="createTime" placeholder="开始注册时间" style="height: 26px"/>
                            <input type="text" name="updateTime" value="${param.updateTime}" id="updateTime" placeholder="结束注册时间" style="height: 26px"/>

                            <input type="submit" value="查找" class="ui_input_btn01" onclick="search();"/>
                            <input type="button" value="清空" class="ui_input_btn01" id="clearId" onclick="clear();" />
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
                            <th>ID</th>
                            <th>姓名</th>
							<th>头衔</th>
							<th>资历</th>
							<th>简介</th>
							<th>注册时间</th>
                            <th>排序</th>
							<th>操作</th>
						</tr>
							<#--<tr>-->
								<#list teaList as teac>
									<tr>
                                    <td>
										<input type="checkbox" name="IDCheck" value="${user.userId}" class="acb" />
									</td>
                                    <td>${teac.id}</td>
                                    <td>${teac.name}</td>
                                    <td>
                                        <#if (teac.isStar==true)>普通讲师
                                        <#elseif (user.isStar==false)>高级讲师<#else></#if>
                                    </td>
                                    <td width="200">${teac.education}</td>
                                    <td width="300">${teac.career}</td>
                                    <td>${teac.createTime?date}</td>
                                    <td>${teac.sort}</td>
                                    <td>
                                        <a href="${APP_PATH}/teacher/teaUpdate?userId=${teac.id}&page=${resPag.pageno}" class="edit" style="color: #000EFF">修改</a>
                                        <a href="${APP_PATH}/teacher/teaDele?userId=${teac.id}&page=1" style="color: #000EFF">删除</a>
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
							<input type="submit" value="上一页" class="ui_input_btn01" id="prePage"  onclick="jumpPrePage();"/>
							<input type="submit" value="下一页" class="ui_input_btn01"  id="nextPage" onclick="jumpNextPage();" />
							<input type="submit" value="尾页" class="ui_input_btn01" id="lastPage" onclick="jumpLastPage();" />
						
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01"  value="${resPag.pageno}"/>页
							 <input type="submit" class="ui_input_btn01" value="跳转" onclick="jumpInputPage();" />
					</div>
				</div>
			</div>
		</div>
	</form>

<script type="text/javascript">

    function jumpFirst() {
        $("#submitForm").attr("action","${APP_PATH}/teacher/getTeacherList?page=1").submit;
     }

    /** 模糊查询用户  **/
    function search() {
        $("#submitForm").attr("action","${APP_PATH}/teacher/teaSearch").submit();
    }

    function jumpPrePage() {
        var pageno = ${resPag.pageno};
        if(pageno<=1){
            $("#submitForm").attr("action","${APP_PATH}/teacher/getTeacherList?page="+1).submit();
        }else{
            $("#submitForm").attr("action","${APP_PATH}/teacher/getTeacherList?page="+(pageno-1)).submit();
        }
    }
    function jumpNextPage() {
        var pageno = ${resPag.pageno};
        var pageto = ${resPag.totalno};
        if(pageno>=pageto){
            $("#submitForm").attr("action","${APP_PATH}/teacher/getTeacherList?page="+pageto).submit();
        }else{
            $("#submitForm").attr("action","${APP_PATH}/teacher/getTeacherList?page="+(pageno+1)).submit();
        }

    }
    function jumpLastPage() {
        $("#submitForm").attr("action","${APP_PATH}/teacher/getTeacherList?page=${resPag.totalno}").submit();
    }

    /** 输入页跳转 **/
    function jumpInputPage() {
        // 如果“跳转页数”不为空
        if ($("#jumpNumTxt").val() != '') {
            var pageNum = parseInt($("#jumpNumTxt").val());
            // 如果跳转页数在不合理范围内，则置为1
            var totalPage = ${resPag.totalno};
            if (pageNum < 1 | pageNum > totalPage) {
                art.dialog({
                    icon: 'error',
                    title: '友情提示',
                    drag: false,
                    resize: false,
                    content: '请输入合适的页数，\n自动为您跳到首页',
                    ok: true,
                });
                pageNum = 1;
            }
            $("#submitForm").attr("action", "${APP_PATH}/teacher/getTeacherList?page="+pageNum).submit();
        } else {
            // “跳转页数”为空
            art.dialog({
                icon: 'error',
                title: '友情提示',
                drag: false,
                resize: false,
                content: '请输入合适的页数，\n自动为您跳到首页',
                ok: true,
            });
            $("#submitForm").attr("action", "${APP_PATH}/teacher/getTeacherList?page=" + 1).submit();
        }
    }
    
    function batchDel(){

        var allIDCheck = "";
        $("input[name='IDCheck']:checked").each(function (index,demo) {
            allIDCheck += $(demo).val() + ",";
        });
        if(allIDCheck.length>0) {
            allIDCheck = allIDCheck.substring(0, allIDCheck.length-1);
            // 赋给隐藏域
            $("#allIDCheck").val(allIDCheck);
            if(confirm("您确定要批量删除这些记录吗？")){
                // 提交form
                $("#submitForm").attr("action", "${APP_PATH}/batchDe").submit();
            }
        }
    }

    function exportExcel(){

        /* art.dialog({
             icon: 'error',
             title: '友情提示',
             drag: false,
             resize: false,
             content: '请输入合适的页数，\n自动为您跳到首页',
             ok: true,
         });*/
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
                $("#submitForm").attr("action", "${APP_PATH}/exportExcel").submit();
            }
        }
    }


    $("#clearId").click(function(){
        $("#param").val("");


    })

    $("#clearId").click(function(){
        $("#param").val("");
        $("#createTime").val("");
        $("#updateTime").val("");
        $("#isStar").val("");
    })


</script>
</body>
</html>
