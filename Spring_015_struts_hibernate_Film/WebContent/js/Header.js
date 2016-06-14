window.onload = function () {
    var a = document.getElementById("header_top");
    a.children[1].children[0].onclick = function () {
        window.open("Login.htm")
    }
    a.children[1].children[1].onclick = function () {
        window.open("Resgin.htm")
    }
}