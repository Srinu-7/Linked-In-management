package LinkedInManagementSystem.example.LinkedInManagement.SeriveLayer;

import LinkedInManagementSystem.example.LinkedInManagement.Enums.Status;
import LinkedInManagementSystem.example.LinkedInManagement.Exceptions.CompanyAlreadyExist;
import LinkedInManagementSystem.example.LinkedInManagement.Exceptions.NoCompaniesAreHiringNow;
import LinkedInManagementSystem.example.LinkedInManagement.Exceptions.NoCompanyExist;
import LinkedInManagementSystem.example.LinkedInManagement.Models.Company;
import LinkedInManagementSystem.example.LinkedInManagement.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public String addCompany(Company company)throws Exception {

      Company company1 = companyRepository.findCompanyByName(company.getName());

      if(company1 != null) {
          throw  new CompanyAlreadyExist("This company is already registered");
      }

      companyRepository.save(company);

      return company.getName() + " registered successfully!";
    }

    public List<Company> hiringCompanies() throws Exception{

        List<Company> companyList = companyRepository.hiringCompaniesList();

        if(companyList.isEmpty()){
            throw new NoCompaniesAreHiringNow("no companies is hiring now");
        }
        return companyList;
    }

    public Company topFollowed() throws Exception{

        Company company = companyRepository.topFollowed();

        if(company == null) throw new NoCompanyExist("no company is there");

        return company;
    }
}
