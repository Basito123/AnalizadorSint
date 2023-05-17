/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author varga
 */
public class Creador {

    public static void main(String[] args) throws Exception{
        String ruta1 = "C:/Users/renef/Documents/NetBeansProjects/Principal/src/principal/Lexer.flex";
        String ruta2 = "C:/Users/renef/Documents/NetBeansProjects/Principal/src/principal/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/Basito/Documents/NetBeansProjects/Principal/src/principal/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/renef/Documents/NetBeansProjects/Principal/src/principal/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/renef/Documents/NetBeansProjects/Principal/src/principal/sym.java"), 
                Paths.get("C:/Users/renef/Documents/NetBeansProjects/Principal/src/principal/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/renef/Documents/NetBeansProjects/Principal/src/principal/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/renef/Documents/NetBeansProjects/Principal/src/principal/Sintax.java"), 
                Paths.get("C:/Users/renef/Documents/NetBeansProjects/Principal/src/principal/Sintax.java")
        );
    }
}

