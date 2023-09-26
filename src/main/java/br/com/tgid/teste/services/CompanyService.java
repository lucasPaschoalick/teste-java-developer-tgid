package br.com.tgid.teste.services;

import br.com.tgid.teste.exception.CompanyNotFoundException;
import br.com.tgid.teste.exception.InvalidClientException;
import br.com.tgid.teste.exception.InvalidCompanyException;
import br.com.tgid.teste.model.Company;
import br.com.tgid.teste.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company cadastrarEmpresa(Company company) {
        if (!isCnpjValid(company.getCnpj())) {
            throw new InvalidCompanyException("CNPJ inválido");
        } else if (!isBlank(company.getCnpj(), company.getNome(), company.getTaxa())){
            throw new InvalidClientException("Nome, CNPJ e a Taxa não podem estar em branco!");
        }
        return companyRepository.save(company);
    }

    public Company buscarEmpresa(String cnpj) {
        return companyRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new CompanyNotFoundException("Empresa não encontrada"));
    }

    public static boolean isBlank(String cnpj, String nome, Double taxa) {
        if (cnpj == null || cnpj.equals("") || nome == null || nome.equals("") || taxa == null || taxa == 0) {
            return false;
        } else{
            return true;
        }
    }

    public static boolean isCnpjValid(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        } else{
            return true;
        }
    }
}
