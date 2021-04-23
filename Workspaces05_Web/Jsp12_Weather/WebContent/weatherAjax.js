$(function() {
	$("#weaView").click(
			function() {
				// servlet
				var url = "weatherOpen";
				// id가 address인 태그의 하위태그중 option에서 선택된것들의 value(값)
				var code = $("#address option:selected").val();
				$.ajax({
					// type : http 요청방식 get, post, put
					type : "GET",
					// 통신할 서버(페이지, 파일) 주소
					url : url + "?code=" + code,
					// dataType : 값을 받을때 타입
					dataType : "text",
					success : function(data) {
						//.trim() 앞뒤 공백 제거
						var temp = $.trim(data);
						//JSON.parse(temp) JSON문자열을 JSON객체로 바꿈 
						var obj = JSON.parse(temp);
						
						// val() -> ()안에 값이 들어가면 값을 넣어주는 것인듯
						$("#pubDate").val(obj.pubDate);
						$("#temp").val(obj.temp);
						$("#x").val(obj.x);
						$("#y").val(obj.y);
						$("#reh").val(obj.reh);
						$("#pop").val(obj.pop);
						$("#wfKor").val(obj.wfKor);

						var weather_condition = obj.wfKor;
						if (weather_condition == "맑음"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/sun.png");
						}else if (weather_condition == "비"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/rain.png");
						}else if (weather_condition == "눈"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/snow.png");
						}else if (weather_condition == "흐림"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/cloud.png");
						}else if (weather_condition == "구름 조금"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/cloud_sun.png");
						}else{
							$("#weather_img").attr("src","/Jsp12_Weather/image/etc.png");
						}
					},
					error : function() {
						alert("정보를 불러오는데 실패하였습니다.");
					}
				});
			});
});
