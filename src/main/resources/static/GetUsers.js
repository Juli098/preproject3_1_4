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
        data.forEach(({id, username, password, email, age, roles}) => {
            let userRoles = "";
            roles.forEach((role) => {
                userRoles = userRoles + role.name.split("_")[1] + " ";
            })
            const element = document.createElement("tr");
            element.innerHTML = `
            <th scope="row">${id}</th>
            <td>${username}</td>
            <td>${password}</td>
            <td>${email}</td>
            <td>${age}</td>
            <td>${userRoles}</td>
            <td>
                <button type="button" class="btn btn-info text-white" data-bs-userId=${id}
                    data-bs-userUsername=${username} data-bs-userPassword=${password} data-bs-userEmail=${email}
                    data-bs-userAge=${age} data-bs-toggle="modal"
                    data-bs-target="#ModalEdit">Edit</button>
            </td>
            <td>
                <button type="button" class="btn btn-danger" data-bs-userId=${id}
                    data-bs-userUsername=${username} data-bs-userPassword=${password} data-bs-userEmail=${email}
                    data-bs-userAge=${age} data-bs-toggle="modal"
                    data-bs-target="#ModalDelete">Delete</button>
            </td>            
            `
            placement.append(element);
        })
    }


}