package employees;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class OpenCsvExample {

    public static void main(String[] args) throws IOException, CsvException {

        String fileName = "D:\\Sirma\\employees\\EmployeesWorkedTogether.csv";
        
        List<String[]> r = new ArrayList<String[]>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            r = reader.readAll();
        }

        List<WorkedTogether> wtl = new ArrayList<WorkedTogether>();
        WorkedTogether wtld;
        long dayWorked = 0L;
        int listIndex = 0;
        for (String[] arrays : r) {
        	listIndex++;
            
            int index = 0;
            for (String array : arrays) {
            	index++;
                
                if(listIndex != 1) {
                	String[] tmp = array.split(", ");
                	
                	WorkedTogether wt = new WorkedTogether(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]),
                 			LocalDate.parse(tmp[2]), tmp[3].equals("NULL")?LocalDate.now():LocalDate.parse(tmp[3]));
                    wtl.add(wt);                   
                    
                }
             }
        }
        
        if(wtl.size() > 0) {
        	long maxDayWorked = 0;
        	int currEmpIdOne = -1;
        	int currEmpIdTwo = -1;
        	int oldEmpIdOne = -1;
        	int oldEmpIdTwo = -1;
        	
        	for(int i = 0; i< wtl.size()-1; i++) {
        		wtld = wtl.get(i);
        		
	            for(int j = i+1; j< wtl.size(); j++) {
	            	if(wtl.get(j).getProjectId() == wtld.getProjectId()) {
	            		//System.out.println("projectId = " + wtld.getProjectId());
	            		dayWorked = ChronoUnit.DAYS.between(DateCommon.max(wtl.get(j).getDateFrom(), wtld.getDateFrom()), DateCommon.min(wtl.get(j).getDateTo(), wtld.getDateTo()));
	            		currEmpIdOne = wtl.get(j).getEmpId();
	            		currEmpIdTwo = wtld.getEmpId();
	            		
	            		if(dayWorked > 0) {
	            			//System.out.println(currEmpIdOne + ", " + currEmpIdTwo + ", " + dayWorked);
	            		}
	            	}
	            }
	            
	            if(dayWorked > maxDayWorked) {
	            	maxDayWorked = dayWorked;
	            	oldEmpIdOne = currEmpIdOne;
	            	oldEmpIdTwo = currEmpIdTwo;
	            } else {
	            	currEmpIdOne = oldEmpIdOne;
	            	currEmpIdTwo = oldEmpIdTwo;
	            }	            	
        	}
        	
        	if(maxDayWorked > 0) {
        		//System.out.println("maxDayWorked");
      			System.out.println(currEmpIdOne + ", " + currEmpIdTwo + ", " + maxDayWorked);
        	}
        }
    }
    
    static List<DataGrid> gridview(String myfilename) throws FileNotFoundException, IOException, CsvException {
    	List<String[]> r;
        try (CSVReader reader = new CSVReader(new FileReader(myfilename))) {
            r = reader.readAll();
        }

        List<WorkedTogether> wtl = new ArrayList<WorkedTogether>();
        WorkedTogether wtld;
        
        List<DataGrid> dgl = new ArrayList<DataGrid>();
        DataGrid dgld;
        
        long dayWorked = 0L;
        int listIndex = 0;
        for (String[] arrays : r) {
        	listIndex++;
            
            int index = 0;
            for (String array : arrays) {
            	index++;
                
                if(listIndex != 1) {
                	String[] tmp = array.split(", ");
                	
                	WorkedTogether wt = new WorkedTogether(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]),
                 			LocalDate.parse(tmp[2]), tmp[3].equals("NULL")?LocalDate.now():LocalDate.parse(tmp[3]));
                    wtl.add(wt);                   
                    
                }
            }
        }
        
        if(wtl.size() > 0) {
        	int currEmpIdOne = -1;
        	int currEmpIdTwo = -1;
        		
        	for(int i = 0; i< wtl.size()-1; i++) {
        		wtld = wtl.get(i);
        		
	            for(int j = i+1; j< wtl.size(); j++) {
	            	if(wtl.get(j).getProjectId() == wtld.getProjectId()) {
	            		System.out.println("projectId = " + wtld.getProjectId());
	            		dayWorked = ChronoUnit.DAYS.between(DateCommon.max(wtl.get(j).getDateFrom(), wtld.getDateFrom()), DateCommon.min(wtl.get(j).getDateTo(), wtld.getDateTo()));
	            		currEmpIdOne = wtl.get(j).getEmpId();
	            		currEmpIdTwo = wtld.getEmpId();
	            		
	            		if(dayWorked > 0) {
	            			System.out.println(currEmpIdOne + ", " + currEmpIdTwo + ", " + dayWorked);
	            			dgld = new DataGrid(currEmpIdOne, currEmpIdTwo, wtld.getProjectId(), dayWorked);
	            			dgl.add(dgld);
	            		}
	            			
	            	}
	            }            
        	}  
        }
        
		return dgl;
    }

}