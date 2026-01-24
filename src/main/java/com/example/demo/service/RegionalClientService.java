/*
    ARQUIVO REGIONALCLIENTSERVICE.JAVA: CÓDIGO PARA CONSUMAÇÃO DO ENDPOINT EXTERNO.
*/

package com.example.demo.service;

import com.example.demo.dto.RegionalExternalDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RegionalClientService {

    private static final String URL =
            "https://integrador-argus-api.geia.vip/v1/regionais";

    public List<RegionalExternalDTO> fetchRegionais() {
        RestTemplate restTemplate = new RestTemplate();
        RegionalExternalDTO[] response =
                restTemplate.getForObject(URL, RegionalExternalDTO[].class);

        return Arrays.asList(response);
    }
}
