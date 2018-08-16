import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import Moment from "moment/moment";

class Show extends Component {

    constructor(props) {
        super(props);
        this.state = {
            stock: {},
            link: '',
            isLoading: true
        };
    }

    async componentDidMount() {
        axios.get(this.props.location.state.link)
            .then(res => {
                this.setState({ stock: res.data, link: res.data._links.self.href, isLoading: false });
                console.log(this.state.stock);
            });
    }

    delete(url){
        console.log(url)
        axios.delete(url)
            .then((result) => {
                this.props.history.push("/")
            });
    }

    render() {
        const {stock, link, isLoading} = this.state;
        if (isLoading) {
            return <p>Loading...</p>;

        }
        return (
            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Stock Details
                        </h3>
                    </div>
                    <div class="panel-body">
                        <h4><Link to="/"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> Contacts List</Link></h4>
                        <dl>
                            <dt>Name:</dt>
                            <dd>{stock.name}</dd>
                            <dt>Current Price:</dt>
                            <dd>{stock.currentPrice}</dd>
                            <dt>Last Update:</dt>
                            <td>{Moment(stock.lastUpdate).format('DD-MMM-YYYY')}</td>
                        </dl>
                        <Link to={{ pathname: '/edit', state: {link: link} }} class="btn btn-success">Edit</Link>&nbsp;
                        <button onClick={this.delete.bind(this, this.state.link)} class="btn btn-danger">Delete</button>
                    </div>
                </div>
            </div>
        );
    }
}

export default Show;