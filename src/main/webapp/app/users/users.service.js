(function(){
    'use strict';

    angular.module('users.module.service', ['users.module.profile'])
    .service('usersService', Service);

    
    function Service($http, $q ,usersProfile){
       this.$http = $http;
       this.$q = $q;
       this.usersProfile = usersProfile;
    }

 
    Service.prototype.addUser = function (user) {
        var deferred = this.$q.defer();
        var _this = this;
        this.$http.post("http://localhost:8080/samba/rest/user/addUser",user)
        .then(function (result) {
        	var addedUser =result.data;
        	_this.usersProfile.usersList.push(addedUser);
            deferred.resolve();
        });
        return deferred.promise;
    };
    
    Service.prototype.loadAllUsers = function () {
        var deferred = this.$q.defer();
        var _this = this;
        this.$http.get("http://localhost:8080/samba/rest/user/getAllUsers")
        .then(function (result) {
        	_this.usersProfile.usersList = result.data;
        	console.log(_this.usersProfile.usersList);
            deferred.resolve();
        });
        return deferred.promise;
    };
    
    

})();
