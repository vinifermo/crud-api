package com.library.crudapi.crudapi.service;
import com.library.crudapi.crudapi.dto.request.ClienteRequestDTO;
import com.library.crudapi.crudapi.entity.Cliente;
import com.library.crudapi.crudapi.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ApplicationEventPublisher publisher;


    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente atualizar(UUID id, ClienteRequestDTO clienteRequestDTO) {
        Cliente clienteSalvo = buscarClientePeloId(id);
        BeanUtils.copyProperties(clienteRequestDTO, clienteSalvo, "id");
        Cliente save = clienteRepository.save(clienteSalvo);
        return save;
    }

    public Cliente buscarClientePeloId(UUID id) {
        Cliente clienteSalvo = clienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return clienteSalvo;
    }

    public Cliente remover(@PathVariable UUID id) {
        clienteRepository.deleteById(id);
        return null;
    }

    public Optional<Cliente> buscarPeloId(@PathVariable UUID id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente;
    }


    @Override
    public Cliente criar(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = new Cliente(clienteRequestDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo;
    }
}