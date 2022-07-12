import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';
import 'font-awesome/css/font-awesome.min.css';
import React from 'react';
import { HashRouter } from 'react-router-dom';

// import SignIn from './SignIn';

import Logo from '../templates/Logo';
import Nav from '../templates/Nav';
import Routes from './Routes';


export default props =>
        <HashRouter>
            <div className="app">
                <Logo />
                <Nav />
                <Routes />
            </div>
        </HashRouter>
