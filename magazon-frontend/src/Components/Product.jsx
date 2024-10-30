import { useParams } from "react-router-dom";
import { useProducts } from "../Store/ProductsContext";
import NavBar from "./NavBar";
import Card from "./Card";

function Product() {
    const { products, setProducts } = useProducts();
    const { product_id } = useParams();

    const product = products.find((product) => product.product_id == product_id);

    return (
        <>
            <NavBar></NavBar>
            <div style={{ display: "flex" }}>
                <Card
                    name={product.name}
                    price={product.price}
                    category_name={product.category.category_name}
                    description={product.description}
                    image_url={product.imageUrl}>
                </Card>
            </div>

        </>

    );
}

export default Product;