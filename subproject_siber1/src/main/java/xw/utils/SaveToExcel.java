package xw.utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

public class SaveToExcel<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    private static void setColumnWidth(HSSFSheet sheet ,int colnum){
       for(int i=0;i<colnum;i++){
           int v = 0 ;
           v = Math.round(Float.parseFloat("15.0")*37F);
           v = Math.round(Float.parseFloat("20.0")*267.5F);
           sheet.setColumnWidth(i,v);
       }
    }

    public void writeExcel(List<T> list ,String fileAbPath) throws Exception {
        int columnNum ;
        int rows = list.size() ;
        File file ;
        file = new File(fileAbPath);
        if(!file.getName().endsWith("xls")) {
            return;
        }
        if(!file.exists()){
            file.createNewFile();
        }
        if(list.size()==0||list.equals("")||list ==null){
            return;
        }
        Class obClass = list.get(0).getClass();
        Field[] fields = obClass.getDeclaredFields();

        columnNum = fields.length;
        String[] titleNames = new String[columnNum];

        for(int i= 0 ;i<columnNum ;i++){
            titleNames[i] = fields[i].getName() ;
            System.out.println(titleNames[i]);
        }

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        setColumnWidth(sheet, titleNames.length);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null ;
        for (int i = 0 ;i<titleNames.length;i++){
            cell = row.createCell(i);
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            HSSFFont font = workbook.createFont();
            font.setFontName("宋体");
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setFontHeightInPoints((short) 13);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(titleNames[i]);
        }

        for (int i= 1 ;i<(list.size()+1);i++){
            HSSFRow nextRow = sheet.createRow(i);
            for (int j= 0 ;j<titleNames.length;j++){
                T t = list.get(i - 1);
                HSSFCell cell2 = nextRow.createCell(j);
                Field field  = t.getClass().getDeclaredField(fields[j].getName());
                field.setAccessible(true);
                String s = (String) field.get(t);
                cell2.setCellValue(s);
            }
        }

        FileOutputStream fileOutputStream = FileUtils.openOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();

    }
}




