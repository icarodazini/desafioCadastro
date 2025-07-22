package service;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CadastrarUmNovoPet {
    private final MapeandoUmNovoPet mapeamentoDeUmNovoPet;

    public CadastrarUmNovoPet(MapeandoUmNovoPet mapeamentoDeUmNovoPet) {
        this.mapeamentoDeUmNovoPet = mapeamentoDeUmNovoPet;
    }

    public void cadastrarPetNoArquivo() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatando = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String arquivoFormatado = agora.format(formatando);

        String nomeDoPet = mapeamentoDeUmNovoPet.pet.getNomeCompleto().replace(" ", "").toUpperCase();

        String nomeDoArquivo = arquivoFormatado + "-" + nomeDoPet + ".TXT";

        File caminhoArquivoPet = new File("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\petsCadastrados\\" + nomeDoArquivo);

        try (FileWriter fw = new FileWriter(caminhoArquivoPet, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            if (caminhoArquivoPet.createNewFile()) {
                System.out.println("Arquivo criado com sucesso: " + caminhoArquivoPet.getName());
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}