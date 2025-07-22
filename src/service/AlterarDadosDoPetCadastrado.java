package service;

import java.io.*;
import java.util.Scanner;

public class AlterarDadosDoPetCadastrado {
    Scanner scanner = new Scanner(System.in);

    public void alterarPetNoArquivo() {
        ListarTodosOsPetsCadastrados buscarTodosPetsCadastrados = new ListarTodosOsPetsCadastrados();
        File diretorio = new File("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\petsCadastrados");

        if (diretorio.isDirectory()) {
            File[] petsCadastrados = diretorio.listFiles(((dir, name) -> name.endsWith(".TXT")));

            if (petsCadastrados != null && petsCadastrados.length > 0) {
                boolean petsEncontrados = false;

                while (!petsEncontrados) {
                    buscarTodosPetsCadastrados.buscarTodosPets();

                    System.out.println("\nDigite o número do pet que você deseja alterar os dados: ");
                    int petEscolhido = scanner.nextInt();
                    scanner.nextLine();

                    if (petEscolhido > 0 && petEscolhido <= petsCadastrados.length) {
                        File petSelecionado = petsCadastrados[petEscolhido - 1];
                        alterarDadosDoPet(petSelecionado);
                        petsEncontrados = true;
                    } else {
                        System.out.println("Número de pet inválido. Por favor, tente novamente.");
                    }
                }
            } else {
                System.out.println("Nenhum pet cadastrado encontrado.");
            }
        } else {
            System.out.println("O diretório especificado não é um diretório válido ou não existe.");
        }
    }

    private void alterarDadosDoPet(File petSelecionado) {
        try (BufferedReader br = new BufferedReader(new FileReader(petSelecionado))) {
            String[] dadosPet = new String[7];
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" - ");
                if (partes.length == 2) {
                    int indice = Integer.parseInt(partes[0].trim()) - 1;
                    dadosPet[indice] = partes[1].trim();
                }
            }

            System.out.println("Pet selecionado: " + dadosPet[0]);
            String[] opcoes = {"Nome", "Tipo", "Sexo", "Endereço", "Idade", "Peso", "Raça"};

            for (int i = 0; i < dadosPet.length; i++) {
                if (i == 1 || i == 2) {
                    System.out.println(opcoes[i] + " atual: " + dadosPet[i] + " (não pode ser alterado)");
                    continue;
                }

                System.out.println(opcoes[i] + " atual: " + dadosPet[i]);
                System.out.print("Digite o novo " + opcoes[i] + " (ou pressione Enter para manter o atual): ");
                String novoDado = scanner.nextLine();
                if (!novoDado.isEmpty()) {
                    dadosPet[i] = novoDado;
                }
            }

            salvarNovosDados(petSelecionado, dadosPet);
            System.out.println("Dados do pet alterados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void salvarNovosDados(File petSelecionado, String[] novosDados) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(petSelecionado))) {
            for (int i = 0; i < novosDados.length; i++) {
                bw.write((i + 1) + " - " + novosDados[i]);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
