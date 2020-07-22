/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exerciseSpringBoot.crudBootstrap.controllers;

import com.exerciseSpringBoot.crudBootstrap.entities.Datamhs;
import com.exerciseSpringBoot.crudBootstrap.entities.Matkul;
import com.exerciseSpringBoot.crudBootstrap.services.DatamhsService;
import com.exerciseSpringBoot.crudBootstrap.services.MatkulService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */
@RequestMapping("api")
@RestController
public class KsmRestController {

    @Autowired
    DatamhsService datamhsservices;

    @Autowired
    MatkulService matkulservices;

    @GetMapping("{nim}")
    @SuppressWarnings("empty-statement")
    public List<Matkul> ksm(Model model, @PathVariable(name = "nim") String nim) {
        return matkulservices.getbyNIM(nim);
    }

    @DeleteMapping("{kode}/{nim}")
    public String delete(@PathVariable(name = "kode") String kode, @PathVariable(name = "nim") String nim) {
        if (matkulservices.checkksm(kode, nim)) {
            matkulservices.deleteksm(kode, nim);
            return "Mata Kuliah " + kode + " sudah terhapus dari KSM Mahasiswa " + nim;
        } else {
            return "Mata Kuliah " + kode + " tidak ada di KSM Mahasiswa " + nim;
        }
    }

    @PostMapping("/{kode}/{nim}")
    public String save(Matkul matkul, @PathVariable(name = "kode") String kode, @PathVariable(name = "nim") String nim) {
        if (matkulservices.checkksm(matkul.getKode(), nim)) {
            return "Mata Kuliah " + kode + " sudah ada di KSM Mahasiswa " + nim;
        } else if (matkulservices.checkkode(matkul.getKode()) == false) {
            return "Mata Kuliah " + kode + " tidak dapat ditemukan di database!";
        } else {
            matkulservices.savetoksm(matkul.getKode(), nim);
        }
        return "Mata Kuliah " + kode + " berhasil ditambah di KSM Mahasiswa " + nim;
    }

    @GetMapping("/alljadwal")
    public List<Matkul> alljadwal() {
        return matkulservices.getAll();
    }

    @GetMapping("/check/{nim}/{pass}")
    public String checkLogin(Datamhs datamhs, @PathVariable(name = "nim") String nim, @PathVariable(name = "pass") String pass) {
        if (datamhsservices.checknim(nim)) {
            if (pass.equalsIgnoreCase(datamhsservices.checkpass(nim))) {
                return "Berhasil Login";
            } else {
                return "Gagal Login";
            }
        } else {
            return "Gagal Login";
        }
    }

}
