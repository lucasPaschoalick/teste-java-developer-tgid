package br.com.tgid.teste.cotroller;

import br.com.tgid.teste.exception.ClientNotFoundException;
import br.com.tgid.teste.exception.CompanyNotFoundException;
import br.com.tgid.teste.model.Client;
import br.com.tgid.teste.model.Company;
import br.com.tgid.teste.repository.ClientRepository;
import br.com.tgid.teste.repository.CompanyRepository;
import br.com.tgid.teste.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/depositar/{cpf}/{cnpj}")
    public ResponseEntity <?> depositoDoCliente(@PathVariable String cpf, @PathVariable String cnpj, @RequestBody double valor) {
        Client client = clientRepository.findById(cpf)
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado"));
        Company company = companyRepository.findById(cnpj)
                .orElseThrow(() -> new CompanyNotFoundException("Empresa não encontrada"));
        transactionService.depositar(client, company, valor);
        return ResponseEntity.ok("Depósito realizado com sucesso.");
    }

    @PostMapping("/sacar/{cpf}/{cnpj}")
    public ResponseEntity <?> saqueDoCliente(@PathVariable String cpf, @PathVariable String cnpj, @RequestBody double valor) {
        Client client = clientRepository.findById(cpf)
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado"));
        Company company = companyRepository.findById(cnpj)
                .orElseThrow(() -> new CompanyNotFoundException("Empresa não encontrada"));
        transactionService.sacar(client, company, valor);
        return ResponseEntity.ok("Saque realizado com sucesso.");
    }
}
