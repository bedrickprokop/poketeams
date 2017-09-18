app.controller('coachController', function ($scope, $http, $routeParams, coachService) {

    $scope.headingTitle = "Coach list";
    $scope.coachList = [];
    $scope.coach = {};
    $scope.emptyMessage = "No items available";

    var coachId = $routeParams.coachId;
    if (coachId) {
        coachService.findOne(coachId).then(function (response) {
            $scope.coach = response.data;
        }, function (error) {
            console.log(error);
        });
    } else {
        coachService.findAll().then(
            function (response) {
                $scope.coachList = response.data;
            }, function (error) {
                console.log(error);
            });
    }

    $scope.create = function (isValid) {
        if (isValid) {
            coachService.create($scope.coach).then(function (response) {
                $scope.coachList.push(response.data);
            }, function (error) {
                console.log(error);
            });
        }
    }

});