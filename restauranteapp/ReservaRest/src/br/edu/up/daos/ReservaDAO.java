package br.edu.up.daos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Reserva;

public class ReservaDAO {
    private static final String FILE_NAME = "reservas.txt";

    public List<Reserva> getAllReservas() {
        List<Reserva> reservas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                reservas.add(Reserva.fromString(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public void addReserva(Reserva reserva) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(reserva.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeReserva(String nomeCliente) {
        List<Reserva> reservas = getAllReservas();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Reserva reserva : reservas) {
                if (!reserva.getNomeCliente().equalsIgnoreCase(nomeCliente)) {
                    bw.write(reserva.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
