const form = document.querySelector("form");

form.addEventListener("submit", function (e) {
    e.preventDefault();

    const email = document.querySelector("input[type='text']").value;
    const password = document.querySelector("input[type='password']").value;

    fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: email,
            password: password
        })
    })
    .then(res => res.json())
    .then(data => {
        console.log(data);

        // ✅ Token save
        localStorage.setItem("token", data.token);
        localStorage.setItem("role", data.role);

        // ✅ Role based redirect
        if (data.role === "ADMIN") {
            window.location.href = "dashboard.html";
        } else {
            window.location.href = "evaluator.html";
        }
    })
    .catch(err => {
        alert("Login Failed");
        console.error(err);
    });
});