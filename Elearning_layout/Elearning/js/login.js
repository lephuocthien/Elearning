

// GỌI API LOAD THÔNG TIN ROLE LÊN FORM

let login = function(){
     let email = document.getElementById("email").value;
     let password = document.getElementById("password").value;
    axios({
        url:`http://localhost:8087/api/auth`,
        method:"POST",
        data: {
            email: email,
            password: password
        }
    })
    .then(function(resp){
         let token = resp.data
         console.log(resp.data);
         alert("Đăng nhập thành công!");
         //Lưu token vào localstorage
         localStorage.setItem("USER_TOKEN", token);

         
     //     let role = resp.data
     //     document.getElementById("name").value = role.name;
     //     document.getElementById("desc").value = role.desc;
         
    })
    .catch(function(err){
         console.log(err.response)
    });
 }

