package nizam_setiawan.test_msib_sei.repository;

import nizam_setiawan.test_msib_sei.model.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Long> {
}
