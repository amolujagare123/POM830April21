package utility;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderUtil {

    public static  Object[][] testDataProvider(String filePath,String sheetName) throws IOException {
        //1.  Read the file :
        FileInputStream fis = new FileInputStream(filePath);

        //2.  Convert file object into workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // 3. Identify the sheet name & create sheet object
        XSSFSheet sheet = workbook.getSheet(sheetName);

        // 4. count the number of active rows in the sheet
        int rowCount = sheet.getPhysicalNumberOfRows(); // 5
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][colCount];

        // 5. traverse the array
        for (int i = 0; i < rowCount - 1; i++) {
            XSSFRow row = sheet.getRow(i + 1); // excel

            for (int j = 0; j < colCount; j++)
                data[i][j] = row.getCell(j).toString().trim();

        }

        return data;
    }

}
