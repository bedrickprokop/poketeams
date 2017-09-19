app.factory('moveService', function ($http) {

    function findAll() {
        return $http.get('api/move');
    }

    return {
        findAll: findAll
    }

});