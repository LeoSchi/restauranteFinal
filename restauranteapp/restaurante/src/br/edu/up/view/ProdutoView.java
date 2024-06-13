package br.edu.up.view;

import br.edu.up.controller.ProdutoController;
import br.edu.up.model.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoView {
    private final Scanner scanner;
    private final ProdutoController produtoController;
    private final List<Produto> pedido;

    public ProdutoView() {
        this.scanner = new Scanner(System.in);
        this.produtoController = new ProdutoController();
        this.pedido = new ArrayList<>();
    }

    public void adicionarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Produto produto = new Produto(nome, preco);
        produtoController.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");

        pedido.add(produto);
        salvarProdutosEmArquivo();
    }

    public void listarProdutos() {
        List<Produto> produtos = produtoController.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
        }
    }

    public void adicionarProdutoAoPedido() {
        System.out.println("Digite o nome do produto que deseja adicionar ao pedido:");
        String nome = scanner.nextLine();
        Produto produto = produtoController.buscarProduto(nome);
        if (produto != null) {
            pedido.add(produto);
            System.out.println("Produto \"" + produto.getNome() + "\" adicionado ao pedido!");
            System.out.println("Total de produtos no pedido: " + pedido.size());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void calcularTotalPedido() {
        double total = calcularTotal();
        System.out.println("O total do pedido é: R$ " + total);
    }

    private double calcularTotal() {
        return pedido.stream().mapToDouble(Produto::getPreco).sum();
    }

    public void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Adicionar Produto ao Pedido");
        System.out.println("4. Calcular Total do Pedido");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    adicionarProdutoAoPedido();
                    break;
                case 4:
                    calcularTotalPedido();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private void salvarProdutosEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("produtos.txt", true))) {
            for (Produto produto : pedido) {
                writer.write("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
                writer.newLine();
            }
            System.out.println("Produtos salvos em produtos.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos em arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ProdutoView view = new ProdutoView();
        view.iniciar();
    }
}