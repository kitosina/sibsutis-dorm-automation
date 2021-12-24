var app = angular.module("SPRAVKI",[]);

app.controller("SPRAVKI_CONTROLLER",function($scope, $http) {
    $scope.tenantInfo = []

    $scope.init =  function () {
        let url_tenant_info = '/tenant';
        $http({
            url: url_tenant_info,
            method: 'GET',
        }).then(function (response) {
            $scope.tenantInfo = response.data
        })
    }

    $scope.spravkaNew = function (quantity, comment) {
        let url_new_repair = '/certification/request/new';
        $http({
            url: url_new_repair,
            method: 'POST',
            data: {
                "comment": comment,
                "quantity": quantity,
                "tenant_id": $scope.tenantInfo.tenant[0].base_info.id
            }
        })
    }


})