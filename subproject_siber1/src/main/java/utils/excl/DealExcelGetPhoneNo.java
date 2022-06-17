package utils.excl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DealExcelGetPhoneNo {
    static String filePath = "C:\\Users\\86182\\Desktop\\订单资料";
    static String outFilePath="C:\\Users\\86182\\Desktop\\订单资料_txt\\";

    public static void main(String[] args) throws  Exception {
      DealExcelGetPhoneNo d = new DealExcelGetPhoneNo();
      d.getAllFile();
    }

    public void getAllFile() throws Exception{
        File tagFile = new File(outFilePath);
        File[] tagfiles = tagFile.listFiles();
        for(File file:tagfiles){
            file.delete();
        }

     File faFile = new File(filePath);
     File[] files = faFile.listFiles();
     for(File file:files){
         dealExcelPhoneNum(file);
     }
    }

    public static void dealExcelPhoneNum(File file) throws Exception{
        String fileName = file.getName();
        fileName = fileName.replace(".xlsx",".txt");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook sheets = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = sheets.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        List<String> phoneNoList = new ArrayList<String>();

        int dealCell = 18 ;
        if(fileName.indexOf("京东")>-1){
            dealCell = 16 ;
        }

        for (int i = 0; i <rows ; i++) {
/*            if(i==0){
                XSSFRow row0 = sheet.getRow(0);
                for (int j = 0; j < row0.getLastCellNum(); j++) {
                    Cell cellObj = row0.getCell(j);
                    if(cellObj==null) continue;
                    String cell = cellObj.toString();
                    if(cell!=null&&!cell.equals("null")){
                        cell = cell.replace("'","");
                    }
                    if(cell.indexOf("联系电话")>-1){
                        dealCell = j ;
                    }
                    System.out.println("----"+cell);
                }
                continue;
            }*/
            XSSFRow row = sheet.getRow(i);
                Cell cellObj = row.getCell(dealCell);
                if(cellObj==null) continue;
                String cell = cellObj.toString();
                if(cell!=null&&!cell.equals("null")){
                    cell = cell.replace("'","");
                    phoneNoList.add(cell);
                }
        }
        savePhone2txt(fileName,phoneNoList);
    }

    public static void savePhone2txt(String name ,List<String> list) throws  Exception{
        System.out.println(name+"-----"+list);
        String outfilePaht = outFilePath+name;
        File file = new File(outfilePaht);
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        HashMap<String ,String> map = new HashMap<String,String>();
        for (int i = 0; i <list.size() ; i++) {
            String str = list.get(i);
            if (map.get(str)==null){
                map.put(str,str);
            }else{
                continue;
            }
            if(str==null||"null".equals(null)||"".equals(str))
                continue;
            ps.println(str);
        }

    }
}


