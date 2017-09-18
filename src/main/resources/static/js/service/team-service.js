app.factory('teamService', function ($http) {

    function create(team) {
        return;// $http.post('api/team', team);
    }

    function findOne(teamId) {
        return;// $http.get('api/team/' + teamId);
    }

    function findByCoachId(coachId) {
        //return; $http.get('api/team');
    }

    function update(team) {
        return;// $http.put('/api/team', team);
    }

    function deleteOne(teamId) {
        return;// $http.delete("api/team/" + teamId);
    }

    return {
        create: create,
        findOne: findOne,
        findByCoachId: findByCoachId,
        update: update,
        deleteOne: deleteOne
    }

});