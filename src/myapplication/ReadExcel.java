package myapplication;

import java.awt.*;
import java.io.*;
import jxl.*;
import javax.swing.*;

public final class ReadExcel extends JFrame {
    
    public ReadExcel(String fileName) throws Exception{
        File f = new File(fileName);
        
        WorkbookSettings t = new WorkbookSettings();
        t.setEncoding("UTF-8");
        Workbook wb;
        wb = Workbook.getWorkbook(f, t);
        
        Sheet s = wb.getSheet(0);
        int row = s.getRows();
        int col = s.getColumns();
        
        String[][] data = new String[row][col];
        String column[] = new String[col];
        int i_data = 0;
        for(int i=0;i<row; i++){
            for (int j=0;j<col;j++){
                Cell c = s.getCell(j, i);
                if(i!=0){
                    data[i_data][j] = c.getContents();
                }else{
                    column[j] = c.getContents();
                }
            }
            i_data++;
        }
        JTable jt = new JTable(data,column);
        JScrollPane sp = new JScrollPane(jt);  
        this.add(sp);
        this.setTitle("Xem Excel");
        this.setLayout(new GridLayout(1,1));
        this.setSize(350,500); 
        this.setVisible(true);
    }
}