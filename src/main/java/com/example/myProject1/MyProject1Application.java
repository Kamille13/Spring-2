package com.example.myProject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class MyProject1Application {
	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Impossible de récupérer l'incarnation <numéro de l'incarnation>")

	public class DoctorNotFoundException extends RuntimeException{
		public DoctorNotFoundException(String exception){
			super(exception);
		}
	}
	@ResponseStatus(code = HttpStatus.SEE_OTHER,reason = "Not Doctor")
	public class DoctorFoundException extends RuntimeException{
		public DoctorFoundException(String exception){
			super(exception);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(MyProject1Application.class, args);
	}


	@RequestMapping("/doctor/{number}")
	@ResponseBody
	public Doctor myDoctor(@PathVariable ("number") int number, @RequestParam(required = false) boolean details) {

		List<ExtendedDoctor> docteur = new ArrayList<>();
		ExtendedDoctor doc9 = new ExtendedDoctor("Christopher Eccleston", 9, 13, 41);
		ExtendedDoctor doc10 = new ExtendedDoctor("David Tennant", 10, 47, 34);
		ExtendedDoctor doc11 = new ExtendedDoctor("Math Smith", 11, 44, 27);
		ExtendedDoctor doc12 = new ExtendedDoctor("Peter Capaldi", 12, 40, 55);
		ExtendedDoctor doc13 = new ExtendedDoctor("Jodie Whittaker", 13, 11, 35);
		docteur.add(doc9);
		docteur.add(doc10);
		docteur.add(doc11);
		docteur.add(doc12);
		docteur.add(doc13);

		List<Doctor> docteurs = new ArrayList<>();
		Doctor doc1 = new Doctor("William Hartnell", 1);
		Doctor doc2 = new Doctor("Patrick Throughton", 2);
		Doctor doc3 = new Doctor("Jon Pertwee", 3);
		Doctor doc4 = new Doctor("Tom Baker", 4);
		Doctor doc5 = new Doctor("Peter Davidson", 5);
		Doctor doc6 = new Doctor("Colin Baker", 6);
		Doctor doc7 = new Doctor("Sylvester McCoy", 7);
		Doctor doc8 = new Doctor("Paul McGann", 8);
		Doctor doc_9 = new Doctor("Christopher Eccleston", 9);
		Doctor doc_10 = new Doctor("David Tennant", 10);
		Doctor doc_11 = new Doctor("Math Smith", 11);
		Doctor doc_12 = new Doctor("Peter Capaldi", 12);
		Doctor doc_13 = new Doctor("Jodie Whittaker", 13);

		docteurs.add(doc1);
		docteurs.add(doc2);
		docteurs.add(doc3);
		docteurs.add(doc4);
		docteurs.add(doc5);
		docteurs.add(doc6);
		docteurs.add(doc7);
		docteurs.add(doc8);
		docteurs.add(doc_9);
		docteurs.add(doc_10);
		docteurs.add(doc_11);
		docteurs.add(doc_12);
		docteurs.add(doc_13);

		if (number == 0 || number > 13) {
			throw new DoctorNotFoundException("Impossible de récupérer l'incarnation" + number);
		}
		if (number < 9 && details == false) {
			throw new DoctorFoundException("Not Doctor");
		}
		if (number >= 9 && number <= 13 && details == true) {
			return docteur.get(number - 9);
		}
		if (number >= 9 && number <= 13) {
			return docteurs.get(number - 1);
		}
		else{
			return null;
		}


	}
	class Doctor {

		private String name;
		private int number;

		public Doctor(String name, int number) {
			this.name = name;
			this.number = number;
		}

		public String getName() {
			return name;
		}

		public int getNumber() {
			return number;
		}
	}
	class ExtendedDoctor extends Doctor {

		private int ageOfStart;
		private int numberOfEpisodes;

		public ExtendedDoctor(String name, int number, int numberOfEpisodes, int ageOfStart) {
			super(name, number);
			this.numberOfEpisodes = numberOfEpisodes;
			this.ageOfStart = ageOfStart;
		}

		public int getNumberOfEpisodes() {
			return numberOfEpisodes;
		}
		public int getAgeOfStart() {
			return ageOfStart;
		}
	}
}
