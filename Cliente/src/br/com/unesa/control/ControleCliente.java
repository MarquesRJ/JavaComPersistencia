package br.com.unesa.control;

import br.com.unesa.model.Cliente;
import br.com.unesa.model.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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

    public List<Cliente> ObterListar() {
        return Cdao.listar();
    }

    public void alterar(Cliente client) {
        Cdao.alterar(client);
    }

    public void buscar(int id) {
        List<Cliente> codigo = new ArrayList<>();
        codigo = Cdao.buscar(id);
        if (codigo.get(id - 1).id == id) {
            JOptionPane.showMessageDialog(null, codigo.get(id - 1).id + "\n" + codigo.get(id - 1).cpf + "\n"
                    + codigo.get(id - 1).nome + "\n" + codigo.get(id - 1).idade + "\n" + codigo.get(id - 1).email + "\n"
                    + codigo.get(id - 1).telefone);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
        }
    }
}

/* public List<Cliente> buscar(int codigo){
        return Cdao.buscar(codigo);
    }*/
