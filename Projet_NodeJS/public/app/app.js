var app=angular.module("MaBourse",['ui.router']);
var clientSocket=io.connect("http://localhost:8081");
 app.controller('HomeController',function($scope){
	 	$scope.societe= null;
		$scope.code="";
		$scope.pageOrdre=[];
		$scope.pageCourante=0;
		$scope.size=3;
		$scope.pages=[];
		$scope.chargerSociete=function(){
			//Charger La Societe
			clientSocket.emit('chargerSociete',{code:$scope.code});
			clientSocket.on('societeLoaded',function(data){
				$scope.societe=data.societe;
			});		
			clientSocket.emit('chargerOrdres',{code:$scope.code,page:$scope.pageCourante,size:$scope.size});
			clientSocket.on('ordresLoaded',function(data){
				console.log(data.ordres)
				$scope.pageOrdre=data.ordres;
				$scope.pages=new Array(data.totalPages);
			});
		}
		$scope.goToPage=function(p){
			$scope.pageCourante=p;
			$scope.chargerSociete();
		}
 });