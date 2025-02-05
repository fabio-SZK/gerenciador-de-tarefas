/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author Fabio
 */

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class DateConverter {
    public static Date convertToSqlDate(String dateString) throws Exception {
        try {
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            
            LocalDate localDate = LocalDate.parse(dateString, formatter);

            
            return Date.valueOf(localDate);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null,
                "Formato de data inválido. Por favor utilize dd/MM/yyyy.",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro");
            //return null; // Handle error appropriately
        }
    }
}
