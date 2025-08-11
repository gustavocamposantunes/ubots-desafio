package com.ubots.model;

import java.util.LinkedList;
import java.util.Queue;

public class Atendente {
    private String nome;
    private Queue<Solicitacao> atendimentos = new LinkedList<>();
    private static final int LIMITE = 3;

    public Atendente(String nome) {
        this.nome = nome;
    }

    public boolean podeAtender() {
        return atendimentos.size() < LIMITE;
    }

    public void atender(Solicitacao s) {
        if (podeAtender()) {
            atendimentos.add(s);
        } else {
            throw new IllegalStateException("Atendente cheio: " + nome);
        }
    }

    public void finalizarAtendimento() {
        atendimentos.poll();
    }

    public String getNome() { return nome; }

    public Queue<Solicitacao> getAtendimentos() {
        return atendimentos;
    }
}
