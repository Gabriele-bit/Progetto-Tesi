import { useParams } from "react-router-dom";
import { useProducts } from "../Store/ProductsContext";
import NavBar from "./NavBar";
import "../css/Product.css";
import NotFound from "./NotFound";

function Product() {
    const { products, loading, error } = useProducts();
    const { product_id } = useParams();

    const product = products.find((product) => product.product_id == product_id);
    if (loading) {
        return <p></p>
    }
    if (error) {
        return <NotFound errorType={error}></NotFound>;
    }
    if (!product) {
        return <NotFound errorType="Prodotto non trovato"></NotFound>;
    }

    return (
        <>
            <NavBar></NavBar>
            <div className="singleProduct">

                <div className="img">
                    <img className="product-img" src={product.image_url} alt="Immagine del prodotto" />
                </div>
                <div className="details">
                    <div className="information">
                        <h2 className="singleProduct-name">{product.name}</h2>
                        <span className="singleProduct-category">{product.category.category_name}</span>
                        <p className="singleProduct-description">{product.description}</p>
                        <span className="singleProduct-price">€{product.price}</span>
                    </div>
                    <div className="buttons">
                        <button className="buyButton">Acquista</button>
                        <button className="wishlistButton">Wishlist</button>
                    </div>
                </div>
            </div>
        </>

    );
}

export default Product;