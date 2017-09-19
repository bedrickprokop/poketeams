app.factory('teamService', function ($http) {

    function create(team, coachId) {
        return $http.post('api/team/' + coachId, team);
    }

    function findOne(teamId) {
        return $http.get('api/team/' + teamId);
    }

    function findByCoach(coachId) {
        return $http.get('api/team/coach/' + coachId);
    }

    function update(team) {
        return $http.put('api/team', team);
    }

    function deleteOne(teamId) {
        return $http.delete("api/team/" + teamId);
    }

    return {
        create: create,
        findOne: findOne,
        findByCoach: findByCoach,
        update: update,
        deleteOne: deleteOne
    }

});