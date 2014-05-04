/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

var myApp = angular.module('regform', [
    'myApp.directives',
    'myApp.controllers',
    'ngRoute'
]);


/* Controllers */

angular.module('myApp.controllers', []).
        controller('MyCtrl1', ['$scope', '$http', function($scope, $http) {

                $http.get('js/data/ashira.json').success(function(data) {
                    $scope.movies = data;
                });

            }]).controller('formCtrl', ['$scope', function($scope) {

//                    $http.get('js/data/ashira.json').success(function(data) {
//                        $scope.movies = data;
//                    });
        $scope.fildes = [{
                'name': "email",
                "label":"כתובת מייל",
                "type": "email",
                "id": "email",
                "errMsg": "אימייל לא תקין",
                "placeholder":"כתובת המייל"
            },
            {
                'name': "password",
                "type": "password",
                "id": "password",
                "errMsg": "בעיה בסיסמה"
            },
            {
                'name': "user-name",
                "type": "text",
                "id": "username",
                "errMsg": "שם משתמש כבר קיים"
            }
        ];
    }]);



/* Directives */


angular.module('myApp.directives', []).
        directive('mainMenu', function() {
            return {
                restrict: 'E',
                templateUrl: 'partial/menu.html'
            };
        }).directive('carousel', function() {
    return {
        restrict: 'E',
        templateUrl: 'partial/Carousel.html'
    };
}).directive('formReg', function() {
    return {
        restrict: 'E',
        templateUrl: 'partial/form.html'
    };
});
  