app.factory('creatureService', function ($http) {

    function findByTeam(teamId) {
        return;
    }

    function findAll() {
        return $http.get('api/creature');
    }

    return {
        findAll: findAll,
        findByTeam: findByTeam
    }

});