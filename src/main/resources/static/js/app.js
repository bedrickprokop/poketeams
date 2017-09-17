var app = angular.module('app', ['ngRoute', 'ngResource']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/coach', {
            templateUrl: '/views/coach.html',
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