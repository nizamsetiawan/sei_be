package nizam_setiawan.test_msib_sei.repository;

import nizam_setiawan.test_msib_sei.model.ProyekLokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, Long> {
}
