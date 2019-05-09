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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    <title>信息管理系统</title>
    <script type="text/javascript">
        $(document).ready(function() {

            /** 删除 **/
            function del(fyID) {
                // 非空判断
                if (fyID == '') return;
                if (confirm("您确定要删除吗？")) {
                    $("#submitForm").attr("action", "/xngzf/archives/delFangyuan.action?fyID=" + fyID).submit();
                }
            }

            /** 批量删除 **/
            function batchDel() {
                if ($("input[name='IDCheck']:checked").size() <= 0) {
                    art.dialog({icon: 'error', title: '友情提示', drag: false, resize: false, content: '至少选择一条', ok: true,});
                    return;
                }
                // 1）取出用户选中的checkbox放入字符串传给后台,form提交
                var allIDCheck = "";
                $("input[name='IDCheck']:checked").each(function (index, domEle) {
                    bjText = $(domEle).parent("td").parent("tr").last().children("td").last().prev().text();
// 			alert(bjText);
                    // 用户选择的checkbox, 过滤掉“已审核”的，记住哦
                    if ($.trim(bjText) == "已审核") {
// 				$(domEle).removeAttr("checked");
                        $(domEle).parent("td").parent("tr").css({color: "red"});
                        $("#resultInfo").html("已审核的是不允许您删除的，请联系管理员删除！！！");
// 				return;
                    } else {
                        allIDCheck += $(domEle).val() + ",";
                    }
                });
                // 截掉最后一个","
                if (allIDCheck.length > 0) {
                    allIDCheck = allIDCheck.substring(0, allIDCheck.length - 1);
                    // 赋给隐藏域
                    $("#allIDCheck").val(allIDCheck);
                    if (confirm("您确定要批量删除这些记录吗？")) {
                        // 提交form
                        $("#submitForm").attr("action", "/xngzf/archives/batchDelFangyuan.action").submit();
                    }
                }
            }

        });
    </script>
    <style>
        .alt td{ background:black !important;}
    </style>
</head>
<body>
<form id="submitForm" name="submitForm" action="" method="post">
    <input type="hidden" name="page" value="${resPag.pageno}" id="allIDCheck"/>
    <input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
    <div id="container">
        <div class="ui_content">
            <div class="ui_text_indent">
                <div id="box_border">
                    <div id="box_top">批量操作</div>
                    <div id="box_center">
                        <!-- Small modal
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button>

                        <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-sm" role="document">
                                <div class="modal-content">
                                    <div class="modal-content">
                                        &nbsp;性&nbsp;别：<input type="radio" value="0" name="gender" checked="checked">男</input>&nbsp;&nbsp;&nbsp;
                                        <input type="radio" value="1" name="gender">女</input>
                                    </div>

                                </div>
                            </div>
                        </div>
                        </div>-->
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">批量上传</button>
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="exampleModalLabel">学员信息</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <div class="form-group">
                                                <label for="recipient-name" class="control-label">电话:</label>
                                                <input type="text" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="form-group">
                                                <label for="message-text" class="control-label">邮件:</label>
                                                <input type="text" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="form-group">
                                                <label for="message-text" class="control-label">用户名:</label>
                                                <input type="text" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="form-group">
                                                <label for="message-text" class="control-label">密码:</label>
                                                <input type="text" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="form-group">
                                                <label for="message-text" class="control-label">昵称:</label>
                                                <input type="text" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="form-group">
                                                <label for="message-text" class="control-label">年龄:</label>
                                                <input type="text" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="form-group">
                                                <label for="message-text" class="control-label">年龄:</label>
                                                <input type="text" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="form-group">
                                                <label for="message-text" class="control-label">性别:</label>
                                                <input type="radio" value="0" name="gender" checked="checked">男</input>
                                                <input type="radio" value="1" name="gender">女</input>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                        <button type="button" class="btn btn-primary">上传</button>
                                    </div>
                                </div>
                            </div>
                        </div>
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
                <#list eduUsers as user>
									<tr>
                                        <td>
                                            <input type="checkbox" name="IDCheck" value="14458579642011" class="acb" />
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
										<#if (user.avalible==false)>冻结
                                        <#elseif (user.avalible==true)>正常<#else></#if>
                                        <td>
                                            <a href="../teacher/teacher_edit.ftl?fyID=14458579642011" class="edit" style="color: #000EFF">修改密码</a>
                                            <a href="${APP_PATH}/updateStatus?userId=${user.userId}&page=${resPag.pageno}" style="color: #000EFF">
											<#if (user.avalible==false)><span style="color: #00B83F">解冻</span>
                                            <#elseif (user.avalible==true)><span style="color: #990000">冻结</span><#else></#if>
                                            </a>
                                            <a href="javascript:del('14458579642011');" style="color: #000EFF">操作日志</a>
                                        </td>
                                    </tr>
                                </#list>
                </table>
            </div>
        </div>
    </div>
</form>

</body>
</html>
