/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jmas
 * @param <T> DTO
 */
public interface IDAO<T> {
    
    
    int actualizar(T objeto) throws SQLException;
    int anyadir(T objeto) throws SQLException;
    T eliminar(int codigo) throws SQLException;
    T eliminar(T objeto) throws SQLException;
    boolean existe(T objeto) throws SQLException;
    ArrayList<T> getAll() throws SQLException;
    T getByCodigo(int codigo) throws SQLException;
    int siguienteCodigo() throws SQLException;
    void vaciar() throws SQLException;
    
    
    
    
    
}
