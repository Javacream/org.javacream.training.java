package org.javacream.training.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BmiController {
	@Value("${bmi.template}") 
	String TEMPLATE;
	
	@Value("${bmi.underweight_limit}")
	Double UNDERWEIGHT_LIMIT;
	
	@Value("${bmi.normalweight_limit}")
	Double NORMALWEIGHT_LIMIT;
	
	@Value("${bmi.overweight_limit}")
	Double OVERWEIGHT_LIMIT;
	
	@Value("${bmi.underweight}")
	String UNDERWEIGHT;
	
	@Value("${bmi.normalweight}")
	String NORMALWEIGHT;
	
	@Value("${bmi.overweight}")
	String OVERWEIGHT;
	
	@Value("${bmi.obese}")
	String OBESE;

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
		} else if (bmi < NORMALWEIGHT_LIMIT) {
			bmiClassification = NORMALWEIGHT;
		} else if (bmi < OVERWEIGHT_LIMIT) {
			bmiClassification = OVERWEIGHT;
		} else {
			bmiClassification = OBESE;
		}
		return bmiClassification;

	}

	public String createOutputMessage(String name, Double height, Double weight, Double bmi, String bmiClassification) {
		var bmiOutput = TEMPLATE.formatted(weight, height, name, bmi, bmiClassification);
		return bmiOutput;

	}
}
