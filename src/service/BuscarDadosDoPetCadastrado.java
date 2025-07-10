package service;

import java.util.Scanner;

public class BuscarDadosDoPetCadastrado {
    Scanner scanner = new Scanner(System.in);

    public void buscarDados() {
        menuBuscaPet();

        try {
            System.out.print("Digite sua(s) opção(ões) de busca.");
            String entrada = scanner.nextLine();
            String[] opcoes = entrada.split(",");

            if (opcoes.length == 1) {
                int opcao1 = Integer.parseInt(opcoes[0].trim());
                processarOpcao(opcao1, 0);
            }
            if (opcoes.length == 2) {
                int opcao1 = Integer.parseInt(opcoes[0].trim());
                int opcao2 = Integer.parseInt(opcoes[1].trim());
                processarOpcao(opcao1, opcao2);
            } else {
                System.out.println("Entrada inválida! Por favor, insira uma ou duas opções separadas por vírgula.");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida! Por favor, insira números válidos entre 1 e 6.");
        }
    }

    public void processarOpcao(int opcao1, int opcao2) {
        System.out.println("Buscando com os seguintes critérios:");
        buscarPorCriterio(opcao1);
        if (opcao2 != 0) {
            buscarPorCriterio(opcao2);
        }
    }

    public void buscarPorCriterio(int opcao) {
        switch (opcao) {
            case 1 -> System.out.println("Buscando por nome ou sobrenome");
            case 2 -> System.out.println("Buscando por sexo");
            case 3 -> System.out.println("Buscando por idade");
            case 4 -> System.out.println("Buscando por peso");
            case 5 -> System.out.println("Buscando por raça");
            case 6 -> System.out.println("Buscando por endereço");
            default -> System.out.println("Opção inválida! Por favor, escolha uma opção entre 1 e 6.");
        }
    }

    public void menuBuscaPet() {
        System.out.println("Bem-vindo ao sistema de busca de pets cadastrados!");
        System.out.println("Por quais critérios você gostaria de buscar o pet?:");
        System.out.println("1. Nome ou sobrenome");
        System.out.println("2. Sexo");
        System.out.println("3. Idade");
        System.out.println("4. Peso");
        System.out.println("5. Raça");
        System.out.println("6. Endereço");
    }
}
