/**
 * register
 */
$(function(){
	//校验用户名是否存在
	$(document).on('blur','#username',function () {
		var $this = $(this);
		var username = $this.val();
		if(username){
			var callbackFun = function (response) {
				if(response && response.code == '101'){
					if($this.next() && $this.next().length > 0){
                        $this.next().remove();
					}
                }else {
                    $this.after('<label id="username-error" class="error" for="username">用户名已存在</label>');
				}
            }
			ajaxGet("/login/valid/name",{username:username},callbackFun);
		}
    });
});

$("#registerForm").validate({
	 rules: {
         username: {
			 required:true
		 },
		 pwd: {
			 required:true
		 },
		 pwda: {
			 required:true,
			 equalTo:"#pwd"
		 },
         vrifyCode:{
		 	 required:true
		 }
	},
	messages: {
        username: {
			required: "请输入用户名",
		},
		pwd: {
			required: "请输入密码",
		},
		pwda: {
			required: "请再次输入密码",
			equalTo:"两次密码输入的不一致"
		},
        vrifyCode:{
            required: "请输入验证码"
		}
	}
});
//form submit valid
var checkForm = function(){
     if($("#username").next() && $("#username").next().length > 0){
        return false;
     }
	 if(!$("#registerForm").valid()){
		 return false;
	 }
     // $("#errorModal_b").modal({
     //     backdrop : false
     // });
	 //校验验证码是否正确
	 return validCode();
};
/**
 *
 */
function validCode() {
    var callbackFun = function (response) {
		if(response && response.code == '101'){
			if($("#vrifyCode").next() && $("#vrifyCode").next().length > 0){
                $("#vrifyCode").next().remove();
			}
			return true;
		}else {
            if($("#vrifyCode").next() && $("#vrifyCode").next().length > 0){
                $("#vrifyCode").next().remove();
                $("#vrifyCode").after('<label id="vrifyCode-error" class="error" for="vrifyCode">用户名已存在</label>');
            }
			return false;
		}
    }
	ajaxGet("/login/valid/kaptcha",{vrifyCode:encodeURI($("#vrifyCode").val())},callbackFun);
}