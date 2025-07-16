package service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CriacaoMenuInicial {
    public void menuInicial() {
        Scanner scanner = new Scanner(System.in);
        exibirMenuInicial();

        try {
            System.out.print("Digite sua opção: ");
            int opcao = scanner.nextInt();
            processarOpcao(opcao);
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida! Por favor, digite um número entre 1 e 6.");
        }
    }

    public void processarOpcao(int opcao) {
        MapeamentoDeUmNovoPet mapeamentoDeUmNovoPet = new MapeamentoDeUmNovoPet();
        BuscarDadosDoPetCadastrado buscarDadosDoPet = new BuscarDadosDoPetCadastrado();
        switch (opcao) {
            case 1 -> {
                mapeamentoDeUmNovoPet.mapeandoAsPerguntas();
                CadastrarUmNovoPet cadastrarUmNovoPet = new CadastrarUmNovoPet(mapeamentoDeUmNovoPet);
                cadastrarUmNovoPet.cadastrarPetNoArquivo();
            }
            case 2 -> System.out.println("Alterar os dados do pet cadastrado.");
            case 3 -> System.out.println("Deletar um pet cadastrado.");
            case 4 -> {
                BuscarTodosPetsCadastrados buscarTodosPetsCadastrados = new BuscarTodosPetsCadastrados();
                buscarTodosPetsCadastrados.buscarTodosPets();
            }
            case 5 -> {
                buscarDadosDoPet.buscarDados();
            }
            case 6 -> System.out.println("Saindo do sistema.");
            default -> System.out.println("Opção inválida! Por favor, escolha uma opção entre 1 e 6.");
        }
    }

    public void exibirMenuInicial() {
        System.out.println("Bem-vindo ao sistema de cadastro!");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");
    }
}
