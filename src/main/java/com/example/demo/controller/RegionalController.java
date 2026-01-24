/*
    ARQUIVO REGIONALCONTROLLER.JAVA: 
*/

package com.example.demo.controller;

import com.example.demo.service.RegionalSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/regionais")
public class RegionalController {

    private final RegionalSyncService syncService;

    public RegionalController(RegionalSyncService syncService) {
        this.syncService = syncService;
    }

    @PostMapping("/sync")
    public ResponseEntity<Void> sync() {
        syncService.sync();
        return ResponseEntity.ok().build();
    }
}
