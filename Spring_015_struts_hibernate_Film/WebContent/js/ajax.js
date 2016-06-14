
var req;
var cartItem;//供delCartItemCallback使用的购物车项tr

function getReq() {
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
}


/*********购物车 添加商品 开始********/
function cartAdd(pid) {
	var count = 1;
	try {
		count = document.getElementById("count").value;
	} catch (err) {	}

	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//var idField = document.search.category1.value;
//alert(idField);
	var url = "deal/productcartadddeal.jsp?id=" + pid + "&count=" + count;
	
	//设置回调函数
	req.onreadystatechange = cartAddCallback;//在req对象的状态发生更改时调用的函数
	req.open("get", url, true);
	
	req.send(null);
}

/*删除类别回调函数*/
function cartAddCallback() {
	if (req.readyState == 4) {//处理完成
		if (req.status == 200) {//是否是正常的反馈
			//eval(req.responseText);
			var str = req.responseText;
			alert(str);
		}	
	}
}
/*******购物车 添加商品 结束***********/


/********购物车 删除商品 开始*********/

function delCartItem(id) {
	
	cartItem = document.getElementById('product_id_' + id);
	
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	
	var url = "deal/DelCartItem?id=" + id;
	
	//设置回调函数
	req.onreadystatechange = delCartItemCallback;//在req对象的状态发生更改时调用的函数
	req.open("get", url, true);
	
	req.send(null);
	
	
	
	
}

/*删除类别回调函数*/
function delCartItemCallback() {
	if (req.readyState == 4) {//处理完成
		if (req.status == 200) {//是否是正常的反馈
			var str = req.responseText;
alert(str);
			if (str == "1") {//1代表正常
				if(cartItem) cartItem.parentNode.removeChild(cartItem);
			} else {
				alert("删除失败!请重新尝试");
			}
		}	
	}
}
/********购物车 删除商品 结束*******/




/**********删除信息********/

function delMsg(id) {
	getReq();
	
	var url = "deal/messagedelete.jsp?id=" + id;
	
	//设置回调函数
	req.onreadystatechange = delMsgCallback;//在req对象的状态发生更改时调用的函数
	req.open("get", url, true);
	
	req.send(null);
	
	
	
	
}

/*删除类别回调函数*/
function delMsgCallback() {
	if (req.readyState == 4) {//处理完成
		if (req.status == 200) {//是否是正常的反馈
			var str = req.responseText;
			alert(str);
			
			if (str.match("删除成功")) {//当删除成功刷新页面
				//delRow('category','c' + id);//删除表格的一行
				window.location.reload(true);
			}
		}	
	}
}
/******************/
