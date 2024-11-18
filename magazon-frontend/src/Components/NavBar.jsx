import { NavLink } from 'react-router-dom';
import "../css/NavBar.css"
function NavBar() {
    return (
        <>
            <div className='header'>
                <span className="title">MAGAZON</span>
            </div>
            <div className='navdiv'>
                <ul>
                    <li>
                        <NavLink to={"/"} className={({isActive})=>isActive ? "active":""}>Home </NavLink>
                    </li>
                    <li>
                        <NavLink to={"/Catalogo"} className={({isActive})=>isActive ? "active":""}>Catalogo</NavLink>
                    </li>
                    <li>
                        <NavLink to={"/Carrello"} className={({isActive})=>isActive ? "active":""}>Carrello</NavLink>
                    </li>
                    <li>
                        <NavLink to={"/Wishlist"} className={({isActive})=>isActive ? "active":""}>Wishlist</NavLink>
                    </li>
                    <li>
                        <NavLink to={"/Profilo"} className={({isActive})=>isActive ? "active":""}>Profilo</NavLink>
                    </li>
                    <li>
                        <NavLink to={"/About"} className={({isActive})=>isActive ? "active":""}>About</NavLink>
                    </li>
                    <li>
                        <NavLink to={"/Login"} className={({isActive})=>isActive ? "active":""} >Login/Registrati</NavLink>
                    </li>
                </ul>
            </div>
        </>
    );
}

export default NavBar;