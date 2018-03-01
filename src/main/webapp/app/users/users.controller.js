(function(){
    'use strict';
    angular.module('users.module.controller',['users.module.profile',
                                              'users.module.service']).controller('UsersController',Controller);
    
    function Controller(usersProfile,usersService,$scope){
    	this.usersProfile = usersProfile;
    	this.usersService = usersService;
    	usersService.loadAllUsers();
    	this.userToAdd ={};
    	$scope.$on('$destroy', function() {
    		usersProfile.destroyData();
        });
    }
    
    Object.defineProperty(Controller.prototype, "usersList", {
		enumerable : true,
		configurable : false,
		get : function() {
        	return this.usersProfile.usersList;
		}
	});
    
    Controller.prototype.addUser = function() {
    	var _this =this;
    	this.usersService.addUser(this.userToAdd).then(function(){
    		_this.userToAdd ={};
    	});
    };
       
})();