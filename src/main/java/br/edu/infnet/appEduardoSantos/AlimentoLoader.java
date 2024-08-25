package br.edu.infnet.appEduardoSantos;

import br.edu.infnet.appEduardoSantos.model.domain.Alimento;
import br.edu.infnet.appEduardoSantos.model.domain.Produto;
import br.edu.infnet.appEduardoSantos.model.domain.Vendedor;
import br.edu.infnet.appEduardoSantos.model.service.AlimentoService;
import br.edu.infnet.appEduardoSantos.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class AlimentoLoader implements ApplicationRunner {
    @Autowired
    private AlimentoService alimentoService;
    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        FileReader alimentoFile = new FileReader("files/alimento.txt");
        BufferedReader alimentoReader = new BufferedReader(alimentoFile);

        String linha = alimentoReader.readLine();
        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");

            Vendedor vendedor = new Vendedor();
            vendedor.setId(Integer.valueOf(campos[6]));

            Alimento alimento = new Alimento();

            alimento.setCodigo(Integer.parseInt(campos[0]));
            alimento.setDescricao(campos[1]);
            alimento.setEstoque(Boolean.parseBoolean(campos[2]));
            alimento.setPreco(Float.parseFloat(campos[3]));
            alimento.setDetalhes(campos[4]);
            alimento.setBebida(Boolean.parseBoolean(campos[5]));
            alimento.setVendedor(vendedor);

            //incluir
//          alimentoMap.put(alimento.getId(), alimento);
            alimentoService.incluirAlimento(alimento);


//            System.out.println("[Aliments]" + alimento);
            linha = alimentoReader.readLine();
        }

        for(Alimento a : alimentoService.obterAlimento()){
            System.out.println("[ALIMENTOS]" + a);
        }

        Boolean[] tiposAlimentos = {true,false};
        for(Boolean tipo : tiposAlimentos){
            for(Alimento a : alimentoService.obterBebida(tipo)){
                System.err.println("É BEBIDA? " + (tipo ? "sim " : "não " )+ a);
            }
        }

        Integer id = 1;
        for(Produto p : produtoService.obterProdutosPorVendedor(id)){
            System.out.println("[PRODUTO POR ID]" + p);
        }

        Vendedor vendedor = new Vendedor();
        vendedor.setId(2);
        for(Produto p : produtoService.obterProdutosPorVendedor(vendedor)){
            System.out.println("[PRODUTO POR OBJETO]" + p);
        }

        alimentoReader.close();
    }
}
