app.controller('teamController', function ($scope, $routeParams, $location, teamService,
                                           creatureService) {

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

    $scope.submit = function (isValid) {
        if (isValid) {

        }
        console.log($scope.selectedCreatureList);
    };

    $scope.creatureList = [
        {id: 1, name: "Java"},
        {id: 2, name: "C"},
        {id: 3, name: "C++"},
        {id: 4, name: "AngularJs"},
        {id: 5, name: "C#"},
        {id: 6, name: "Pyton"},
        {id: 7, name: "JQuery"},
        {id: 8, name: "Android"},
        {id: 9, name: "NodeJs"},
        {id: 10, name: "ShellScript"},
        {id: 11, name: ".NET"}
    ];

    $scope.beforeSelectItem = function (item) {
        console.log("beforeSelectItem");
        console.log($scope.selectedCreatureList.length);
    };

});