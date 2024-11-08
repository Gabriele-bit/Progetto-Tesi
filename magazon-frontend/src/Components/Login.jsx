import "../css/Login.css";

function Login() {
    return (
        <div className="loginContainer">
            <form className="loginForm">
                <h2>Login</h2>
                <span>Nome utente</span>
                <input type="text" className="nameInput" ></input>
                <span>Password</span>
                <input type="password" className="passInput"></input>
                <button type="submit" className="loginButton">Accedi</button>
                <hr></hr>
                <span>Non hai un account? Registrati!</span>
                <input type="submit" className="signupButton" value={"Registrati"}></input>
            </form>
        </div>
    );
}

export default Login;