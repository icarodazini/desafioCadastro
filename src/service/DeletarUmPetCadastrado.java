package service;

import java.io.File;
import java.util.Scanner;

public class DeletarUmPetCadastrado {
    Scanner scanner = new Scanner(System.in);

    public void deletarPetCadastrado() {
        File diretorio = new File("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\petsCadastrados");
        if (diretorio.isDirectory()) {
            File[] petsCadastrados = diretorio.listFiles(((dir, name) -> name.endsWith(".TXT")));

            if (petsCadastrados != null && petsCadastrados.length > 0) {
                System.out.println("Selecione o número do pet que você deseja deletar:");
                for (int i = 0; i < petsCadastrados.length; i++) {
                    System.out.println((i + 1) + ". " + petsCadastrados[i].getName());
                }

                int petEscolhido = scanner.nextInt();
                scanner.nextLine();

                if (petEscolhido > 0 && petEscolhido <= petsCadastrados.length) {
                    File petSelecionado = petsCadastrados[petEscolhido - 1];
                    boolean isDeleted = petSelecionado.delete();
                    if (isDeleted) {
                        System.out.println("Pet deletado com sucesso: " + petSelecionado.getName());
                    } else {
                        System.out.println("Erro ao deletar o pet.");
                    }
                } else {
                    System.out.println("Número de pet inválido. Por favor, tente novamente.");
                }
            } else {
                System.out.println("Nenhum pet cadastrado encontrado.");
            }
        } else {
            System.out.println("O diretório especificado não é um diretório válido ou não existe.");
        }
    }
}
