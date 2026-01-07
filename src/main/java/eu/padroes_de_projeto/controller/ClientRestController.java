package eu.padroes_de_projeto.controller;

import eu.padroes_de_projeto.dto.ClientRequestDTO;
import eu.padroes_de_projeto.dto.ClientResponseDTO;
import eu.padroes_de_projeto.mapper.ClientMapper;
import eu.padroes_de_projeto.model.Client;
import eu.padroes_de_projeto.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("clientes")
public class ClientRestController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientMapper clientMapper;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> selectAll() {
        List<ClientResponseDTO> response = StreamSupport.stream(clientService.selectAll().spliterator(), false).map(clientMapper::toResponseDTO).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> selectById(@PathVariable Long id) {
        Client client = clientService.selectById(id);
        ClientResponseDTO response = clientMapper.toResponseDTO(client);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody ClientRequestDTO dto) {
        Client client = clientMapper.toEntity(dto);
        Client saved = clientService.insert(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long id, @RequestBody @Valid ClientRequestDTO dto) {
        Client client = clientMapper.toEntity(id, dto);
        Client updated = clientService.update(id, client);
        ClientResponseDTO response = clientMapper.toResponseDTO(updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
