package projectThree;
import java.io.File;
import java.util.Random;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;
public  class KnnAlgorithm {
	private List<DataPoint> data;
	private String xLabel;
	private String yLabel;
	
	
	private List<DataPoint> trainingData;
	private List<DataPoint> testingData;
	

	
	
	
	public KnnAlgorithm(String fileName, String xLabel, String yLabel) throws FileNotFoundException {
		this.xLabel=xLabel;
		this.yLabel=yLabel;
		data=readFile(fileName);
		 

		
		
		trainingData=new ArrayList<DataPoint>();
		testingData=new ArrayList<DataPoint>();
		
	} 
	// Helper function to split the line by commas and
	// return the values as a List of String
	private  List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(",");
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		
		return values;
		
		
	}
	private  List<DataPoint> readFile(String fileName) throws FileNotFoundException {
		List<DataPoint> data = new ArrayList<DataPoint>();   
		try (Scanner scanner = new Scanner(new File(fileName));) {
			List<String> labels=getRecordFromLine(scanner.nextLine());
			int xIndex=-1;
			int yIndex=-1;
			
			for(int i=0;i<labels.size();i++) {
				if(labels.get(i).equals(xLabel)) {
	
					xIndex=i+1;
					
				}
				 if(labels.get(i).equals(yLabel)) {
					yIndex=i+1;
					
					
				} 
			}
			
			
			while (scanner.hasNextLine()) {
				List<String> record = getRecordFromLine(scanner.nextLine());
				
				// TODO: Select the columns from the records and create a DataPoint object
				double dataLabel=Double.parseDouble(record.get(1));
				if(record.size()<yIndex+1) {
					record.add("33.29548");
					
				}
				String xAsString = record.get(xIndex); 
				String yAsString = record.get(yIndex);
				
				double x=29.88113;//if we missing the age use the average age of all passengers
				double y= 33.29548;//if we missing the fare use the average fare of all passengers
				
				if(!(xAsString.equals(""))) {
					x=Double.parseDouble(record.get(xIndex));	
				}
				if(!(yAsString.equals(""))) {
					y=Double.parseDouble(record.get(yIndex));
				
				}
			
					
				
				 
				 
				 
				
				 
				DataPoint<Double> dp = new DataPoint<Double> (x,y,dataLabel,0.0);
				
				// TODO: Store the DataPoint object in a collection
				data.add(dp);
				
			}
			
		}
		
		return data;
	}
	public void splitData() {
		Random rand = new Random();
		int trainCount=0;
		int testCount=0;
		for(DataPoint dp:data) {
			double randNum = rand.nextDouble();
			
			// 90% of the data is reserved for training
			if (randNum < 0.9) {
				// Set the type of DataPoint as “train” and put into the Collection
				dp.setPredictorLabel(1.0);
				
				trainingData.add(dp);
				
				
				trainCount++;
				
			}else  {
				// Set the type of DataPoint as “test” and put into the Collection
				dp.setPredictorLabel(2.0);
				testingData.add(dp);
				testCount++;
				
			}
			
			
		}
		
		completeData();
	}
	private void completeData() {
		data.clear();
		for(DataPoint<Double> dp:trainingData) {
			data.add(dp);
			
		}
		for(DataPoint<Double> dp:testingData) {
			data.add(dp);
			
		}
	}
	public List<DataPoint> getAllDataPoint(){
		return data;
	}
	public List<DataPoint> getTraining(){
		return trainingData;
	}
	public List<DataPoint> getTesting(){
		return testingData;
	}
	
}

	
	
	


