import { Link, NavLink } from 'react-router-dom';
import "../css/NavBar.css"
function NavBar() {
    return (
        <div>
            <ul>
                <li>
                    <NavLink to={"/"} activeClassName="active">Home </NavLink>
                </li>
                <li>
                    <NavLink to={"/Prodotti" }activeClassName="active">Prodotti</NavLink>
                </li>
                <li>
                    <NavLink to={"/Carrello"} activeClassName="active">Carrello</NavLink>
                </li>
                <li>
                    <NavLink to={"/Wishlist"} activeClassName="active">Wishlist</NavLink>
                </li>
                <li>
                    <NavLink to={"/Profilo"} activeClassName="active">Profilo</NavLink>
                </li>
                <li>
                    <NavLink to={"/About"} activeClassName="active">About</NavLink>
                </li>
            </ul>
        </div>

    );
}

export default NavBar;