/**
 * 
 */

function ProfileController($scope, $http) {
    $scope.goProfile = function () {
    	
    	    $http.get("http://localhost:8080/booksandmusicstack/user/profile/")
    	    .success(function(response) {
    		    console.log(response);
    	    });
    	
    }

    /*$scope.addstock = function () {
        var value = new Object();
        value.stock = $scope.stock;
        value.stock.UserId = $('#ValueHiddenField').val();
        $http.post("/home/srithar/projects/MarketPortfolio/ReceiveQuote.aspx/AddStock", JSON.stringify(value)).
            success(function (data) {
                if (data.d == null) {
                    alert("the selected stock has been added to the database to the User Portfolio");
                    location.reload();
                } else {
                    alert("There has been some error. Please contact the System Administrator");
                }
            });
    }*/
}