package com.endereco.gerenciar.end;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoDto {
    private String cep;
    private String rua;
    private String numero;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
