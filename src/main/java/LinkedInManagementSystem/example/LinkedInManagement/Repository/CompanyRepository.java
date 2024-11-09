package LinkedInManagementSystem.example.LinkedInManagement.Repository;

import LinkedInManagementSystem.example.LinkedInManagement.Models.Company;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CompanyRepository extends JpaRepository<Company , Integer> {
    @Query(value = "select * from company where name = :name",nativeQuery = true)
    Company findCompanyByName(String name);

    @Query(value = "select * from company order by followers desc limit 1",nativeQuery = true)
    Company topFollowed();

    @Query(value = "select * from company where status = 'HIRING'",nativeQuery = true)
    List<Company> hiringCompaniesList();
}
