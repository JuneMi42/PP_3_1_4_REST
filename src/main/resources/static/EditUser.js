const formEdit = document.getElementById("formEdit");
formEdit.addEventListener('submit', e => {
    e.preventDefault();

    const formDataEdit = new FormData(formEdit);
    const object = {
        roles:[]
    };

    formDataEdit.forEach((value, key) => {
        if (key === "rolesId"){

            const roleId = value.split(" ")[0];
            const roleName = value.split(" ")[1];
            const roleEdit = {
                id : roleId,
                name : "ROLE_" + roleName
            };
            object.roles.push(roleEdit);
        } else {
            object[key] = value;
        }
    });
    fetch("api/users/"+IdEdit.value, {
        method: "PATCH",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(object)
    })
        .then(() => getUsers());
    $("#editModal").modal("hide");
    formEdit.reset();
})