/**
 * Created by lenovo on 2017/5/24.
 */
var Index = function () {
    //生成目录

    var createMenu =function (data) {
        var rootMenu = new Array();
        var rootId = "";
        $.each(data,function (key,obj) {
            if(obj.parentId == 0){ rootId = obj.id;}
        })

        $.each(data, function(key, obj){
            if(obj.parentId==rootId){
                rootMenu.push(obj)
            }
        });
        var str = "";

        str += '<li class="start active "><a href="javascript:;"  myurl="home.html"><i class="icon-home"></i>'
            + '<span class="title">首页</span><span class="selected"></span></a></li>';
        $.each(rootMenu, function(key, root){
            str+="<li class='last'><a href='javascript:'><i class='"+root.icon+"'></i><span class='title'>"+root.name+"</span><span class='arrow'></span></a><ul class='sub-menu'>";
            $.each(data, function(key, obj){

                if(obj.parentId==root.id){
                    str+="<li><a href='javascript:' parText="+root.name+" myurl=\""+obj.href+"\" >"+obj.name+"</a></li>";
                }
            });

            str+="</ul></li>";
        });
        str = "<li><div class='sidebar-toggler hidden-phone'></div></li>"+str;

        $("#menu").html("");
        $("#menu").html(str);
        initMenuTitle();
    }


    //验证空值
    var checkText = function (data) {
        return data == null ? '' : data;
    };
    // contents 跳转页面信息
    var mainContents = function (url, id) {
        $("#" + id).empty();
        // 展示Druid控制台
        if(url.indexOf("/druid")>=0){
            var iframe = '<iframe src="' + addr + '/druid" frameborder="0" height="100%" style="min-height: 600px;" width="100%" scrolling="auto"></iframe>'
            $("#"+id).html(iframe);
        } else {
            $.ajax({
                type: "GET",
                url: url,
                success: function (data) {
                    $("#" + id).html(data);
                }
            });
        }
    }
    //刷新页面不返回首页
    var reloadMainContents = function () {
        var msg = $.cookie('mContents')||"system/user.html";
        var arr = msg.split("@");
        mainContents(arr[0],'mainContents')
    }

    // 初始化页面信息

    var init = function () {
        var user="";
        try{
            user = JSON.parse($.cookie("mycookie"));
        }catch(err){

        }
        $.ajax({
            url: addr + "/api/sys/menu/listMenuByUserId/"+user.userid,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                // 根据用户创建目录菜单；
                // console.log(data);
                createMenu(data.data);
                //国际化
                var msgcode=data.respCode;
                // sign(msgcode);

            }
        });
        //刷新页面
        reloadMainContents();
    };
    //登录人员信息
    var userMsg = function (user) {
        var str = '';
        $('#usname').empty();
        str += '<img alt="" src="../images/avatar1_small.jpg" /><span class="username" >&nbsp;'
            + user.username + '</span> <i class="icon-angle-down"></i>';
        $('#usname').html(str);
    };
    var initMenuTitle = function () {
        $(".sub-menu li a").on('click', function () {
            breadcrumb($(this).attr('myurl'), $(this).attr('parText'),$(this).text());
            $("#mainTitle").empty("#mainTitle");
            //在cookie中加入现在页面刷新后重新加载
            $.cookie('mContents', $(this).attr('myurl')+"@"+$(this).attr('parText')+"@"+$(this).text());
            $("#mainTitle").html($(this).text());
        });
    }
    // 快速链接头
    var breadcrumb = function (url,ptext,text) {
        $("#breadcrumb").empty("#breadcrumb");
        $("#breadcrumb").html('<li> <i class="icon-home"></i> <a href="index.html">首页</a> </li>'
            + '<li> <i class="icon-angle-right"></i> <a href="javascript:void(0);">'
            +  ptext + '</a></li>'
            + '<li> <i class="icon-angle-right"></i> <a href="javascript:;" onclick="'
            + mainContents(url, 'mainContents') + '">' + text + '</a></li>');
    }

    return {
        init: init,
        createMenu: createMenu,
        mainContents: mainContents,
        initMenuTitle: initMenuTitle
    }
}();