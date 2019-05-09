package com.jeff_code.estudy.util;

/**
 * @Author: jefflike
 * @create: 2018/10/15
 * @describe:
 */
/**
 *
 */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

/**
 *
 * Description: Excel操作
 *
 * CreateTime: 2017年12月11日  下午3:08:09
 *
 * Change History:
 *
 *        Date             CR Number              Name              Description of change
 *
 */
@Component
public class ExcelUtil {

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    /**
     * 判断Excel的版本,获取Workbook
     * @param in
     * @param filename
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(InputStream in,File file) throws IOException{
        Workbook wb = null;
        if(file.getName().endsWith(EXCEL_XLS)){  //Excel 2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 判断文件是否是excel
     * @throws Exception
     */
    public static void checkExcelVaild(File file) throws Exception{
        if(!file.exists()){
            throw new Exception("文件不存在");
        }
        if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){
            throw new Exception("文件不是Excel");
        }
    }
}

