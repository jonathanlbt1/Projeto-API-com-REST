package com.teste.primeiroexemplo.model.error;

public class ErrorMessage {
    // Nesta classe vc coloca o que for expecifico para sua aplicacao.

//#region atributos
    private String titulo;

    private Integer status;

    private String mensagem;
//#endregion
    
//#region construtores
    public ErrorMessage(String titulo, Integer status, String mensagem) {
        this.titulo = titulo;
        this.status = status;
        this.mensagem = mensagem;
    }

//#endregion

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    

    
}
