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
        return $http.put('/api/coach', coach);
    }

    function deleteOne(coachId) {
        return $http.delete("api/coach/" + coachId);
    }

    return {
        create: create,
        findOne: findOne,
        findAll: findAll,
        update: update,
        deleteOne: deleteOne
    }

});