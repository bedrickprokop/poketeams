app.controller('teamController', function ($scope, $routeParams, $location, teamService,
                                           creatureService, moveService) {

    $scope.headingTitle = "Maintain teams";
    $scope.emptyMessage = "No teams available /:";

    $scope.entity = {};
    $scope.entityList = [];

    $scope.creatureList = [];
    $scope.selectedCreature = {moveList: []};
    $scope.selectedCreatureList = [];

    $scope.moveList = [];
    $scope.selectedMoveList = [];

    $scope.isEditing = false;

    var coachId = $routeParams.coachId;
    if (coachId) {
        teamService.findByCoach(coachId).then(function (response) {
            $scope.entityList = response.data;
        }, function (error) {
            console.log(error);
        });

        creatureService.findAll().then(function (response) {
            $scope.creatureList = response.data;
        }, function (error) {
            console.log(error);
        });

        moveService.findAll().then(function (response) {
            $scope.moveList = response.data;
        }, function (error) {
            console.log(error);
        });

    } else {
        $location.path("/");
    }

    $scope.submit = function (isValid) {
        if (isValid) {

            if (!$scope.isEditing) {
                teamService.create($scope.entity, coachId).then(function (response) {
                    $scope.entityList.push(response.data);
                }, function (error) {
                    console.log(error);
                })
            } else {
                teamService.update($scope.entity).then(function (response) {
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
    };

    $scope.creatureChance = function () {
        console.log($scope.selectedCreature);
        //console.log($scope.selectedCreatureList);
    }

    //$scope.updateMoves = function () {
    //    console.log($scope.selectedMoveList);
    //}
    //ng-change="updateMoves()"

    $scope.checkNewCreatureAdded = function () {
        if ($scope.selectedCreatureList.length < 6) {
            if ($scope.selectedMoveList.length <= 4) {
                $scope.selectedCreatureList.push($scope.selectedCreature);

                var creature = angular.copy($scope.selectedCreature);
                creature.moveList = [];

                for (var i = 0, len = $scope.selectedMoveList.length; i < len; i++) {
                    creature.moveList.push($scope.selectedMoveList[i]);
                }

                if (!$scope.entity.creatureList) {
                    $scope.entity.creatureList = new Array();
                }
                $scope.entity.creatureList.push(creature);

                console.log($scope.entity);
            } else {
                alert("You can't choose more than 4 moves");
            }
        } else {
            alert("You can't add more than 6 creatures");
        }
    };

    $scope.edit = function (entity, isEditing) {
        $scope.entity = angular.copy(entity);
        $scope.isEditing = isEditing;
    }

    $scope.clear = function () {
        $scope.selectedCreatureList = [];
        $scope.selectedCreature = {moveList: []};
        $scope.selectedMoveList = [];

        $scope.entity = {};
        $scope.isEditing = false;
    };

    $scope.delete = function (entityId) {
        teamService.deleteOne(entityId).then(function (response) {
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