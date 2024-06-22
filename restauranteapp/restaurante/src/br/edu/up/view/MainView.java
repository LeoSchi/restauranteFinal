package br.edu.up.view;

import br.edu.up.controller.ReservaController;
import br.edu.up.dao.ReservaDAO;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        ProdutoView produtoView = new ProdutoView();
        ReservaView reservaView = new ReservaView();

        ReservaDAO reservaDAO = new ReservaDAO();
        ReservaController reservaController = new ReservaController(reservaDAO, reservaView);

        do {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Cadastro de Produtos");
            System.out.println("2. Realizar Reserva");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    produtoView.iniciar();
                    break;
                case 2:
                    int opcaoReserva;
                    do {
                        opcaoReserva = reservaView.mostrarMenu();
                        switch (opcaoReserva) {
                            case 1:
                                reservaController.adicionarReserva();
                                break;
                            case 2:
                                reservaController.cancelarReserva();
                                break;
                            case 3:
                                reservaController.listarReservas();
                                break;
                            case 4:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    } while (opcaoReserva != 4);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}
