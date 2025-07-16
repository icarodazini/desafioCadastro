package service;

import java.io.*;

public class BuscarTodosPetsCadastrados {
    public void buscarTodosPets() {
        File diretorio = new File("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\petsCadastrados");

        if (diretorio.isDirectory()) {
            File[] petsCadastrados = diretorio.listFiles((dir, name) -> name.endsWith(".TXT"));

            if (petsCadastrados != null && petsCadastrados.length > 0) {
                System.out.println("Lista de todos os pets cadastrados:");
                int contador = 1;

                for (File pet : petsCadastrados) {
                    try (BufferedReader br = new BufferedReader(new FileReader(pet))) {
                        String linha;
                        String[] campos = new String[7];

                        while ((linha = br.readLine()) != null) {
                            String[] partes = linha.split(" - ");
                            if (partes.length == 2) {
                                int indiceCampo = Integer.parseInt(partes[0].trim()) - 1;
                                campos[indiceCampo] = partes[1].trim();
                            }
                        }

                        System.out.println(contador + ". " +
                                campos[0] + " - " + // Nome
                                campos[1] + " - " + // Tipo
                                campos[2] + " - " + // Sexo
                                campos[3] + " - " + // Endereço
                                campos[4] + " - " + // Idade
                                campos[5] + " - " + // Peso
                                campos[6]);         // Raça
                        contador++;

                    } catch (IOException e) {
                        System.out.println("Erro ao ler o arquivo: " + pet.getName());
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Nenhum pet cadastrado encontrado.");
            }
        } else {
            System.out.println("O caminho especificado não é um diretório válido.");
        }
    }
}
