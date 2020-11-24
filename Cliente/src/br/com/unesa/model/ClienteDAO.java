package br.com.unesa.model;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

/**
 * @author Jonas Silva Carvalho<jonasloop1@gmail.com>
 * @author Gabriel Henrique Santos Marques<gabrielmarques142@gmail.com>
 * @author Marlon Ribeiro da Silva<marlonribeirodasilva@outlook.com.br>
 * @brief Classe DAO
 * @date 23/11/2020
 *
 */
public class ClienteDAO extends Cliente {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection("jdbc:derby://localhost:1527/JGM", "JGM", "JGM");
    }

    private void closeConnection(Connection cx) {
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Erro de exceção SQL-close" + ex);
        }
    }

    public void incluir(Cliente client) {
        Connection cx1 = null;
        try {
            cx1 = getConnection();
            PreparedStatement st = cx1.prepareStatement(
                    "INSERT INTO CLIENTE VALUES (?, ?, ?, ?, ?, ?)");
            st.setInt(1, client.getId());
            st.setString(2, client.cpf);
            st.setString(3, client.nome);
            st.setString(4, client.idade);
            st.setString(5, client.email);
            st.setString(6, client.telefone);
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro de exceção.-incluir" + ex);
        } finally {
            closeConnection(cx1);
        }
    }
    
    public void excluir(Cliente client){
        Connection cx1 = null;
        try{
            cx1 = getConnection();
            PreparedStatement st = cx1.prepareStatement(
                    "DELETE FROM CLIENTE WHERE ID = ?");
            st.setInt(1, client.getId());
            st.executeUpdate();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Erro de exceção.-excluir" + ex);
        }finally{
            closeConnection(cx1);
        }
    }

    public List<Cliente> listar() {
        ArrayList<Cliente> listaCliente = new ArrayList();
        Connection cx1 = null;

        try {
            cx1 = getConnection();
            Statement estado = cx1.createStatement();
            ResultSet resultado = estado.executeQuery("SELECT * FROM CLIENTE");
            while (resultado.next()) {
                listaCliente.add(new Cliente(
                        resultado.getInt(1), resultado.getString(2), resultado.getString(3),
                        resultado.getString(4), resultado.getString(5), resultado.getString(6)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro de exceção.-listar" + ex);
        } finally {
            closeConnection(cx1);
        }
        return listaCliente;
    }

    public List<Cliente> buscar() {
        ArrayList<Cliente> buscarCliente = new ArrayList();
        Connection cx1 = null;

        try {
            cx1 = getConnection();
            Statement estado = cx1.createStatement();
            ResultSet resultado = estado.executeQuery("SELECT * FROM CLIENTE WHERE id = ?");
            while (resultado.next()) {
                buscarCliente.add(new Cliente(
                        resultado.getInt(1), resultado.getString(2), resultado.getString(3),
                        resultado.getString(4), resultado.getString(5), resultado.getString(6)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro de exceção.-Buscar" + ex);
        } finally {
            closeConnection(cx1);
        }
        return buscarCliente;
    }

    public void alterar(Cliente client) {
        Connection cx1 = null;
        try {
            cx1 = getConnection();
            PreparedStatement st = cx1.prepareStatement(
                    "UPDATE CLIENTE SET cpf=?, nome=?, idade=?, email=?, telefone=? WHERE id=?");
            st.setInt(1, client.getId());
            st.setString(2, client.getCpf());
            st.setString(3, client.getNome());
            st.setString(4, client.getIdade());
            st.setString(5, client.getEmail());
            st.setString(6, client.getTelefone());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro de exceção.-alterar" + ex);
        } finally {
            closeConnection(cx1);
        }
    }
}
