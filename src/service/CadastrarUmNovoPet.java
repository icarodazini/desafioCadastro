package service;

import java.io.*;

public class CadastrarUmNovoPet {
    private final MapeamentoDeUmNovoPet mapeamentoDeUmNovoPet;

    public CadastrarUmNovoPet(MapeamentoDeUmNovoPet mapeamentoDeUmNovoPet) {
        this.mapeamentoDeUmNovoPet = mapeamentoDeUmNovoPet;
    }

    public void cadastrarPetNoArquivo() {
        File filePets = new File("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\petsCadastrados\\filePets.txt");

        try (FileWriter fw = new FileWriter(filePets, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            if (filePets.createNewFile()) {
                System.out.println("Arquivo criado com sucesso: " + filePets.getName());
            }
            bw.write("1 - " + mapeamentoDeUmNovoPet.pet.getNomeCompleto());
            bw.newLine();
            bw.write("2 - " + mapeamentoDeUmNovoPet.pet.getTipoDoPet());
            bw.newLine();
            bw.write("3 - " + mapeamentoDeUmNovoPet.pet.getSexo());
            bw.newLine();
            bw.write("4 - " + mapeamentoDeUmNovoPet.pet.getEnderecoPet().getEnderecoCompleto());
            bw.newLine();
            bw.write("5 - " + mapeamentoDeUmNovoPet.pet.getIdadeAproximada() + " anos");
            bw.newLine();
            bw.write("6 - " + mapeamentoDeUmNovoPet.pet.getPesoAproximado() + " kg");
            bw.newLine();
            bw.write("7 - " + mapeamentoDeUmNovoPet.pet.getRaca());
            bw.newLine();
            bw.write("--------------------------------------------------\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}