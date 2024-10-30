import React, { createContext, useContext, useEffect, useState } from "react";

const ProductsContext = createContext();

//hook personalizzato. Scorciatoia anzichè scrivere useContext(ProductsContext)
export const useProducts = ()=>{
    return useContext(ProductsContext);
};

export const ProductProvider = ({children}) =>{
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetch('/api/prodotti')
            .then(response => response.json())
            .then(data => setProducts(data))
            .catch(error => console.error('Errore nel recupero dei prodotti:', error));
    },[]);

    return(
        //avvolge tutti i componenti figli nel provider (il quale fornisce products e setProducts). NB: nell'index.jsx il provider avvolge il router (quindi tutta la app)
        <ProductsContext.Provider value= {{products,setProducts}}>
            {children}
        </ProductsContext.Provider>
    );
};