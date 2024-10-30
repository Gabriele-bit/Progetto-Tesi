import { useEffect, useState } from "react";
import NavBar from "./NavBar";
import Card from "./Card";
import "../css/Products.css";
import { Link } from 'react-router-dom';
import { useProducts } from "../Store/ProductsContext";

function Products() {
    const  {products, setProducts}  = useProducts();
    const [categories, setCategories] = useState([]);
    const [selectedCategory, setSelectedCategory] = useState("");
    const [searchTerm, setSearchTerm] = useState("");

    useEffect(() => {
        fetch("/api/categorie")
            .then(response => response.json())
            .then(data => {
                const sortedCategories = data.sort((a, b) =>
                    a.category_name.localeCompare(b.category_name)
                );
                setCategories(sortedCategories);
            })
            .catch(error => console.error('Errore nel recupero delle categorie:', error));
    }, []);


    const changeCategory = (e) => {
        setSelectedCategory(e.target.value);
    };

    const handleChange = (e) => {
        setSearchTerm(e.target.value);
    };

    const filteredProducts = products.filter(product => {
        const matchesCategory = selectedCategory ? product.category.category_id == selectedCategory : true;
        const matchesSearch = product.name.toLowerCase().includes(searchTerm.toLowerCase());
        return matchesCategory && matchesSearch;
    });


    return (
        <>
            <NavBar></NavBar>
            <div className="searchBox">
                <select name="categories" id="filter" onChange={changeCategory} value={selectedCategory}>
                    <option value={""}>Tutti i prodotti</option>
                    {categories.map(category => (
                        <option key={category.category_id} value={category.category_id}>{category.category_name}</option>
                    ))}
                </select>
                <input className="searchBar" type="text" placeholder="Cosa vuoi cercare?" value={searchTerm} onChange={handleChange}></input>
                <button type="submit"> 🔍</button>
            </div>
            <div className="CardsContainer">

             {/* <Link to={`/Prodotto/1`} key={1} className="link">
                    <Card
                        name={"alpaca"}
                        price={100}
                        category_name={2}
                        description={""}
                        image_url={""}>
                    </Card>
                </Link>
                <Link to={`/Prodotto/2`} key={2} className="link">
                    <Card
                        name={"alpaca"}
                        price={100}
                        category_name={2}
                        description={""}
                        image_url={""}>
                    </Card>
                </Link> */}
                {filteredProducts.length > 0 ? (
                    filteredProducts.map(product => (
                        <Link to={`/Prodotto/${product.product_id}`} className="link" key={product.product_id}>
                            <Card
                                name={product.name}
                                price={product.price}
                                category_name={product.category.category_name}
                                description={product.description}
                                image_url={product.imageUrl}>
                            </Card>
                        </Link>
                    ))
                ) : (
                    <p className="noProducts">Non esiste questo prodotto.. :( </p>
                )}
            </div>
        </>
    );
}

export default Products;
