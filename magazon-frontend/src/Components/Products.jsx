import { useEffect, useState } from "react";
import NavBar from "./NavBar";
import Card from "./Card";
import "../css/Products.css"

function Products() {
    const [products, setProducts] = useState([]);
    useEffect(() => {
        fetch('/Prodotti')
            .then(response => response.json())
            .then(data => {
                console.log(data); 
                setProducts(data)
            })
            
            .catch(error => console.error('Errore nel recupero dei prodotti:', error));
    }, []);

    return (
        <>
            <NavBar></NavBar>
            <div className="CardsContainer">
                {products.map(product => (
                    <Card
                        key={product.product_id}
                        name={product.name}
                        price={product.price}
                        description={product.description}
                        image_url={product.imageUrl}>
                    </Card>
                ))
                }
            </div>
        </ >
    );
}

export default Products;