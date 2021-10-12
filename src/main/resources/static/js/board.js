let index = {
    init: function (){
        $("#btn-board-save").on("click",()=>{
            this.save();
        }),
            $("#btn-board-secondary").on("click",()=>{
                this.deleteById();
            });


    },

    save: function (){
        // alert("user call ")
        let data = {
            title : $("#title").val(),
            content : $("#content").val()
        }

      //  console.log(data);

        $.ajax({
            type: "POST",
            url:"/board/saveProc",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json" // 요청을 서버로 해서 응답이 스트링 또는 json 이면 js object으로 변환
        }).done(function (resp) {
            alert("글쓰기 완료");
           // console.log(resp);
            location.href="/";
        }).fail(function (error) {
            alert(error);
        });
    },
    deleteById: function (){
        // alert("user call ")

        //  console.log(data);
        var _url = "/board/" + $("#id").text();
        alert( _url);
        $.ajax({
            type: "DELETE",
            url: _url ,
            dataType: "json" // 요청을 서버로 해서 응답이 스트링 또는 json 이면 js object으로 변환
        }).done(function (resp) {
            // console.log(resp);
            alert(" 삭제 완료 ")
            location.href="/";
        }).fail(function (error) {
            alert(error);
        });
    },


}

index.init();