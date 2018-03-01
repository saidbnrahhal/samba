(function(){
    'use strict';

    angular.module('users.module.profile', [])
    .service('usersProfile', Profile);

    
    function Profile() {
    	
    	this.initData();
    }

    
    Profile.prototype.initData = function () {
    	this.isWaiting = false;
    	this.usersList = [];
    };

    
    Profile.prototype.destroyData = function () {
    	delete this.isWaiting;
    	delete this.usersList;
    };
    
})();