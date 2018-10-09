/* 默认隐藏弹出表单*/
console.log("user.js");
$('#usAdd').hide();
$('#editPwd').hide();
$('#subUserTabel').hide();
$('#propertyAdd').hide();
var pageSize =8, pageNo=1, totalSize = 1, totalCounts = 1,
    id ="usertable" ;
var tid = "userFieldTable",fieldTotalCounts = 1,fieldPageSize =8, fieldPageNo=1;
var searchmsg = {usname:'',rolestr:''};
var url ='';
var pagearr = [1,3,5,8,10,15,20];
var tableName ="T_S_USER";  //对应数据库中 TS_FORM_FIELD 表 TABLE_NAME 字段
var mainTableName="TS_USER";
var header;
var curd="";
$("#roleSet").hide();
// 工具栏 点击弹窗
$(".tabletools").on('click', 'a', function () {
    var html = "", title = "", htmlstr = "";
    var checkboxs = $("input[name='checkboxes']:checked");

    bindHeader('init');

    switch ($(this)[0].id) {
        case 'userAdd':
            htmlstr = $("#usAdd");
            title = "新增用户信息";
            $("#usAdd input, #usAdd textarea").attr("disabled", false);
            layerfn(htmlstr, title, "add",id); //新增用户
            break;
        case 'userUpdate':
            $("#usAdd input, #usAdd textarea").attr("disabled", false);
            if (checkboxs.length == 1) {
                htmlstr = $("#usAdd");
                title = "修改用户信息";
                htmlstr = getform(checkboxs.val(), htmlstr, title);
            } else {
                layer.msg("请选择一条信息");
            }
            break;
        case 'updatePwd':
            $("#editPwd input").attr("disabled", false);
            if (checkboxs.length == 1) {
                htmlstr = $("#editPwd");
                title = "修改密码";
                layerfnEditPwd(htmlstr, title, checkboxs.val());
            } else {
                layer.msg("请选择一条信息");
            }
            break;
        case 'userDelete':
            title = "删除用户信息";
            var chk_value = [];
            checkboxs.each(function () {
                chk_value.push($(this).val());
            });
            //alert(chk_value.length);
            if(chk_value.length>0){
                dellist(chk_value);
            }
            else{
                layer.msg("请选择一条信息");
            }
            break;
        case 'userMessage':
            if (checkboxs.length == 1) {
                htmlstr = $("#usAdd");
                title = "查看用户信息";
                htmlstr = getformView(checkboxs.val(), htmlstr, title);
            } else {
                layer.msg("请选择一条信息");
            }
            break;
        case 'tableConfig':
            fieldTotalCounts = 1,fieldPageSize =8, fieldPageNo=1;
      
            getfieldlist('init');
            setfieldjqpage();
            getfieldpagesize();
            htmlstr = $("#subUserTabel");
            title = "附表管理";

            layerfnSubUserTable(htmlstr, title);
            break;
    }
    $('#userform')[0].reset();

});
var rusid='',rrid='';

/**************字段管理窗口***************************/
// 工具栏 点击弹窗
$(".fieldtabletools").on('click', 'a', function () {
    //alert(0);
    var html = "", title = "", htmlstr = "";
    var checkboxs = $("input[name='checkboxes1']:checked");
    switch ($(this)[0].id) {
        case 'fieldAdd':
            htmlstr = $("#propertyAdd");
            title = "新增字段信息";
            $("#propertyAdd input, #propertyAdd textarea").attr("disabled", false);
            layerfnFieldAdd(htmlstr, title, "add");
            break;
        case 'fieldUpdate':
            $("#propertyAdd input, #propertyAdd textarea").attr("disabled", false);
            if (checkboxs.length == 1) {
                htmlstr = $("#propertyAdd");
                title = "修改字段信息";
                htmlstr = getfieldform(checkboxs.val(), htmlstr, title);
            } else {
                layer.msg("请选择一条信息");
            }
            break;
        case 'fieldDelete':
            title = "删除字段信息";
            var chk_value = [];
            checkboxs.each(function () {
                chk_value.push($(this).val());
            });
            //alert(chk_value.length);
            if(chk_value.length>0){
                delfield(chk_value);
            }
            else{
                layer.msg("请选择一条信息");
            }
            break;
        case 'fieldMessage':
            if (checkboxs.length == 1) {
                htmlstr = $("#propertyAdd");
                title = "查看字段信息";
                htmlstr = getfieldformView(checkboxs.val(), htmlstr, title);
            } else {
                layer.msg("请选择一条信息");
            }
            break;
    }
});

var getDicTypeList=function(dictionaryCode){
    url = addr+"/api/sys/dictionary";
    $.ajax({
        url: url ,
        type:"GET",
        data:{
            pageNo : "",
            pageSize : "",
            dictionaryCode : dictionaryCode,
            dictionaryName : ""
        },
        async:false,
        success:function (data) {
            if(data.data.list.length>0){
                curd=data.data.list[0].dicTypeEOList;
                return curd;
            }
        }
    });
}
function getDropDownList(dictionaryCode){
    var rurl= addr+"/api/sys/dictionary";
    var list = {
        url: rurl, //+dictionaryCode,
        data:{
            pageNo : pageNo,
            pageSize : pageSize,
            dictionaryCode : dictionaryCode
        },
        delay: 250,
        allowClear: true,
        placeholder: {
            id: '-1', // the value of the option
            text: '请选择1'
        },
        processResults: function (data) {
            var cur = data.data.list[0].dicTypeEOList,
                selectrole = [{"id":" ", "text":"---请选择---"}];
            // alert(JSON.stringify(data.data.list[0]));
            for (var i =0;i<cur.length;i++){
                var land = cur[i];
                var option = {"id":land.dicTypeName, "text": land.dicTypeName};
                selectrole.push(option);
            }

            return {
                results: selectrole
            };
        },
        templateResult: function (data) {
            if (data.id == '') { // adjust for custom placeholder values
                return '请选择';
            }
            return data.text;
        },
        cache:true,
        success:function(){
        }
    };
    /*console.log(list);*/
    return list;
}
var dictionaryCode = "";

//动态绑定表头
var bindHeader = function(type ){
    $.ajax({
        //url: addr+"/api/datatable/"+tableName,//根据tableName获取扩展的字段信息
        url: addr+"/api/datatable?tableName="+tableName,
        type:"GET",
        async : false,
        success:function (data) {
            header = data.data.list;
            var rowCount = data.data.count|| 1;
            var dynamicHeader = "";
            var dynamicDiv = "";//新增用户信息窗口
            var htmlStr="";
            var temp = "";
            if(type=="init"){
                $("#usertable > thead>tr>th").eq(4).nextAll().remove();
                $("#userform > div").eq(3).nextAll().remove();
                for(var i=0 ;i<rowCount; i ++){
                    console.log(header[i]);
                    if(header[i].isShow=="是"){
                        dynamicHeader = dynamicHeader+"<th>"+header[i].content+"</th>";
                    }
                    dictionaryCode = header[i].fieldName;
                    if(header[i].showType == "text") {
                        htmlStr="";
                        htmlStr += '<div class="control-group">'
                            + '<label for="' + header[i].fieldName
                            + '" class="control-label">'
                            + header[i].content + '：</label>'
                            + '<div class="col-sm-7">'
                            + '<input type="text" class="form-control" id="'
                            + header[i].fieldName
                            + '" name="' + header[i].fieldName
                            + '" placeholder="' + header[i].content + '"></div></div>';
                        dynamicDiv = dynamicDiv+htmlStr;
                    }
                    //多行文本框
                    if(header[i].showType == "textarea") {
                        htmlStr="";
                        htmlStr += '<div class="control-group">'
                            + '<label for="' + header[i].fieldName
                            + '" class="control-label">'
                            + header[i].content + '：</label>'
                            + '<div class="col-sm-7">'
                            + '<textarea rows="4" class="form-control" id="'
                            + header[i].fieldName
                            + '" name="' + header[i].fieldName
                            + '" placeholder="' + header[i].content + '"></textarea></div></div>';
                        dynamicDiv = dynamicDiv+htmlStr;
                    }

                    //下拉框
                    if(header[i].showType == "dropdownlist"){
                        htmlStr = '<div class="control-group">'+'<label for="'+header[i].fieldName+'" class="control-label">'+header[i].content+'：</label>'+
                            '<div class="col-sm-7">'+'<select class="form-control" id="'+header[i].fieldName+'" name="'+header[i].fieldName+'" data-placeholder="'+header[i].content+'"><option></option></select></div></div>';
                        (function(dictionaryCode)
                        {setTimeout(function(){
                            $("#"+dictionaryCode).select2({
                                ajax:getDropDownList(dictionaryCode)
                            });
                        },100)})(dictionaryCode);
                        (function(dictionaryCode)
                        {
                            $("#"+dictionaryCode).select2({
                                ajax:getDropDownList(dictionaryCode)
                            });
                        })(dictionaryCode);

                        dynamicDiv = dynamicDiv+htmlStr;
                    }

                    //单选框
                    if(header[i].showType == "radio") {
                        htmlStr="";
                        (function(dictionaryCode)
                        {
                            getDicTypeList(dictionaryCode);
                            htmlStr += '<div class="control-group">'
                                +'<label for="'+header[i].fieldName+'" class="control-label">'
                                +header[i].content+'：</label>'
                                + '<div class="col-sm-7">';

                            for(var k=0;k<curd.length;k++){
                                htmlStr +='<input type="radio"  id="'+curd[k].Id
                                    +'" name="'+header[i].fieldName
                                    // +'" value=" '+curd[k].dicTypeCode+'"/>'+curd[k].dicTypeName
                                    +'" value=" '+curd[k].dicTypeCode+'"/>'+curd[k].dicTypeName
                                    +'&nbsp;&nbsp;&nbsp;';
                            }
                            htmlStr+='</div></div>';
                            dynamicDiv = dynamicDiv+htmlStr;
                            htmlStr="";
                        })(dictionaryCode);
                    }

                    //文件
                    if(header[i].showType == "file") {
                        htmlStr="";
                        htmlStr += '<div class="control-group">'
                            + '<label for="' + header[i].fieldName + '" class="control-label">'
                            + header[i].content + '：</label>'
                            + '<div class="col-sm-7">';

                        var fileFormId = header[i].id;
                        var divId = header[i].fieldName;

                      htmlStr += '<input name="' + header[i].fieldName + '" value="div" style="display:none;" type="text" />' +
                          '<form id="' + header[i].id + '" style="text-align:center;" enctype="multipart/form-data"> '
                           +  '<div  class="form-control" style="padding: 0px;">' +
                          '<input  style="outline:none;" class="change" type="file" id="' + header[i].fieldName + '" name="file"/></div>'
                           +'<input type="button" class="btn blue" style="margin-top:10px" value="上传" onclick="uploads('+fileFormId+')" />'
                           +' </form> </div></div> ';

                        dynamicDiv = dynamicDiv + htmlStr;
                    }

                    //图片
                    if(header[i].showType == "image") {
                        htmlStr="";
                        htmlStr += '<div class="control-group">'
                            + '<label for="' + header[i].fieldName + '" class="control-label">'
                            + header[i].content + '：</label>'
                            + '<div class="col-sm-7">';

                        var fileFormId = header[i].id;
                        var divId = header[i].fieldName;

                        htmlStr += '<input  name="' + header[i].fieldName + '" value="div" style="display:none;" type="text" />' +
                            '<form id="' + header[i].id + '" style="text-align:center;" enctype="multipart/form-data"> '
                            +  '<div  class="form-control" style="padding: 0px;">' +
                            '<input  style="outline:none;" class="change" type="file" id="' + header[i].fieldName + '" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" name="file"/></div>'
                            +' <input type="button" class="btn blue" style="margin-top:10px" value="上传" onclick="uploads('+fileFormId+')" />'
                            +' </form> </div></div> ';

                        dynamicDiv = dynamicDiv + htmlStr;
                    }

                    if(header[i].showType == 'Date'){
                        htmlStr="";
                        htmlStr += '<div class="control-group">'
                            + '<label for="' + header[i].fieldName + '" class="control-label">'
                            + header[i].content + '：</label>'
                            + '<div class="col-sm-7">'
                        htmlStr += '<input type="text" readonly class="form-control" id="'+dictionaryCode+'" name="'+header[i].fieldName+'"/>'
                            +'<script type="text/javascript">'
                       //     +'laydate.render({elem: "#'+dictionaryCode+'",theme:"#4d90fe"});'
                            +'</script> </div></div>';
                       temp = dictionaryCode;
                       dynamicDiv = dynamicDiv + htmlStr;
                    }

                    //时间
                    if(header[i].showType == 'Time'){
                        htmlStr="";
                        htmlStr += '<div class="control-group">'
                            + '<label for="' + header[i].fieldName + '" class="control-label">'
                            + header[i].content + '：</label>'
                            + '<div class="col-sm-7">';
                        htmlStr +=
                    '<input type="text" readonly class="form-control" name="'+header[i].fieldName+'" id="'+dictionaryCode+'"/></div>'
                            +'<script type="text/javascript">'
                  //  +'laydate.render({elem: "#'+dictionaryCode+'",type: "datetime",theme:"#4d90fe"});'
                    +'</script> </div> ';

                        dynamicDiv = dynamicDiv + htmlStr;
                    }
                }
            }
            $("#usertable > thead>tr").append(dynamicHeader);
            $("#userform").append(dynamicDiv);

        }
    })
}


function uploads(fileFormId){
    $.ajax({
        url: addr+"/api/sys/file/upload",
        type: 'POST',
        cache: false,
        async:false,
        data: new FormData($(fileFormId)[0]),
        processData: false,//必须false才会避开jQuery对 formdata 的默认处理
        contentType: false,//必须false才会自动加上正确的Content-Type

        success: function (result) {

            $(fileFormId).prev().attr("value",result.data.fileId);
        },
        error: function (err) {
        }
    });

}

/*
function download(fi) {
    var fileid = $(fi).attr("value");
    alert(fileid);
    $.ajax({
        url: addr+"/api/sys/file/"+fileid+"/download",
        type: 'GET',
        success: function (result) {
                alert(addr+"/api/sys/file/"+fileid+"/download");
                return url;
        },
        error: function (err) {
        }
    });
}*/



// 获取用户列表数据
var getlist = function(type ){
    // url = addr+"/api/dataset/"+mainTableName+"?pageNo="+pageNo+"&pageSize="+pageSize+ "&usname="+searchmsg.usname+ "&rolestr="+searchmsg.rolestr;
    url = addr+"/api/dataset/"+mainTableName+"?pageNo="+pageNo+"&pageSize="+pageSize+"&tableName="+tableName;
    $.ajax({
        url: url ,
        type:"GET",
        success:function (data) {
            console.log(data.data);
            var cur = data.data.list, str="",
                roles="", rolestr = "" , statu = "",phone="",mobilephone="";
            totalCounts = data.data.count|| 1;
            pagecount = data.data.pageCount;
            if(type != 'change') {
                setjqpage();
                $(".checkboxes").change(function () {
                    console.log(3);
                });
            }

            for(var i=0 ;i<cur.length; i ++){
                rolestr = "";
                userid = cur[i].USID;
                username = cur[i].USNAME;
                account = cur[i].ACCOUNT;
                rolestr = cur[i].ROLENAME==null?"":cur[i].ROLENAME; //原显示角色功能，暂未启用

                str+= "<tr><td><input type='checkbox' name='checkboxes' class='checkboxes' rowno = '"+i+"' value='"+userid+"' /></td>"
                    + "<td>"+parseInt(i+1)+"</td>"
                    + "<td>"+username+"</td>"
                    + "<td>"+account+"</td>"
                  //  + "<td>"+rolestr+"</td>"
                    +"<td><input class='setRole btn blue ' id='"+userid+"' value='设置角色' type='button'/></td>";

                //显示文件下载链接
                for(var col=0;col<header.length;col++){
                    if(header[col].isShow=="是" && header[col].showType == "file"  && header[col].showType != "image"){
                        var fieldName = header[col].fieldName;
                       // console.log(cur[i])
                        if(cur[i][fieldName]==null || cur[i][fieldName]== "div"){
                            str = str + "<td></td>";
                        }
                        else{

                            //str = str + '<td><i class="icon-download" value="'+cur[i][fieldName]+'" aria-hidden="true" onclick="download(this)" title="下载" ></i>' +
                            str = str + '<td><i class="icon-download"></i>' +
                            '<a href='+addr+'/api/sys/file/'+cur[i][fieldName]+'/download >下载</a></td>';
                        }
                    }

                    else if(header[col].isShow=="是" && header[col].showType == "image"){
                       // console.log("--------------------")
                       // console.log(header[col])
                        var fieldName = header[col].fieldName;
                       // console.log(cur[i])
                        if(cur[i][fieldName]==null){
                            str = str + "<td></td>";
                        }
                        //显示图片预览，点击下载
                        else{
                            str = str + "<td>tupian</td>";
                        }
                    }

                    else if(header[col].isShow=="是"){
                        console.log("--------------------")
                        console.log(header[col])
                        var fieldName = header[col].fieldName;
                        console.log(cur[i][fieldName])
                        if(cur[i][fieldName]==null){
                            str = str + "<td></td>";
                        }
                        else{
                            str = str + "<td>"+cur[i][fieldName]+"</td>";
                        }
                    }
                }
                str+="</tr>";
            }
            $("#"+id+" tbody").html(str);
        }
    });
}


/**
 *
 *设置用户角色
 */
$('body').on('click','.setRole',function () {
    rusid=this.id;
    layer.open({
        type:1,
        title:"配置用户角色",
        skin: 'ayui-layer-molv,demo-class', //加上边框
        area: ['500px', '300px'], //宽高
        content: $("#roleSet"),
        anim: 2, //弹出动画
        shadeClose: false, //开启遮罩关闭
        btn: [ '提交','重置', '关闭'],
        btnAlign: 'b',
        btn1: function (index, layero) {
            console.log(rrid + "=====" + rusid);
            setUserRole(rusid,rrid);
            layer.closeAll();
        },

        btn2: function(index, layero){
            $('#rnameSet').val("");
            $('#rdescSet').val("");
            return false //开启该代码可禁止点击该按钮关闭
        } ,

        btn3: function(index, layero){

        }

    });

});

/**
 * 设置用户角色
 * @param userId,roleId
 */
function setUserRole(userId,roleId) {
    $.ajax({
        //url:addr+"/api/sys/user/saveUserRole/?userId="+userId+"&roleId="+roleId,
        url:addr+"/api/sys/user/saveUserRole/?userId="+userId+"&roleId="+roleId,
        type:'POST',
        contentType:"application/json; charset=UTF-8",
        success:function (data) {
            getlist('init');
        }
    });
}


/**
 *
 *填充角色下拉框
 */
$("#rnameSet").select2({
    ajax: {
        url: addr+"/api/sys/role",
        delay: 250,
        async:false,
        allowClear: true,
        placeholder: {
            id: '-1', // the value of the option
            text: '请选择1'
        },
        processResults: function (data) {
            var cur = data.data, selectrole = [{"id":" ", "text":"---请选择---"}];
            for (var i =0;i<cur.length;i++){
                var land = cur[i];
                var optionid=land.rid+"#"+land.rdesc;
                var option = {"id":optionid, "text": land.rname};
                selectrole.push(option);
            }
            return {
                results: selectrole
            };
        },
        templateResult: function (data) {
            if (data.id === '') { // adjust for custom placeholder values
                return '请选择';
            }
            return data.text;
        },
        cache:true,
        success:function(){

        }
    }
});
/**
 *
 *填充角色描述信息
 */
$("#rnameSet").on("change",function(e){
    // e 的话就是一个对象 然后需要什么就 “e.参数” 形式 进行获取
    var desc =  e.target.value.split('#');
    $("#rdescadd").val(desc[1]);
    rrid = desc[0];
})





/**********/
// 获取列表数据
var getfieldlist = function(type ){
    url = addr+"/api/datatable?tableName="+tableName+"&pageNo="+fieldPageNo+"&pageSize="+fieldPageSize;
    $.ajax({
        url: url ,
        type:"GET",
        success:function (data) {
            console.log(data.data);
            var cur = data.data.list, str="",fieldId="";
            fieldName="", content = "" , type = "",fieldLength="",isNull="",isShow="";
            fieldTotalCounts = data.data.count|| 1;
            pagecount = data.data.pageCount;
            if(type != 'change') {
                setfieldjqpage();
                $(".checkboxes").change(function () {
                    console.log(3);
                });
            }

            for(var i=0 ;i<cur.length; i ++){

                fieldId= cur[i].id;
                fieldName = cur[i].fieldName;
                content = cur[i].content;
                type = cur[i].fieldType;
                fieldLength = cur[i].fieldLength;
                isNull = cur[i].isNull;
                isShow = cur[i].isShow;
                // showType = cur[i].showType;

                str+= "<tr><td><input type='checkbox' name='checkboxes1' class='checkboxes' rowno = '"+i+"' value='"+fieldId+"' /></td>"
                    + "<td>"+parseInt(i+1)+"</td>"
                    + "<td>"+fieldId+"</td><td>"+fieldName+"</td>"
                    + "<td>"+content+"</td><td>"+type+"</td>"
                    + "<td>"+fieldLength+"</td><td>"+isNull+"</td>"
                    + "<td>"+isShow+"</td>";
                str+="</tr>";
            }
            $("#"+tid+" tbody").html(str);
        }
    });
}
/**********/
bindHeader('init');
getlist('init');
setjqpage();
getpagesize();
//分页设置
function setjqpage() {
    pageSize = parseInt(pageSize);
    $('#paglist').jqPaginator({
        totalCounts:totalCounts,
        pageSize:pageSize,
        visiblePages: 5,
        currentPage: pageNo,
        first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
        last: '<li class="last"><a href="javascript:void(0);">尾页</a></li>',
        page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
        onPageChange: function (num,type) {
            pageNo = num;
            //alert(pageNo);
            if(type == 'change') {
                //alert(1);
                getlist('change');
            }
            var pagesizearr='';
            for(var i  in pagearr){
                pagesizearr +='<option value = "'+ pagearr[i] +'">'+ pagearr[i]+'</option>'
            }
//                $('#text').html('当前第' + num + '页');
            // $('#totalcount').html('共 '+ Math.ceil(totalCounts/pageSize) +" 页");
            $('#totalcount').html('共 ' + Math.ceil(totalCounts) + " 条");
            $('#pagesize').html(pagesizearr).val(pageSize);
        }
    });
}
//附表管理页面表格分页
function setfieldjqpage() {
    fieldPageSize = parseInt(fieldPageSize);
    $('#userFieldTablePagelist').jqPaginator({
        totalCounts:fieldTotalCounts,
        pageSize:fieldPageSize,
        visiblePages: 5,
        currentPage: fieldPageNo,
        first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
        last: '<li class="last"><a href="javascript:void(0);">尾页</a></li>',
        page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
        onPageChange: function (num,type) {
            fieldPageNo = num;
            if(type == 'change') getfieldlist('change');
            var pagesizearr='';
            for(var i  in pagearr){
                pagesizearr +='<option value = "'+ pagearr[i] +'">'+ pagearr[i]+'</option>'
            }
//                $('#text').html('当前第' + num + '页');
            // $('#totalcount').html('共 '+ Math.ceil(totalCounts/pageSize) +" 页");
            $('#userFieldTableTotalcount').html('共 ' + Math.ceil(fieldTotalCounts) + " 条");
            $('#userFieldTablePageSize').html(pagesizearr).val(fieldPageSize);
        }
    });
}
// 全选
$(".group-checkable").change(function () {
    var isChecked = $(this).prop("checked");
    $("input[name='checkboxes']").prop("checked", isChecked);
});

function getpagesize() {
    var pagesizearr = '';
    for (var i  in pagearr) {
        pagesizearr += '<option value = "' + pagearr[i] + '">' + pagearr[i] + '</option>'
    }
    $('#pagesize').html(pagesizearr).val(pageSize);
}
function getfieldpagesize() {
    var pagesizearr = '';
    for (var i  in pagearr) {
        pagesizearr += '<option value = "' + pagearr[i] + '">' + pagearr[i] + '</option>'
    }
    $('#userFieldTablePageSize').html(pagesizearr).val(fieldPageSize);
}
//每页显示条数
$("#pagesize").on('change',function () {
    if(pageSize != $(this).val()){
        pageSize =  $(this).val();
        pageNo = 1;
        getlist('init');
    }
});
$("#userFieldTablePageSize").on('change',function () {
    if(fieldPageSize != $(this).val()){
        fieldPageSize =  $(this).val();
        fieldPageNo = 1;
        getfieldlist('init');
    }
});


// // 角色下拉框
// $("#searchrole").select2({
//     ajax:rolelist
// });




// 搜索
function searchparam() {
    pageNo = 1;
    var selectRoleName = $("#searchrole").select2('data')[0].text;
    if(selectRoleName=="---请123选择---"){
        selectRoleName="";
    }
    searchmsg.usname = $("#searchuser").val();
    searchmsg.rolestr = selectRoleName;
    getlist('init');
}


/*****************************************/

//弹窗
function layerfn(htmlstr,title,type,id) {
    $("#passwordDiv").show();
    layer.open({
        type: 1,
        title:title,
        skin: 'ayui-layer-molv,demo-class', //加上边框
        area: ['500px', '480px'], //宽高
        content: htmlstr,
        anim: 2, //弹出动画
        shadeClose: false, //开启遮罩关闭
        btn: [ '提交','重置', '关闭'],
        btnAlign:'b',
        btn1: function(index, layero){
            if (type == "add") {
                //增加
                //addlist(addr+"/api/sys/tuser","POST",params);
                var fmsg = $("#userform").serializeArray();
                var params ="{";
                var mainField = "";
                var mainFieldValue="";
                var subFieldV = "";
                for(var i=0;i<4;i++){
                    params += '"' + fmsg[i].name.toLowerCase() + '":"' + fmsg[i].value + '",';
                    mainField += fmsg[i].name.toLowerCase();
                    if(i<3 ){
                        mainField += ",";
                    }
                }
                
                for(var i=1;i<4;i++){
                    mainFieldValue += "'"+fmsg[i].value+"'" ;

                    if(i<3){
                        mainFieldValue += ",";
                    }
                }

                for(var j=4;j<fmsg.length;j++){
                    subFieldV += fmsg[j].name + "='" + fmsg[j].value + "'";
                    if (j < fmsg.length-1) {
                        subFieldV += ',';
                    }
                }
                params += '"subFieldV":'+'"'+subFieldV+'"}';
                
                $.ajax({
                    
                    url:addr+"/api/dataset/"+mainTableName+"?tableName="+tableName+"&subFieldV="+subFieldV+"&mainField="+mainField+"&mainFieldValue="+mainFieldValue,
                    type:'POST',
                    contentType:"application/json; charset=UTF-8",
                    success:function (data) {
                        layer.msg("zx:"+mainField); //测试完毕记得删除
                        getlist('init');
                    }
                });
                


                
            }else if (type == "update"){
                //修改 checkboxs.val()
                //alert(params);
                var fmsg = $("#userform").serializeArray();
                var subFieldV = "";

                for(var j=4;j<fmsg.length;j++){
                    subFieldV += fmsg[j].name + "='" + fmsg[j].value + "'";
                    if (j < fmsg.length-1) {
                        subFieldV += ',';
                    }
                }

                $.ajax({
                       
                    url:addr+"/api/dataset/"+mainTableName+"/"+id+"?tableName="+tableName+"&subFieldV="+subFieldV,
                    type:'PUT',
                    contentType:"application/json; charset=UTF-8",
                    success:function (data) {
                        getlist('init');
                        layer.msg("zx:"+subFieldV); //测试完毕记得删除
                    }
                });



            }
            layer.closeAll();
        } ,
        btn2: function(index, layero){
            $('#usadd input').val("");
            return false //开启该代码可禁止点击该按钮关闭
        } ,
        btn3: function(index, layero){
            // $('#userform').reset;
            // return false 开启该代码可禁止点击该按钮关闭
        }

    });
}

//修改密码弹窗
function layerfnEditPwd(htmlstr, title, id) {
    layer.open({
        type: 1,
        title: title,
        skin: 'ayui-layer-molv,demo-class', //加上边框
        area: ['500px', '350px'], //宽高
        content: htmlstr,
        anim: 2, //弹出动画
        shadeClose: false, //开启遮罩关闭
        btn: ['提交', '重置', '关闭'],
        btnAlign: 'b',
        btn1: function (index, layero) {
            if($("#pwd").val()==null || $("#newPwd").val() == null || "" == $("#pwd").val() || ""==$("#newPwd").val()){
                layer.msg("密码不能为空");
            }else {
                if($("#pwd").val() == $("#newPwd").val()){
                    var params = "{";
                    params += '"usid":"' + id + '"'+ ",";
                    params += '"password":"' + $("#pwd").val() + '"';
                    params += '}';

                    addlist(addr + "/api/sys/tuser", "PUT", params);
                    layer.closeAll();

                }else {
                    layer.msg("密码不一致");
                }
            }
        },
        btn2: function (index, layero) {
            return false //开启该代码可禁止点击该按钮关闭
        },
        btn3: function (index, layero) {
//                $('#userform').reset;
            //return false 开启该代码可禁止点击该按钮关闭
        }

    });

}

function layerfnSubUserTable(htmlstr, title){
    layer.open({
        type: 1,
        title: title,
        skin: 'ayui-layer-molv,demo-class', //加上边框
        area: ['700px', '500px'], //宽高
        content: htmlstr,
        anim: 2, //弹出动画
        shadeClose: false//, //开启遮罩关闭
        //  btn: ['提交', '重置', '关闭'],
    });
}

//弹窗-新增字段信息
function layerfnFieldAdd(htmlstr,title,type) {
    var ttt = layer.open({
        type: 1,
        title:title,
        skin: 'ayui-layer-molv,demo-class', //加上边框
        area: ['500px', '480px'], //宽高
        content: htmlstr,
        anim: 2, //弹出动画
        shadeClose: false, //开启遮罩关闭
        btn: [ '提交','重置', '关闭'],
        btnAlign:'b',
        btn1: function(index, layero){
            var fmsg = $("#fieldform").serializeArray();
            var params ="{";
            for(var i in fmsg){
                if(fmsg[i].name=="fieldName"){
                    params += '"' + fmsg[i].name + '":"' + fmsg[i].value.toUpperCase() + '"';
                }else if(fmsg[i].name=="fieldLength" && fmsg[3].name != "DATE" ){
                    params += '"' + fmsg[i].name + '":' + fmsg[i].value;
                }
                else{
                    params += '"' + fmsg[i].name + '":"' + fmsg[i].value + '"';
                }
                if (i < fmsg.length - 1) {
                    params += ',';
                }
            }
            var createTime = getNowFormatDate();
            params +=',"createTime":"'+createTime+'","tableName":"'+tableName+'"';
            params += "}";

            if (type == "add") {
                //增加
                addFieldList(addr+"/api/datatable","POST",params);
            }else if (type == "update"){
                //修改
                //alert(params);
                addFieldList(addr+"/api/datatable","PUT",params);
            }
            layer.close(ttt);
        } ,
        btn2: function(index, layero){
            $('#propertyAdd input').val("");
            return false //开启该代码可禁止点击该按钮关闭
        } ,
        btn3: function(index, layero){
//                $('#userform').reset;
            //return false 开启该代码可禁止点击该按钮关闭
        }

    });
}

//增
function addlist(url,type,param) {
console.log(param);
    $.ajax({
        url:url,
        type:type,
        data: param,
        contentType:"application/json; charset=UTF-8",
        success:function (data) {
            if(data.ok){
                pageNo =1;
                getlist('init');
            }
        }
    });
}

//增字段
function addFieldList(url,type,param) {
    // param  = JSON.stringify(param);
    //alert(param);
    $.ajax({
        url:url,
        type:type,
        data: param,
        contentType:"application/json; charset=UTF-8",
        success:function (data) {
            //alert(data.ok);
            if(data.ok){
                pageNo =1;
                getfieldlist('init');
                bindHeader('init');
                getlist('init');
                //  alert(1);
            }
            else{
                if(type=="PUT"){
                     layer.msg("对不起！该字段所在列存在数据，不能修改类型和默认值！");
                }else{
                    layer.msg("22222"+param);
                }
            }
        }
    });
}

function getform(id,htmlstr,title){

    $.ajax({
        url: addr + "/api/dataset/"+mainTableName+"/usid='"+ id+"'?tableName="+tableName,
        //url: addr + "/api/dataset/"+mainTableName+"/"+ id +"?tableName="+tableName,
        type: "GET",
        success:function (data) {
            layerfn(htmlstr,title,"update",id); //修改用户信息
            // alert(JSON.stringify(data.data.userInfo[0]));
            loadData(data.data.dataSetList[0]);
            //console.log( data);
        },
        fail:function (data) {
            return htmlstr= "";
        }
    });
}

//查看信息
function getformView(id, htmlstr, title) {
    $.ajax({
        url: addr + "/api/dataset/"+mainTableName+"/USID='"+id+"'?tableName="+tableName,
        type: "GET",
        
        success: function (data) {
            
            //查看用户信息
            layerfn(htmlstr, title, "userMessage",id);
            //loadDataView(data.data.userInfo[0]);
            loadDataView(data.data.dataSetList[0]);
        },
        error: function (data) {
            console.log(url);
            layer.msg("获取信息失败")
        },
        beforeSend: function () {
            ShowDiv();
        },
        complete: function () {
            HiddenDiv();
        }
    });
}
/*************弹窗-字段修改窗口*******************/
function getfieldform(id,htmlstr,title){

    $.ajax({
        url: addr + "/api/datatable/"+ id,
        type: "GET",
        success:function (data) {
            layerfnFieldAdd(htmlstr,title,"update");
            // alert(JSON.stringify(data.data.userInfo[0]));
            loadData(data.data);
            //console.log( data);
        },
        fail:function (data) {
            return htmlstr= "";
        }
    });
}
/**************查看字段信息*********************/
function getfieldformView(id, htmlstr, title) {
    $.ajax({
        url: addr + "/api/datatable/"+ id,
        type: "GET",
        success: function (data) {
            layerfnFieldAdd(htmlstr, title, "fieldMessage");
            loadDataView(data.data);
        },
        error: function (data) {
            layer.msg("获取信息失败")
        },
        beforeSend: function () {
            ShowDiv();
        },
        complete: function () {
            HiddenDiv();
        }
    });
}

//    加载修改弹窗的相应信息
function loadData(obj) {
    var key, value, tagName, type, arr;
    $("#passwordDiv").hide();
    // alert(obj.length);
    for (x in obj) {
        key = x;
        value = obj[x];
        $("[name='" + key + "'],[name='" + key + "[]']").each(function () {
            tagName = $(this)[0].tagName;
            type = $(this).attr('type');
            if (tagName == 'INPUT') {
                if (type == 'radio') {
                    $(this).attr('checked', $(this).val() == value);
                } else if (type == 'checkbox') {
                    arr = value.split(',');
                    for (var i = 0; i < arr.length; i++) {
                        if ($(this).val() == arr[i]) {
                            $(this).attr('checked', true);
                            break;
                        }
                    }
                }else {
                    $(this).val(value);
                    if(key=="PASSWORD"){
                        $(this).val("");
                    }
                }
            } else if (tagName == 'SELECT') {
                //alert($(this)[0].id);
                var select_id = $(this)[0].id;
                $("#"+select_id).val(value);
                //  $(this).val(value.split(',')).select2(); //.trigger("change")s
            } else if (tagName == 'TEXTAREA') {
                $(this).val(value);
            }
            $(this).attr("disabled", false);
        });
    }
}

//  加载查看弹窗的相应信息
function loadDataView(obj) {
    var key, value, tagName, type, arr;
    for (x in obj) {
        key = x;
        value = obj[x];
        $("[name='" + key + "'],[name='" + key + "[]']").each(function () {
            tagName = $(this)[0].tagName;
            type = $(this).attr('type');
            if (tagName == 'INPUT') {
                if (type == 'radio') {
                    $(this).attr('checked', $(this).val() == value);
                } else if (type == 'checkbox') {
                    arr = value.split(',');
                    for (var i = 0; i < arr.length; i++) {
                        if ($(this).val() == arr[i]) {
                            $(this).attr('checked', true);
                            break;
                        }
                    }
                }else {
                    $(this).val(value);
                }
            } else if (tagName == 'SELECT') {
                var select_id = $(this)[0].id;
                $("#"+select_id).val(value);
                // $(this).val(value.split(',')).select2(); //.trigger("change")s
            } else if (tagName == 'TEXTAREA') {
                $(this).val(value);
            }
            //只读
            $(this).attr("disabled", true);

        });
    }
}



function dellist(id) {
    layer.confirm('您确定删除勾选的用户吗？', {
        btn: ['删除','取消'] //按钮
    }, function(){
        ShowDiv();
        $.ajax({
            // url:addr+'/api/sys/tuser/'+id,
            // DELETE /api/dataset/{mainTableName}/{id}
            url:addr+'/api/dataset/'+mainTableName+'/'+id+'?tableName='+tableName,
            type:'DELETE',
            success:function (data) {
                if(data.ok){
                    layer.msg("删除成功！");
                    HiddenDiv();
                    getlist('init');
                }

            }
        });
    });
}
//删除字段信息
function delfield(id) {
    layer.confirm('您确定删除勾选的字段吗？', {
        btn: ['删除','取消'] //按钮
    }, function(){
        ShowDiv();
        $.ajax({
            url:addr+'/api/datatable/'+id,
            type:'DELETE',
            success:function (data) {
                if(data.ok){
                    layer.msg("删除成功！");
                    HiddenDiv();
                    getfieldlist('init');
                    bindHeader('init');
                    getlist('init');
                }

            }
        });
    });
}

//显示加载数据
function ShowDiv() {
    index = layer.load(1, {shade: [0.8, '#ccc'],content:'玩命同步中...',success: function(layero){
        layero.find('.layui-layer-content').css({'padding-top': '40px','width':'150px'});
    }})
}

function HiddenDiv() {
    layer.close(index);
}
//获取当前的日期时间 格式“yyyy-MM-dd HH:MM:SS
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}

