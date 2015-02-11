<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/config.jsp"%>
	<title>登陆</title>
</head>
<body>
	<div id="loginWin" class="easyui-window" title="登录"
		style="width: 350px; height: 188px; padding: 5px;" minimizable="false"
		maximizable="false" resizable="false" collapsible="false">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 5px; background: #fff; border: 1px solid #ccc;">
				<form id="loginForm" method="post">
					<div style="padding: 5px 0;">
						<label for="userName">帐号:</label>
						<input type="text" name="userName" style="width: 260px;"/>
					</div>
					<div style="padding: 5px 0;">
						<label for="password">密码:</label>
						<input type="password" name="password" style="width: 260px;"/>
					</div>
					<div style="padding: 5px 0; text-align: center; color: red;" id="showMsg"></div>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: right; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:void(0)" onclick="login()">登录</a> <a
					class="easyui-linkbutton" iconCls="icon-cancel"
					href="javascript:void(0)" onclick="cleardata()">重置</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	document.onkeydown = function(e) {
		var event = e || window.event;
		var code = event.keyCode || event.which || event.charCode;
		if (code == 13) {
			login();
		}
	}
	$(function() {
		$("input[name='login']").focus();
	});
	function cleardata() {
		$('#loginForm').form('clear');
	}
	function login() {
		if ($("input[name='userName']").val() == ""
				|| $("input[name='password']").val() == "") {
			$("#showMsg").html("用户名或密码为空，请输入");
			$("input[name='login']").focus();
		} else {
			//ajax异步提交  
			$.ajax({
				type : "POST", //post提交方式默认是get
				url : "${ctx}/sys/login.do",
				data : $("#loginForm").serialize(), //序列化               
				error : function(request) { // 设置表单提交出错                 
					$("#showMsg").html(request); //登录错误提示信息
				},
				success : function(data) {
					document.location = "/sys/index.do";
				}
			});
		}
	}
</script>
</html>