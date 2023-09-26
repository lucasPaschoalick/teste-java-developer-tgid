package br.com.tgid.teste.services;

import br.com.tgid.teste.exception.InvalidClientException;
import br.com.tgid.teste.model.Client;
import br.com.tgid.teste.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client cadastrarCliente(Client client) {
        if (!isCpfValid(client.getCpf())) {
            throw new InvalidClientException("CPF inválido!");
        } else if (!isBlank(client.getCpf(), client.getNome())){
            throw new InvalidClientException("Nome ou cpf não podem estar em branco!");
        }
        return clientRepository.save(client);
    }

    public static boolean isBlank(String cpf, String nome) {
        if (cpf == null || cpf.equals("") || nome == null || nome.equals("") ) {
            return false;
        } else{
            return true;
        }
    }
    public static boolean isCpfValid(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        } else{
            return true;
        }
    }
}
