var app = angular.module("REPAIR",[]);

app.controller("REPAIR_CONTROLLER",function($scope, $http) {
    $scope.tenantInfo = []
    $scope.repairTypeList = []

    $scope.init =  function () {
        let url_tenant_info = '/tenant';
        $http({
            url: url_tenant_info,
            method: 'GET',
        }).then(function (response) {
            $scope.tenantInfo = response.data
        })

        let url_repair_type = '/repair/types';
        $http({
            url: url_repair_type,
            method: 'GET',
        }).then(function (response) {
            console.log(response.data)
            $scope.repairTypeList = response.data.repair_type
        })
    }

    $scope.repairNew = function (repairType, comment) {
        let url_new_repair = '/repair/request/new';
        $http({
            url: url_new_repair,
            method: 'POST',
            data: {
                "repair_type_id": repairType.base_info.id,
                "comment": comment,
                "repair_info": {
                    "tenant_id": $scope.tenantInfo.tenant[0].base_info.id,
                    "tenant_room_num": $scope.tenantInfo.tenant[0].room_tenant.base_info.name,
                    "tenant_section_name": $scope.tenantInfo.tenant[0].section_tenant.base_info.name,
                    "dorm_id": $scope.tenantInfo.tenant[0].dorm_tenant.base_info.id
                }
            }
        })
    }


})