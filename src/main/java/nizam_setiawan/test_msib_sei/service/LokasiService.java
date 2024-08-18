package nizam_setiawan.test_msib_sei.service;

import nizam_setiawan.test_msib_sei.exception.ResourceNotFoundException;
import nizam_setiawan.test_msib_sei.model.Lokasi;
import nizam_setiawan.test_msib_sei.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public Lokasi tambahLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public List<Lokasi> dapatkanSemuaLokasi() {
        return lokasiRepository.findAll();
    }

    public Lokasi perbaruiLokasi(Long id, Lokasi lokasiDetail) {
        Lokasi lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lokasi dengan ID " + id + " tidak ditemukan"));
        lokasi.setNamaLokasi(lokasiDetail.getNamaLokasi());
        lokasi.setNegara(lokasiDetail.getNegara());
        lokasi.setProvinsi(lokasiDetail.getProvinsi());
        lokasi.setKota(lokasiDetail.getKota());
        return lokasiRepository.save(lokasi);
    }

    public void hapusLokasi(Long id) {
        Lokasi lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lokasi dengan ID " + id + " tidak ditemukan"));
        lokasiRepository.delete(lokasi);
    }
}
