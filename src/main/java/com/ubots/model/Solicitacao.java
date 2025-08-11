package com.ubots.model;

public class Solicitacao {
    private String cliente;
    private String assunto;

    public Solicitacao() {}

    public Solicitacao(String cliente, String assunto) {
        this.cliente = cliente;
        this.assunto = assunto;
    }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getAssunto() { return assunto; }
    public void setAssunto(String assunto) { this.assunto = assunto; }
}
