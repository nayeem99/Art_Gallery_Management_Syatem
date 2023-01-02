package GELLERY;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class CurrentDateTime {    
  public static void main(String[] args) {    
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now();  
   System.out.println(dtf.format(now));  
  }    
} 