var app = angular.module("REGISTRATION",[]);

app.controller("REGISTRATION_CONTROLLER",function($scope, $http) {
    $scope.paymentTypeList = []
    $scope.dormList = []

    $scope.sectionList = []
    $scope.roomList = []

    $scope.init = function () {
        let url_payment_type = '/payment/types';
        $http({
            url: url_payment_type,
            method: 'GET',
        }).then(function (response) {
            $scope.paymentTypeList = response.data.payment_type;
        })

        let url_dorm = '/dorm';
        $http({
            url: url_dorm,
            method: 'GET',
        }).then(function (response) {
            $scope.dormList = response.data.dorm;
        })
    }

    $scope.sectionGet = function (dorm) {
        let url_dorm = '/section';
        $http({
            url: url_dorm,
            params:{
                dorm_id: dorm.base_info.id
            },
            method: 'GET',
        }).then(function (response) {
            $scope.sectionList = response.data.section
        })
    }

    $scope.roomGet = function (section) {
        // Чистим комнаты
        $scope.roomList = []
        if (section != null) {
            let url_dorm = '/room';
            console.log(section)
            $http({
                url: url_dorm,
                params: {
                    section_id: section.base_info.id
                },
                method: 'GET',
            }).then(function (response) {
                $scope.roomList = response.data.room
            })
        }
    }

    $scope.registrationUser = function (email, name, lastName, patronymic, birthDate, contractBegin,
                                        contractEnd, paymentType, dorm, section, room, password, passportData) {
        let url = "/registration";
        let formData = new FormData();
        let documentScanOne = document.getElementById('scanOne').files[0]
        let documentScanTwo = document.getElementById('scanTwo').files[0]
        formData.append('document_scan_one', documentScanOne)
        formData.append('document_scan_two', documentScanTwo)
        formData.append('registration_info', new Blob([JSON.stringify({
            "user_basic_info": {
                "email": email,
                "password": password
            },
            "name": name,
            "last_name": lastName,
            "patronymic": patronymic,
            "birth_date": birthDate,
            "contract_begin": contractBegin,
            "contract_end": contractEnd,
            "passport": passportData,
            "payment_type_id": paymentType.base_info.id,
            "dorm_id": dorm.base_info.id,
            "room_id": room.base_info.id,
            "registration_strategy": "tenant"
        })], {
            type: "application/json"
        }));

        fetch(url, {
            method: 'post',
            body: formData
        }).then(function (response) {
            if (response.status !== 200) {
                alert("Ошибка регистрации");
            } else {
                alert("Пользователь зарегистрирован");
            }
        }).catch(function (err) {
            alert("Ошибка регистрации");
        });

    }

});

function isPasswordMatch() {
    let password = $("#InputPassword").val();
    let repeatPassword = $("#InputPasswordRepeat").val();
    if (password !== repeatPassword) {
        $("#passwordHelp").html("Пароль неверный!");
        document.getElementById('passwordHelp').style.color = '#8B0000';
    }
    else {
        $("#passwordHelp").html("Пароль верный!");
        document.getElementById('passwordHelp').style.color = '#006400'
    }
}

$(document).ready(function () {
    $("#InputPasswordRepeat").keyup(isPasswordMatch);
});