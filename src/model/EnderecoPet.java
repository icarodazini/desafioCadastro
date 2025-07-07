package model;

public class EnderecoPet {
    private String cidade;
    private String rua;
    private int numero;

    public static final String naoInformado = "Não Informado";

    public void setEnderecoCompleto(String enderecoCompleto) {
        String[] cep = enderecoCompleto.split(", ");
        if (cep.length == 3) {
            this.cidade = cep[0];
            this.rua = cep[1];
            this.numero = Integer.parseInt(cep[2]);
        }
    }

    public String getEnderecoCompleto() {
        return cidade + ", " + rua + ", " + numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        if (numero.toString() == null){
            System.out.println(naoInformado);
        } else {
            this.numero = numero;
        }
    }
}
