var user = JSON.parse(localStorage.getItem('USER_INFOR'));
let token = localStorage.getItem("USER_TOKEN");
console.log(user);
if (!user) {
    //Nếu token null hoặc rỗng (chưa đăng nhập)
    window.location.href = "/index.html";
}
let setProfile = function () {
    user = JSON.parse(localStorage.getItem('USER_INFOR'));
    document.getElementById("bannerFullname").innerHTML = user.fullname;
    document.getElementById("bannerEmail").innerHTML = user.email;

    document.getElementById("fmFullname").value = user.fullname;
    document.getElementById("fmEmail").value = user.email;
    document.getElementById("fmAddress").value = user.address;
    document.getElementById("fmPhone").value = user.phone;

    document.getElementById("securityEmail").value = user.email;
}

let loadUserInfor = function () {
    console.log(token);
    axios({
        url: `http://localhost:8087/api/user/get-user-by-token`,
        method: "GET",
        headers: {
            "Authorization": "Bearer " + token
        }
    })
        .then(function (resp) {
            let userTemp = resp.data;
            console.log(resp.data);
            localStorage.setItem("USER_INFOR", JSON.stringify(userTemp));
            let tbody = document.getElementById("dropdownId");
            tbody.innerHTML = userTemp.fullname;
            setProfile();
        })
        .catch(function (e) {
            console.log(e.resp)
        });
};

let updateProfile = function () {
    let fullname = document.getElementById("fmFullname").value;
    let address = document.getElementById("fmAddress").value;
    let phone = document.getElementById("fmPhone").value;
    let email = document.getElementById("fmEmail").value;
    axios({
        url: `http://localhost:8087/api/user/update/${user.id}`,
        method: "PUT",
        responseType: 'json',
        headers: {
            "Authorization": "Bearer " + token
        },
        data: {
            id: user.id,
            fullname: fullname,
            email: email,
            address: address,
            phone: phone,
            roleId: user.roleId,
            password: ""
        }
    })
        //Xữ lý mã trạng thái bắt đầu bằng số 2
        .then(function (response) {
            console.log(response.data);
            if (email === user.email) {
                loadUserInfor();
                setProfile();
                document.getElementById("updateMess").classList.add("text-success");
                document.getElementById("updateMess").innerHTML = "Update success !";
            } else {
                alert(`Cập nhật thành công email! Vui lòng đăng nhập lại !`);
                logout();
            }
        })
        //Xữ lý mã trạng thái còn lại
        .catch(function (e) {
            console.log(e.response);
            document.getElementById("updateMess").classList.add("text-danger");
            document.getElementById("updateMess").innerHTML = "Invalid email !";
        });
};
let updatePassword = function () {
    let password = document.getElementById("securityPassword").value;
    let confirmPassword = document.getElementById("securityConfirmPassword").value;
    if ((password !== confirmPassword) || (!password)) {
        document.getElementById("updateSecurityMess").classList.add("text-danger");
        document.getElementById("updateSecurityMess").innerHTML = "Password incorrect !";
        $(function () {
            $('#myModalRegister').modal({
                show: true
            });
        });
    } else {
        axios({
            url: `http://localhost:8087/api/user/update/${user.id}`,
            method: "PUT",
            responseType: 'json',
            headers: {
                "Authorization": "Bearer " + token
            },
            data: {
                id: user.id,
                fullname: user.fullname,
                email: user.email,
                address: user.address,
                phone: user.phone,
                roleId: user.roleId,
                password: password
            }
        })
            //Xữ lý mã trạng thái bắt đầu bằng số 2
            .then(function (response) {
                console.log(response.data);
                loadUserInfor();
                document.getElementById("updateSecurityMess").classList.add("text-success");
                document.getElementById("updateSecurityMess").innerHTML = "Update success !";

            })
            //Xữ lý mã trạng thái còn lại
            .catch(function (e) {
                console.log(e.response);
                document.getElementById("updateSecurityMess").classList.add("text-danger");
                document.getElementById("updateSecurityMess").innerHTML = "Password incorrect !";
            });
    }
};

let updateAvatar;

setProfile();