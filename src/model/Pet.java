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
        } else if (nomeCompleto == null) {
            this.nomeCompleto = naoInformado;
        }
        throw new IllegalArgumentException("Nome inválido. Por favor, insira um nome completo válido contendo apenas letras e espaços.");
    }


    public Enum getTipoDoPet() {
        return tipoDoPet;
    }

    public void setTipoDoPet(Enum tipoDoPet) {
        if (tipoDoPet == null) {
            throw new IllegalArgumentException("Tipo do pet não pode ser nulo.");
        }
        this.tipoDoPet = tipoDoPet;
    }

    public Enum getSexo() {
        return sexo;
    }

    public void setSexo(Enum sexo) {
        if (sexo == null) {
            throw new IllegalArgumentException("Sexo não pode ser nulo.");
        }
        this.sexo = sexo;
    }

    public double getIdadeAproximada() {
        return idadeAproximada;
    }

    public void setIdadeAproximada(String idadeAproximada) {
        try {
            double idade = Double.parseDouble(idadeAproximada);
            if (idade <= 20 && idade >= 0.1) {
                this.idadeAproximada = idade;
            } else if (idadeAproximada == null) {
                this.raca = naoInformado;
            }
            throw new IllegalArgumentException("Idade aproximada deve ser maior que 0 e menor ou igual a 20 anos. Por favor, tente novamente.");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato inválido para idade aproximada. Por favor, insira um número válido.", e);
        }
    }

    public double getPesoAproximado() {
        return pesoAproximado;
    }

    public void setPesoAproximado(String pesoAproximado) {
        try {
            double peso = Double.parseDouble(pesoAproximado);
            if (peso < 60 && peso >= 0.5) {
                this.pesoAproximado = peso;
            } else if (pesoAproximado == null) {
                this.raca = naoInformado;
            }
            throw new IllegalArgumentException("Peso aproximado deve ser maior que 0.5 e menor que 60 kg. Por favor, tente novamente.");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato inválido para peso aproximado. Por favor, insira um número decimal.", e);
        }
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        if (raca != null && !raca.trim().isEmpty() && raca.matches("[a-zA-Z\\s]+")) {
            this.raca = raca;
        } else if (raca == null) {
            this.raca = naoInformado;
        }
        throw new IllegalArgumentException("Raça inválida. Por favor, insira uma raça válida contendo apenas letras e espaços.");
    }

    public EnderecoPet getEnderecoPet() {
        return enderecoPet;
    }

    public void setEnderecoPet(EnderecoPet enderecoPet) {
        if (enderecoPet == null) {
            throw new IllegalArgumentException("Endereço do pet não pode ser nulo.");
        }
        this.enderecoPet = enderecoPet;
    }
}