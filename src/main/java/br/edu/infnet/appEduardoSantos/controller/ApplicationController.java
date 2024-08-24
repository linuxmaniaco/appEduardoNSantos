package br.edu.infnet.appEduardoSantos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ApplicationController {

//    @GetMapping(value = "/")
//    public String paginaInicial(Model model){
//        model.addAttribute("quantidade", 999);
//        return "index";
//    }
//
//    @GetMapping(value = "/listar")
//    public String listaAlimentos(Model model){
////        Collection<Alimento> alimentoList = alimentoService.obterAlimento();
//        List<String> alimentoList = new ArrayList<String>(
//                Arrays.asList("Eduardo", "nascimento", "dos", "Santos")
//        );
//        model.addAttribute("alimentoList", alimentoList.get(0));
//        return "index";
//    }
}
