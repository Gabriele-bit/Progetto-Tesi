import { useState } from "react";
import "../css/Login.css";
import { Link, useNavigate } from "react-router-dom";

function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [errorLogin, setErrorLogin] = useState(false);
    const [notExist, setNotExist] = useState(false);
    const [required, setRequired] = useState(false);
    const navigate = useNavigate();

    const checkUser = async () => {
        try {
            const response = await fetch("/api/login/checkUser", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email, password }),
            });
            if (response.ok) {
               const existing= await response.json()
                setNotExist(!existing);
            }
        } catch (error) {
            console.error("Errore durante il login:", error);
            setErrorLogin(true);
        }
    };

    const handleLogin = async (e) => {
        e.preventDefault();
        if (email === "" || password === "") {
            setRequired(true);
            return;
        }
        setRequired(false);

        checkUser();
        if (notExist) navigate("/"); 
    };

    return (
        <div className="loginContainer">
            <form className="loginForm" onSubmit={handleLogin}>
                <div className="formHeader">
                    <img src="/logo_transparentGIORNO.png" alt="Logo" />
                    <h2>Login</h2>
                </div>
                {required && (
                    <span className="alert">Compila tutti i campi obbligatori!</span>
                )}
                {errorLogin && !notExist && (
                    <span className="alert">Errore durante il login</span>
                )}
                {notExist && (
                    <span className="alert">Utente non esistente</span>
                )}

                <span>Email</span>
                <input
                    type="email"
                    className="formInput"
                    onChange={(e) => setEmail(e.target.value)}
                    value={email}
                    autoComplete="email"
                />

                <span>Password</span>
                <input
                    type="password"
                    className="formInput"
                    onChange={(e) => setPassword(e.target.value)}
                    value={password}
                    autoComplete="current-password"
                />

                <button type="submit" className="loginButton">Accedi</button>

                <hr />
                <span>Non hai un account? <Link to="/Registrazione">Registrati!</Link></span>
            </form>
        </div>
    );
}

export default Login;
