const API = "http://localhost:8080/api";

// ✅ CHECK TOKEN FIRST
const token = localStorage.getItem("token");

if (!token) {
    alert("Please login first");
    window.location.href = "login.html";
}

// ✅ HEADER FUNCTION
function getHeaders() {
    return {
        "Authorization": "Bearer " + token,
        "Content-Type": "application/json"
    };
}

// LOGOUT
function logout(){
    localStorage.clear();
    window.location.href="login.html";
}

// CREATE BATCH
function createBatch(){

    const data = {
        batchName:document.getElementById("batchName").value,
        startDate:document.getElementById("startDate").value,
        endDate:document.getElementById("endDate").value
    };

    fetch(API+"/batches",{
        method:"POST",
        headers:getHeaders(),
        body:JSON.stringify(data)
    })
    .then(res => {
        if(!res.ok) throw new Error("Error");
        return res.json();
    })
    .then(()=>{
        alert("Batch Created");
        loadBatches();
    })
    .catch(()=>{
        alert("Access Denied / Error");
    });
}

// LOAD BATCHES
function loadBatches(){

    fetch(API+"/batches",{
        headers:getHeaders()
    })
    .then(res => {
        if(!res.ok) throw new Error("Unauthorized");
        return res.json();
    })
    .then(batches=>{

        document.getElementById("batchCount").innerText=batches.length;

        const table=document.getElementById("batchTable");
        table.innerHTML=`<tr><th>ID</th><th>Name</th></tr>`;

        batches.forEach(b=>{
            const row=table.insertRow();
            row.insertCell(0).innerText=b.id;
            row.insertCell(1).innerText=b.batchName;
        });

    })
    .catch(()=>{
        alert("Session expired. Login again.");
        logout();
    });

}

loadBatches();