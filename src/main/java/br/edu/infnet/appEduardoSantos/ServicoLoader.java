package br.edu.infnet.appEduardoSantos;

import br.edu.infnet.appEduardoSantos.model.domain.ServicoImpressao;
import br.edu.infnet.appEduardoSantos.model.service.ServicoImpressaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

@Component
public class ServicoLoader implements ApplicationRunner {

    @Autowired
    private ServicoImpressaoService servicoImpressaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader servicosFile = new FileReader("files/servico.txt");
        BufferedReader servicoReader = new BufferedReader(servicosFile);

        String line = servicoReader.readLine();
        String[] campos = null;

        while(line != null){
            campos = line.split(";");

            ServicoImpressao servicoImpressao = new ServicoImpressao();
            servicoImpressao.setId(Integer.parseInt(campos[0]));
            servicoImpressao.setServico(campos[1]);
            servicoImpressao.setQuantidade(Integer.parseInt(campos[2]));
            servicoImpressao.setCor(campos[3]);
            servicoImpressao.setValor(Double.parseDouble(campos[4]));
            servicoImpressao.setData(LocalDate.parse(campos[5]));
            servicoImpressao.setHora(campos[6]);

            servicoImpressaoService.incluirServicoImpressao(servicoImpressao);

            line = servicoReader.readLine();
        }
        for(ServicoImpressao s : servicoImpressaoService.obterServicoImpressao()){
            System.out.println("[SERVIÇO] " + s);
        }

        servicoReader.close();
    }
}
