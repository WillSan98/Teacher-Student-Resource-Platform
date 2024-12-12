package Group3_CSC340.TSRP_Backend.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer>{
    List<User> findByBanStatusFalse();

    List<User> findByBanStatusTrue();

}
