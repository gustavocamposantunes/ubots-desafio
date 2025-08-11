package com.ubots.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados para finalizar um atendimento")
public class FinalizarAtendimentoRequest {

    @Schema(description = "Nome do time", example = "Cartões", allowableValues = {"Cartões", "Empréstimos", "Outros Assuntos"})
    private String time;

    @Schema(description = "Nome do atendente", example = "João")
    private String atendente;

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getAtendente() { return atendente; }
    public void setAtendente(String atendente) { this.atendente = atendente; }
}
