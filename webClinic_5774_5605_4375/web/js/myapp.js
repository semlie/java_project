/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

var app = angular.module('javapro', ['ngRoute','ngResource']);
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
                when('/help/', {
                    templateUrl: 'partials/help.html',
                    controller: 'CtrlHelp'
                }).
                otherwise({
                    redirectTo: '/home'
                });
    }]);


app.factory('Metting', ['$http', '$q', function($http, $q) {
        return {
            getData: function(parm) {
                var deferred = $q.defer();
                var promise = $http.get('/webClinic_5774_5605_4375/get.jsp?f=' + parm).success(function(data) {
                    deferred.resolve(data);
                    console.log(data);
                });
                // Return the promise to the controller
                return deferred.promise;
            }
        };
    }]);
//service.factory("UsersD", function ($resource) {
//    return $resource(
//        "/users/:Id",
//        {Id: "@Id" },
//        {
//            "update": {method: "PUT"},
//            "reviews": {'method': 'GET', 'params': {'reviews_only': "true"}, isArray: true}
// 
//        }
//    );
//});
app.controller('CtrlHome', ['$scope', 'Metting', function($scope, Metting) {
        $scope.items = [];

        function refreshItems() {
            Metting.getData('meeting').then(function(data) {

                $scope.items = eval("([" + data + "])");
            },
                    function(errorMessage) {
                        $scope.error = errorMessage;
                    });
        }
        ;

        refreshItems();

    }]);
app.controller('CtrlService', ['$scope', 'Metting', function($scope, Metting) {
        function refreshItems() {
            Metting.getData('service').then(function(data) {

                $scope.items = eval("([" + data + "])");
            },
                    function(errorMessage) {
                        $scope.error = errorMessage;
                    });
        }
        ;

        refreshItems();
        $scope.name = "CtrlService";
    }]);
app.controller('CtrlUsers', ['$scope', 'Metting', function($scope, Metting) {
        function refreshItems() {
            Metting.getData('patient').then(function(data) {

                $scope.items = eval("([" + data + "])");
            },
                    function(errorMessage) {
                        $scope.error = errorMessage;
                    });
        }
        ;

        refreshItems();
        $scope.name = "CtrlUsers";
    }]);
app.controller('CtrlUsersDetels', ['$scope', '$routeParams', 'Metting', function($scope, $routeParams, Metting) {
        var parm = $routeParams;
        console.log(parm);
        function refreshItems() {
            Metting.getData('userD&name='+parm.userID).then(function(data) {

                $scope.items = eval("([" + data + "])");
            },
                    function(errorMessage) {
                        $scope.error = errorMessage;
                    });
        }
        ;

        refreshItems();
        $scope.name = "CtrlUsersDetels";
    }]);
app.controller('CtrlMeeting', ['$scope', 'Metting', function($scope, Metting) {
        function refreshItems() {
            Metting.getData('meeting').then(function(data) {

                $scope.items = eval("([" + data + "])");
            },
                    function(errorMessage) {
                        $scope.error = errorMessage;
                    });
        }
        ;

        refreshItems();
        $scope.name = "CtrlMeeting";
    }]);
app.controller('CtrlHelp', ['$scope', function($scope) {

        $scope.name = "CtrlHelp";
    }]);

