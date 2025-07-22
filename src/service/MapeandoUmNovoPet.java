package service;

import model.Pet;
import model.Sexo;
import model.TipoDoPet;

import java.io.*;
import java.util.*;

public class MapeandoUmNovoPet {
    Pet pet = new Pet();
    ArrayList<String> listaRespostas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public String mapeandoAsPerguntas() {
        try (FileReader fr = new FileReader("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\arquivo\\formulario.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String pergunta;
            int contador = 0;

            while ((pergunta = br.readLine()) != null) {
                System.out.println(pergunta);
                String resposta = scanner.nextLine();
                listaRespostas.add(resposta);

                try {
                    validarEMapearResposta(contador, resposta);
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                    throw e;
                }
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Pet salvo com sucesso!");
        System.out.println("Nome - " + pet.getNomeCompleto());
        System.out.println("Tipo - " + pet.getTipoDoPet());
        System.out.println("Sexo - " + pet.getSexo());
        System.out.println("Endereço - " + pet.getEnderecoPet().getEnderecoCompleto());
        System.out.println("Idade - " + pet.getIdadeAproximada() + " anos");
        System.out.println("Peso - " + pet.getPesoAproximado() + " kg");
        System.out.println("Raça - " + pet.getRaca());

        return "Nome - " + pet.getNomeCompleto()
                + "Tipo - " + pet.getTipoDoPet()
                + "Sexo - " + pet.getSexo()
                + "Endereço - " + pet.getEnderecoPet().getEnderecoCompleto()
                + "Idade - " + pet.getIdadeAproximada() + " anos"
                + "Peso - " + pet.getPesoAproximado() + " kg"
                + "Raça - " + pet.getRaca();
    }

    private void validarEMapearResposta(int contador, String resposta) {
        switch (contador) {
            case 0:
                pet.setNomeCompleto(resposta);
                break;
            case 1:
                pet.setTipoDoPet(TipoDoPet.valueOf(resposta.toUpperCase()));
                break;
            case 2:
                pet.setSexo(Sexo.valueOf(resposta.toUpperCase()));
                break;
            case 3:
                pet.getEnderecoPet().setEnderecoCompleto(resposta);
                break;
            case 4:
                pet.setIdadeAproximada(resposta);
                break;
            case 5:
                pet.setPesoAproximado(resposta);
                break;
            case 6:
                pet.setRaca(resposta);
                break;
            default:
                throw new IllegalArgumentException("Pergunta inválida.");
        }
    }
}