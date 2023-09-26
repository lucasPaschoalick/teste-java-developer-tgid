package br.com.tgid.teste.services;

import br.com.tgid.teste.exception.ClientNotFoundException;
import br.com.tgid.teste.exception.InsufficientFundsException;
import br.com.tgid.teste.model.Client;
import br.com.tgid.teste.model.Company;
import br.com.tgid.teste.model.TransactionType;
import br.com.tgid.teste.model.Transaction;
import br.com.tgid.teste.repository.ClientRepository;
import br.com.tgid.teste.repository.CompanyRepository;
import br.com.tgid.teste.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void depositar(Client client, Company company, double valor) {
        clientRepository.findById(client.getCpf())
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado"));

        double taxaAdmin = calcularTaxaAdmin(valor, company.getTaxa());
        double valDeposito = valor - taxaAdmin;

        company.setSaldo(company.getSaldo() + valDeposito);
        companyRepository.save(company);

        Transaction transaction = new Transaction();
        transaction.setClient(client);
        transaction.setCompany(company);
        transaction.setValTransferencia(valor);
        transaction.setTaxaEmpresa(taxaAdmin);
        transaction.setType(TransactionType.DEPOSIT);
        transactionRepository.save(transaction);
    }

    public void sacar(Client client, Company company, double valor) {
        clientRepository.findById(client.getCpf())
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado"));

        if (company.getSaldo() >= valor) {
            double taxaAdmin = calcularTaxaAdmin(valor, company.getTaxa());

            company.setSaldo(company.getSaldo() - valor - taxaAdmin);
            companyRepository.save(company);

            Transaction transaction = new Transaction();
            transaction.setClient(client);
            transaction.setCompany(company);
            transaction.setValTransferencia(valor);
            transaction.setTaxaEmpresa(taxaAdmin);
            transaction.setType(TransactionType.WITHDRAW);
            transactionRepository.save(transaction);
        } else {
            throw new InsufficientFundsException("Saldo insuficiente na empresa.");
        }
    }

    private double calcularTaxaAdmin(double amount, double taxaAdmin) {
        return amount * taxaAdmin / 100.0;
    }
}
