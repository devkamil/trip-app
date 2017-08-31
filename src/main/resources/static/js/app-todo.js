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


//    $scope.modify = function(tod){
//        $scope.modifyField = true;
//        $scope.viewField = true;
//    };



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




//    $scope.update = function(tod) {
//        $scope.modifyField = false;
//        $scope.viewField = false;
//    };

//    $scope.update = function(tod){
//        $scope.editingTodo[tod.id] = false;
//    };







});









//    $scope.inlineOptions = {
//        customClass: getDayClass,
//        minDate: new Date(),
//        showWeeks: true
//    };
//
//    $Scope.dateOptions = {
//        formatYear: 'yy',
//        maxDate: new Date(2020, 5, 22),
//        minDate: new Date(),
//        startingDay: 1
//    };










app.filter('doneUndone', function() {
    return function (text) {
        return text ? "Done" : "Undone";
     }
});




//app.directive('dateFrom', function() {
//    return function(scope, element, attrs) {
//        $(element).datepicker({minDate: currentTime });
//        $(element).change(function () {
//            currentTime = element.val();
//        });


//       return function(){
//            $('datetimepicker4').datetimepicker();
//    };
//});


//
//           $(function () {
//                $('#datetimepicker4').datetimepicker();
//            });