// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'


var app=angular.module('starter', ['ionic']);
var url="http://localhost:8080";
app.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    if(window.cordova && window.cordova.plugins.Keyboard) {
      // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
      // for form inputs)
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);

      // Don't remove this line unless you know what you are doing. It stops the viewport
      // from snapping when text inputs are focused. Ionic handles this internally for
      // a much nicer keyboard experience.
      cordova.plugins.Keyboard.disableScroll(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
});
/* Configuration des routes */
app.config(function($stateProvider,$urlRouterProvider){
  $stateProvider.state("Societe",{

    url:"/Societe",
    templateUrl:"/view/Societe.html",
    controller:"SocieteController"
  });
  $stateProvider.state("DetailOrdre",{
    url:"/DetailOrdre/:code",
    templateUrl:"/view/DetailOrdre.html",
    controller:"ALLOrdresController"
  });
  $urlRouterProvider.otherwise("Societe");
});
/* Recuperation de Code de Societe et l'envoyer a la page des Ordres */
app.controller("SocieteController",function($scope,$state){
  $scope.getOrdres=function(CodeSociete){
    $state.go("DetailOrdre",{code:CodeSociete})
  }
});
app.controller("ALLOrdresController",function($scope,$stateParams,$http,$ionicLoading){

  $scope.listOrdres=[];
  $scope.currentPage=-1;
  $scope.size=10;
  $scope.url=url;
  $scope.pageCount=0;

  $ionicLoading.show({
    template:"Chargement en cours"
  });

  $scope.ChargerOrdres=function(page){
    console.log($stateParams.code);
    $http.get(url+"/PageOrdres?code="+$stateParams.code+"&page="+$scope.currentPage+"&size="+$scope.size)
        .success(function(data){
          console.log(data);
          $scope.pageCount=data.totalPages;
          data.content.forEach(function(Ord){
            $scope.listOrdres.push((Ord));
          });
          $ionicLoading.hide();
          $scope.$broadcast('scroll.infiniteScrollComplete');
        })
        .error(function(err) {
          console.log(err);
        } );
}

  $scope.loadMore=function(){
    if($scope.currentPage <= $scope.pageCount) {
      ++$scope.currentPage;
      $scope.ChargerOrdres($scope.currentPage);
    }
    else alert('vous avez '+$scope.pageCount);

  }
});



