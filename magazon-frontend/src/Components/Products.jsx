import { useEffect, useState } from "react";
import NavBar from "./NavBar";
import Card from "./Card";
import "../css/Products.css"
import { AiOutlineFilter } from 'react-icons/ai';

function Products() {
    const [products, setProducts] = useState([]);
    const [categories, setCategories] = useState([]);
    const [selectedCategory, setSelectedCategory] = useState("");
    useEffect(() => {
        fetch('/api/prodotti')
            .then(response => response.json())
            .then(data => setProducts(data))
            .catch(error => console.error('Errore nel recupero dei prodotti:', error));
        fetch("/api/categorie")
            .then(response => response.json())
            .then(data => {
                const sortedCategories = data.sort((a, b) =>
                    a.category_name.localeCompare(b.category_name)
                );
                setCategories(sortedCategories);
            })
            .catch(error => console.error('Errore nel recupero dei prodotti:', error));
    }, []);

    const changeCategory = (e) => {
        setSelectedCategory(e.target.value);
        console.log("categoria selezionata: ", e.target.value);
    }

    const filteredProducts = selectedCategory
        ? products.filter(product => product.category.category_id == selectedCategory)
        : products;
    console.log("dimensione filteredProducts: ", filteredProducts.length);

    return (
        <>
            <NavBar></NavBar>
            <div className="searchBox">
                <input className="searchBar" type="text" placeholder="Cosa vuoi cercare?"></input>
                <p title="filtra"><AiOutlineFilter size={24} /> </p>
                <select name="categories" id="filter" onChange={changeCategory} value={selectedCategory}>
                    <option value={""}>Tutti i prodotti</option>
                    {categories.map(category => (
                        <option key={category.category_id} value={category.category_id}>{category.category_name}</option>
                    ))}
                </select>
            </div>

            <div className="CardsContainer">
                {/* <Card
                    key={1}
                    name={"ps5"}
                    price={300}
                    description={"ok"}
                    image_url={"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD5WRQaxgZqnVp6e3VA_qGSCU-UUlnMJo_EA&s"}>
                </Card> */}


                {filteredProducts.map(product => (
                    <Card
                        key={product.product_id}
                        name={product.name}
                        price={product.price}
                        category_name={product.category.category_name}
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