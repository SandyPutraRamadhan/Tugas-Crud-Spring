package com.toko.online.service;

import com.toko.online.exception.InternalErrorException;
import com.toko.online.exception.NotFoundException;
import com.toko.online.model.BarangModel;
import com.toko.online.model.UserModel;
import com.toko.online.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarangServiceImpl implements BarangService {

    @Autowired
    BarangRepository barangRepository;

    @Override
    public Object getBarang(Integer id) {
        try {
            return barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan Memunculkan Data");
        }
    }

    @Override
    public Object addBarang(BarangModel barangModel) {
        return barangRepository.save(barangModel);
    }

    @Override
    public Object getAllBarang() {
        try {
            return barangRepository.findAll();
        } catch (Exception e) {
            return "Barang 404 Not Found";
        }
    }

    @Override
    public Object editBarang(Integer id, String name, float price, int count, int rating, String description, boolean publish) {
      BarangModel barangModel = barangRepository.findById(id).get();
      barangModel.setName(name);
      barangModel.setPrice(price);
      barangModel.setCount(count);
      barangModel.setRating(rating);
      barangModel.setDescription(description);
      barangModel.setPublish(publish);
      return barangRepository.save(barangModel);
    }

    @Override
    public void deleteBarang(Integer id) {
        barangRepository.deleteById(id);
    }
}
