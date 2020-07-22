/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoc.webservice.controllers;

import com.mccoc.webservice.entities.Matkul;
import com.mccoc.webservice.services.KsmRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JESSI
 */
@Controller
public class KsmRestControllerClient {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */

    @Autowired
    KsmRestService ksmRestServices;

    
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/ksm")
    public String ksm() {
        return "ksm";
    }
    
    @GetMapping("/jadwal")
    public String jadwal() {
        return "jadwal";
    }

//    @RequestMapping("/ksm/{nim}")
//    public ModelAndView ksm(Model model, @PathVariable(name = "nim") String nim) {
//        ModelAndView mav = new ModelAndView("ksm");
//        mav.addObject("matkul", new Matkul());
//        mav.addObject("matkuls", matkulservices.getbyNIM(nim));
//        mav.addObject("mahasiswa", datamhsservices.getbynim(nim));
//        model.addAttribute("matkulll", matkulservices.getAll());
//        return mav;
//    }
//
//    //Menuju ke laman login
//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("datamhs", new Datamhs());
//        return "login";
//    }
//
//    @RequestMapping("/delete/{kode}/{nim}")
//    public String delete(@PathVariable(name = "kode") String kode, @PathVariable(name = "nim") String nim) {
//        matkulservices.deleteksm(kode, nim);
//        return "redirect:/ksm/" + nim;
//    }
//
//    @PostMapping("/savedata/{nim}")
//    public String save(@ModelAttribute(value = "kode") Matkul matkul, @PathVariable(name = "nim") String nim, Model model) {
//        if (matkulservices.checkksm(matkul.getKode(), nim)) {
//            model.addAttribute("error", true);
//        } else if (matkulservices.checkkode(matkul.getKode()) == false) {
//            model.addAttribute("error", true);
//        } else {
//            matkulservices.savetoksm(matkul.getKode(), nim);
//        }
//        return "redirect:/ksm/" + nim;
//    }
//
//    @GetMapping("/alljadwal/{nim}")
//    public String alljadwal(@PathVariable(name = "nim") String nim, Model model) {
//        model.addAttribute("matkulll", matkulservices.getAll());
//        model.addAttribute("mahasiswa", datamhsservices.getbynim(nim));
//        return "jadwal";
//    }
//
//    //mengecek isi dari form login, apakah sesuai di database
//    @RequestMapping("/check")
//    public String checkLogin(@ModelAttribute(name = "datamhs") Datamhs datamhs, Model model) {
//
//        String nim = datamhs.getNim();
//        String password = datamhs.getPassword();
//
//        if ((nim.equalsIgnoreCase("admin")) && (password.equalsIgnoreCase("admin"))) {
//            return "redirect:/adminpage";
//        }
//
//        if (datamhsservices.checknim(nim)) {
//            if (password.equalsIgnoreCase(datamhsservices.checkpass(nim))) {
//                model.addAttribute("name", datamhsservices.checkname(nim));
//                return "redirect:/ksm/" + nim;
//            } else {
//                model.addAttribute("loginError", true);
//                return "login";
//            }
//        } else {
//            model.addAttribute("loginError", true);
//            return "login";
//        }
//    }
//
//    @GetMapping("/adminpage")
//    public String ksm(Model model) {
//        model.addAttribute("matkul", new Matkul());
//        model.addAttribute("matkulll", matkulservices.getAll());
//        return "adminpage";
//    }
//
//    @GetMapping("/delete/{kode}")
//    public String delete(@PathVariable(name = "kode") String kode) {
//        matkulservices.deletematkul(kode);
//        return "redirect:/adminpage";
//    }
//
//    @PostMapping("/savematkul")
//    public String save(@Valid Matkul matkul) {
//         matkul.setKode(matkul.getKode().toUpperCase());
//         matkulservices.savematkul(matkul);
//        return "redirect:/adminpage";
//    }
//
//    @RequestMapping("/updatematkul/{kode}")
//    public String update(@Valid Matkul matkul, Model model,@PathVariable(name = "kode") String kode) {
//        model.addAttribute("matkul", new Matkul(kode));
//        model.addAttribute("matkulll", matkulservices.getAll());
//        matkulservices.savematkul(matkul);
//        return "redirect:/adminpage";
//    }
}
