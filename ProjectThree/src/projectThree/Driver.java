package projectThree;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a K value for our KNNPredictor: ");
		int K=0;
		try{
			 K=input.nextInt();
		}catch(IllegalArgumentException e) {
			System.out.println("Error: K must be an positive odd int value ");
		}
		if(K%2==0||K<0) {
			System.out.println("Error: K must be an positive odd int value ");
		}else {
			KnnPredictor predictor = new KnnPredictor(K);
			predictor.readData("C:\\Users\\15102\\eclipse-workspace\\ProjectThree\\src\\titanic.csv", "age", "fare","pclass","sex");
			double accuracy = predictor.getAccuracy();
			double precision= predictor.getPrecision();
			JFrame fram = new JFrame("KNNPredictor");
			fram.setLayout(new GridLayout(2,1));
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
		input.close();
	}
}
