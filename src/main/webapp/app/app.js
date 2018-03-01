(function(){
    'use strict';
    
    var app = angular.module('sambaApp',['users.module','ui.router','ngStorage']);

    app.constant('urls', {
        BASE: 'http://localhost:8080/SpringBootCRUDApp',
        USER_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/user/'
    });
    
})();

