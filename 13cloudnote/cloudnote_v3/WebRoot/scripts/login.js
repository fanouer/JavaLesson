//页面载入后初始化处理
$(function(){
	//给登录按钮绑定单击处理
	$("#login").click(checklogin);
	//给注册按钮绑定单击处理
	$("#regist_button").click(registuser);
});

//登录检查处理
function checklogin(){
	//清空原有提示信息
	$("#count_span").html("");
	$("#password_span").html("");
	//获取请求要提交的参数
	var name = $("#count").val().trim();
	var password = $("#password").val().trim();
	var checked = true;//默认通过检测
	if(name==""){
		$("#count_span").html("用户名为空");
		checked = false;
	}
	if(password==""){
		$("#password_span").html("密码为空");
		checked = false;
	}
	//通过检测发送Ajax请求
	if(checked){
		$.ajax({
			type:"post",
			url:schemaUrl+"/user/login.do",
			data:{"name":name,"password":password},
			dataType:"json",
			success:function(result){
				if(result.status==0){//成功
					//获取用户ID写入Cookie
					var userId = result.data;
					addCookie("userId",userId,2);
					window.location.href="edit.html";
				}else if(result.status==1){//用户名错误
					$("#count_span").html(result.msg);
				}else if(result.status==2){//密码错误
					$("#password_span").html(result.msg);
				}
			},
			error:function(){
				alert("登录异常");
			}
		});
	}
};

//注册处理
function registuser(){
	//清空原有信息
	$("#warning_1 span").html("");
	$("#warning_2 span").html("");
	$("#warning_3 span").html("");
	$("#warning_1").hide();
	$("#warning_2").hide();
	$("#warning_3").hide();
	//获取请求参数
	var username = $("#regist_username").val().trim();
	var nickname = $("#nickname").val().trim();
	var password = $("#regist_password").val().trim();
	var final_password = $("#final_password").val().trim();
	//格式检查
	var checked = true;//默认检测通过
	if(username==""){
		$("#warning_1 span").html("用户名为空");
		$("#warning_1").show();
		checked = false;
	}
	if(password==""){
		$("#warning_2 span").html("密码为空");
		$("#warning_2").show();
		checked = false;
	}else if(password.length<6){
		$("#warning_2 span").html("密码位数太少");
		$("#warning_2").show();
		checked = false;
	}
	if(final_password==""){
		$("#warning_3 span").html("确认密码为空");
		$("#warning_3").show();
		checked = false;
	}else if(final_password!=password){
		$("#warning_3 span").html("与密码不一致");
		$("#warning_3").show();
		checked = false;
	}
	//发送Ajax请求
	if(checked){
		$.ajax({
			url:schemaUrl+"/user/regist.do",
			type:"post",
			data:{"name":username,
				"nick":nickname,"password":password},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					alert(result.msg);//提示成功
					$("#back").click();//切换到登录界面
				}else if(result.status==1){
					$("#warning_1 span").html(result.msg);
					$("#warning_1").show();//显示提示信息
				}
			},
			error:function(){
				alert("注册异常");
			}
		});
	}
};


