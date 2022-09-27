
async function getUsers() {


    const response = await fetch("api/users");

    if (response.ok) {
        let json = await response.json()
            .then(data => replaceTable(data));
    } else {
        alert("Ошибка HTTP: " + response.status);
    }

    function replaceTable(data) {

        const placement = document.getElementById("usersTablePlacement")
        placement.innerHTML = "";
        data.forEach(({id, name, surname, age, email, roles}) => {
            let userRoles = "";
            roles.forEach((role) => {
                userRoles = userRoles + role.name.split("_")[1] + " ";
            })
            const element = document.createElement("tr");
            element.innerHTML = `
            <th scope="row">${id}</th>
            <td>${name}</td>
            <td>${surname}</td>
            <td>${age}</td>
            <td>${email}</td>
            <td>${userRoles}</td>
            <td>
                <button class="btn btn-info eBtn" data-toggle="modal">Edit</button>
            </td>

            <td>
             <button class="btn btn-danger dBtn" data-toggle="modal">Delete</button>
             </td>            
            `
            placement.append(element);
        })
    }
}
