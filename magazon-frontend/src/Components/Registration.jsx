import { useState } from "react";
import "../css/Registration.css";
import {useNavigate } from "react-router-dom";

function Registration() {
    const navigate = useNavigate();
    const [newUser, setNewUser] = useState({ userName: "", user_surname: "", number: "", email: "", address: "", password: "" });
    const [repeatePassword, setRepeatePassword] = useState("");
    const [required, setRequired] = useState(false);
    const [notSamePass, setNotSamePass] = useState(false);
    const [existingEmail, setExistingEmail] = useState(false);
    const [isSubmitting, setIsSubmitting] = useState(false);

    const showInfo = () => {
        const ele = document.getElementsByClassName("otherInfo")[0];
        ele.style.display = ele.style.display === "none" ? "flex" : "none";
    };

    const checkRequired = () => {
        if (newUser.user_name == "" || newUser.password == "" || newUser.email == "" || repeatePassword == "") {
            setRequired(true);
        }
        setRequired(false);
    };

    const checkPassword = () => {
        if (newUser.password != repeatePassword || repeatePassword == "") {
            setNotSamePass(true);
        }
        setNotSamePass(false);
    };

    const checkExistingEmail = async () => {
        try {
            const response = await fetch(`/api/signup/checkExistingEmail?email=${newUser.email}`);
            if (response.ok) {
                const emailExists = await response.json();
                setExistingEmail(emailExists);
            }
        } catch (error) {
            console.error("Errore nel controllo email:", error);
            return false;
        }
    };

    const sendInformation = async (e) => {
        e.preventDefault();
         checkRequired();
        checkPassword();
        if (required==true && notSamePass==true) return;

        checkExistingEmail();
        if (existingEmail) return;
        setIsSubmitting(true);
        try {
            const response = await fetch("/api/signup/addUser", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(newUser),
            });
            if (response.ok) {
                console.log("Registrazione completata con successo");
                navigate("/"); 
            } else {
                console.error("Errore durante la registrazione");
            }
        } catch (error) {
            console.error("Errore durante l'invio:", error);
        }
        finally {
            setIsSubmitting(false); 
        }
    };

    return (
        <div className="loginContainer">
            <form className="loginForm">
                <div className="formHeader">
                    <img src="/logo_transparentGIORNO.png" alt="Logo" />
                    <h2>Registrazione</h2>
                </div>

                {required && <span className="alert">Compila tutti i campi obbligatori!</span>}
                {existingEmail && <span className="alert">Email già registrata!</span>}
                {notSamePass && !required && <span className="alert">Le password non coincidono!</span>}

                <div className="requiredInfo">
                    <span className="required">Nome </span>
                    <input
                        type="text"
                        className="formInput"
                        onChange={(e) => setNewUser({ ...newUser, user_name: e.target.value })}
                        autoComplete="given-name"
                    />

                    <span className="required">Email </span>
                    <input
                        type="email"
                        className="formInput"
                        onChange={(e) => setNewUser({ ...newUser, email: e.target.value })}
                        autoComplete="email"
                    />

                    <span className="required">Password </span>
                    <input
                        type="password"
                        className="formInput"
                        onChange={(e) => setNewUser({ ...newUser, password: e.target.value })}
                        autoComplete="new-password"
                    />

                    <span className="required">Ripeti Password </span>
                    <input
                        type="password"
                        className="formInput"
                        onChange={(e) => setRepeatePassword(e.target.value)}
                        autoComplete="new-password"
                    />
                </div>

                <fieldset>
                    <legend onClick={showInfo}>Altre informazioni</legend>
                    <div className="otherInfo">
                        <span>Cognome</span>
                        <input
                            type="text"
                            className="formInput"
                            onChange={(e) => setNewUser({ ...newUser, user_surname: e.target.value })}
                            autoComplete="family-name"
                        />
                        <span>Numero di telefono</span>
                        <input
                            type="tel"
                            className="formInput"
                            onChange={(e) => setNewUser({ ...newUser, number: e.target.value })}
                            autoComplete="tel"
                        />
                        <span>Indirizzo (via/piazza)</span>
                        <input
                            type="text"
                            className="formInput"
                            onChange={(e) => setNewUser({ ...newUser, address: e.target.value })}
                            autoComplete="street-address"
                        />
                    </div>
                </fieldset>

                <button type="submit" onClick={sendInformation} className="loginButton">
                    {isSubmitting ? "Registrazione in corso..." : "Registrati"}
                </button>
            </form>
        </div>
    );
}

export default Registration;
