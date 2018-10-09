/**
 * @author:adc_liuyang
 * 2017-09-25
 * 测试通过：chrome(44.0.2403.157);FireFox(38.0.6);IE11;
 */
//part1
//定义变量
var isTimeBegin = false;

//超时时间
var setOutMin = 20; //通过修改此处控制超时时间
var timeOutSec = setOutMin * 60;

//寻找timeObj对象，并重置时间
function resetTime() {
    try {
        if (document.getElementById("timeObj") != null) {
            resetNoOperationTime();
            return;
        } else if (parent.document.getElementById("timeObj") != null) {
            parent.resetNoOperationTime();
            return;
        } else if (parent.parent.document.getElementById("timeObj") != null) {
            parent.parent.resetNoOperationTime();
            return;
        }

    } catch (e) {}
    return;
}

//页面开始计时
function timeBeginPlus() {
    //console.log(isTimeBegin);
    if (isTimeBegin == false) {
        timelisten = window.setInterval("treatNoOperationTime()", 1000);
        //console.log(timelisten);
        isTimeBegin = true;
    }
}

//非必须代码
//var testAll = timeOutSec;
//到此为止

//判断是否达到超时时间、未达到则更新页面无操作时间，达到超时时间则调用超时处理
function treatNoOperationTime() {
    //非必须代码
//	var test = document.getElementById("test");
//	testAll = testAll -1;
//	test.innerText = testAll;
    //到此为止
    var timeObj = document.getElementById("timeObj");
    if (timeObj.value < timeOutSec) {
        timeObj.value = 1 + parseInt(timeObj.value);
    } else {
        clearInterval(timelisten);
        isTimeBegin = false;
        logOut();
    }
    //console.log(document.getElementById("timeObj").value);
}

//重置页面无操作时间：鼠标左键点击时调用
function resetNoOperationTime() {
    document.getElementById("timeObj").value = 0;
    //非必须代码
    //testAll = timeOutSec;
    //到此为止
}

//超时退出
function logOut() {
    //再次验证
    if (document.getElementById("timeObj").value >= timeOutSec) {
        isLogOut = true;
        //window.location.href = "/Home/LogOut";
        window.location.href = "login.html";
    }
}


//*********************************************************************************************
//part2

//开始页面计时
timeBeginPlus();

//加载click事件
if (typeof document.addEventListener != "undefined") {
    document.addEventListener("click", resetTime, true);
} else {
    document.attachEvent("onclick", resetTime);
}
//超时后，返回之前的操作页面
function RedirectToView (url) {
    if(ViewBag.redirect !=null) {
        document.getElementById("timeObj").click();
    }
}
