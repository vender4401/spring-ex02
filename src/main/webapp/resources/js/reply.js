//

var replyService = (function() {

	function addMethod(test, good, miss) {
		console.log("add1 method");
		console.log(test);
		
		$.ajax({
			type: "post",
			url: "/replies/new",			// context root로 변경
			data: JSON.stringify(test),		// form data를 json으로
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr) {
				if(good) {
				good(result);
				}
			},
			error: function(xhr, status, er) {
				if(miss) {
				miss(er);
				}
			}
		})
	}
	
	function getListMethod(param, callback, error) {
		var bno = param.bno;
		var page = param.page || 1;	
		// javascript
		// boolean false : 0, "", null, undefined	
	
		$.getJSON("/replies/pages/" + bno + "/" + page, function(data) {
			if(callback) {
				callback(data);
			}
		}).fail(function(xhr, status, err) {
			if(error) {
				error();
			}
		});		
	}
	
	
	function removeMethod(rno, callback, error) {
		$.ajax({
			type: "delete",
			url: appRoot + "/replies/" + rno,
			success: function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if(error) {
				error(er);
				}
			}
		})
	}
	
	function updateMethod(reply, callback, error) {
		$.ajax({
			type: "put",
			url: "/replies/" + reply.rno,
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		})
	}
	
	function getMethod(rno, callback, error) {
		$.get('/replies/' + rno, function(data) {
			if (callback) {
				callback(data);
			}
		}).fail(function() {
			if (error) {
				error();
			}
		});
	}
	
	
	return {
		add: addMethod,
		getList: getListMethod,
		remove: removeMethod,
		update: updateMethod,
		get: getMethod
		};
	
})();

	