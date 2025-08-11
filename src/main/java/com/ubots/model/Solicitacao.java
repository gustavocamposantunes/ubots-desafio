package com.ubots.model;

public class Solicitacao {
    private String cliente;
    private String assunto;
    private String time;

    public Solicitacao() {}

    public Solicitacao(String cliente, String assunto) {
        this.cliente = cliente;
        this.assunto = assunto;
    }

    public Solicitacao(String cliente, String assunto, String time) {
        this.cliente = cliente;
        this.assunto = assunto;
        this.time = time;
    }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getAssunto() { return assunto; }
    public void setAssunto(String assunto) { this.assunto = assunto; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
}
