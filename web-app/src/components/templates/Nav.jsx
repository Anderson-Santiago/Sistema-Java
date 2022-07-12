/* eslint-disable import/no-anonymous-default-export */
import './Nav.css'
import React from 'react'
import { Link } from 'react-router-dom' 

export default props => 
    <aside className="menu-area">
        <nav className="menu">
            <Link to="/">
                <i className="fa fa-home"> Inicio</i>
            </Link>
            <Link to="/product">
                <i className="fa fa-product-hunt"> Produtos</i>
            </Link>
        </nav>
    </aside>


