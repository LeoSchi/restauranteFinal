package br.edu.up.view;

import java.util.Scanner;

import br.edu.up.model.Cliente;
import br.edu.up.controller.ClienteController;

public class ClienteView {

    String name,cpf,fone,local;

    private Scanner scanner = new Scanner(System.in);
    ClienteController ctrlcliente = new ClienteController();

    public void cadastrarCliente(){

        System.out.println("Insira os dados solicitados:");
        System.out.println("Nome");
        name = scanner.nextLine();
        System.out.println("CPF");
        cpf = scanner.nextLine();
        System.out.println("Telefone");
        fone = scanner.nextLine();
        System.out.println("Endereço");
        local = scanner.nextLine(); 

        Cliente cliente = new Cliente(name,cpf,fone,local);

        ctrlcliente.adicionarCliente(cliente);

        System.out.println("Cliente adicionado com sucesso!");
    }

    //cogito ergo sum

}