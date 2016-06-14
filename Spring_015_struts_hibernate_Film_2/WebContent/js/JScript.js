var emailState;		//emal状态
var phoneNumState;	//电话号码状态
var passworedState; //密码状态
var passworedState1; //密码状态


//function flags(flags, targetEle) {
//    var flag = false;
//    if (flag == true) {
//        var txtPhone = document.getElementById("txtphone").value;
//        msg = encodeURIComponent(txtPhone);
//        window.open("PhoneEmail.htm?msg=" + msg);
//    } else {
//        var div = document.createElement("div");
//        div.className = "div2";
//        targetEle.appendChild(div);
//        var divtxt = document.createTextNode("");
//        div.appendChild(divtxt);
//        switch (id) {
//            case "txtemail":
//                divtxt.nodeValue = "邮件格式不——请重新输入";
//                
//                break;
//            case "txtphone":
//                divtxt.nodeValue = "号码输入不对!";
//                break;
//            case "txtpwd1":
//                divtxt.nodeValue = "密码长度至少要为6!";
//            case "txtpwd2":
//                divtxt.nodeValue = "两次密码要为一致，请重新输入!";
//                break;
//        }
//    }
// }

//根据传入的文本的ＩＤ　来判断传入的是否为合法
//ID:表示控件的id
function Check(id) {
    var ele = document.getElementById(id);
   
    switch (id) {
        case "txtemail":
            var reg=   /^\w+@\w+\.\w{2,3}(\.\w{2,3})?$/;      
            emailState =  reg.test(ele.value);
            return emailState;
            break;
        case "txtphone":
            var reg = /(^(0?1[358]\d{9})$)|(^(0\d{2,3}-[1-9]\d{6,7}(-\d{3,4})?)$)/;
            phoneNumState = reg.test(ele.value);
            
            return phoneNumState;
            break;
        case "txtpwd1":
            var reg = /.{6,}/;
            passwordState = reg.test(ele.value);
           
            return passwordState;
            break;
        case "txtpwd2":
            var reg = /.{6,}/;
            var pwd1value = document.getElementById("txtpwd1").value;
            
            passwordState = (reg.test(ele.value) && (ele.value == pwd1value));
            //alert(passwordState);
            return passwordState;
            break;
    }
}
//设置提示信息
//id:传入的控件的id
//flag:两个可能的值:blur/focus
//targetEle:在其中设置信息的 "目标元素"(第三个tr)
//imageName:输入正确的图标名称（含路径）
function Set(id, flag, targetEle, imageName) {
    if (flag == "focus") {

        //每一次加载时都会有一个层.把它移出
        if (targetEle.children.length > 0) {
            targetEle.removeChild(targetEle.firstChild);
        }

        var div = document.createElement("div");
        div.className = "div1";
        targetEle.appendChild(div);
        var divtxt = document.createTextNode("");
        div.appendChild(divtxt);

        switch (id) {
            case "txtemail":
                divtxt.nodeValue = "请填写你的邮件，方便接收信息";
                break;
            case "txtphone":
                divtxt.nodeValue = "请填写你的手机号码，你需要接收一个验证码";
                break;
            case "txtpwd1":
                divtxt.nodeValue = "请输入一个密码，长度最少６个";
                break;
            case "txtpwd2":
                divtxt.nodeValue = "请再次输入确认密码";
                break;
        }
    } 
    else if (flag == "blur") {

        //每一次加载时都会有一个层.把它移出

            if (targetEle.children.length > 0) {
                targetEle.removeChild(targetEle.firstChild);
            }

            if (Check(id)) {
                var img = document.createElement("img");
                img.src = imageName;
                img.style.paddingLeft = "10px"; //图片的位于左边的距离 //块级标签无margin属性
                targetEle.appendChild(img);
               

            }
            else {

                var div = document.createElement("div");
                div.className = "div2";
                targetEle.appendChild(div);
                var divtxt = document.createTextNode("");
                div.appendChild(divtxt);
                switch (id) {
                    case "txtemail":
                        divtxt.nodeValue = "邮件格式不正确请重新输入";
                      	emailState = false;
                        break;
                    case "txtphone":
                        divtxt.nodeValue = "电话号码输入不对!";
                        phoneNumState = false;
                        break;
                    case "txtpwd1":
                        divtxt.nodeValue = "密码长度至少要为6!";
                        passworedState = false;
                    case "txtpwd2":
                        divtxt.nodeValue = "两次密码要为一致，请重新输入!";
                        passworedState = false;
                        break;
                }
               // flags(false);
       }    
    }
}
function btnimage1() {
    document.getElementById("btnimage1").onclick = function () {

        if (!emailState) {
            alert("请输入正确的email地址");
            return;
        }
        if (!phoneNumState) {
            alert("请输入正确的电话号码");
            return;
        }

        if (!passwordState) {
            alert("请确认你的密码符合条件");
            return;
        }
        
        if (document.getElementById("checkbox").checked) {
            var txtPhone = document.getElementById("txtphone").value;
            msg = encodeURIComponent(txtPhone);
			document.location = "PhoneEmail.htm?msg=" + msg;
           //window.open("PhoneEmail.htm?msg=" + msg);
           
        } else {
            //window.open("Resgin.htm");
            alert("您必须同意《当当网交易条款》和《当当网社区条款》才能注册账号");
        }

        return false;
    }
}

window.onload = function () {
    var inputList = document.getElementById("mytable").getElementsByTagName("input");
    // var inputList = document.getElementById("mytable").getElementsByTagName("input");
    for (var i = 0; i < inputList.length; i++) {
        if (inputList[i].type == "text" || inputList[i].type == "password") {
            //丢失焦点
            inputList[i].onblur = function () {
                // var id = this.id;
                //  alert(id + ":" + Check(id));
                var targetEle = this.parentNode.parentNode.children[2];
                var imageName = "image/pic-ok.gif";
                Set(this.id, "blur", targetEle, imageName);

            }
            inputList[i].onfocus = function () {
                var targetEle = this.parentNode.parentNode.children[2];
                Set(this.id, "focus", targetEle);
            }
        }
    }
      btnimage1();
}

