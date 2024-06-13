package br.edu.up.controller;

import java.util.List;

import br.edu.up.daos.ReservaDAO;
import br.edu.up.model.Reserva;
import br.edu.up.view.ReservaView;

public class ReservaController {
    private ReservaDAO reservaDAO;
    private ReservaView reservaView;

    public ReservaController(ReservaDAO reservaDAO, ReservaView reservaView) {
        this.reservaDAO = reservaDAO;
        this.reservaView = reservaView;
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = reservaView.mostrarMenu();
            switch (opcao) {
                case 1:
                    adicionarReserva();
                    break;
                case 2:
                    cancelarReserva();
                    break;
                case 3:
                    listarReservas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    public void listarReservas() {
        List<Reserva> reservas = reservaDAO.getAllReservas();
        reservaView.showReservas(reservas);
    }

    public void adicionarReserva() {
        Reserva reserva = reservaView.getReservaDetails();
        reservaDAO.addReserva(reserva);
    }

    public void cancelarReserva() {
        String nomeCliente = reservaView.getNomeCliente();
        reservaDAO.removeReserva(nomeCliente);
    }
}
