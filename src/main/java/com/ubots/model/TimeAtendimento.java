package com.ubots.model;

import java.util.*;

public class TimeAtendimento {
    private String nome;
    private List<Atendente> atendentes = new ArrayList<>();
    private Queue<Solicitacao> filaEspera = new LinkedList<>();

    public TimeAtendimento(String nome, List<Atendente> atendentes) {
        this.nome = nome;
        this.atendentes = atendentes;
    }

    public void distribuir(Solicitacao s) {
        for (Atendente a : atendentes) {
            if (a.podeAtender()) {
                a.atender(s);
                return;
            }
        }
        filaEspera.add(s);
    }

    public void liberarAtendimento(Atendente a) {
        a.finalizarAtendimento();
        if (!filaEspera.isEmpty() && a.podeAtender()) {
            a.atender(filaEspera.poll());
        }
    }

    public String getNome() { return nome; }
    public Queue<Solicitacao> getFilaEspera() { return filaEspera; }
    public List<Atendente> getAtendentes() { return atendentes; }
}
