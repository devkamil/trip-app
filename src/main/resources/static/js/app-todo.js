var app = angular.module('todo-app', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);


app.controller('mainController', function ($scope, $http, $window) {
    $http.get("api/todos")
        .then(function(response) {
            $scope.todos = response.data;
    });

   $scope.addTodos=function() {
        $http({
              method: 'POST',
              url: 'api/todos',
              data: {"name":$scope.name, "routeLength":$scope.routeLength, "startsFrom":$scope.startsFrom, "finish":$scope.finish, "dateFrom":$scope.dateFrom, "dateTo":$scope.dateTo, "days":$scope.days, "difficult":$scope.difficult},
              headers: {'Content-Type':'application/json'}
        })
   };

   $scope.reloadPage = function(){
        $window.location.reload();
   };

   $scope.removeTodo=function(id) {
        $http({
            method: 'DELETE',
            url: 'api/todos/' + id
   })};

   $scope.editTodo = function(tod) {
        $http({
            method: 'PUT',
            url: 'api/todos/' + tod.id,
             data: {"id":tod.id, "name":tod.name, "routeLength":tod.routeLength, "startsFrom":tod.startsFrom, "finish":tod.finish, "dateFrom":tod.dateFrom, "dateTo":tod.dateTo, "days":tod.days, "difficult":tod.difficult},
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

    $scope.todos = function(){
        $http.get("api/todos")
            .then(function(response) {
                    response = response.data;
     })};




//     $scope.selectStartDate = function(value){
//        $scope.filterByStartDate = value;
//        console.log("VALUE selectStartDate: ", value)
//     }

//  $scope.selectName = function(value){
//     $scope.filterByName = value;
//  }




    $scope.editingTodo = {};

    for (var i = 0, length = $scope.todos.length; i < length; i++) {
      $scope.editingTodo[$scope.todos[i].id] = false;
    }

    $scope.modify = function(tod){
        $scope.editingTodo[tod.id] = true;
    };


});



app.filter('isDifficult', function() {
    return function (text) {
        return text ? "Tak" : "Nie";
     }
});

//
//app.filter('dateFormat', function($filter)
//    {
//        return function(input)
//        {
//            if(input == null){ return ""; }
//            var _date = $filter('date')(new Date(input), 'yyyy-MM-dd');
//            return _date.toUpperCase();
//        };
//    });
//

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