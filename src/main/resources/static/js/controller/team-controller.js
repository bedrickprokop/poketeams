app.controller('teamController', function ($scope, $routeParams, $location, teamService,
                                           creatureService) {

    $scope.headingTitle = "Maintain teams";
    $scope.emptyMessage = "No teams available /:";

    $scope.entity = {};
    $scope.entityList = [];

    $scope.creatureList = [];
    $scope.selectedCreatureList = [];

    $scope.isEditing = false;

    var coachId = $routeParams.coachId;
    if (coachId) {
        teamService.findByCoach(coachId).then(
            function (response) {
                $scope.entityList = response.data;
            }, function (error) {
                console.log(error);
            });

        creatureService.findAll().then(function (response) {
            $scope.creatureList = response.data;
        }, function (error) {
            console.log(error);
        })

    } else {
        $location.path("/");
    }

    $scope.submit = function (isValid) {
        if (isValid) {

            $scope.entity.creatureList = $scope.selectedCreatureList;
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

    $scope.clear = function () {
        $scope.selectedCreatureList = [];
        $scope.entity = {};
        $scope.isEditing = false;
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

    //TODO not working
    //Reference: https://www.npmjs.com/package/angular-multiple-select
    $scope.beforeSelectItem = function (item) {
        alert(item);
    };
});