package com.example.demo.service;

import com.example.demo.dto.ArtistRequestDTO;
import com.example.demo.model.Artist;
import com.example.demo.repository.ArtistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

    @Mock
    private ArtistRepository repository;

    @InjectMocks
    private ArtistService service;

    @Test
    void shouldCreateArtist() {
        ArtistRequestDTO dto = new ArtistRequestDTO("Metallica", "BAND");

        Artist artistSaved = new Artist();
        artistSaved.setId(1L);
        artistSaved.setName("Metallica");
        artistSaved.setType("BAND");

        when(repository.save(any(Artist.class))).thenReturn(artistSaved);

        Artist result = service.create(dto);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Metallica");
        assertThat(result.getType()).isEqualTo("BAND");

        verify(repository, times(1)).save(any(Artist.class));
    }
}
