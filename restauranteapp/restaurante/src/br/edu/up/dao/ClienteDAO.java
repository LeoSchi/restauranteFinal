package br.edu.up.dao;

import br.edu.up.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente> {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscar(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes);
    }

    @Override
    public void atualizar(Cliente cliente) {
        Cliente existente = buscar(cliente.getCpf());
        if (existente != null) {
            existente.setNome(cliente.getNome());
            existente.setTelefone(cliente.getTelefone());
            existente.setEndereco(cliente.getEndereco());
        }
    }

    @Override
    public void remover(String cpf) {
        Cliente cliente = buscar(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
        }
    }
}
