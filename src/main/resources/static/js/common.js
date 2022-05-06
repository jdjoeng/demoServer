var ajaxCallGet = function(url, data, callback) {

    $.ajax({
        url: url, // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
        data: data, // HTTP 요청과 함께 서버로 보낼 데이터
        beforeSend:function(){
            //console.log('시작');
        },
        method: "GET", // HTTP 요청 메소드(GET, POST 등)
        dataType: "json", // 서버에서 보내줄 데이터의 타입
        success: callback
    })
    .done(function(json) { // HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
        //console.log(json);
    })
    .fail(function(xhr, status, errorThrown) { // // HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
        /**
         * status : 상태
         * errorThrown : 오류명
         */
        alert('오류가 발생하였습니다.');
    })
    .always(function(xhr, status) {
        //$("#text").html("요청이 완료되었습니다!");
        //console.log('end : ' + status);
    });
};

var ajaxCallFilePost = function(url, data, callback) {

    $.ajax({
        url: url, // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
        data: data, // HTTP 요청과 함께 서버로 보낼 데이터
        beforeSend:function(){
            //console.log('시작');
        },
        method: "POST", // HTTP 요청 메소드(GET, POST 등)
        processData: false,
        contentType: false,
        crossDomain: true,
        success: callback
    })
    .done(function(json) { // HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
        //console.log(json);
    })
    .fail(function(xhr, status, errorThrown) { // // HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
        /**
         * status : 상태
         * errorThrown : 오류명
         */
        alert('오류가 발생하였습니다.');
    })
    .always(function(xhr, status) {
        //$("#text").html("요청이 완료되었습니다!");
        //console.log('end : ' + status);
    });
}

