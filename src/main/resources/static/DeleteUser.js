const formDelete = document.getElementById('formDelete')
formDelete.addEventListener('submit', e =>{
    e.preventDefault();
    fetch("api/users/"+idDel.value, {
        method: "DELETE"
    })
        .then(() => getUsers());
    $("#deleteModal").modal("hide");
    formDelete.reset();
})