package org.javacream.training.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BmiController {
	String template = "Mit einem Gewicht von %.2f kg und einer Größe von %.2f cm  hat %s einen BMI von %.2f und ist damit %s.";
	Double UNDERWEIGHT_LIMIT = 18.0;
	Double NORMALWEIGHT_LIMIT = 25.0;
	Double OVERWEIGHT_LIMIT = 28.0;
	String UNDERWEIGHT = "untergewichtig";
	String NORMALWEIGHT = "normalgewichtig";
	String OVERWEIGHT = "übergewichtig";
	String OBESE = "fettleibig";

	@GetMapping("/bmi")
	public String bmi(String name, Double height, Double weight) {
		var calculatedBmi = calculateBmi(height, weight);
		var bmiClassification = classifyBmi(calculatedBmi);
		var result = createOutputMessage(name, height, weight, calculatedBmi, bmiClassification); 
		return result;
	}
	public Double calculateBmi(Double height, Double weight) {
		var heightInMeter = height / 100;
		var bmi = weight / (heightInMeter * heightInMeter);
		return bmi;
	}
	public String classifyBmi(Double bmi) {
		var bmiClassification = "";
		if (bmi < UNDERWEIGHT_LIMIT) {
			bmiClassification = UNDERWEIGHT;
		}
		else if (bmi < NORMALWEIGHT_LIMIT) {
			bmiClassification = NORMALWEIGHT;
		}
		else if (bmi < OVERWEIGHT_LIMIT) {
			bmiClassification = OVERWEIGHT;
		}
		else {
			bmiClassification = OBESE;
		}
		return bmiClassification;
		
	}
	
	public String createOutputMessage(String name, Double height, Double weight, Double bmi, String bmiClassification) {
		var bmiOutput = template.formatted(weight, height, name, bmi, bmiClassification);
		return bmiOutput;
	
	}
}
