import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

class Edit extends Component {

    constructor(props) {
        super(props);
        this.state = {
            stock: {},
            link: '',
            isLoading: true
        };
    }

    async componentDidMount() {
        axios.get(this.props.location.state.link + '?projection=update')
            .then(res => {
                this.setState({ stock: res.data, link: res.data._links.self.href, isLoading: false });
                console.log(this.state.stock);
            });
    }

    onChange = (e) => {
        const state = this.state.stock
        state[e.target.name] = e.target.value;
        this.setState({stock:state});
    }

    onSubmit = (e) => {
        e.preventDefault();

        const {stock, link} = this.state

        axios.put(link, stock)
            .then((result) => {
                this.props.history.push({ pathname: '/show', state: {link: link} })
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
                            EDIT Stock
                        </h3>
                    </div>
                    <div class="panel-body">
                        <h4><Link to={{ pathname: '/show', state: {link: link} }}><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Stocks List</Link></h4>
                        <form onSubmit={this.onSubmit}>
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" class="form-control" name="name" value={stock.name} onChange={this.onChange} placeholder="Name" />
                            </div>
                            <div class="form-group">
                                <label for="currentPrice">Current Price:</label>
                                <input type="number" class="form-control" name="currentPrice" value={stock.currentPrice} onChange={this.onChange} placeholder="Current price" />
                            </div>
                            <button type="submit" class="btn btn-default">Update</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default Edit;