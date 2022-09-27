const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if (e.target.closest(selector)) {
            handler(e)
        }
    })
}


on(document, 'click', '.eBtn', e => {

    const line = e.target.parentNode.parentNode
    console.log(line)
    const idMod = line.children[0].innerHTML
    const nameMod = line.children[1].innerHTML
    const surnameMod = line.children[2].innerHTML
    const ageMod = line.children[3].innerHTML
    const emailMod = line.children[4].innerHTML
    const rolesMod = line.children[5].innerHTML


    IdEdit.value = idMod
    NameEdit.value = nameMod
    SurnameEdit.value = surnameMod
    AgeEdit.value = ageMod
    EmailEdit.value = emailMod
    RolesEdit.value = rolesMod

    $('#editModal').modal()
})