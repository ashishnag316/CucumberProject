package DatatDrivenTesting.ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class dataTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		dataDrivenTest d = new dataDrivenTest();
		ArrayList<String> data = d.getData("Add Profile");
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i));
		}
		
	
	}

}
