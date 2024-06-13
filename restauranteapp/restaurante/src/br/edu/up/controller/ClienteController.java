package br.edu.up.controller;

import br.edu.up.dao.ClienteDAO;
import br.edu.up.model.Cliente;

public class ClienteController {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void adicionarCliente(Cliente cliente) {
        clienteDAO.adicionar(cliente);
    }

}