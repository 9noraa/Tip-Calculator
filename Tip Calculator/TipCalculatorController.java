			//Includes from scene builder
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class TipCalculatorController {
			//Number formats for dollars and percent
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    
    		//Default tip perccentage
    private BigDecimal tipPercentage = new BigDecimal(0.15);

    		//FXML text fields and labels
    @FXML
    private Label tipPercentageLabel;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private Slider tipPercentageSlider;
    
    public void initialize() {
			//Rounding mode
	currency.setRoundingMode(RoundingMode.HALF_UP);
	
			//Listener that runs when the amount text field is changed
	amountTextField.textProperty().addListener(
			new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> ov,
									String oldValue, String newValue) {
					
			//Getting the amount and tip from the fields
					BigDecimal amount = new BigDecimal(amountTextField.getText());
		    		BigDecimal tip = amount.multiply(tipPercentage);
		    		
		    //Setting total equal to the (amount + tip)
		    		BigDecimal total = amount.add(tip);
		    		
		    //Formatting and printing to output text fields
		    		tipTextField.setText(currency.format(tip));
		    		totalTextField.setText(currency.format(total));

	               }

	            }
			);
	
			//Changing the Tip with the slider and then recalculating the total
	tipPercentageSlider.valueProperty().addListener(
			new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
			//try catch that catches when there is not a valid input in the amount
					try {
						tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
						tipPercentageLabel.setText(percent.format(tipPercentage));
					
						BigDecimal amount = new BigDecimal(amountTextField.getText());
						BigDecimal tip = amount.multiply(tipPercentage);
			    		
			//Setting total equal to the (amount + tip)
						BigDecimal total = amount.add(tip);
			    		
			//Formatting and printing to output text fields
						tipTextField.setText(currency.format(tip));
						totalTextField.setText(currency.format(total));
					}
					catch(NumberFormatException ex) {
			//Exception
						amountTextField.setText("Enter amount");
			    		amountTextField.selectAll();
			//Requesting focus to the amount field
			    		amountTextField.requestFocus();
					}
				}
			}
		);
    }

}
