package com.ubots.controller;

import com.ubots.model.Atendente;
import com.ubots.model.TimeAtendimento;
import com.ubots.dto.FinalizarAtendimentoRequest;
import com.ubots.service.DistribuidorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/solicitacoes")
public class AtendimentoController {

    private final DistribuidorService service;

    public AtendimentoController(DistribuidorService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Distribui uma solicitação para o time correto")
    public String distribuirSolicitacao(@RequestBody com.ubots.model.Solicitacao solicitacao) {
        service.distribuirSolicitacao(solicitacao);
        return "Solicitação recebida e distribuída.";
    }

    @GetMapping("/status")
    @Operation(summary = "Lista as filas e atendentes em tempo real")
    public List<Map<String, Object>> listarStatus() {
        List<Map<String, Object>> status = new ArrayList<>();

        for (Map.Entry<String, TimeAtendimento> entry : service.getTimes().entrySet()) {
            Map<String, Object> timeInfo = new LinkedHashMap<>();
            timeInfo.put("time", entry.getKey());

            List<Map<String, Object>> atendentesInfo = new ArrayList<>();
            for (Atendente a : entry.getValue().getAtendentes()) {
                Map<String, Object> atendenteData = new LinkedHashMap<>();
                atendenteData.put("nome", a.getNome());

                List<String> clientesAtendidos = new ArrayList<>();
                a.getAtendimentos().forEach(s -> 
                    clientesAtendidos.add(s.getCliente() + " - " + s.getAssunto())
                );

                atendenteData.put("atendimentos_atuais", clientesAtendidos);
                atendentesInfo.add(atendenteData);
            }
            timeInfo.put("atendentes", atendentesInfo);

            List<String> fila = new ArrayList<>();
            entry.getValue().getFilaEspera().forEach(s -> fila.add(s.getCliente() + " - " + s.getAssunto()));
            timeInfo.put("fila_espera", fila);

            status.add(timeInfo);
        }

        return status;
    }

    @DeleteMapping("/finalizar")
    @Operation(summary = "Finaliza um atendimento e libera o atendente")
    public String finalizarAtendimento(@RequestBody FinalizarAtendimentoRequest request) {
        String time = request.getTime();
        String atendente = request.getAtendente();

        TimeAtendimento t = service.getTimes().get(time);
        if (t == null) {
            return "Time não encontrado: " + time;
        }

        for (Atendente a : t.getAtendentes()) {
            if (a.getNome().equalsIgnoreCase(atendente)) {
                if (a.getAtendimentos().isEmpty()) {
                    return "O atendente " + atendente + " não possui atendimentos ativos.";
                }
                t.liberarAtendimento(a);
                return "Atendimento finalizado para " + atendente;
            }
        }

        return "Atendente não encontrado no time " + time;
    }
}
