package nizam_setiawan.test_msib_sei.controller;

import nizam_setiawan.test_msib_sei.model.Proyek;
import nizam_setiawan.test_msib_sei.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> tambahProyek(@RequestBody Proyek proyek) {
        Proyek savedProyek = proyekService.tambahProyek(proyek);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.CREATED.value());
        response.put("pesan", "Proyek berhasil dibuat");
        response.put("data", savedProyek);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> dapatkanSemuaProyek() {
        List<Proyek> proyekList = proyekService.dapatkanSemuaProyek();
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("pesan", "Semua proyek berhasil diambil");
        response.put("data", proyekList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> perbaruiProyek(@PathVariable Long id, @RequestBody Proyek proyekDetail) {
        Proyek updatedProyek = proyekService.perbaruiProyek(id, proyekDetail);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("pesan", "Proyek berhasil diperbarui");
        response.put("data", updatedProyek);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> hapusProyek(@PathVariable Long id) {
        proyekService.hapusProyek(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NO_CONTENT.value());
        response.put("pesan", "Proyek berhasil dihapus");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
