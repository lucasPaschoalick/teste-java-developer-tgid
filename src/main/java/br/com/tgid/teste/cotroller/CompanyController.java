package br.com.tgid.teste.cotroller;

import br.com.tgid.teste.model.Company;
import br.com.tgid.teste.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/cadastrar/empresa")
    public ResponseEntity<Company> cadastrarEmpresa(@RequestBody Company company) {
        Company newCompany = companyService.cadastrarEmpresa(company);
        return new ResponseEntity<>(newCompany, HttpStatus.CREATED);
    }

    @GetMapping("/empresa/{cnpj}")
    public ResponseEntity<Company> buscarEmpresaPorCnpj(@PathVariable String cnpj) {
        Company company = companyService.buscarEmpresa(cnpj);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
}
