
$(function(){
    호출();
})


function 작성() {
    $.ajax({
        url: 'save',
        data: {"content" : $("#content").val()},
        success: function(re){
            alert("java 와 통신결과 " + re);
        }
    })
}
let list = [];
function 호출(){
    $.ajax({
    url:'getlist',
    success: function(re){
       list = re;
       console.log(list)
       let html =
        '<tr>'+
                '<th>번호</th><th>내용</th><th>비고</th>'+
        '</tr>';
        for ( let i = 0; i<list.length; i++){
            html +=
                   '<tr>'+
                        '<td>'+list[i]["no"]+'</td>' +
                        '<td>'+list[i]["content"]+'</td>' +
                        '<td><button onclick="수정('+ list[i]["no"] + ')">수정</button><button onclick="삭제('+ list[i]["no"] + ')">삭제</button></td>'+
                    '</tr>';
        }
        $("#viewtable").html(html);
    }
    });
}

function 삭제(no) {


    $.ajax({
        url:"delete",
        data: {"no" : no} ,
        success: function(re){
                    if(re == "1") {alert("삭제 성공");}
                    else{alert("삭제 실패")
                    호출();
                    }
                }
    })
}


function 수정(no) {

    $.ajax({
       url:"update",
       data:{"no" : no,
                "content" : $("#content").val()},
       success: function(re){
            if(re == "1") {alert("수정 성공");}
            else{alert("수정실패")
            호출();
            }
        }
})
}