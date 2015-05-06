(function () {
    var app = angular.module('modone', []);

    app.controller('prodctrl',
            function($http,$scope){
                $scope.val="hello";
                $scope.token="";
                        
                this.sendReq=function(){
                    alert('got');
                    $http.get('oauth/token?username=myuser&password=mypassword&client_id=mysupplycompany&client_secret=mycompanykey&grant_type=password&scope=read').
                    success(function(data, status, headers, config) {
                      alert('success'+data.access_token);
                      $scope.token=data.access_token;
                      
                    }).
                    error(function(data, status, headers, config) {
                      alert('fail');
                    });
                    
                    
                };        

                this.sendReq2=function(){
                    alert('got');
                    $http.defaults.headers.common['Authorization'] = "Bearer " + $scope.token;
                    $http.get('rest/products').
                    success(function(data, status, headers, config) {
                      alert('success'+JSON.stringify(data));
                    }).
                    error(function(data, status, headers, config) {
                      alert('fail');
                    });                    
                    
                };        

                
            }
    );



})();





