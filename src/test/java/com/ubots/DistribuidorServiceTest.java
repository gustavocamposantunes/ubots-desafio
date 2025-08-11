package com.ubots;

import com.ubots.model.Solicitacao;
import com.ubots.model.Atendente;
import com.ubots.service.DistribuidorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistribuidorServiceTest {

    @Test
    void deveDistribuirParaTimeCartoes() {
        DistribuidorService service = new DistribuidorService();
        service.distribuirSolicitacao(new Solicitacao("Cliente1", "Problemas com cartão"));

        assertEquals(0, service.getTimes().get("Cartões").getFilaEspera().size());
        boolean temAtendimento = service.getTimes()
                .get("Cartões")
                .getAtendentes()
                .stream()
                .anyMatch(a -> !a.getAtendimentos().isEmpty());
        assertTrue(temAtendimento);
    }

    @Test
    void deveColocarNaFilaQuandoAtendentesLotados() {
        DistribuidorService service = new DistribuidorService();

        for (int i = 0; i < 6; i++) {
            service.distribuirSolicitacao(new Solicitacao("C" + i, "Problemas com cartão"));
        }

        service.distribuirSolicitacao(new Solicitacao("C7", "Problemas com cartão"));

        assertEquals(1, service.getTimes().get("Cartões").getFilaEspera().size());
    }

    @Test
    void deveDistribuirUsandoCampoTimeDireto() {
        DistribuidorService service = new DistribuidorService();

        Solicitacao s = new Solicitacao();
        s.setCliente("Carlos");
        s.setAssunto("Não importa");
        s.setTime("Empréstimos");

        service.distribuirSolicitacao(s);

        assertEquals(0, service.getTimes().get("Empréstimos").getFilaEspera().size());
        boolean temAtendimento = service.getTimes()
                .get("Empréstimos")
                .getAtendentes()
                .stream()
                .anyMatch(a -> !a.getAtendimentos().isEmpty());
        assertTrue(temAtendimento);
    }

    @Test
    void deveFinalizarAtendimentoELiberarFila() {
        DistribuidorService service = new DistribuidorService();

        for (int i = 0; i < 6; i++) {
            service.distribuirSolicitacao(new Solicitacao("C" + i, "Problemas com cartão"));
        }
        service.distribuirSolicitacao(new Solicitacao("Extra", "Problemas com cartão"));

        Atendente primeiro = service.getTimes().get("Cartões").getAtendentes().get(0);
        int filaAntes = service.getTimes().get("Cartões").getFilaEspera().size();

        service.getTimes().get("Cartões").liberarAtendimento(primeiro);

        int filaDepois = service.getTimes().get("Cartões").getFilaEspera().size();
        assertEquals(filaAntes - 1, filaDepois);
    }
}
