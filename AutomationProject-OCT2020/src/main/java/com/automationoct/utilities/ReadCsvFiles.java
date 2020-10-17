package com.automationoct.utilities;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;


public class ReadCsvFiles {
 
 public static void readCsv(String CsvFilePath) throws IOException, CsvException {
    
 // This will load csv file 
 CSVReader reader = new CSVReader(new FileReader(CsvFilePath));
 
 // this will load content into list
  List<String[]> li=reader.readAll();
  System.out.println("Total rows which we have is "+li.size());
  System.out.print(" Values are ");
            
 // create Iterator reference
  Iterator<String[]>i1= li.iterator();
    
 // Iterate all values 
 while(i1.hasNext()){
     
 String[] str=i1.next();
   

 for(int i=0;i<str.length;i++)
{
 
   System.out.print(" "+str[i]);
 
}
   System.out.println("   ");

    
}
 
}
 
}