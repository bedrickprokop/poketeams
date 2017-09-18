app.controller('coachController', function ($scope, $http, $routeParams, coachService) {

    $scope.headingTitle = "Maintain coaches";
    $scope.emptyMessage = "No items available /:";

    $scope.entity = {};
    $scope.entityList = [];

    $scope.isEditing = false;

    coachService.findAll().then(
        function (response) {
            $scope.entityList = response.data;
        }, function (error) {
            console.log(error);
        });

    $scope.submit = function (isValid) {
        if (isValid) {
            if (!$scope.isEditing) {
                coachService.create($scope.entity).then(function (response) {
                    $scope.entityList.push(response.data);
                }, function (error) {
                    console.log(error);
                });
            } else {
                coachService.update($scope.entity).then(function (response) {
                    var updatedEntity = response.data;
                    var selectedIndex = findEntityIndex(updatedEntity.id);
                    $scope.entityList[selectedIndex] = updatedEntity;
                    $scope.isEditing = false;

                }, function (error) {
                    console.log(error);
                })
            }
            $scope.clear();
        }
    }

    $scope.edit = function (entity, isEditing) {
        $scope.entity = angular.copy(entity);
        $scope.isEditing = isEditing;
    }

    $scope.clear = function () {
        $scope.entity = {};
    }

    $scope.delete = function (entityId) {
        coachService.deleteOne(entityId).then(function (response) {
            var selectedIndex = findEntityIndex(response.data.id);
            if (selectedIndex > -1) {
                $scope.entityList.splice(selectedIndex, 1);
            }
        }, function (error) {
            console.log(error);
        });
    }

    function findEntityIndex(entityId) {
        var array = $scope.entityList;
        var selectedIndex = -1;
        for (var i = 0, len = array.length; i < len; i++) {
            if (array[i].id == entityId) {
                selectedIndex = i;
                break;
            }
        }
        return selectedIndex;
    }

});