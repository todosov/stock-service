import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import App from './App';
import './App.css';
import Edit from './stocks/Edit';
import Create from './stocks/Create';
import Show from './stocks/Show';

ReactDOM.render(
<Router>
<div>
<Route exact path='/' component={App} />
<Route path='/edit' component={Edit} />
<Route path='/create' component={Create} />
<Route path='/show' component={Show} />
</div>
</Router>,
document.getElementById('root')
);