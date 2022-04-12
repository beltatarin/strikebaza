
function validateForm() {
	var userName = document.getElementById("userName");
    var passFirst = document.getElementById("pass");
    var passSecond = document.getElementById("pass2");
    var email = document.getElementById("email");
    var userNameErr = document.getElementById("userName_err");
    var tel = document.getElementById("tel");
    var emailErr = document.getElementById("email_err");
    var passErr = document.getElementById("pass_err");
    var passErr2 = document.getElementById("pass_err2");
    var telErr = document.getElementById("tel_err");

    userName.addEventListener('focus', function () {
        userNameErr.style.display = "none";
    });
    email.addEventListener('focus', function () {
        emailErr.style.display = "none";
    });

    passFirst.addEventListener('focus', function () {
        passErr.style.display = "none";
    });
    
    passSecond.addEventListener('focus', function () {
        passErr2.style.display = "none";
    });
    
    tel.addEventListener('focus', function () {
        telErr.style.display = "none";
    });
    
    if (!/\S/.test(userName.value)) {
        userNameErr.style.display = "block";
        return false;
    }
    if (passFirst.value.length < 6) {
        passErr.style.display = "block";
        return false;
    }

    if (!/\d/.test(passFirst.value) || !/[A-Z]/.test(passFirst.value) || !/[a-z]/.test(passFirst.value)) {
        alert("Пароль должен быть латинскими буквами и содержать хотя бы одну цифру, букву в верхнем регистре и букву в нижнем регистре");
        return false;
    }
    
    
    if (passFirst.value !== passSecond.value) {
        passErr2.style.display = "block";
        return false;
    }
   
    if (!/^[\w.-]{3,}@{1}[\w+.-].{1}[\w.-]+$/.test(email.value)) {
        emailErr.style.display = "block";
        return false;
    }
    if (tel.value.length < 12 || tel.value.length > 12) {
        telErr.style.display = "block";
        return false;
    }
    return true;
}
