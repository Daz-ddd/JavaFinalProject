$(document).ready(function e) {
	$(".submit-one").click(function() {
			if ($(".password").val() != $(".repassword").val()) {
				alert("密码不一致，请重新输入！");
				$(".password").val(null);
			})
	}
}
