async function getUsersById() {


    const response2 = await fetch("api/userById");

    if (response2.ok) {
        let json = await response2.json()
            .then(data => infoBar(data));
    } else {
        alert("Ошибка HTTP: " + response2.status);
    }

    function infoBar(data) {
        const placement = document.getElementById("infoTable")

        let userRoles = "";
        data.roles.forEach((role) => {
            userRoles = userRoles + role.name.split("_")[1] + " ";
        })


        placement.innerHTML = `
    <td>${data.id}</td>
    <td>${data.name}</td>
    <td>${data.surname}</td>
    <td>${data.age}</td>
    <td>${data.username}</td>
    <td>${userRoles}</td>
    `
    }
}