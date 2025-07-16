package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Scanner;

public class BuscarDadosDoPetCadastrado {
    Scanner scanner = new Scanner(System.in);

    public void buscarDados() {
        try {
            System.out.print("Digite o tipo de animal (ex: CACHORRO, GATO, etc.): ");
            String tipoAnimal = scanner.nextLine();
            menuBuscaPet();

            System.out.print("Digite sua(s) opção(ões) de busca (separadas por vírgula): ");
            String entrada = scanner.nextLine();
            String[] opcoes = entrada.split(",");

            if (opcoes.length == 0) {
                buscarPorCriterios(2, 0, tipoAnimal, null);
            } else if (opcoes.length == 1) {
                int opcao1 = Integer.parseInt(opcoes[0].trim());
                System.out.print("Digite o dado relacionado à opção " + opcao1 + ": ");
                String dado1 = scanner.nextLine();
                buscarPorCriterios(2, opcao1, tipoAnimal, dado1);
            } else if (opcoes.length == 2) {
                int opcao1 = Integer.parseInt(opcoes[0].trim());
                int opcao2 = Integer.parseInt(opcoes[1].trim());
                System.out.print("Digite o dado relacionado à opção " + opcao1 + ": ");
                String dado1 = scanner.nextLine();
                System.out.print("Digite o dado relacionado à opção " + opcao2 + ": ");
                String dado2 = scanner.nextLine();
                buscarPorCriterios(2, opcao1, tipoAnimal, dado1);
            } else {
                System.out.println("Entrada inválida! Por favor, insira uma ou duas opções separadas por vírgula.");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida! Por favor, insira números válidos entre 1 e 7.");
        }
    }

    public void buscarPorCriterios(int opcao1, int opcao2, String dado1, String dado2) {
        File diretorio = new File("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\petsCadastrados");

        if (diretorio.isDirectory()) {
            File[] petsCadastrados = diretorio.listFiles((dir, name) -> name.endsWith(".TXT"));

            if (petsCadastrados != null && petsCadastrados.length > 0) {
                StringBuilder resultados = new StringBuilder();
                int contador = 1;

                for (File pet : petsCadastrados) {
                    try (BufferedReader br = new BufferedReader(new FileReader(pet))) {
                        String linha;
                        String[] campos = new String[7];
                        boolean encontrado = false;

                        while ((linha = br.readLine()) != null) {
                            String[] partes = linha.split(" - ");
                            int indiceCampo = Integer.parseInt(partes[0].trim()) - 1;
                            campos[indiceCampo] = partes[1].trim();
                        }

                        if (opcao1 > 0 && opcao1 <= 7) {
                            String campoNormalizado = removerAcentos(campos[opcao1 - 1].toLowerCase());
                            String dado1Normalizado = removerAcentos(dado1.toLowerCase());
                            if (campoNormalizado.contains(dado1Normalizado)) {
                                encontrado = true;
                            }
                        }

                        if (opcao2 > 0 && opcao2 <= 7 && campos[opcao2 - 1] != null) {
                            String campoNormalizado = removerAcentos(campos[opcao2 - 1].toLowerCase());
                            String dado2Normalizado = removerAcentos(dado2.toLowerCase());
                            if (!campoNormalizado.contains(dado2Normalizado)) {
                                encontrado = false;
                            }
                        }

                        if (encontrado) {
                            resultados.append(contador).append(". ")
                                    .append(campos[0]).append(" - ") // Nome
                                    .append(campos[1]).append(" - ") // Tipo
                                    .append(campos[2]).append(" - ") // Sexo
                                    .append(campos[3]).append(" - ") // Endereço
                                    .append(campos[4]).append(" - ") // Idade
                                    .append(campos[5]).append(" - ") // Peso
                                    .append(campos[6]).append("\n"); // Raça
                            contador++;
                        }
                    } catch (IOException e) {
                        System.out.println("Erro ao ler o arquivo: " + pet.getName());
                        e.printStackTrace();
                    }
                }
                if (resultados.length() > 0) {
                    System.out.println("Resultados encontrados:\n" + resultados.toString());
                } else {
                    System.out.println("Nenhum pet encontrado com os critérios especificados.");
                }
            } else {
                System.out.println("Nenhum pet cadastrado encontrado.");
            }
        } else {
            System.out.println("O caminho especificado não é um diretório válido.");
        }
    }
    private String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    public void menuBuscaPet() {
        System.out.println("Por quais critérios você gostaria de buscar o pet?:");
        System.out.println("1. Nome ou sobrenome");
        System.out.println("2. Sexo");
        System.out.println("3. Idade");
        System.out.println("4. Peso");
        System.out.println("5. Raça");
        System.out.println("6. Endereço");
    }
}
