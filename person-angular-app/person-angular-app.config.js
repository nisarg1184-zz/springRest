(function() {
    "use strict";
    var app = angular.module('app');

    app.$inject=['$stateProvider'];

    app.config(function($stateProvider) {
        var person-angular-appState = {
            name : 'person-angular-app',
            url : '/person-angular-app',
            templateUrl : '/view/person-angular-app',
            controller: 'Person-angular-appController as person-angular-app'
        };
        $stateProvider.state(person-angular-appState);
    });

})();