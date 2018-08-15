import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router-dom';
import axios from 'axios';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            stocks: [],
            isLoading: true
        };
    }

    async componentDidMount() {
        axios.get('/api/stocks')
            .then(res => {
                this.setState({ stocks: res.data._embedded.stocks, isLoading: false });
            });
    }

    render() {
        const {stocks, isLoading} = this.state
        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            STOCKS LIST
                        </h3>
                    </div>
                    <div class="panel-body">
                        <h4><Link to="/create"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Add Stock</Link></h4>
                        <table class="table table-stripe">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Current Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            {stocks.map(stock =>
                                <tr>
                                    <td><Link to={{ pathname: '/show', state: {link: stock._links.self.href} }}>{stock.name}</Link></td>
                                    <td>{stock.currentPrice}</td>
                                </tr>
                            )}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        );
    }
}

export default App;