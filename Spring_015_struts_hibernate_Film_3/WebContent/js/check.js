/*
 * 检查登录,用户名和密码是否被输入
 * formName:登录的表单
 */
function loginCheck(formName) {
	if (document.forms[formName]["userName"].value == "") {
		//document.getElementById("userName").innerHTML="用户名不能为空";
		alert('用户名不能为空');
		return false;
	}
		
	if (document.forms[formName]["password"].value == "") {
		//document.getElementById("password").innerHTML="密码不能为空";
		alert('密码不能为空');
		return false;
	}
	return true;
}

/*
 * 注册验证
 * obj:填写信息的文本框
 * objSpan://显示提示信息span的id号
 */
function checkItem(obj,objSpan) {
	//alert(obj.name);
	var span = document.getElementById(objSpan);//用于显示文本框填写错误,输出提示信息
	switch (obj.name) {
		case "userName":
			if (obj.value == "") {
				span.innerHTML = "用户名不能为空";
				return false;
			} else {
				
			}
			break;
		case "password1":
			if (obj.value == "") {
				span.innerHTML = "密码不能为空";
				return false;
			} else if (obj.value != document.forms["register"]["password2"].value) {
				span.innerHTML = "两次输入的密码不相同";
				return false;
			}
			document.getElementById('cpassword2').innerHTML = "√";
			break;
		case "password2":
			if (obj.value == "") {
				span.innerHTML = "确认密码不能为空";
				
				return false;
			} else if (obj.value != document.forms["register"]["password1"].value) {
				span.innerHTML = "两次输入的密码不相同";
				return false;
			}
			document.getElementById('cpassword1').innerHTML = "√";
			break;
		case "name":
			if (obj.value == "") {
				span.innerHTML = "名字不能为空";
				return false;
			}
			break;
		case "email":
			if (obj.value == "") {
				span.innerHTML = "邮箱不能为空";
				return false;
			}
			break;
		case "phoneNumber":
			if (obj.value == "") {
				span.innerHTML = "电话不能为空";
				return false;
			}
			break;
		case "address":
			if (obj.value == "") {
				span.innerHTML = "默认送货地址不能为空";
				return false;
			}
			break;
	}
	
	span.innerHTML = "√";
	return true;
}
/*
 * 获取注册表单参数
 */
function $form(name) {
	return document.forms["register"][name].value;
}

/*
 * 检查表单所有信息
 */
function checkItems() {
	if ($form("userName") == "") {
		alert("用户名不能为空");
		return false;
	} else if ($form("password1") == "") {
		alert("请填写密码");
		return false;
	} else if ($form("password2") == "") {
		alert("请填写密码");
		return false;
	} else if ($form("password1") != $form("password2")) {
		alert("两次密码填写不一致");
		return false;
	} else if ($form("name") == "") {
		alert("请填写名字");
		return false;
	} else if ($form("email") == "") {
		alert("请填写email");
		return false;
	} else if ($form("phoneNumber") == "") {
		alert("请填写电话号码");
		return false;
	}  else if ($form("address") == "") {
		alert("请填写默认送货地址");
		return false;
	}
	return true;
}

function check(id) {
	if (document.getElementById(id).value == "") {
		return false;
	}
	return true;
}