import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Driver {

	public static void main(String[] args) {
		ArrayList<DataPoint> trainingData  = new ArrayList<DataPoint>();
		ArrayList<DataPoint> testData  = new ArrayList<DataPoint>();
		Random rand = new Random();
		Double rangeMin = 0.0;
		Double rangeMax = 100.0;
		
		for(int i=0;i<100;i++) {
			Double f1 = rangeMin +(rangeMax- rangeMin)*rand.nextDouble();
			Double f2 = rangeMin +(rangeMax- rangeMin)*rand.nextDouble();
			String label = "Train";
			Boolean test = null;
			DataPoint dp = new DataPoint(f1,f2,label,test);
			trainingData.add(dp);
			
		}
		for(int i=0;i<100;i++) {
			Double f1 = rangeMin +(rangeMax- rangeMin)*rand.nextDouble();
			Double f2 = rangeMin +(rangeMax- rangeMin)*rand.nextDouble();
			String label = "test";
			Boolean test = null;
			DataPoint dp = new DataPoint(f1,f2,label,test);
			testData.add(dp);
			
		}
		DummyPredictor dummyp1 = new DummyPredictor();
		for(int i =0; i< trainingData.size();i++) {
			dummyp1.train(trainingData.get(i));
			
		}
		
		Double accuracy = dummyp1.getAccuracy(testData);
		Double precision = dummyp1.getPrecision(testData);
		JFrame fram = new JFrame("Dummy Predictor");
		fram.setLayout(new FlowLayout());
		JLabel accuracyLabel = new JLabel();
		accuracyLabel.setText("Accuracy: ");
		JLabel accuracyValue = new JLabel();
		accuracyValue.setText(String.valueOf(accuracy));
		JLabel precisionLabel = new JLabel();
		JLabel precisionValue = new JLabel();
		precisionValue.setText(String.valueOf(precision));
		precisionLabel.setText("Precision: ");
		fram.add(precisionLabel);
		fram.add(precisionValue);
		fram.add(accuracyLabel);
		fram.add(accuracyValue);
		
		
		fram.pack();
		fram.setLocationRelativeTo(null);
		fram.setVisible(true);
		
	}

}
