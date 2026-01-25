package com.example.demo.service;

import com.example.demo.dto.AlbumNotificationDTO;
import com.example.demo.model.Album;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class AlbumNotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    public AlbumNotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void notifyNovoAlbum(Album album) {
        AlbumNotificationDTO dto = new AlbumNotificationDTO(
                album.getId(),
                album.getTitle(),             
                album.getArtist().getName() 
        );

        messagingTemplate.convertAndSend("/topic/albuns", dto);
    }
}
