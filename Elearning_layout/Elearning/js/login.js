

// GỌI API LOAD THÔNG TIN ROLE LÊN FORM

let login = function () {
    let email = document.getElementById("loginEmail").value;
    let password = document.getElementById("loginPassword").value;
    axios({
        url: `http://localhost:8087/api/auth`,
        method: "POST",
        data: {
            email: email,
            password: password
        }
    })
        .then(function (resp) {
            let token = resp.data
            console.log(resp.data);
            alert("Đăng nhập thành công!");
            //Lưu token vào localstorage
            localStorage.setItem("USER_TOKEN", token);
            // loadUserInfor();
            axios({
                url: `http://localhost:8087/api/user/get-user-by-token`,
                method: "GET",
                headers: {
                    "Authorization": "Bearer " + token
                }
            })
                .then(function (resp) {
                    let user = resp.data;
                    console.log(resp.data);
                    localStorage.setItem("USER_INFOR", JSON.stringify(user));
                    let tbody = document.getElementById("userInforDropdown");
                    let content = '';
                    content += `
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="dropdownId"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Hi, ${user.fullname}
                                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownId">
                    <a class="dropdown-item" href="profile.html">Profile</a>
                    <a class="dropdown-item" href="course.html">My Course</a>
                    <a class="dropdown-item" onclick = "logout()">Logout</a>
                </div>
            </li>
        </ul>
    </div>
    `;
                    tbody.innerHTML = content;

                })
                .catch(function (e) {
                    console.log(e.resp)
                });

        })
        .catch(function (err) {
            console.log(err.response);
            document.getElementById("loginMess").innerHTML = "Invalid email or password incorrect !";
                $(function () {
                    $('#myModalLogin').modal({
                        show: true
                    });
                });
        });
}

let logout = function () {
    localStorage.removeItem('USER_TOKEN');
    localStorage.removeItem('USER_INFOR');
    window.location.href = "/index.html";
}

let getRole = function () {
    axios({
        url: "http://localhost:8087/api/role/get-all-not-admin",
        method: "GET"
    })
        //Xữ lý mã trạng thái bắt đầu bằng số 2
        .then(function (response) {
            //Truy xuất đến thẻ body( nơi sẽ chứa giao diện)
            let tbody = document.getElementById("selectRole");
            //Thay đổi nội dung thẻ tbody
            let content = `<select class="form-control form-control-line" id="regRoleId">`;
            for (let item of response.data)
                content += `<option value = "${item.id}">${item.description}</option>`;
            content += `</select>`;
            tbody.innerHTML = content;
        })
        //Xữ lý mã trạng thái còn lại
        .catch(function (e) {
            console.log(e.response)
        });
}

let register = function () {
    let email = document.getElementById("regEmail").value;
    let password = document.getElementById("regPassword").value;
    let confirmPassword = document.getElementById("regConfirmPassword").value;
    let roleId = document.getElementById("regRoleId").value;
    let fullname = document.getElementById("regFullname").value;
    //  console.log(email);
    //  console.log(password);
    //  console.log(confirmPassword);
    //  console.log(roleId);
    if ((password !== confirmPassword) || (!password)) {
        document.getElementById("regMess").innerHTML = "Password incorrect !";
        $(function () {
            $('#myModalRegister').modal({
                show: true
            });
        });
    }
    else {
        axios({
            url: `http://localhost:8087/api/user/add`,
            method: "POST",
            data: {
                fullname: fullname,
                email: email,
                password: password,
                roleId: roleId
            }
        })
            //Xữ lý mã trạng thái bắt đầu bằng số 2
            .then(function (response) {
                console.log(response.data);
                alert(`Đăng ký thành công! Đăng nhập lại vào hệ thống!`);
            })
            //Xữ lý mã trạng thái còn lại
            .catch(function (e) {
                document.getElementById("regMess").innerHTML = "Invalid email !";
                $(function () {
                    $('#myModalRegister').modal({
                        show: true
                    });
                });
            });
    }

}
getRole();
