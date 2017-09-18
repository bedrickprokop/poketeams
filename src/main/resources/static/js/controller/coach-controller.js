app.controller('coachController', function ($scope, $http, $routeParams, coachService) {

    $scope.headingTitle = "Maintain coaches";
    $scope.coachList = [];
    $scope.coach = {};
    $scope.emptyMessage = "No items available /:";

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
            $scope.coach = {}
        }
    }

    $scope.delete = function (coachId) {
        coachService.deleteOne(coachId).then(function (response) {
            var array = $scope.coachList;
            var selectedIndex = -1;
            for (var i = 0, len = array.length; i < len; i++) {
                if (array[i].id == coachId) {
                    selectedIndex = i;
                    break;
                }
            }
            if (selectedIndex > -1) {
                $scope.coachList.splice(selectedIndex, 1);
            }
        }, function (error) {
            console.log(error);
        });
    }

});