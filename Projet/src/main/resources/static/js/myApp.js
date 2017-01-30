var app=angular.module("MaBourse",[]);
var url="http://localhost:8080";
app.controller("myController",function($scope,$http){
	
	$scope.societe=null;
	$scope.code=null;
	
	$scope.pageOrdre=null;
	$scope.pageCourante=0;
	$scope.size=3;
	$scope.pages=[];
	
	$scope.TotalAchat;
	$scope.TotalVente;
	
	$scope.MoyenVente;
	$scope.MoyenAchat;
	
	$scope.EstimationVente;
	$scope.EstimationAchat;
	
	$scope.chargerSociete=function(){
		//Charger La Societe
		$http.get("/societe/"+$scope.code)
		.success(function(data){
			$scope.societe=data;
		});
		//Récuperer le Calcule
		$http.get("totalAchat/"+$scope.code).success(function(data){ $scope.TotalAchat=data; });
		$http.get("totalVente/"+$scope.code).success(function(data){ $scope.TotalVente=data; });
		$http.get("MoyenAchat/"+$scope.code).success(function(data){ $scope.MoyenAchat=data; });
		$http.get("MoyenVente/"+$scope.code).success(function(data){ $scope.MoyenVente=data; });
		$http.get("EstimationAchat/"+$scope.code).success(function(data){ $scope.EstimationVente=data; });
		$http.get("EstimationVente/"+$scope.code).success(function(data){ $scope.EstimationAchat=data; });
		$http.get("PageOrdres?code="+$scope.code+"&page="+$scope.pageCourante+"&size="+$scope.size).success(function(data){
			$scope.pageOrdre=data;
			$scope.pages=new Array(data.totalPages);
		}); 
	};
	$scope.goToPage=function(p){
		$scope.pageCourante=p;
		$scope.chargerSociete();
	};
});

