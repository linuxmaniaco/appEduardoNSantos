package br.edu.infnet.appEduardoSantos;

import br.edu.infnet.appEduardoSantos.model.domain.Papelaria;
import br.edu.infnet.appEduardoSantos.model.domain.Vendedor;
import br.edu.infnet.appEduardoSantos.model.service.PapelariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class PapelariaLoader implements ApplicationRunner {
    @Autowired
    private PapelariaService papelariaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        FileReader papelariaFile = new FileReader("files/papelaria.txt");
        BufferedReader papelariaReader = new BufferedReader(papelariaFile);
        String line = papelariaReader.readLine();

        String[] campos = null;

        while(line != null){
            campos = line.split(";");

            Vendedor vendedor = new Vendedor();
            vendedor.setId(Integer.valueOf(campos[6]));

            Papelaria papelaria = new Papelaria();
            papelaria.setCodigo(Integer.parseInt(campos[0]));
            papelaria.setMarca(campos[1]);
            papelaria.setTipoMercadoria(campos[2]);
            papelaria.setDescricao(campos[3]);
            papelaria.setEstoque(Boolean.parseBoolean(campos[4]));
            papelaria.setPreco(Float.parseFloat(campos[5]));
            papelaria.setVendedor(vendedor);


            papelariaService.incluirPapelaria(papelaria);
//            System.out.println("[Papelaria] " + papelaria);

            line = papelariaReader.readLine();
        }
        for(Papelaria p : papelariaService.obterPapelaria()){
            System.out.println("[PAPELARIA] " + p);
        }

        String marca = "spiral";
        for(Papelaria p : papelariaService.obterPorMarca(marca)){
            System.err.printf("[PAPELARIA - %s] %s \n", marca,  p);
        }

        papelariaReader.close();
    }
}
