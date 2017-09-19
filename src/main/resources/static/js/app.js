var app = angular.module('app', ['ngRoute', 'ngResource', 'multipleSelect']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/views/coach/list.html',
            controller: 'coachController',
            service: 'coachService'
        })
        .when('/team/:coachId', {
            templateUrl: '/views/team/list.html',
            controller: 'teamController'
        })
        .otherwise(
            {redirectTo: '/'}
        );
});