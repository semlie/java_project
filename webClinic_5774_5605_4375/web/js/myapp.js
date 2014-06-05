/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

var app = angular.module('javapro',['ngRoute']);
app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/home', {
        templateUrl: 'partials/home.html',
        controller: 'CtrlHome'
      }).
      when('/service', {
        templateUrl: 'partials/service.html',
        controller: 'CtrlService'
      }).
      when('/users/:userID', {
        templateUrl: 'partials/users-detels.html',
        controller: 'CtrlUsersDetels'
      }).
      when('/users/', {
        templateUrl: 'partials/users.html',
        controller: 'CtrlUsers'
      }).
      when('/meeting/', {
        templateUrl: 'partials/metting.html',
        controller: 'CtrlMeeting'
      }).
      otherwise({
        redirectTo: '/home'
      });
  }]);
app.controller('CtrlHome',['$scope',function ($scope){
      $scope.name="home";
}]);
app.controller('CtrlService',['$scope',function ($scope){
      $scope.name="CtrlService";
}]);
app.controller('CtrlUsers',['$scope',function ($scope){
      $scope.name="CtrlUsers";
}]);
app.controller('CtrlUsersDetels',['$scope',function ($scope){
      $scope.name="CtrlUsersDetels";
}]);
app.controller('CtrlMeeting',['$scope',function ($scope){
      $scope.name="CtrlMeeting";
}]);