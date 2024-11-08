import React from 'react';
import NavBar from './NavBar';
import "../css/NotFound.css";
function NotFound(props){
    const {errorType}= props;
    return(
        <>
        <div className="errorContainer">
            <h1>{errorType}</h1>
            <a href='/'>Home</a>
        </div>
        </>
    );
}
export default NotFound;