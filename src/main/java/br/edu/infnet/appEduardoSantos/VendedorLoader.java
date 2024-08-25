package br.edu.infnet.appEduardoSantos;

import br.edu.infnet.appEduardoSantos.model.domain.Alimento;
import br.edu.infnet.appEduardoSantos.model.domain.Endereco;
import br.edu.infnet.appEduardoSantos.model.domain.Papelaria;
import br.edu.infnet.appEduardoSantos.model.domain.Vendedor;
import br.edu.infnet.appEduardoSantos.model.service.EnderecoService;
import br.edu.infnet.appEduardoSantos.model.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {

    @Autowired
    private VendedorService vendedorService;
    @Autowired
    private EnderecoService enderecoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        FileReader fileReader = new FileReader("files/vendedor.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha = bufferedReader.readLine();
        String[] campos = null;

        Vendedor vendedor = null;

        while (linha != null){
            campos = linha.split(";");


            switch (campos[0].toUpperCase()) {
                case "V":

                    Endereco endereco = enderecoService.obterPorCep(campos[4]);

                    vendedor = new Vendedor();
                    vendedor.setNome(campos[1]);
                    vendedor.setTipo(campos[2]);
                    vendedor.setEmail(campos[3]);
                    vendedor.setEndereco(endereco);

                    vendedorService.incluirVendedor(vendedor);

//                    System.out.println("[Vendedor] " + vendedor);
                    break;

                case "A":
                    Alimento alimento = new Alimento();
                    alimento.setCodigo(Integer.parseInt(campos[1]));
                    alimento.setDescricao(campos[2]);
                    alimento.setEstoque(Boolean.parseBoolean(campos[3]));
                    alimento.setPreco(Float.parseFloat(campos[4]));
                    alimento.setDetalhes(campos[5]);
                    alimento.setBebida(Boolean.parseBoolean(campos[6]));


                    vendedor.getProdutos().add(alimento);
                    break;

                case "P":
                    Papelaria papelaria = new Papelaria();
                    papelaria.setCodigo(Integer.parseInt(campos[1]));
                    papelaria.setMarca(campos[2]);
                    papelaria.setTipoMercadoria(campos[3]);
                    papelaria.setDescricao(campos[4]);
                    papelaria.setEstoque(Boolean.parseBoolean(campos[5]));
                    papelaria.setPreco(Float.parseFloat(campos[6]));


                    vendedor.getProdutos().add(papelaria);
                    break;

            }


            linha = bufferedReader.readLine();
        }

        for (Vendedor v : vendedorService.obterVendedor()){
            System.out.println("[Vendedor]" + v);
        }

        String nome = "Eduardo Santos";
        Vendedor v1 = vendedorService.obterPorNome(nome);
        System.out.println(v1 + "É o nome do vendedor escolhido");

        bufferedReader.close();
    }
}
