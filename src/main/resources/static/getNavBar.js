async function auth() {
    let authObj;

    fetch("api/userById").then(res => {
        res.json().then(
            user => {
                authObj = {
                    id: user.id,
                    name: user.name,
                    surname: user.surname,
                    age: user.age,
                    username: user.username,
                    userRoles: ""
                }
                user.roles.forEach((role) => {
                    authObj.userRoles += role.name.substring(5) + " ";
                })
                navBar(authObj.userRoles, authObj.username)

            }
        )
    })
}

                function navBar(roles, email) {
    const placement = document.getElementById("navBar");
    const element = document.createElement("div");
    element.innerHTML = `
            <a class="navbar-brand" href="#">
            <nobr class="font-weight-bold">${email}</nobr>
            <nobr>with roles:</nobr>
            <nobr th:text="${roles}">${roles}</nobr>
            </a>
                        `
    placement.append(element)

}
