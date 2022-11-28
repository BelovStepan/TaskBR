package buisnessProcess.resultStore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultStoreRepository extends JpaRepository<ResultStore, Long> {
    ResultStore findByName(String name);
}
