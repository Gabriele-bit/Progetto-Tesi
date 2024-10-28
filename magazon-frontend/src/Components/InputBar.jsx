import React, { useEffect, useState } from 'react';
function InputBar() {
    
    const handleSubmit = (event) => {
        event.preventDefault();
        const userMessage = event.target.elements[0].value;
        console.log("Messaggio inviato:", userMessage);
        event.target.elements[0].value = "";
    };
    return (
        <div class="App">
            <img src="/logo_transparent.png" alt="Magazon Logo" className="navbar-logo" />
            <p id="message">Benvenuto in Magazon</p>
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <input type="text" className="input-box" placeholder="Come posso aiutarti?"></input>
                </div>
            </form>
            <div id="responseMessage"></div>
        </div>
    );
}

export default InputBar;