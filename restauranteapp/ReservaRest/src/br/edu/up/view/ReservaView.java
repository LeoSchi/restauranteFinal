package br.edu.up.view;

import java.util.List;
import java.util.Scanner;

import br.edu.up.model.Reserva;

public class ReservaView {
    private Scanner scanner;

    public ReservaView() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\nMenu de Reservas:");
        System.out.println("1. Fazer Reserva");
        System.out.println("2. Cancelar Reserva");
        System.out.println("3. Ver Reservas");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public void showReservas(List<Reserva> reservas) {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println("Cliente: " + reserva.getNomeCliente() +
                                   ", Data: " + reserva.getData() +
                                   ", Nº de Pessoas: " + reserva.getNumeroPessoas());
            }
        }
    }

    public Reserva getReservaDetails() {
        scanner.nextLine(); 
        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        System.out.println("Digite a data (DD/MM/AAAA):");
        String data = scanner.nextLine();
        System.out.println("Digite o número de pessoas:");
        int numeroPessoas = scanner.nextInt();
        scanner.nextLine();
        return new Reserva(nomeCliente, data, numeroPessoas);
    }

    public String getNomeCliente() {
        scanner.nextLine();
        System.out.println("Digite o nome do cliente para cancelar a reserva:");
        return scanner.nextLine();
    }
}
