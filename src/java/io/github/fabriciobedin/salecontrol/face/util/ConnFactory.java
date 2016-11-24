/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.face.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fabricio
 */
public class ConnFactory {
//variáveis globais
    private static Connection con;
    private Statement s;

    //--------------- DADOS PARA CONEXÃO----------------------------
    private final String banco = "DB_SALECONTROL"; // Nome do banco de dados   
    private static final String usuario = "postgres"; // Usuario do banco integrator
    private static final String enderecoFisicoBanco = "jdbc:postgresql://localhost:5432/"; // Banco Integrator
    private final String senha = "masterkey"; // Senha
   
    //--------------------------------------------------------------

    // Cria a conexão...
    public void conectar() {
        try {
            if (getCon() == null || getCon().isClosed()) {
                Class.forName("org.postgresql.Driver");
                setCon(DriverManager.getConnection(enderecoFisicoBanco + banco, usuario, senha));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("não foi possível conectar ao banco ->" + e);
        }
    }

    //Atualizando dados...
    public int executarAtualizacao(String sql){
        try{
            if (s==null){
                s= getCon().createStatement();
            }
            int ii=s.executeUpdate(sql);
            return(ii);
        } catch (Exception e){
            System.out.println(e);
        }
        return(0);
    }

    //Executando consulta...
    public ResultSet executarConsulta(String sql){
        try{
            if (s==null)
                s= getCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            return r;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //Fechando conexão com Banco de Dados...
    public void fechar() {
        if (getCon() != null) {
            try {
                if (s!=null) {
                    s.close();
                    s=null;}
                getCon().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

     /**
     * @return the con
     */
    public static Connection getCon() {
        return con;
    }

    /**
     * @param aCon the con to set
     */
    public static void setCon(Connection aCon) {
        con = aCon;
    }

}
