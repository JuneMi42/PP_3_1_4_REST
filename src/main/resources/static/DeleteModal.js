on(document, 'click', '.dBtn', e => {

    const line = e.target.parentNode.parentNode
    const idDelMod = line.children[0].innerHTML
    const usernameDelMod = line.children[1].innerHTML
    const surNameDelMod = line.children[2].innerHTML
    const ageDelMod = line.children[3].innerHTML
    const emailDelMod = line.children[4].innerHTML

    idDel.value = idDelMod
    usernameDel.value = usernameDelMod
    surnameDel.value = surNameDelMod
    ageDel.value = ageDelMod
    emailDel.value = emailDelMod

    $('#deleteModal').modal()
})

