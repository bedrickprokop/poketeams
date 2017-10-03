app.controller('teamController', function ($scope, $routeParams, $location, teamService,
                                           creatureService) {

    $scope.headingTitle = "Maintain teams";
    $scope.emptyMessage = "No teams available /:";

    $scope.entity = {};
    $scope.entityList = [];

    $scope.creatureList = [];
    $scope.toSelectCreatureList = [];
    $scope.selectedCreatureList = [];

    $scope.isEditing = false;

    //TODO change coachId for the coach object
    var coachId = $routeParams.coachId;

    if (coachId) {
        teamService.findByCoach(coachId).then(function (response) {
            $scope.entityList = response.data;
        }, function (error) {
            console.log(error);
        });

        creatureService.findAll().then(function (response) {
            $scope.creatureList = response.data;
            $scope.toSelectCreatureList = angular.copy($scope.creatureList);
        }, function (error) {
            console.log(error);
        });

    } else {
        $location.path("/");
    }

    $scope.selectCreature = function () {
        if ($scope.selectedCreature.id) {
            var selectedIndex = findEntityIndex($scope.selectedCreature.id, $scope.toSelectCreatureList);
            if (selectedIndex != -1) {
                $scope.toSelectCreatureList.splice(selectedIndex, 1);
                $scope.selectedCreatureList.push($scope.selectedCreature);
                $scope.selectedCreature = {};
            }
        }
    }

    $scope.unselectCreature = function () {
        if ($scope.selectedCreature.id) {
            var selectedIndex = findEntityIndex($scope.selectedCreature.id, $scope.selectedCreatureList);
            if (selectedIndex != -1) {
                $scope.selectedCreatureList.splice(selectedIndex, 1);
                $scope.toSelectCreatureList.push($scope.selectedCreature);
                $scope.selectedCreature = {};
            }
        }
    }

    $scope.edit = function (entity, isEditing) {
        $scope.entity = angular.copy(entity);
        $scope.toSelectCreatureList = angular.copy($scope.creatureList);
        $scope.selectedCreatureList = angular.copy($scope.entity.creatureList);

        $scope.isEditing = isEditing;
    }

    $scope.clear = function () {
        $scope.entity = {};
        $scope.selectedCreatureList = [];
        $scope.toSelectCreatureList = angular.copy($scope.creatureList);
        $scope.isEditing = false;
    };

    $scope.submit = function (isValid) {
        //TODO make the validation
        if (isValid) {

            $scope.entity.creatureList = angular.copy($scope.selectedCreatureList);

            if (!$scope.isEditing) {
                teamService.create($scope.entity, coachId).then(function (response) {
                    $scope.entityList.push(response.data);
                }, function (error) {
                    console.log(error);
                });

            } else {

                teamService.update($scope.entity).then(function (response) {
                    var updatedEntity = response.data;
                    var selectedIndex = findEntityIndex(updatedEntity.id, $scope.entityList);

                    $scope.entityList[selectedIndex] = updatedEntity;
                    $scope.isEditing = false;

                }, function (error) {
                    console.log(error);
                });
            }
            $scope.clear();
        }
    };

    $scope.delete = function (entityId) {
        teamService.deleteOne(entityId).then(function (response) {
            var selectedIndex = findEntityIndex(response.data.id, $scope.entityList);
            if (selectedIndex > -1) {
                $scope.entityList.splice(selectedIndex, 1);
            }
        }, function (error) {
            console.log(error);
        });
    }

    function findEntityIndex(entityId, entityList) {
        var array = entityList;
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