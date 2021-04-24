<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우리동네 운동친구∴∵Heath Friends</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<%-- 결제페이지인데 추후에 조금더 자세하게 수정해야함! --%>
    <script>
    $(function(){
        IMP.init('imp30454386'); // 승인key
        var msg;
        var price = 1000000;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card', //카카오페이의 경우 card가 기본
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : 'Health Friends Premium', // 상품이름
            amount : price //가격
        }, function(rsp) {
            if ( rsp.success ) {
                $.ajax({
                	//통신할 서버
                    url: '', 
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid,
                        amount : price
                    }
                });
                //성공시 이동할 페이지
                alert('결제가 완료되었습니다.');
                location=""
            } else {
                //결제가 실패하면 이동할 페이지와 메세지
                msg = '결제에 실패하였습니다.\n';
                msg += '에러내용 : ' + rsp.error_msg; // rsp.error_msg는 실패 내용 출력
                alert(msg);
                location.href="";
            }
        });
    });
    </script>
</body>
</html>