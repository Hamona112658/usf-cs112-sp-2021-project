package projectThree;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class KnnPredictor {
	private int K;
	private int survived;
	private int didNotSurvived;
	private List<DataPoint> data;
	private List<DataPoint> trainingData;
	private List<DataPoint> testingData;
	
	public KnnPredictor(int K) {
		this.K=K;
		survived=0;
		didNotSurvived=0;
		
	} 
	public List<DataPoint> getTrainingData(){
		return trainingData; 
	} 
	public List<DataPoint> getTestingData(){
		return testingData; 
	} 
	
	public List readData(String fileName, String xLabel, String yLabel) throws FileNotFoundException{
		KnnAlgorithm alg= new KnnAlgorithm(fileName,xLabel,yLabel);
		
		alg.splitData();
		data=alg.getAllDataPoint();
		trainingData=alg.getTraining();
		testingData=alg.getTesting();
  
		return data;
	}
	
	private double getDistance(DataPoint<Double> p1,DataPoint<Double> p2){
		double x1=p1.getx();
		double y1=p1.gety();
		
		
		double x2=p2.getx();
		double y2=p2.gety();
		
		return Math.sqrt(Math.pow((y2-y1), 2.0)+Math.pow((x2-x1), 2.0));
		
	}
	public String test(DataPoint<Double> input) {
		Double[][] distances = new Double[trainingData.size()][2];
		
		int i=0;
		for(DataPoint<Double> dp: trainingData ) {
			Double distance= getDistance(input,dp);
			Double label= dp.getDataLabel();
			
			distances[i][0]=distance;
			distances[i][1]=label;
			i++;
		}
		
	
		
		java.util.Arrays.sort(distances, new java.util.Comparator<Double[]>() {
			public int compare(Double[] a, Double [] b) {
				
				return a[0].compareTo(b[0]);
			}
		});
		
		
		
		 survived=0;
		 didNotSurvived=0;
		
		 
		 for(i=0;i<K;i++) {
			 double label=distances[i][1];
			
			 if(label==1.0) {
				 survived++; 
			 }else if(label==0.0){
				 didNotSurvived++; 
			 }
		 }
		 
		if(survived> didNotSurvived) {
			return "1";
			
		}
		return "0";
	}
	public Double getAccuracy() {
		
		double truePositive=0.0;
		double falsePositive=0.0;
		double trueNegative=0.0;
		double falseNegative=0.0;
		for(DataPoint<Double> dp:testingData) {
			
			String label_testMethod= test(dp);
			String label_dataPoint=Double.toString(dp.getDataLabel());
			
			
			if((label_testMethod.equals("1"))&&(label_dataPoint.equals("1.0"))) {
				truePositive=truePositive+1.0;
			}
			if((label_testMethod.equals("1"))&&(label_dataPoint.equals("0.0"))) {
				falsePositive=falsePositive+1.0;
			}
			if((label_testMethod.equals("0"))&&(label_dataPoint.equals("1.0"))) {
				falseNegative=falseNegative+1.0;
			}
				
			if((label_testMethod.equals("0"))&&(label_dataPoint.equals("0.0"))) {
				trueNegative=trueNegative+1.0;
			}
			
				
		}
		
		return (truePositive + trueNegative) / (truePositive +trueNegative + falsePositive + falseNegative);
		
	}
	public double getPrecision() {
		double truePositive=0.0;
		double falsePositive=0.0;
		double trueNegative=0.0;
		double falseNegative=0.0;
		for(DataPoint<Double> dp:testingData) {
			String label_testMethod= test(dp);
			
			
			String label_dataPoint=Double.toString(dp.getDataLabel());
			
			if((label_testMethod.equals("1"))&&(label_dataPoint.equals("1.0"))) {
				truePositive=truePositive+1.0;
			}
			if((label_testMethod.equals("1"))&&(label_dataPoint.equals("0.0"))) {
				falsePositive=falsePositive+1.0;
			}
			if((label_testMethod.equals("0"))&&(label_dataPoint.equals("1.0"))) {
				falseNegative=falseNegative+1.0;
			}
				
			if((label_testMethod.equals("0"))&&(label_dataPoint.equals("0.0"))) {
				trueNegative=trueNegative+1.0;
			}
			
				
		}
		
		
		return truePositive / (truePositive + falseNegative);
	}
	public List getResult() {
		List result = new ArrayList<DataPoint>();
		for(DataPoint<Double> dp:testingData) {
			String label_testMethod= test(dp);
			Double label_testMethod_asDouble= Double.parseDouble(label_testMethod);
			DataPoint<Double> newDp= new DataPoint<Double>(dp.getx(),dp.gety(),label_testMethod_asDouble,dp.getPredictorLabel()); 
			result.add(newDp);
		}
		for(DataPoint<Double> dp:trainingData) {
			result.add(dp);
		}
		return result;
	
	
	}		
}  
	
	

