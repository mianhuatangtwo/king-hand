/**
 * register
 */
$(function(){
	
});

$("#registerForm").validate({
	 rules: {
		 userName: {
			 required:true
		 },
		 pwd: {
			 required:true
		 },
		 pwda: {
			 required:true,
			 equalTo:"#pwd"
		 }
	},
	messages: {
		userName: {
			required: "请输入用户名",
		},
		pwd: {
			required: "请输入密码",
		},
		pwda: {
			required: "请再次输入密码",
			equalTo:"两次密码输入的不一致"
		}
	}
});
//form submit valid
var checkForm = function(){
	 if(!$("#registerForm").valid()){
		 return false;
	 }	
};