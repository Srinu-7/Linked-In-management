package LinkedInManagementSystem.example.LinkedInManagement.Repository;

import LinkedInManagementSystem.example.LinkedInManagement.Models.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow , Integer> {
    @Query(value = " select  distinct following_person_id from follow where user_user_id = :id",nativeQuery = true)
    List<Integer> followers(int id);

    @Query(value = " select user_user_id from follow group by user_user_id order by count(*) desc limit 1",nativeQuery = true)
    int famous();
}
