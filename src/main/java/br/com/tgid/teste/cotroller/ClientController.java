package br.com.tgid.teste.cotroller;

import br.com.tgid.teste.model.Client;
import br.com.tgid.teste.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/cadastrar/cliente")
    public ResponseEntity<Client> cadastrarCliente(@RequestBody Client client) {
        Client newClient = clientService.cadastrarCliente(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }
}
