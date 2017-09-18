app.factory('coachService', function ($http) {

    function create(coach) {
        return $http.post('api/coach', coach);
    }

    function findOne(coachId) {
        return $http.get('api/coach/' + coachId);
    }

    function findAll() {
        return $http.get('api/coach');
    }

    function update(coach) {
        return;
    }

    function deleteOne(coachId) {
        return;
    }

    return {
        create: create,
        findOne: findOne,
        findAll: findAll,
        update: update,
        deleteOne: deleteOne
    }

});