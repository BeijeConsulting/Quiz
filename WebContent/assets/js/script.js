function changeQuestion(url, id, current) {
	fetch('./question/'+id, {
    method: 'post',
    body: JSON.stringify(current)
  }).then(response => response.json()).then(function(json){
		
	})
	
}