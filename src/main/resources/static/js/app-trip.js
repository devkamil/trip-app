var app = angular.module('trip-app', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);


app.controller('mainController', function ($scope, $http, $window) {
    $http.get("api/trips")
        .then(function(response) {
            $scope.trips = response.data;
    });

   $scope.addTrips=function() {
        $http({
              method: 'POST',
              url: 'api/trips',
              data: {"name":$scope.name, "routeLength":$scope.routeLength, "startsFrom":$scope.startsFrom, "finish":$scope.finish, "dateFrom":$scope.dateFrom, "dateTo":$scope.dateTo, "days":$scope.days, "difficult":$scope.difficult},
              headers: {'Content-Type':'application/json'}
        })
   };

   $scope.reloadPage = function(){
        $window.location.reload();
   };

   $scope.removeTrip=function(id) {
        $http({
            method: 'DELETE',
            url: 'api/trips/' + id
   })};

   $scope.editTrip = function(trip) {
        $http({
            method: 'PUT',
            url: 'api/trips/' + trip.id,
             data: {"id":trip.id, "name":trip.name, "routeLength":trip.routeLength, "startsFrom":trip.startsFrom, "finish":trip.finish, "dateFrom":trip.dateFrom, "dateTo":trip.dateTo, "days":trip.days, "difficult":trip.difficult},
             headers: {'Content-Type':'application/json'}
   })};


    $scope.openFrom = function() {
        $scope.popupFrom.opened = true;
    };

    $scope.openTo = function() {
        $scope.popupTo.opened = true;
    };

    $scope.openSearchFrom = function() {
        $scope.popupSearchFrom.opened = true;
    };

    $scope.openSearchTo = function() {
        $scope.popupSearchTo.opened = true;
    };

    $scope.popupFrom = {
        opened: false
    };

    $scope.popupTo = {
        opened: false
    };

    $scope.popupSearchFrom = {
        opened: false
    };

    $scope.popupSearchTo = {
        opened: false
    };

  $scope.dateOptions = {
    startingDay: 1,
    showWeeks: false
  };

    $scope.trips = function(){
        $http.get("api/trips")
            .then(function(response) {
                    response = response.data;
     })};

    $scope.editingTrip = {};

    for (var i = 0, length = $scope.trips.length; i < length; i++) {
      $scope.editingTrip[$scope.trips[i].id] = false;
    }

    $scope.modify = function(trip){
        $scope.editingTrip[trip.id] = true;
    };


});



app.filter('isDifficult', function() {
    return function (text) {
        return text ? "Tak" : "Nie";
     }
});


app.filter("myfilter", function() {
      return function(items, from, to) {
            if(from===undefined && to===undefined){
                return items;
            }

            var result = [];
            for (var i=0; i<items.length; i++){
                if(from===undefined && items[i].dateTo <= to){
                    result.push(items[i]);
                } else if (items[i].dateFrom >= from && to===undefined){
                    result.push(items[i]);
                } else if (items[i].dateFrom >= from && items[i].dateTo <= to)  {
                    result.push(items[i]);
                }
            }
            return result;
      };
});