package br.com.unesa.control;

import br.com.unesa.model.Cliente;
import br.com.unesa.model.ClienteDAO;
import java.util.List;

/**
 * @author Jonas Silva Carvalho<jonasloop1@gmail.com>
 * @author Gabriel Henrique Santos Marques<gabrielmarques142@gmail.com>
 * @author Marlon Ribeiro da Silva<marlonribeirodasilva@outlook.com.br>
 * @brief Controle dos usuarios.
 * @date 23/11/2020.
 */
public class ControleCliente extends Cliente {

    private ClienteDAO Cdao = new ClienteDAO();

    public void incluir(Cliente client) {
        Cdao.incluir(client);
    }
    
    public void excluir(Cliente client){
        Cdao.excluir(client);
    }

    public List<Cliente> ObterListar() {
        return Cdao.listar();
    }

    public void alterar(Cliente client) {
        Cdao.alterar(client);
    }

    public List<Cliente> buscar(){
        return Cdao.buscar();
    }
}
