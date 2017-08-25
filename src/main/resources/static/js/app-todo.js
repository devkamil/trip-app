var app = angular.module('todo-app', []);

app.controller('mainController', function ($scope, $http) {
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


});