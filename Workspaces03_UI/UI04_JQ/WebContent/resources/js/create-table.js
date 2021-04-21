
function makeTable(elem){

	$table = $("<table border=1>");
	
	
	
	for(var i = 0; i < 1; i++){
		$tr = $("<tr>");
		for(var j = 0; j < elem.eq(i).children().length; j++){
			$td = $("<td>").append(elem.eq(i).children().eq(j).prop("tagName"));
			$tr.append($td);
		}
		$table.append($tr);
	}
	
	
	
	for(var i = 0; i < elem.length; i++){
		$tr = $("<tr>");
		for(var j = 0; j < elem.eq(i).children().length; j++){
			$td = $("<td>").append(elem.eq(i).children().eq(j).text());
			$tr.append($td);
		}
		$table.append($tr);
	}
	
	
	
	
	return $table;
	
}