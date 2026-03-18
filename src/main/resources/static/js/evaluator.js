const API = "http://localhost:8080/api";

// CHECK TOKEN
if (!localStorage.getItem("token")) {
    alert("Please login first");
    window.location.href = "login.html";
}

// HEADERS
function getHeaders() {
    return {
        "Authorization": "Bearer " + localStorage.getItem("token"),
        "Content-Type": "application/json"
    };
}

// LOAD PARTICIPANTS
function loadParticipants() {

    console.log("TOKEN:", localStorage.getItem("token"));

    fetch(API + "/participants", {
        headers: getHeaders()
    })
    .then(res => {
        console.log("STATUS:", res.status);
        if (!res.ok) throw new Error("Unauthorized");
        return res.json();
    })
    .then(data => {
        const table = document.getElementById("participantTable");

        table.innerHTML = `<tr><th>ID</th><th>Name</th></tr>`;

        data.forEach(p => {
            const row = table.insertRow();
            row.insertCell(0).innerText = p.id;
            row.insertCell(1).innerText = p.name;
        });
    })
    .catch((err)=>{
        console.error(err);
        alert("Access Denied");
    });
}

// CALL ON LOAD
loadParticipants();