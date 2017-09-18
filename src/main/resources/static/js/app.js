var app = angular.module('app', ['ngRoute', 'ngResource']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/views/coach/list.html',
            controller: 'coachController',
            service: 'coachService'
        })
        .when('/coachdetail/:coachId', {
            templateUrl: '/views/coach/detail.html',
            controller: 'coachController'
        })
        .when('/team', {
            templateUrl: '/views/team.html',
            controller: 'teamController'
        })
        .otherwise(
            {redirectTo: '/'}
        );
});