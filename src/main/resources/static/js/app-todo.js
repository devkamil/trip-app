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
              data: {"content":$scope.content, "date":$scope.date, "done":$scope.done},
              headers: {'Content-Type':'application/json'}

        })

         };

   $scope.reloadPage = function(){$window.location.reload();};



   $scope.removeTodo=function(id) {
        $http({
            method: 'DELETE',
            url: 'api/todos/' + id
   })};


    $scope.editTodo = function(tod) {
        $http({
            method: 'PUT',
            url: 'api/todos/' + tod.id,
             data: {"id":tod.id, "content":tod.content, "date":tod.date, "done":tod.done},
             headers: {'Content-Type':'application/json'}
    })};



    $scope.open = function() {
        $scope.popup.opened = true;
    };

    $scope.popup = {
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


    $scope.editingTodo = {};

    for (var i = 0, length = $scope.todos.length; i < length; i++) {
      $scope.editingTodo[$scope.todos[i].id] = false;
    }

    $scope.modify = function(tod){
        $scope.editingTodo[tod.id] = true;
    };


});



app.filter('doneUndone', function() {
    return function (text) {
        return text ? "Done" : "Undone";
     }
});
