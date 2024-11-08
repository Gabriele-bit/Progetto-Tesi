import "../css/Card.css";
import { Link } from "react-router-dom";
function Card(props) {
    const { name, description, price, id, image_url, category_name } = props;

    return (
        <div className="product-card">
            <Link to={`/Prodotto/${id}`} className="link" key={id}>
                <img src={image_url} className="product-image" />
                <hr></hr>
                <h3 className="product-name">{name}</h3>
                <p className="product-category">{category_name}</p>
                <p className="product-price">€{price.toFixed(2)}</p>
                {/* <p className="product-description">{description}</p> */}
            </Link>
            <button className="add-to-cart-button">🛒Aggiungi al carrello</button>
        </div>
    );
}

export default Card;