import React, { Component, useState } from "react";
import Main from '../templates/Main';
import Axios from 'axios'

const headerProps = {
    icon: "fa fa-product-hunt",
    title: "Produtos",
    subtitle: 'Cadastro de produtos: Incluir, Listar, Alterar e Excluir'
}
const initialState = {
    products: { name: '', stock: 0, price: 0.0 },
    list: []
}
export default class Products extends Component {

    state = { ...initialState }

    componentWillMount() {
        Axios("http://localhost:3001/productdb").then(resp => {
            this.setState({ list: resp.data })
        })
    }

    clear() {
        this.setState({ products: initialState.products })
    }

    reload(){
        window.location.reload()
    }
    save() {
        const products = this.state.products
        const method = products.id ? 'put' : 'post'
        const url = products.id ? `${'http://localhost:3001/update'}` : 'http://localhost:3001/create'
        Axios[method](url, products)
            .then(resp => {
                const list = this.getUpdatedList(resp.data)
                this.setState({ products: initialState.products, list })
                this.reload()
            })
    }

    getUpdatedList(products, add = true) {
        const list = this.state.list.filter(u => u.id !== products.id)
        if (add) list.unshift(products)
        return list
    }

    updateField(event) {
        const products = { ...this.state.products }
        products[event.target.name] = event.target.value
        this.setState({ products })
    }
    renderForm() {
        return (
            <div className="form">
                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Nome</label>
                            <input type="text" className="form-control"
                                name="name"
                                valeu={this.state.products.name}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o nome do Produto"
                            />
                        </div>
                    </div>
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Estoque</label>
                            <input type="text" className="form-control"
                                name="stock"
                                valeu={this.state.products.stock}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite a quantidade que chegou" />
                        </div>
                    </div>
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Preço</label>
                            <input type="text" className="form-control"
                                name="price"
                                valeu={this.state.products.price}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o preço do produto EX: 2.99" />
                        </div>
                    </div>
                </div>
                <hr />
                <div className="row">
                    <div className="col-12 d-flex justify_content-end">
                        <button className="btn btn-primary"
                            onClick={e => this.save(e)}>
                            Salvar
                        </button>
                        <button className="btn btn-secondary nl-2"
                            onClick={e => this.clear(e)}>
                            Cancelar
                        </button>
                    </div>
                </div>
            </div>
        )
    }

    load(products) {
        this.setState({ products })
    }

    remove(products) {
        Axios.delete(`http://localhost:3001/delete/${products.id}`).then(resp => {
            const list = this.getUpdatedList(products, false)
            this.setState({ list })
        })
    }

    renderTable() {
        return (
            <table className="table mt-4">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Estoque</th>
                        <th>Preço</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {this.renderRows()}
                </tbody>
            </table>
        )
    }

    renderRows() {
        return this.state.list.map(products => {
            return (
                <tr key={products.id}>
                    <td>{products.id}</td>
                    <td>{products.name}</td>
                    <td>{products.stock}</td>
                    <td>{products.price}</td>
                    <td>
                        <button className="btn btn-warning"
                            onClick={() => this.load(products)}>
                            <i className="fa fa-pencil"></i>
                        </button>
                        <button className="btn btn-danger ml-2"
                            onClick={() => this.remove(products)}>
                            <i className="fa fa-trash"></i>
                        </button>
                    </td>
                </tr>
            )
        })
    }

    render() {
        return (
            <Main {...headerProps}>
                {this.renderForm()}
                {this.renderTable()}
            </Main>
        )
    }
}