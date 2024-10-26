import React, { useEffect, useState } from 'react';
function InputBar() {
    const [displayedText, setDisplayedText] = useState("");
    const messageText = "Benvenuto in Magazon";

    useEffect(() => {
        let index = 0;
        const intervalId = setInterval(() => {
            if (index <= messageText.length) {
                setDisplayedText(messageText.slice(0, index + 1));
                index++;
            } else {
                clearInterval(intervalId);
            }
        }, 70);

        return () => clearInterval(intervalId);
    }, [messageText]);

    const handleSubmit = (event) => {
        event.preventDefault();
        const userMessage = event.target.elements[0].value;
        console.log("Messaggio inviato:", userMessage);
        event.target.elements[0].value = "";
    };
    return (
        <div class="App">
            <img src="/logo_transparent.png" alt="Magazon Logo" className="navbar-logo" />
            <p id="message">{displayedText}</p>
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <textarea className="input-box" placeholder="Come posso aiutarti?"></textarea>
                </div>
            </form>
            <div id="responseMessage"></div>
        </div>
    );
}

export default InputBar;