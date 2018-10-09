var addr=$.trim(window.location.protocol+ "//"+window.location.host),pagNo=1,pageSize=10,timestamp=(new Date).getTime();var urltstamp="_ts="+timestamp;
var urladdr = "http://localhost";
var lanpath="../config/",language=$.cookie("lan");

/*
*  国际化
* */
/*
$('#language li').on('click',function () {
    language =$(this).attr('lan');
    $.cookie('lan',language);
    $("#language-button span").html(language);
});
function languages(path,fn) {
    $.i18n.properties({
        name : 'translate', //资源文件名称
        path : path+language, //'../languageprop/', //资源文件路径
        mode : 'map', //用Map的方式使用资源文件中的值
        language : language, //'en',
        callback : fn
    });
}
/!* layer成功提示 *!/
function sign(mes) {
    languages(lanpath,function(){
        layer.msg($.i18n.prop(mes), {time: 1100, icon:6 });
    })
};

languages(lanpath,function(){
    console.log(1)
   console.log($.i18n.prop("此项不能为空")) ;
   console.log(2)
    console.log($.i18n.prop("\u6b64\u9879\u4e0d\u80fd\u4e3a\u7a7a")) ;
})*/
