app.controller('teamController', function ($scope, $routeParams, $location, teamService) {

    $scope.headingTitle = "Maintain teams";
    $scope.emptyMessage = "No teams available /:";

    $scope.entity = {};
    $scope.entityList = [];

    var coachId = $routeParams.coachId;
    if (coachId) {
        $scope.entityList = [
            {
                id: 1, name: "Team 1", creatureList: [
                {
                    id: 1,
                    name: "Pikachu",
                    imageUrl: "http://www.google.com",
                    weight: 1.33,
                    height: 33.2,
                    moveList: [
                        {id: 1, name: "Fireblast"}
                    ]
                }
            ]
            }
        ];
        /*teamService.findByCoachId(coachId).then(
            function (response) {
                $scope.entityList = response.data;
            }, function (error) {
                console.log(error);
            });*/

    } else {
        $location.path("/");
    }
});