package com.toko.online.controller;

import com.toko.online.model.BarangModel;
import com.toko.online.response.ResponHelper;
import com.toko.online.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
public class BarangController {

    @Autowired
    BarangService barangService;

    @GetMapping("/{id}")
    public Object getBarang(@PathVariable("id") Integer id) {
        return ResponHelper.ok(barangService.getBarang(id));
    }

    @PostMapping
     public Object addBarang(@RequestBody BarangModel barangModel) {
        return ResponHelper.ok(barangService.addBarang(barangModel));
    }

    @GetMapping
    public Object getAllBarang() {
        return ResponHelper.ok(barangService.getAllBarang());
    }

    @PutMapping("/{id}")
    public Object editBarang(@PathVariable("id") Integer id, @RequestBody BarangModel barangModel) {
        return ResponHelper.ok(barangService.editBarang(id, barangModel.getName(), barangModel.getPrice(), barangModel.getCount(), barangModel.getRating(), barangModel.getDescription(), barangModel.isPublish()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        barangService.deleteBarang(id);
    }
}
