package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerAquivoFormulario {
    public void leituraDoArquivo() {
        try (FileReader fr = new FileReader("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\arquivo\\formulario.txt");
             BufferedReader br = new BufferedReader(fr)) {

            int numeroPergunta = 1;
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
