import React from 'react';
import { Switch, Route, Redirect } from 'react-router';

import Home from '../home/Home';
import Product from '../products/Product'

export default props =>
    <Switch>
        <Route exact path='/' component={Home}/>
        <Route path='/product' component={Product}/>
        <Redirect from= '*' to='/' />
    </Switch>