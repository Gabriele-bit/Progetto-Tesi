import "../css/Card.css";
function Card(props) {
    const { name, description, price, id ,image_url} = props;
    console.log(image_url); // Posizionato correttamente
    return (
        <div className="product-card">
            <img src={image_url}  className="product-image" />
            <p> </p>
            <h3 className="product-name">{name}</h3>
            <p className="product-price">€{price.toFixed(2)}</p>
            <p className="product-description">{description}</p>
            <button className="add-to-cart-button">Aggiungi al Carrello</button>
        </div>
    );
}

export default Card;