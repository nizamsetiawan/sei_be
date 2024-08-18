package nizam_setiawan.test_msib_sei.repository;

import nizam_setiawan.test_msib_sei.model.Lokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Long> {
}
