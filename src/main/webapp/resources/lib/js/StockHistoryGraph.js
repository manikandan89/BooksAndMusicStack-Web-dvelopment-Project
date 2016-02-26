$(function () {
    $("#symbolsearch")
        .focus()
        .autocomplete({
            source: function (request, response) {
                $.ajax({
                    beforeSend: function () {
                        $("span.help-inline").show();
                        $("span.label-info").empty().hide();
                    },
                    url: "http://localhost:8080/booksandmusicstack/user/music/album",
                    dataType: "json",
                    data: {
                        input: request.term
                    },
                    success: function (data) {
                    	//console.log("anything");
                    	//alert("every");
                    	//console.log(data);
                        response($.map(data, function (item) {
                            return {
                                label: item.name + " (" + item.type + ")",
                                value: item.id
                            }
                        }));
                        $("span.help-inline").hide();
                    },
                    error: function() {
                    	console.log("error");
                    }
                    //alert("outside");
                });
            },
            minLength: 0,
            select: function (event, ui) {
                console.log(ui.item);
                $("span.label-info").html("You selected " + ui.item.value).fadeIn("fast");
            },
            open: function () {
                $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
            },
            close: function () {
                $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
            }
        });
});

function StockGraphController($scope, $http) {
	console.log("Inside StockGraphController");
    $scope.showquote = function () {
        var dur = 365;
        var id = $scope.equitystock.id;
        console.log($scope.equitystock);
        $http.get("http://localhost:8080/booksandmusicstack/user/music/" + id)
        .success(function(response) {
    	    console.log(response);
    	    $scope.tracks = response;
        });
        
    }
}