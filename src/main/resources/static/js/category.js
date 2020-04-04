$(function() {
		//■ parent > childの流れ
		$('#inputParentId').on("change", function() {
                var hostUrl = 'http://localhost:8080/category_search/check_parent';
                var inputParentId = $("#inputParentId").val();
                $.ajax({
                        url : hostUrl,
                        type : 'POST',
                        dataType : 'json',
                        data : {
                        	parentId : inputParentId
                        },
                        async: true
                }).done(function(data) {
                        console.log(data);
                        console.dir(JSON.stringify(data));                        
                        $.each(data, function(index, child) {
                        	$("#inputChildId").append("<option value=" + child.id + ">" + child.name + "</option>");
                        });
                }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
                        alert("エラーが発生しました！");
                        console.log("XMLHttpRequest : " + XMLHttpRequest.status);
                        console.log("textStatus     : " + textStatus);
                        console.log("errorThrown    : " + errorThrown.message);
                });
        });
        
      //■ child > grandChildの流れ
        $('#inputChildId').on("change", function() {
            var hostUrl = 'http://localhost:8080/category_search/check_child';
            var inputChildId = $("#inputChildId").val();
            var inputChildName = $("#inputChildName").val();
            $.ajax({
                    url : hostUrl,
                    type : 'POST',
                    dataType : 'json',
                    data : {
                    	childId : inputChildId
                    },
                    async: true
            }).done(function(data) {
                    console.log(data);
                    console.dir(JSON.stringify(data));
                    $.each(data, function(index, grandChild) {
                    	$("#inputGrandChildId").append("<option value="+grandChild.id+">"+grandChild.name+"</option>");
                    });
            }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("エラーが発生しました！");
                    console.log("XMLHttpRequest : " + XMLHttpRequest.status);
                    console.log("textStatus     : " + textStatus);
                    console.log("errorThrown    : " + errorThrown.message);
            });
    });

});