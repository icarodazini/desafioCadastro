package service;

import model.Pet;
import model.Sexo;
import model.TipoDoPet;

import java.io.*;
import java.util.*;

public class MapeamentoDeUmNovoPet {
    Pet pet = new Pet();
    ArrayList<String> listaRespostas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public String mapeandoAsPerguntas() {
        try (FileReader fr = new FileReader("C:\\Users\\icarodazini\\OneDrive\\Documentos\\Java\\desafioCadastro\\arquivo\\formulario.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String pergunta;

            while ((pergunta = br.readLine()) != null) {
                System.out.println(pergunta);
                String resposta = scanner.nextLine();
                listaRespostas.add(resposta);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        pet.setNomeCompleto(listaRespostas.get(0));
        pet.setTipoDoPet(TipoDoPet.valueOf(listaRespostas.get(1).toUpperCase()));
        pet.setSexo(Sexo.valueOf(listaRespostas.get(2).toUpperCase()));
        pet.getEnderecoPet().setEnderecoCompleto(listaRespostas.get(3));
        pet.setIdadeAproximada(listaRespostas.get(4));
        pet.setPesoAproximado(listaRespostas.get(5));
        pet.setRaca(listaRespostas.get(6));

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
}