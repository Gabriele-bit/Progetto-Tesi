import NavBar from "./NavBar";
import React from 'react';
function NotFound(props){
    const {errorType}= props;
    return(
        <>
        <NavBar></NavBar>
        <div className="errorContainer">
            <h1>{errorType}</h1>
        </div>
        </>
    );
}
export default NotFound;