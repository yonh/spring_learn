// JavaScript Document
var images = ["images/main_up_01.jpg","images/main_up_02.jpg","images/main_up_03.jpg"];//所有广告图片列表
var index = 0;		//图片索引
var intervar = 2000;//切换图片时间间隔
var timeoutID;		//setTimeout方法返回值


/*头部菜单的显示和隐藏*/
function set_mouseout(id, div) {/*hidden*/
	document.getElementById(id).onmouseout = function() {
		document.getElementById(div).style.display = "none";
	}
}

function set_mouseover(id, div) {/*show*/
	document.getElementById(id).onmouseover = function() {
		document.getElementById(div).style.display = "block";
	}
}


//创建数字索引
function createNums() {
	var imgUl = document.createElement("ul");//保存图片按钮的ul
	imgUl.id = "imgUl";
	
	for (var i=0; i<images.length; i++) {
		var imgLi = document.createElement("li");
		
		imgLi.onclick = function () {//li的单击事件
			index = parseInt(this.firstChild.nodeValue) - 1;
			clearTimeout(timeoutID);
			imgLoop(true);
		}
		imgLi.onmouseover = function () {//
			index = parseInt(this.firstChild.nodeValue) - 1;
			clearTimeout(timeoutID);
			imgLoop(false);
			
		}
		imgLi.onmouseout = function () {
			clearTimeout(timeoutID);
			imgLoop(true);
		}
		
		var txt = document.createTextNode(i+1);//创建li的文本节点
		imgLi.appendChild(txt);//添加文本节点到li
		imgUl.appendChild(imgLi);//将这个li添加至ul
	}
	
	document.getElementById("imgNo").appendChild(imgUl);//将创建好的ul添加进div
}

function imgLoop(bool) {
	document.getElementById("img").src = images[index];
	var liList = document.getElementById("imgUl").childNodes;
	
	for (var i=0; i<liList.length; i++) {
		if (parseInt(liList[i].firstChild.nodeValue) == (index+1)) {
			liList[i].style.color = "#FFF";
			liList[i].style.backgroundColor = "#31A1E1";
		} else {
			liList[i].style.backgroundColor = "#FFF";
			liList[i].style.color = "#09F";
		}
	}
	
	if (bool) {
		if (index == images.length - 1) {
			index = 0;
		} else {
			index++;
		}
		
		timeoutID = setTimeout("imgLoop(true)", intervar);
	}
}

function selectBookLi(name) {
	var lis = document.getElementsByName(name);
	for (var i=0; i<lis.length; i++) {
		lis.item(i).style.height = "25px";
	}
	this.style.height = "80px";
}
	
function changeLiHeight(name, index) {
	list = document.getElementsByName(name);
	
	for (var i=0; i<list.length; i+=2) {
		if (index == i) {
			//list.item(i).style.height = "80px";
			list.item(i).style.display = "none";
			list.item(i+1).style.display = "block";
		} else {
			list.item(i).style.display = "block";
			list.item(i+1).style.display = "none";
		}
	}
}

function showdivByContent(div) {
	
	var d = document.getElementById(div);
	d.style.display = "block";
}
// 
// function aaa() {
	// var left = document.getElementById("left_content_" + 2);
	// var right = document.getElementById("right_content_" + 2);
	// alert(left);
	// alert(right);
// }
//div是要显示的div的id
//id是发生事件需要显示的div的id
//i是整个包裹内容的层的距top距离
function showdiv(div, id, i) {
	var d = document.getElementById(div);
	var left = document.getElementById("left_content_" + id);
	var right = document.getElementById("right_content_" + id);
	
	d.style.marginTop = i + "px";
	d.style.display = "block";
	
	for (var index=1; index<=13; index++) {
		if (index != id) {
			document.getElementById("divContainer" + index).style.display = "none";
			//document.getElementById("left_content_" + index).style.display = "none";
			//document.getElementById("right_content_" + index).style.display = "none";
		} else {
			//document.getElementById("right_content_" + index).style.display = "block";
			//document.getElementById("left_content_" + index).style.display = "bolck";
			document.getElementById("divContainer" + index).style.display = "block";
		}
	}
}
function hiddendiv(div) {
	document.getElementById(div).style.display = "none";
}

//获取节点的子节点
	function getChildren(arr) {
		var list = [];
		for (var i = 0; i < arr.length; i++) {
			if (arr[i].nodeType == 1) {
				list.push(arr[i]);
			}
		}
	
		return list;
	}

//初始化左导航菜单
function initLeftsidebar() {
	var div = document.getElementById("leftsidebar_content_div1");//取得左边div
	
	if (window.ActiveXObject) {
		xmlDom = new ActiveXObject("Microsoft.XMLDOM");
	} else {
		xmlDom = document.implementation.createDocument("", "", null);
	}
	xmlDom.async = false;
	xmlDom.load("leftsidebar.xml");
	
	var leftsidebar_content = document.getElementById("leftsidebar_content");
	var root = xmlDom.documentElement;//root
	var items = getChildren(root.childNodes);//获得所以item的数组
	
	//alert(items.length);
	for (var index=0; index<items.length; index++) {
		var itemChildNOdes = getChildren(items[index].childNodes);//获得第一个item里面的所以节点的集合
		//var rows = getChildren(itemLists[0].childNodes);//获得left里面行的集合
		var lefts = getChildren(itemChildNOdes[0].childNodes);//左边所以子节点
		var rights = getChildren(itemChildNOdes[1].childNodes);//右边所以子节点
		
		var divContainer = document.createElement("div");
		divContainer.id = "divContainer" + (index+1);
		
		var div1 = document.createElement("div");
		var div2 = document.createElement("div");
		div1.id = "left_content_" + (index+1);
		div2.id = "right_content_" + (index+1);
		div1.className = "leftsidebar_content_div1";
		div1.innerHTML = "<h1>选择分类</h1>";
		
		div2.className = "leftsidebar_content_div2";
		
		for (var i=0; i<lefts.length; i++) {
			var rows = getChildren(lefts[i].childNodes);
			var rowName = rows[0].childNodes[0].nodeValue;//每个rowName节点的值
			
			var p = document.createElement("p");
			p.innerHTML = "<h2><a href=\"#\" target=\"blank\">"+rowName+"</a></h2>";
			ul = document.createElement("ul");
			
			var lis = getChildren(rows[1].childNodes);
			var str = "";
			for (var j=0; j<lis.length; j++) {
				//if (j == lis.length-1) {
				//	str += "<li class=\"bottom_line\">"+ lis[j].childNodes[0].nodeValue + "</li>";
				//} else {
					str += "<li><a href=\"#\" target=\"blank\">" + lis[j].childNodes[0].nodeValue + "</a></li>";
				//}
			}
			ul.innerHTML = str;
			p.appendChild(ul);
			div1.appendChild(p);
			//if (i != lefts.length - 1) {
			var d = document.createElement("div");
			d.className = "row_line";
			div1.appendChild(d);
			//}
		}
		
		//生成右边div
		title = rights[0].childNodes[0].nodeValue;
		div2.innerHTML = "<h1>"+title+"</h1>";
		var ul = document.createElement("ul");
		var itemLis = getChildren(rights[1].childNodes);
		for (var i=0; i<itemLis.length; i++) {
			var itemLiValue = itemLis[i].childNodes[0].nodeValue;
			ul.innerHTML += "<li><a href=\"#\" target=\"blank\">" + itemLiValue + "</a></li>"
			
		}
		
		div2.appendChild(ul)
		divContainer.appendChild(div1);
		divContainer.appendChild(div2);
		leftsidebar_content.appendChild(divContainer);
	}
	
}
