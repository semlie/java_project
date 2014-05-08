/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

var myApp = angular.module('regform', [
    'myApp.directives',
    'myApp.controllers',
    'ngRoute',
    'ui.bootstrap'
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
                "type": "email",
                "id": "email",
                "errMsg": "אימייל לא תקין",
                "label": "כתובת מייל",
                "placeholder": "כתובת המייל"
            },
            {
                'name': "password",
                "type": "password",
                "id": "password",
                "errMsg": "בעיה בסיסמה",
                "label": "סיסמה לאתר אשירה",
                "placeholder": "סיסמה שתשמש אותך בכניסתך לאתר אשירה"
            },
            {
                'name': "user-name",
                "type": "text",
                "id": "username",
                "errMsg": "שם משתמש כבר קיים",
                "label": "שם משתמש לאתר אשירה",
                "placeholder": "שם המשתמש בכניסתך לאתר אשירה"
            },
            {
                'name': "card_owner",
                "type": "text",
                "id": "card_owner",
                "errMsg": "שם משתמש כבר קיים",
                "label": "שם בעל הכרטיס",
                "placeholder": "שם בעל הכרטיס כפי שמופיע על הכרטיס"
            },
            {
                'name': "owner_phone",
                "type": "text",
                "id": "owner_phone",
                "errMsg": "שם משתמש כבר קיים",
                "label": "מספר טלפון של בעל הכרטיס",
                "placeholder": "מספר טלפון כולל קידומת"
            },
            {
                'name': "card_number",
                "type": "text",
                "id": "card_number",
                "errMsg": "שם משתמש כבר קיים",
                "label": "מספר כרטיס אשראי",
                "placeholder": "מספר כרטיס אשראי כפי שמופיע על הכרטיס"
            },
            {
                'name': "owner_email",
                "type": "text",
                "id": "owner_email",
                "errMsg": "שם משתמש כבר קיים",
                "label": "אי-מייל למשלוח חשבונית",
                "placeholder": "אי-מייל למשלוח חשבונית"
            }
        ];
        
        $scope.user ={};
        $scope.user.submitTheForm = function(item, event) {
            console.log("--> Submitting form");
            var dataObject = {
                name: $scope.myForm.name
                , car: $scope.myForm.car
            };

            var responsePromise = $http.post("/angularjs-examples/json-test-data.jsp", dataObject, {});
            responsePromise.success(function(dataFromServer, status, headers, config) {
                console.log(dataFromServer.title);
            });
            responsePromise.error(function(data, status, headers, config) {
                alert("Submitting form failed!");
            });
        };


    }]);



/* Directives */


angular.module('myApp.directives', []).
        directive('mainMenu', function() {
            return {
                restrict: 'E',
                templateUrl: 'partial/menu.html'
            };
        }).
        directive('carousel', function() {
            return {
                restrict: 'E',
                templateUrl: 'partial/Carousel.html'
            };
        }).
        directive('formReg', function() {
            return {
                restrict: 'E',
                templateUrl: 'partial/form.html'
            };
        }).
        directive('inputs', function() {
            return {
                restrict: 'E',
                templateUrl: 'partial/input-loop.html'
            };
        });
