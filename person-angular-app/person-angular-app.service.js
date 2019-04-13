(function() {
    "use strict";

    angular.module('app').service('Person-angular-appService', Person-angular-appService);

    Person-angular-appService.$inject = ['$q','$http'];

    function Person-angular-appService($q, $http) {

        var service = {
            getAllPerson: getAllPerson,
            getPersonById: getPersonById,
            addPerson: addPerson,
            updatePerson: updatePerson 
         };
        return service;

        function getAllPerson() {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/v1/person',
                method: 'GET',
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }

        function getPersonById() {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/v1/person/'+id+'',
                method: 'GET',
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }

        function addPerson(person) {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/v1/person',
                method: 'POST',
                data: person,
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }

        function updatePerson(person,) {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/v1/persons/'+id+'',
                method: 'PUT',
                data: person,
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }
    }

})();
