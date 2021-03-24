import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class DummyPredictor extends Predictor {
	private  DataPoint prevData= null;
	private  ArrayList<Double> f1change  = new ArrayList<Double>(); 
	private  ArrayList<Double> f2change  = new ArrayList<Double>(); 
	private  Double f1Prediction= null;
	private  Double f2Prediction= null;
	@Override
	ArrayList<DataPoint> readData(String filename) throws FileNotFoundException {
		ArrayList<DataPoint> dps = new ArrayList<DataPoint>();
		
		File f = new File("C:\\Users\\15102\\eclipse-workspace\\DataAnalytics\\src\\(default package)\\DataFile.txt");
		Scanner s = new Scanner(f);
		int pointNumber = 1;
		String pointFormat ="point "+ pointNumber  ;
		while(s.hasNextDouble()) {
			Double f1 = s.nextDouble();
			Double f2 = s.nextDouble();
			String label= pointFormat;
			Boolean test = null;
			DataPoint dp = new DataPoint(f1,f2,label,test);
			dps.add(dp);
			pointNumber++;
			pointFormat ="point "+ pointNumber  ;

		}
		s.close();
		return dps;
	}
	@Override
	public String test(DataPoint data) {
		
		if(prevData.equals(null)) {
			prevData = data;
			
			return "First test no prediction we do not have enought information";
		}
		else {
			 f1Prediction= computeAve(f1change) + prevData.getF1();
			 f2Prediction= computeAve(f2change) + prevData.getF2();
			
			Double f1 = data.getF1();
			Double f2 = data.getF2();
			
			if(Math.abs(f1Prediction-f1)<=5 && Math.abs(f2Prediction-f2)<=5 ) {
				return "The prediction is Good";
			}
			
		}
		
		return "Prediction is bad";	
	}

	
	public String train(DataPoint data) {
		f1change.add(data.getF1());
		f2change.add(data.getF2());
		if(prevData==null) {
			prevData = data;
			
			return "First test no prediction we do not have enought information";
		}
		else {
			 f1Prediction= computeAve(f1change) + prevData.getF1();
			 f2Prediction= computeAve(f2change) + prevData.getF2();
			
			Double f1 = data.getF1();
			Double f2 = data.getF2();
			
			if(Math.abs(f1Prediction-f1)<=5 && Math.abs(f2Prediction-f2)<=5 ) {
				return "The prediction is Good";
			}
			
		}
		
		return "Prediction is bad";
	}

	@Override
	public Double getAccuracy(ArrayList<DataPoint> data) {
		int goodCount = 0;
		for(int i =0; i<data.size();i++) {
			DataPoint datapointiIteration = data.get(i);
			String stringOutPout=test(datapointiIteration);
			if(stringOutPout.equals("The prediction is Good")) {
				datapointiIteration.setTest(true);
				data.set(i, datapointiIteration);
				goodCount++;
			}
			else if(stringOutPout.equals("Prediction is bad")) {
				datapointiIteration.setTest(false);
				data.set(i, datapointiIteration);
				
			}
			
		}
		return (Double.valueOf(goodCount))/(Double.valueOf(data.size())); 
		
	}

	@Override
	public Double getPrecision(ArrayList<DataPoint> data) {
		int exactCount = 0;
		int goodCount =0;
		for(int i =0; i<data.size();i++) {
			DataPoint datapointiIteration = data.get(i);
			String stringOutPout=test(datapointiIteration);
			if(stringOutPout.equals("The prediction is Good")) {
				datapointiIteration.setTest(true);
				data.set(i, datapointiIteration);
				goodCount++;
				if((datapointiIteration.getF1()==f1Prediction) && (datapointiIteration.getF2()==f2Prediction)) {
					exactCount++;	
				}
			}
			else if(stringOutPout.equals("Prediction is bad")) {
				datapointiIteration.setTest(false);
				data.set(i, datapointiIteration);
				
			}
			
		}
		if(goodCount==0) {
			return 0.0;
		}
		return  (Double.valueOf(exactCount))/(Double.valueOf(goodCount));
	}
	private Double computeAve(ArrayList<Double> f) {
		Double sum = 0.0;
		for(int i =0; i<f.size();i++) {
			sum = sum+f.get(i);
			
		}
		Double numFeature = Double.valueOf(f.size());
		return sum/numFeature;
		
	}

}
