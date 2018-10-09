package com.adc.da.myutil.service;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ExeclCheck {
    public int execlCheck(String quasiExaminationNumber) throws IOException, BiffException {
        Sheet sheet;
        Workbook book;
        File file = new File("准考证号.xls");
        //获取整个文件对象
        book = Workbook.getWorkbook(file);
        //获取Execlwe文件的第一页
        sheet = book.getSheet(0);
        //得到有值的行数
        int rows = sheet.getRows();
        List<String> list = new ArrayList<>();
        Cell cell = null;
        for (int i = 0; i < rows; i++ ) {
            //第一列的第i行的值
            cell = sheet.getCell(0, i);
            list.add(cell.getContents());
        }
        if(list.contains(quasiExaminationNumber)){
            //可用
            return 1;
        }
        else{
            //不可用
            return 0;
        }

    }
}
