import React, { createContext, useContext, useEffect, useState } from "react";

const ProductsContext = createContext();

//hook personalizzato. Scorciatoia anzichè scrivere useContext(ProductsContext)
export const useProducts = ()=>{
    return useContext(ProductsContext);
};

export const ProductProvider = ({children}) =>{
    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError]= useState(null);

    useEffect(() => {
        const fetchProducts= async()=>{
            setLoading(true);
            try{
                const response= await  fetch('/api/prodotti');
                if(!response.ok){
                    throw new Error("ERROE RECUPERO PRODOTTI");
                }
                const data= await response.json();
                setProducts(data);
            }catch(error){
                setError(error.message);
            }finally{
                setLoading(false);
            }
        };
        fetchProducts();
    },[]);

    return(
        //avvolge tutti i componenti figli nel provider (il quale fornisce products e setProducts). NB: nell'index.jsx il provider avvolge il router (quindi tutta la app)
        <ProductsContext.Provider value= {{products,setProducts, loading,setLoading,error,setError}}>
            {children}
        </ProductsContext.Provider>
    );
};