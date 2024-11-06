import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Products from './Components/Products';
import Product from './Components/Product';
import { ProductProvider } from './Store/ProductsContext';

const router = createBrowserRouter([
  {
    path: "/",
    element: <App></App>,
  },
  {
    path: "/Prodotti",
    element: <Products></Products>,
  },
  {
    path: "/Carrello",
    element: <App></App>,
  },
  {
    path: "/Wishlist",
    element: <App></App>,
  },
  {
    path: "/Profilo",
    element: <App></App>,
  },
  {
    path: "/About",
    element: <App></App>,
  },
  {
    path: "/Prodotto/:product_id",
    element: <Product />,
  },
]);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <ProductProvider>
      <RouterProvider router={router} />
    </ProductProvider>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
