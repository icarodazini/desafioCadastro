package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Scanner;

public class ListarPetsPorAlgumCriterio {
    Scanner scanner = new Scanner(System.in);

    public void buscarDados() {
        try {
            String tipoAnimal = "";
            while (true) {
                System.out.print("Digite o tipo de animal (CACHORRO ou GATO): ");
                tipoAnimal = scanner.nextLine().trim();
                String tipoNormalizado = normalizar(tipoAnimal);

                if (tipoNormalizado.equals("cachorro") || tipoNormalizado.equals("gato")) {
                    tipoAnimal = tipoNormalizado.toUpperCase(); // padroniza para comparação depois
                    break;
                } else {
                    System.out.println("⚠️ Tipo inválido. Digite apenas 'CACHORRO' ou 'GATO'.");
                }
            }
            menuBuscaPet();

            System.out.print("Digite sua(s) opção(ões) de busca (ex: 1 ou 1,3): ");
            String entrada = scanner.nextLine();
            String[] opcoes = entrada.split(",");

            if (opcoes.length == 0 || entrada.isBlank()) {
                buscarPorCriterios(0, 0, null, null, tipoAnimal);
            } else if (opcoes.length == 1) {
                int opcao1 = Integer.parseInt(opcoes[0].trim());
                System.out.print("Digite o dado relacionado à opção " + opcao1 + ": ");
                String valor1 = scanner.nextLine();
                buscarPorCriterios(opcao1, 0, valor1, null, tipoAnimal);
            } else if (opcoes.length == 2) {
                int opcao1 = Integer.parseInt(opcoes[0].trim());
                int opcao2 = Integer.parseInt(opcoes[1].trim());
                System.out.print("Digite o dado relacionado à opção " + opcao1 + ": ");
                String valor1 = scanner.nextLine();
                System.out.print("Digite o dado relacionado à opção " + opcao2 + ": ");
                String valor2 = scanner.nextLine();
                buscarPorCriterios(opcao1, opcao2, valor1, valor2, tipoAnimal);
            } else {
                System.out.println("Entrada inválida! Máximo de 2 critérios.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Por favor, insira números válidos para as opções de busca.");
        } catch (Exception e) {
            System.out.println("Erro ao ler os dados do pet: " + e.getMessage());
        }
    }

    private void buscarPorCriterios(int campo1, int campo2, String valor1, String valor2, String tipoAnimal) {
        File diretorio = new File("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\petsCadastrados");

        if (!diretorio.isDirectory()) {
            System.out.println("O caminho especificado não é um diretório válido.");
            return;
        }

        File[] arquivos = diretorio.listFiles((dir, name) -> name.endsWith(".TXT"));

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum pet cadastrado encontrado.");
            return;
        }
        StringBuilder resultados = new StringBuilder();
        int contador = 1;

        for (File arquivo : arquivos) {
            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                String[] campos = new String[7];
                boolean corresponde = true;

                while ((linha = br.readLine()) != null) {
                    String[] partes = linha.split(" - ");
                    int indice = Integer.parseInt(partes[0].trim()) - 1;
                    campos[indice] = partes[1].trim();
                }

                if (!normalizar(campos[1]).contains(normalizar(tipoAnimal))) {
                    continue;
                }

                if (campo1 > 0 && campo1 <= 7 && valor1 != null) {
                    String campo = normalizar(campos[campo1 - 1]);
                    String valor = normalizar(valor1);
                    if (!campo.contains(valor)) {
                        corresponde = false;
                    }
                }

                if (campo2 > 0 && campo2 <= 7 && valor2 != null) {
                    String campo = normalizar(campos[campo2 - 1]);
                    String valor = normalizar(valor2);
                    if (!campo.contains(valor)) {
                        corresponde = false;
                    }
                }

                if (corresponde) {
                    resultados.append(contador++).append(". ")
                            .append(campos[0]).append(" - ") // Nome
                            .append(campos[1]).append(" - ") // Tipo
                            .append(campos[2]).append(" - ") // Sexo
                            .append(campos[3]).append(" - ") // Endereço
                            .append(campos[4]).append(" - ") // Idade
                            .append(campos[5]).append(" - ") // Peso
                            .append(campos[6]).append("\n"); // Raça
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + arquivo.getName());
            }
        }

        if (resultados.length() > 0) {
            System.out.println("Resultados encontrados:\n" + resultados);
        } else {
            System.out.println("Nenhum pet encontrado com os critérios especificados.");
        }
    }

    private String normalizar(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }

    public void menuBuscaPet() {
        System.out.println("\n📋 Quais critérios adicionais você deseja usar para buscar o pet?");
        System.out.println("1. Nome ou sobrenome");
        System.out.println("2. Tipo (Cachorro, Gato...)");
        System.out.println("3. Sexo");
        System.out.println("4. Endereço");
        System.out.println("5. Idade");
        System.out.println("6. Peso");
        System.out.println("7. Raça");
    }
}
