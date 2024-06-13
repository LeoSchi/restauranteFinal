package br.edu.up.modelos;

import java.util.List;

public class Pedido {

     private String id;
    private List<Produto> produtos;
    private double total;

    public Pedido(List<Produto> produtos, double total) {
        this.produtos = produtos;
        this.total = total;
    }
    public Pedido(){
        
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    }
