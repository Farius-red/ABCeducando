package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import modeloVO.UsuarioVO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    
    private boolean  operacion = false ;
    
    public static void crearArchivoExcel(String nombreCvs) {
        
        
        
        Workbook libro = new XSSFWorkbook();
        Sheet hoja = libro.createSheet("Java");
        try {
            FileOutputStream archivo = new FileOutputStream(nombreCvs);
            libro.write(archivo);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void leerArchivoExcel() throws FileNotFoundException, IOException {
        
        FileInputStream archivo = new FileInputStream("");
        XSSFWorkbook libro = new XSSFWorkbook(archivo);
        XSSFSheet hoja = libro.getSheetAt(0);
        
        int numero_filas = hoja.getLastRowNum();
        for (int i = 0; i <= numero_filas; i++) {
            Row fila = hoja.getRow(i);
            int numero_columnas = fila.getLastCellNum();
            for (int j = 0; j < numero_columnas; j++) {
                Cell celda = fila.getCell(j);
                
                switch((celda.getCellTypeEnum().toString())){
                    case "NUMERIC" :
                        
                        System.out.print(celda.getNumericCellValue()+"");
                        break;
                    
                    case "STRING":
                        System.out.print(celda.getStringCellValue()+"");
                        break;
                        
                    
                    case "FORMULA":
                        System.out.print(celda.getCellFormula()+"");
                         break;
                        
                }
            }

                System.out.println("");
        }
    }
    
    
    public boolean cargarMatricula(String rutaArchivo) throws FileNotFoundException, IOException{
     
        FileInputStream archivo = new FileInputStream(rutaArchivo);
        XSSFWorkbook libro = new XSSFWorkbook(archivo);
        
        XSSFSheet hoja = libro.getSheetAt(0);
         int numero_filas = hoja.getLastRowNum();
         
         if(numero_filas <= 10){
             operacion = true;
          UsuarioVO usuvo = new UsuarioVO();
         for (int i = 0; i <= numero_filas; i++) {
            Row fila = hoja.getRow(i);
            String  cellu = fila.getCell(0).getStringCellValue();
            usuvo.setUsuarioid(Integer.parseInt(cellu));
            usuvo.setDatostipoid(fila.getCell(2).getStringCellValue());
            usuvo.setNombre(fila.getCell(3).getStringCellValue());
            usuvo.setApellidos(fila.getCell(4).getStringCellValue());
            usuvo.setTelefono(fila.getCell(5).getStringCellValue());
            usuvo.setEmail(fila.getCell(6).getStringCellValue());
            usuvo.setFechaNacimiento((Date) fila.getCell(7).getDateCellValue());
        }
    
    }
         else{
                System.err.println("El archivo no pudo ser cargado numero de filas invalido");
         
         }
         
         return operacion;
  }
   
}
