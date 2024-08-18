package nizam_setiawan.test_msib_sei.service;

import nizam_setiawan.test_msib_sei.exception.ResourceNotFoundException;
import nizam_setiawan.test_msib_sei.model.Proyek;
import nizam_setiawan.test_msib_sei.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    public Proyek tambahProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    public List<Proyek> dapatkanSemuaProyek() {
        return proyekRepository.findAll();
    }

    public Proyek perbaruiProyek(Long id, Proyek proyekDetail) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyek dengan ID " + id + " tidak ditemukan"));
        proyek.setNamaProyek(proyekDetail.getNamaProyek());
        proyek.setClient(proyekDetail.getClient());
        proyek.setTglMulai(proyekDetail.getTglMulai());
        proyek.setTglSelesai(proyekDetail.getTglSelesai());
        proyek.setPimpinanProyek(proyekDetail.getPimpinanProyek());
        proyek.setKeterangan(proyekDetail.getKeterangan());
        return proyekRepository.save(proyek);
    }

    public void hapusProyek(Long id) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyek dengan ID " + id + " tidak ditemukan"));
        proyekRepository.delete(proyek);
    }
}
