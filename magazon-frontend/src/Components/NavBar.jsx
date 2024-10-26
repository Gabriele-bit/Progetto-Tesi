import { Link } from 'react-router-dom';
import "../css/NavBar.css"
function NavBar() {
    return (
        <div>
            <ul>
                <li>
                    <Link to={"/"} activeClassName="active">Home </Link>
                </li>
                <li>
                    <Link to={"/" }activeClassName="active">Prodotti</Link>
                </li>
                <li>
                    <Link to={"/"} activeClassName="active">Carrello</Link>
                </li>
                <li>
                    <Link to={"/"} activeClassName="active">Wishlist</Link>
                </li>
                <li>
                    <Link to={"/"} activeClassName="active">Profilo</Link>
                </li>
                <li>
                    <Link to={"/"} activeClassName="active">About</Link>
                </li>
            </ul>
        </div>

    );
}

export default NavBar;