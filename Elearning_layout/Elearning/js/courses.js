var user = JSON.parse(localStorage.getItem('USER_INFOR'));
let token = localStorage.getItem("USER_TOKEN");
// console.log(user);
if (!user) {
    //Nếu token null hoặc rỗng (chưa đăng nhập)
    window.location.href = "index.html";
}
loadUserInfor();
document.getElementById("bannerCourseFullname").innerHTML = user.fullname + "'s Course";
document.getElementById("bannerCourseEmail").innerHTML = user.email;

axios({
    url: `http://localhost:8087/api/course/get-course-by-user-id/${user.id}`,
    method: "GET",
    headers: {
        "Authorization": "Bearer " + token
    }
})
    //Xữ lý mã trạng thái bắt đầu bằng số 2
    .then(function (response) {
        //Truy xuất đến thẻ body( nơi sẽ chứa giao diện)
        let tbody = document.getElementById("listMyCourse");
        //Thay đổi nội dung thẻ tbody
        let imgUrl = `https://i.udemycdn.com/user/200_H/anonymous_3.png`;
        let content = '';
        for (let item of response.data) {
            if (!(!item.image))
                imgUrl = `http://localhost:8087/api/course/file/load/${item.image}`;
            content += `
            <div class="col-md-3">
            <a href="details.html?id=${item.id}" class="my-course-item">
                <img src="${imgUrl}" alt="">
                <h6 class="my-course-title">${item.title}</h6>
                <div class="my-course-desc">
                    Java Python Android and C# Expert Developer - 467K+ students The Complete Guide (incl Hooks,
                    React Router, Redux)
                </div>
                <div class="my-course-author">
                    <h6>
                        <small>Lê Quang Song</small>
                        <small>Start course</small>
                    </h6>
                </div>
            </a>
        </div>
       `;
        }

        tbody.innerHTML = content;
    })
    //Xữ lý mã trạng thái còn lại
    .catch(function (e) {
        console.log(e.response)
    });