/*
    ARQUIVO REGIONALSYNCSERVICE.JAVA: VAI FAZER A SINCRONIZAÇÃO DOS DADOS.
*/

package com.example.demo.service;

import com.example.demo.dto.RegionalExternalDTO;
import com.example.demo.model.Regional;
import com.example.demo.repository.RegionalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RegionalSyncService {

    private final RegionalRepository repository;
    private final RegionalClientService clientService;

    public RegionalSyncService(
            RegionalRepository repository,
            RegionalClientService clientService
    ) {
        this.repository = repository;
        this.clientService = clientService;
    }

    @Transactional
    public void sync() {

        List<RegionalExternalDTO> externas = clientService.fetchRegionais();

        Map<Integer, RegionalExternalDTO> externasMap =
                externas.stream()
                        .collect(Collectors.toMap(RegionalExternalDTO::id, r -> r));

        repository.findAll().forEach(regional -> {
            RegionalExternalDTO ext = externasMap.get(regional.getId());

            if (ext == null && regional.getAtivo()) {
                regional.setAtivo(false);
                repository.save(regional);
            }

            if (ext != null && regional.getAtivo()
                    && !regional.getNome().equals(ext.nome())) {

                regional.setAtivo(false);
                repository.save(regional);
            }
        });

        externas.forEach(ext -> {
            repository.findByIdAndAtivoTrue(ext.id())
                    .ifPresentOrElse(
                            r -> {},
                            () -> repository.save(
                                    new Regional(
                                            ext.id(),
                                            ext.nome(),
                                            true
                                    )
                            )
                    );
        });
    }
}
