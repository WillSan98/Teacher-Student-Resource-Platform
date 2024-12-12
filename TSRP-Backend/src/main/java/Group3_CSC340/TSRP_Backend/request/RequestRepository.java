package Group3_CSC340.TSRP_Backend.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>{
    List<Request> findByRequestStatusFalse();

    List<Request> findByRequestStatusTrue();
}
