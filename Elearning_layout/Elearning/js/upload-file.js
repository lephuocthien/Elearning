// let imgName;
// let uploadFile = document.getElementById("uploadFile");
// uploadFile.addEventListener("change", function (event) {
//     let file = event.target.files[0];
//     console.log(file);
//     let formData = new FormData();
//     formData.append("file", file);

//     axios({
//         url: `http://localhost:8087/api/file/upload`,
//         method: "POST",
//         headers: {
//             "Authorization": "Bearer " + token
//         },
//         data: formData
//     })
//         .then(function (resp) {
//             imgName = resp.data;
//             let imgUrl = "http://localhost:8087/api/file/load/" + imgName;
//             document.getElementById('imgAvatar').setAttribute("src", imgUrl);
//         })
//         .catch(function (e) {
//             console.log(e.resp)
//         });
// })