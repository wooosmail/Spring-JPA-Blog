let index = {
    init: function (){
        $("#btn-save").on("click",()=>{
            this.save();
        });

    },

    save: function (){
        //alert("user call ")
        let data = {
            username : $("#username").val(),
            email : $("#email").val(),
            password : $("#password").val()
        }

      //  console.log(data);

        $.ajax({
            type: "POST",
            url:"/auth/joinProc",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json" // 요청을 서버로 해서 응답이 스트링 또는 json 이면 js object으로 변환
        }).done(function (resp) {
            alert("회원가입 완료");
           // console.log(resp);
            location.href="/";
        }).fail(function (error) {
            alert(error);
        });
    },



}

index.init();