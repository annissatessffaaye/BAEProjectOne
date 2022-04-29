"use strict";

(function() {
    const baseURL = "http://localhost:12000/getById";

    axios.get(`${baseURL}/`)
        .then(res => { // handle response with callback
            console.log(res);
            console.log("DATA: ", res.data);
        }).catch(err => console.log(err)); // handle error


    console.log("Have we got a response yet?");

    const getAllOutput = document.querySelector("#getAllOutput");

    const userId = document.querySelector("#userId");

    const getAllUsers = () => {
        axios.get(`${baseURL}/getAllUsers`)
            .then(res => {
                const users = res.data;

                getAllOutput.innerHTML = ""; // blanks an element

                users.forEach(user => renderUser(user, getAllOutput));
            }).catch(err => console.log(err));
    }

    const renderUser = (user) => {
        const userColumn = document.createElement('div');
        userColumn.classList.add("col");

        const userCard = document.createElement('div');
        userCard.classList.add("card");
        userColumn.appendChild(userCard);

        const newUser = document.createElement('div');
        newUser.classList.add("card-body");

        const firstName = document.createElement("h3");
        firstName.innerText = first.name;
        firstName.classList.add("card-title");
        newUser.appendChild(firstName);
        userName.addEventListener('click', (e) => updateField(e, user.id));


        const lastName = document.createElement("p");
        lastName.innerText = `LastName: ${last.name}`;
        lastName.classList.add("card-text");
        lastName.addEventListener('click', (e) => updateField(e, user.id));
        newUser.appendChild(lastName);

        const userName = document.createElement("p");
        userName.innerText = `UserName: ${user.name}`;
        userName.classList.add("card-text");
        userName.addEventListener('click', (e) => updateField(e, user.id));
        newUser.appendChild(userName);

        const phoneNumber = document.createElement("p");
        phoneNumber.innerText = `PhoneNumber: ${phone.number}`;
        phoneNumber.classList.add("card-text");
        phoneNumber.addEventListener('click', (e) => updateField(e, user.id));
        newUser.appendChild(phoneNumber);

        const address = document.createElement("p");
        address.innerText = `Address: ${address}`;
        address.classList.add("card-text");
        address.addEventListener('click', (e) => updateField(e, user.id));
        newKitten.appendChild(address);

        const deleteButton = document.createElement('button');
        deleteButton.innerText = "DELETE";
        deleteButton.classList.add("btn", "btn-primary");
        deleteButton.addEventListener('click', () => deleteKitten(user.id));

        newUser.appendChild(deleteButton);

        userCard.appendChild(newUser);

        getAllOutput.appendChild(userColumn);
    }

    const deleteUser = id => {
        axios.delete(`${baseURL}/deleteUser/${id}`)
            .then(res => {
                console.log(res);
                getAllUsers();
            }).catch(err => console.log(err));
    }

    const getKittenById = () => {
        axios.get(`${baseURL}/getUser/${userId.value}`)
            .then(res => {
                const user = res.data;
                getByIdOutput.innerHTML = "";
                renderUser(user, getByIdOutput);
            }).catch(err => console.log(err));
    }

    document.querySelector("input#searchName").addEventListener('input', ({ target: { value } }) => {
        console.log("SEARCH: ", value);
        if (!value) return getAllUsers();
        axios.get(`${baseURL}/getByName/${value}`)
            .then(({ data }) => {
                getAllOutput.innerHTML = "";
                console.log("DATA: ", data);
                data.forEach(user => renderUser(user));
            }).catch(err => console.log(err));
    });

    document.querySelector("section#postSection > form").addEventListener('submit', (e) => {
        e.preventDefault(); // stops the form submitting in the default way

        const form = e.target;

        const data = {
            firstname: form.firstname.value,
            lastname: form.lastname.value,
            username: form.username.value,
            phonenumber: form.phonenumber.value,
            address: form.address.value

        }

        console.log("DATA: ", data);

        axios.post(`${baseURL}/createUser`, data)
            .then((res) => {
                console.log(res);
                getAllUsers();

                form.reset(); //resets form
                form.name.focus(); // selects the name input
            }).catch(err => console.log(err));
    });

    const updateField = ({ target }, id) => {
        const replaceInput = document.createElement('input');
        replaceInput.classList.add("form-control");
        const placeholder = target.tagName === "H3" ? "First Name" : target.innerText.split(":")[0];
        replaceInput.placeholder = placeholder;

        replaceInput.addEventListener('keyup', async(e) => {
            e.preventDefault();
            if (e.key === "Enter") {
                try {
                    const res = await axios.patch(`${baseURL}/patchUser/${id}?${placeholder.toLowerCase()}=${e.target.value}`);
                    getAllUsers();
                } catch (err) {
                    console.error(err);
                }
            } else if (e.key === "Escape") return getAllUsers();
        });
        target.replaceWith(replaceInput);
        replaceInput.focus();
    }

    getAllUsers();

})();