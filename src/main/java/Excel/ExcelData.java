package Excel;


	import java.io.FileInputStream;

	import java.io.IOException;
	import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



	public class ExcelData {
		
		
		int contadorF=0;
		
		public Object[][] getData() throws IOException{
			
		
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//DataDemo.xlsx");
		
		
			XSSFWorkbook libro = new XSSFWorkbook(fis);
				
			XSSFSheet hoja = libro.getSheetAt(0);
			
			
			Iterator<Row> filas = hoja.iterator();
			Iterator<Cell> celdas;
	 		
			Row fila;
		
			Cell celda;
			
				while (filas.hasNext()) 
				{
				
				fila = filas.next();
				celdas = fila.cellIterator();
				contadorF++;
		
				
					while (celdas.hasNext()) {
		
						celda =celdas.next();
						celda.getCellType();
					
					}
				}
				
				Object[][] data = new Object[contadorF-1][hoja.getRow(0).getPhysicalNumberOfCells()];
				for (int i = 1; i < contadorF; i++) {
					for (int j = 0; j <hoja.getRow(0).getPhysicalNumberOfCells() ; j++) {
						XSSFCell value = hoja.getRow(i).getCell(j);
						if (value != null) { value.setCellType(CellType.STRING);
						data[i - 1][j] = value.toString();
						}else {
							
							data[i - 1][j] = "";
						}

		
				}
					libro.close();	
			}
				return data;
		
			
		}	
	}
		
	
	
	

