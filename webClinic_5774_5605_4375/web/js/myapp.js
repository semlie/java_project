/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

var app = angular.module('javapro', ['ngRoute']);
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


app.factory('Metting', ['$http','$q', function($http,$q) {
         return {
                    getData : function(){
                        var deferred = $q.defer();
                        var promise = $http.get('/webClinic_5774_5605_4375/get.jsp?f=meeting').success(function (data) {
                            deferred.resolve(data);
                            console.log(data);
                        });
                        // Return the promise to the controller
                        return deferred.promise; 
                    }
                };
//            
//         $http({method: 'GET', url: '/webClinic_5774_5605_4375/get.jsp?f=meeting'}).
//                success(function(data, status, headers, config) {
//                    // this callback will be called asynchronously
//                    // when the response is available
//                    console.log(data);
//                    met.get=  data;
//                }).
//                error(function(data, status, headers, config) {
//                    // called asynchronously if an error occurs
//                    // or server returns response with an error status.
//                });
//        return met.get;
    }]);
app.controller('CtrlHome', ['$scope', 'Metting', function($scope, Metting) {
         $scope.items = [];
 
  function refreshItems(){
    Metting.getData().then(function(data){
                console.log(eval( data ));
//                console.log(jQuery.parseJSON(data));
                
      $scope.items = eval("([" + data + "])");
    },
    function(errorMessage){
      $scope.error=errorMessage;
    });
  };
 
  refreshItems();
       
    }]);
app.controller('CtrlService', ['$scope', function($scope) {
        $scope.name = "CtrlService";
    }]);
app.controller('CtrlUsers', ['$scope', function($scope) {
        $scope.name = "CtrlUsers";
    }]);
app.controller('CtrlUsersDetels', ['$scope', function($scope) {
        $scope.name = "CtrlUsersDetels";
    }]);
app.controller('CtrlMeeting', ['$scope', function($scope) {
        $scope.name = "CtrlMeeting";
    }]);

