package DatatDrivenTesting.ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrivenTest {
	
	public ArrayList<String> getData(String testCaseName) throws IOException
	{
		ArrayList<String> a = new ArrayList<>();
		FileInputStream fis = new FileInputStream("C:\\Automation\\ExcelDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//count number of sheets
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);//test data sheet access
				//identify testcase column by scanning entire row
				Iterator<Row> row = sheet.iterator();//sheet is a collection of rows...row access
				Row firstRow = row.next();
				Iterator<Cell> cell = firstRow.cellIterator();//row is a collection of cells....cell access
				int j=0;
				int column=0;
				//hasNext() verifies next cell has content or not. But it doesn't move
				while(cell.hasNext())//if cell has value then enter loop
				{
					Cell cellValue = cell.next();//move to next cell
					if(cellValue.getStringCellValue().equalsIgnoreCase("Test cases"))//if cellvalue matches the condition then enter
					{
						//grab column index
						column=j;
						
					}
					j++;
				}
				System.out.println(column);
				//once column is identified then scan entire testcase column to identify purchase row
				while(row.hasNext())
				{
					Row rowValue = row.next();
					if(rowValue.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
					{
						//after you grab Purchase row => fetch all the data of that row
						Iterator<Cell> cv = rowValue.cellIterator();
						while(cv.hasNext())
						{
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING)
							{
								a.add(c.getStringCellValue());//adding values into array
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
						}
					}
					
				}
			}
	}
		return a;

	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

		}
}
