package model;

public class Pet {
    private String nomeCompleto;
    private Enum tipoDoPet;
    private Enum sexo;
    private double idadeAproximada;
    private double pesoAproximado;
    private String raca;
    private EnderecoPet enderecoPet;

    public static final String naoInformado = "Não Informado";

    public Pet() {
        this.enderecoPet = new EnderecoPet();
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String setNomeCompleto(String nomeCompleto) {
        if (nomeCompleto != null && !nomeCompleto.trim().isEmpty() && nomeCompleto.contains(" ") && nomeCompleto.matches("[a-zA-Z\\s]+")) {
            this.nomeCompleto = nomeCompleto;
        } else {
            throw new IllegalArgumentException("Nome inválido. Por favor, insira um nome completo válido contendo apenas letras e espaços.");
        }
        return naoInformado;
    }

    public Enum getTipoDoPet() {
        return tipoDoPet;
    }

    public void setTipoDoPet(Enum tipoDoPet) {
        this.tipoDoPet = tipoDoPet;
    }

    public Enum getSexo() {
        return sexo;
    }

    public void setSexo(Enum sexo) {
        this.sexo = sexo;
    }

    public double getIdadeAproximada() {
        return idadeAproximada;
    }

    public String setIdadeAproximada(String idadeAproximada) {
        try {
            double idade = Double.parseDouble(idadeAproximada);
            if (idade >= 0.1 && idade < 20) {
                this.idadeAproximada = idade;
            } else {
                throw new IllegalArgumentException("Idade aproximada deve estar entre 0.1 e 20 anos.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato inválido para idade aproximada. Por favor, insira um número decimal.", e);
        }
        return naoInformado;
    }

    public double getPesoAproximado() {
        return pesoAproximado;
    }

    public String setPesoAproximado(String pesoAproximado) {
        try {
            double peso = Double.parseDouble(pesoAproximado);
            if (peso < 60 && peso >= 0.5) {
                this.pesoAproximado = peso;
            } else {
                throw new IllegalArgumentException("Peso aproximado não pode ser negativo ou maior que 60kg. Por favor, tente novamente.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato inválido para peso aproximado. Por favor, insira um número decimal.", e);
        }
        return naoInformado;
    }

    public String getRaca() {
        return raca;
    }

    public String setRaca(String raca) {
        if (raca != null && raca.matches("[a-zA-Z\\s]+")) {
            this.raca = raca;
        } else {
            throw new IllegalArgumentException("Raça inválida. Por favor, insira uma raça válida contendo apenas letras e espaços.");
        }
        return naoInformado;
    }

    public EnderecoPet getEnderecoPet() {
        return enderecoPet;
    }

    public void setEnderecoPet(EnderecoPet enderecoPet) {
        this.enderecoPet = enderecoPet;
    }
}