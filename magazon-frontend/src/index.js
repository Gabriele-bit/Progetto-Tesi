import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {createBrowserRouter, RouterProvider } from 'react-router-dom';
import Products from './Components/Products';

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
  // {
  //   path: "/singlecard/:cardID",
  //   element: <SingleCard />,
  // },
  // {
  //   path: "/CardChildren",
  //   element: <CardChildren></CardChildren>,
  //   children: [
  //     {
  //       path: ":cardID",
  //       element: <SingleCard></SingleCard>
  //     },
  //   ],
  // }
]);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <BrowserRouter>
    <App />
  </BrowserRouter> */}
  <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
