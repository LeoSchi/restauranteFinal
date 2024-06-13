package br.edu.up.dao;

import java.util.List;

public interface DAO<T> {
    void adicionar(T t);
    T buscar(String id);
    List<T> listar();
    void atualizar(T t);
    void remover(String id);
}