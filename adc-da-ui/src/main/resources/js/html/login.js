var Login = function () {
    //用户名密码输入后台交互操作
    var verifyCode = $.cookie('verifyCode') || 0;

    var loginSubmit = function () {
        var pw =$("#password").val();// window.btoa($("#password").val());
        var params={
            "username": $("#username").val(),
            "password": pw,
            "isRememberMe": false
        };
        var user = JSON.stringify(params);

        $.ajax({
            url:addr+"/api/login?username="+$("#username").val()+"&password="+pw,
            type:'GET',
            dataType:'json',
            success:function(data){
                if(data.ok ){
                    var date = new Date();
                    date = date.setTime(date.getTime()+30*60*60*1000);
                    params["userid"]= data.data.usid;
                    user = JSON.stringify(params);
                    $.cookie('mycookie', user, {path: '/',expires: 1});
                    window.location.href = "index.html";
                }else if(data.respCode =="0002"){
                    // $("#verifyBox").show();
                    // params.verifyCode = $("#verifyCode").val();
                    // getvCode();
                }else{
                    // verifyCode ++;
                    $('.alert-nouser', $('.login-form')).show();
                    $('.alert-nouser').html('<button class="close" data-dismiss="alert"></button><span>'+data.message+'.</span>')
                }
                /*if(verifyCode >3){
                    $("#verifyBox").show();
                    getvCode();
                }*/
            },
            error: function(e) {
                console.log(e);
            }
        });

    };

    // base64加密开始
    function encode64(input) {
        var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"
            + "wxyz0123456789+/" + "=";
        var output = "";
        var chr1, chr2, chr3 = "";
        var enc1, enc2, enc3, enc4 = "";
        var i = 0;
        do {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);
            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;
            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }
            output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)
                + keyStr.charAt(enc3) + keyStr.charAt(enc4);
            chr1 = chr2 = chr3 = "";
            enc1 = enc2 = enc3 = enc4 = "";
        } while (i < input.length);

        return output;
    }
    // base64加密结束

    var getvCode = function () {
        var oReq = new XMLHttpRequest();
        oReq.open("GET", addr + "/api/verifyCode?_ts="+timestamp, true);
        oReq.responseType = "blob";
        oReq.onreadystatechange = function () {
            if (oReq.readyState == oReq.DONE) {
                var blob = oReq.response;
                console.log(blob);
                document.getElementById("verifyimg").src = URL.createObjectURL(blob);
            }
        };
        oReq.send();
    };
    return {
        //main function to initiate the module
        init: function () {
            //登录页面
            $('.login-form').validate({
                errorElement: 'label', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                rules: {
                    username: {
                        required: true
                    },
                    password: {
                        required: true,
                        rangelength:[6,12],
                        // regpassword:true
                    },
                    remember: {
                        required: false
                    }
                },
                messages: {
                    username: {
                        required: "用户名是必填项."
                    },
                    password: {
                        required: "密码是必填项."
                    }
                },
                invalidHandler: function (event, validator) { //display error alert on form submit
                    $('.alert-error', $('.login-form')).show();
                },
                highlight: function (element) { // hightlight error inputs
                    $(element).closest('.control-group').addClass('error');
                    // set error class to the control group
                },
                success: function (label) {
                    label.closest('.control-group').removeClass('error');
                    label.remove();
                },

                errorPlacement: function (error, element) {
                    error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
                },

                submitHandler: function (form) {
                    loginSubmit();
                }
            });

            $('.login-form input').keypress(function (e) {
                if (e.which == 13) {
                    if ($('.login-form').validate().form()) {
                        loginSubmit();
                    }
                    return false;
                }
            });

            /**  忘记密码  **/
            $('.forget-form').validate({
                errorElement: 'label', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    email: {
                        required: true,
                        email: true
                    }
                },

                messages: {
                    email: {
                        required: "邮箱是必填项."
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit

                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.control-group').addClass('error'); // set error class to the control group
                },

                success: function (label) {
                    label.closest('.control-group').removeClass('error');
                    label.remove();
                },

                errorPlacement: function (error, element) {
                    error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
                },

                submitHandler: function (form) {
                    //忘记密码
                    var reEmail= $("#fgemail").val();
                    $.ajax({
                        url:addr+"/login",//?usname=admin&password=123
                        type:'post',
                        dataType:'json',
                        data: {email:reEmail},
                        // data:{usname:'admin',password:'123'},
                        success:function(data){
                            console.log(data);
                            if(data.respCode == '99'){
                                $('.alert-nouser', $('.login-form')).show();
                            }else if(data.respCode  == "00"){
                                window.location.href = "index.html?usname="+$("#username").val()+"&password="+$('#password').val();
                            }

                        }
                    });

                }
            });

            $('.forget-form input').keypress(function (e) {
                if (e.which == 13) {
                    if ($('.forget-form').validate().form()) {
                        //忘记密码
                        console.log('138');
                        $("#fgemail").val();

                    }
                    return false;
                }
            });

            jQuery('#forget-password').click(function () {
                jQuery('.login-form').hide();
                jQuery('.forget-form').show();
            });

            jQuery('#back-btn').click(function () {
                jQuery('.login-form').show();
                jQuery('.forget-form').hide();
            });
            //注册页面

            $('.register-form').validate({
                errorElement: 'label', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    username: {
                        required: true
                    },
                    password: {
                        required: true ,
                        // rangelength: [6,12],
                        // regpassword: true
                    },
                    rpassword: {
                        equalTo: "#register_password"
                    }
                },

                messages: { // custom messages for radio buttons and checkboxes
                    // tnc: {
                    //     required: "Please accept TNC first."
                    // }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit

                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.control-group').addClass('error'); // set error class to the control group
                },

                success: function (label) {
                    label.closest('.control-group').removeClass('error');
                    label.remove();
                },

                errorPlacement: function (error, element) {
                    if (element.attr("name") == "tnc") { // insert checkbox errors after the container
                        error.addClass('help-small no-left-padding').insertAfter($('#register_tnc_error'));
                    } else {
                        error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
                    }
                },

                submitHandler: function (form) {
                    var jform = $(form).serializeArray();
                    // console.log(jform.serializeArray());
                    var url = addr+"/api/sys/user", type = "POST";
                    var params ="{";
                    for(var i in jform){
                        params+="\""+ jform[i].name+"\":\""+jform[i].value+"\"" ;
                        if(i<jform.length-1){params +=',';}
                    }
                    params += "}";
                    console.log( params);
                    /*$.ajax({
                     url:url,
                     type:type,
                     data: param,
                     contentType:"application/json; charset=UTF-8",
                     success:function (data) {
                     if(data.ok){
                     layer.msg(msg+'成功！');
                     }
                     },
                     error:function (data) {
                     layer.msg(msg+'失败！');
                     }
                     });*/


                }
            });

            jQuery('#register-btn').click(function () {
                jQuery('.login-form').hide();
                jQuery('.register-form').show();
            });

            jQuery('#register-back-btn').click(function () {
                jQuery('.login-form').show();
                jQuery('.register-form').hide();
            });

            $.backstretch([
                "../images/bg/6.jpg",
                "../images/bg/8.jpg"
            ], {
                fade: 1000,
                duration: 8000
            });
        }

    };

}();