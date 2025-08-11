package com.ubots.service;

import com.ubots.model.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DistribuidorService {
    private Map<String, TimeAtendimento> times = new HashMap<>();

    public DistribuidorService() {
        times.put("Cartões", new TimeAtendimento("Cartões",
                Arrays.asList(new Atendente("João"), new Atendente("Maria"))));
        times.put("Empréstimos", new TimeAtendimento("Empréstimos",
                Arrays.asList(new Atendente("Carlos"), new Atendente("Ana"))));
        times.put("Outros Assuntos", new TimeAtendimento("Outros Assuntos",
                Arrays.asList(new Atendente("Pedro"))));
    }

    public void distribuirSolicitacao(Solicitacao s) {
        String assunto = s.getAssunto().toLowerCase();
        if (assunto.contains("cartão")) {
            times.get("Cartões").distribuir(s);
        } else if (assunto.contains("empréstimo")) {
            times.get("Empréstimos").distribuir(s);
        } else {
            times.get("Outros Assuntos").distribuir(s);
        }
    }

    public Map<String, TimeAtendimento> getTimes() { return times; }
}
