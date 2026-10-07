package org.javacream.training.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BmiController {

	@GetMapping("/calculate")
	public String bmi(String name, Double height, Double weight) {
		var template = "Mit einem Gewicht von %.2f kg und einer Größe von %.2f cm  hat %s einen BMI von %.2f und ist damit %s.";
		var heightInMeter = height / 100;
		var bmi = weight / (heightInMeter * heightInMeter);
		var bmiClassification = "";
		if (bmi < 18) {
			bmiClassification = "untergewichtig";
		}
		else if (bmi < 25) {
			bmiClassification = "normalgewichtig";
		}
		else if (bmi < 28) {
			bmiClassification = "übergewichtig";
		}
		else {
			bmiClassification = "fettleibig";
		}
		var bmiOutput = template.formatted(weight, height, name, bmi, bmiClassification);
		return bmiOutput;
	}
}
