(function(){
	'use strict';
	
	angular.module('users.module', ['users.module.controller',
	                                'ui.router'])
	                                
	.config(function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('users', {
                url: '/',
                templateUrl: 'app/users/users.tpl.html',
                controller:'UsersController',
                controllerAs:'usersCtrl'
            });
        $urlRouterProvider.otherwise('/');
    });
})();

