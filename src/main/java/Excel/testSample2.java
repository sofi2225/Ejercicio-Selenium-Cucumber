package Excel;


import java.io.IOException;


public class testSample2 {

	public static void main(String[] args) throws IOException  {
		

		
		ExcelData d = new ExcelData();
		Object[][] data= d.getData();
		
		System.out.println(data[0][0]);
		System.out.println(data[0][1]);
		//System.out.println(data[0][2]);
		//System.out.println(data[0][3]);
		//System.out.println(data[0][4]);
		//System.out.println(data[0][5]);
		
		System.out.println(data[1][0]);
		System.out.println(data[1][1]);
		//System.out.println(data[1][2]);
		//System.out.println(data[1][3]);
		//System.out.println(data[1][4]);
		//System.out.println(data[1][5]);
		
		//System.out.println(data[2][0]);
		//System.out.println(data[2][1]);
		//System.out.println(data[2][2]);
		//System.out.println(data[2][3]);
		//System.out.println(data[2][4]);
		//System.out.println(data[2][5]);
		System.out.println(data[2][0]);
		System.out.println(data[2][1]);
		
		
	}

}
