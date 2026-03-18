function login() {
    console.log("Login clicked"); // 👈 debug

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

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

        localStorage.setItem("token", data.token);
        localStorage.setItem("role", data.role);

        if (data.role === "ADMIN") {
            window.location.href = "dashboard.html";
        } else {
            window.location.href = "evaluator.html";
        }
    })
    .catch(err => console.error(err));
}