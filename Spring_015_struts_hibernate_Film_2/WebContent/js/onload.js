
window.onload = function () {
	//头部菜单条
	set_mouseover('header_top_menu1', 'header_menu_div1');
	set_mouseout('header_top_menu1', 'header_menu_div1');
	set_mouseover('header_top_menu2', 'header_menu_div2');
	set_mouseout('header_top_menu2', 'header_menu_div2');
	set_mouseover('header_top_menu3', 'header_menu_div3');
	set_mouseout('header_top_menu3', 'header_menu_div3');
	
	createNums();
	imgLoop(true);
	//initLeftsidebar();
}

function f() {
	document.getElementById("left_content_1").style.display = "none";
}
