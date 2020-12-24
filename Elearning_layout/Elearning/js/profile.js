let token = localStorage.getItem("USER_TOKEN");
console.log(token);
if(!token){
    //Nếu token null hoặc rỗng (chưa đăng nhập)
    window.location.href="/index.html";
}
// let getUserProfile = () =>{
    axios({
        url:`http://localhost:8087/api/user/getUserByToken`,
        method: "GET",
        headers: {
            "Authorization": "Bearer " + token
        }
    })
    .then(function(resp){
        console.log(resp.data);
        let user = resp.data;
        document.getElementById("bannerFullname").innerHTML = user.fullname;
        document.getElementById("bannerEmail").innerHTML = user.email;

        document.getElementById("fmFullname").value = user.fullname;
        document.getElementById("fmEmail").value = user.email;
        document.getElementById("fmAddress").value = user.address;
        document.getElementById("fmPhone").value = user.phone;
    })
    .catch(function(e){
        console.log(e.resp)
    });
// }

//  getUserProfile();