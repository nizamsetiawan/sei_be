package nizam_setiawan.test_msib_sei.controller;

import nizam_setiawan.test_msib_sei.model.Lokasi;
import nizam_setiawan.test_msib_sei.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> tambahLokasi(@RequestBody Lokasi lokasi) {
        Lokasi savedLokasi = lokasiService.tambahLokasi(lokasi);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.CREATED.value());
        response.put("pesan", "Lokasi berhasil dibuat");
        response.put("data", savedLokasi);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> dapatkanSemuaLokasi() {
        List<Lokasi> lokasiList = lokasiService.dapatkanSemuaLokasi();
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("pesan", "Semua lokasi berhasil diambil");
        response.put("data", lokasiList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> perbaruiLokasi(@PathVariable Long id, @RequestBody Lokasi lokasiDetail) {
        Lokasi updatedLokasi = lokasiService.perbaruiLokasi(id, lokasiDetail);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("pesan", "Lokasi berhasil diperbarui");
        response.put("data", updatedLokasi);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> hapusLokasi(@PathVariable Long id) {
        lokasiService.hapusLokasi(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NO_CONTENT.value());
        response.put("pesan", "Lokasi berhasil dihapus");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
