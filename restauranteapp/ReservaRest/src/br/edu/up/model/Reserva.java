package br.edu.up.model;

public class Reserva {
    private String nomeCliente;
    private String data;
    private int numeroPessoas;

    public Reserva(String nomeCliente, String data, int numeroPessoas) {
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.numeroPessoas = numeroPessoas;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getData() {
        return data;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    @Override
    public String toString() {
        return nomeCliente + ";" + data + ";" + numeroPessoas;
    }

    public static Reserva fromString(String linha) {
        String[] partes = linha.split(";");
        return new Reserva(partes[0], partes[1], Integer.parseInt(partes[2]));
    }
}
