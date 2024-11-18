import React, { useEffect, useState } from 'react';
import "../css/InputBar.css"
function InputBar() {

    const handleSubmit = (event) => {
        event.preventDefault();
        const userMessage = event.target.elements[0].value;
        console.log("Messaggio inviato:", userMessage);
        event.target.elements[0].value = "";
    };
    return (
        <div class="home">
            <div className='logo-container'>
                <img src="/logo_transparentGIORNO.png" alt="Magazon Logo" className="logo" />
            </div>
            <form onSubmit={handleSubmit} className='input-container'>
                <input type="text" className="input-box" placeholder="Come posso aiutarti?"></input>
            </form>
            <div id="responseMessage"></div>
        </div>
    );
}

export default InputBar;