package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class Sample {
	@GetMapping(value = "/Hi")
	public String getHello() {
		return "Hello World";
	}

	@GetMapping(value = "/Hello")
	public String getHi() {

		return "Helloo";
	}

	@GetMapping(value = "/add/{num1}/{num2}")
	public int addition(@PathVariable int num1, @PathVariable int num2) {
		return num1 + num2;
	}

	@GetMapping(value = "/palin/{str}")
	public String palindrome(@PathVariable String str) {
		String y = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			y = y + str.charAt(i);
		}
		if (y.equalsIgnoreCase(str)) {
			return "Palindrom";
		} else {
			return "Not a palindrom";
		}
	}

	@GetMapping(value = "/prime/{num1}")
	public String prime(@PathVariable int num1) {
		boolean b = true;
		for (int i = 2; i <= num1; i++) {
			if (num1 % 2 == 0) {
				b = false;
				break;
			}
		}
		if (b) {
			return "Prime";
		} else {
			return "NotPrime";
		}

	}

	@GetMapping(value = "/even/{num}")
	public ArrayList<Integer> even(@PathVariable int num) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 1; i < num; i++) {
			if (i % 2 == 0) {
				a.add(i);
			} else {
				continue;
			}
		}
		return a;
	}

	@GetMapping(value = "/sqrt/{n}")
	public String perfectSqrt(@PathVariable int n) {
		String b = "";
		for (int i = 0; i < n / 2; i++) {
			if (i * i == n) {
				b = "PERFECT";
			}
		}
		if (b.equals("PERFECT")) {
			return "PERFECT";
		} else {
			return "NOT PERFECT";
		}
	}

	@GetMapping(value = "/validcheck")
	public String getAccess(@RequestParam String userName, @RequestParam String password) {
		if (userName.equals("xxx") && password.equals("yyy")) {
			return "Access";
		} else {
			return "Denied";
		}
	}

	@GetMapping(value = "/fib")
	public ArrayList<Integer> getFib(@RequestParam int start, @RequestParam int end) {
		ArrayList<Integer> num = new ArrayList<>();
		int s = 0;
		int b = 1;
		int c = 0;
		for (int i = 2; i < end; i++) {
			c = s + b;
			num.add(s);
			s = b;
			b = c;
		}
		return num;
	}

	@GetMapping(value = "/getCar")
	public Car getCar(@RequestBody Car c) {
		return c;
	}

	@GetMapping(value = "/getCars")
	public ArrayList<Car> getCars(@RequestBody ArrayList<Car> cars) {
		return cars;
	}

	@GetMapping(value = "/getBrand")
	public List<String> getBrand(@RequestBody List<Car> cars) {
		return cars.stream().map(x -> x.getBrand()).toList();
	}

	@GetMapping(value = "/getPrice")
	public List<Integer> getPrice(@RequestBody List<Car> cars) {
		return cars.stream().map(x -> x.getPrice()).toList();
	}

	@GetMapping(value = "/getModel")
	public List<Integer> getModel(@RequestBody List<Car> cars) {
		return cars.stream().map(x -> x.getModel()).toList();
	}

	@GetMapping(value = "/getColor")
	public List<String> getColor(@RequestBody List<Car> cars) {
		return cars.stream().map(x -> x.getColor()).toList();
	}
	@GetMapping(value="/getBrandColor")
	public List<Car> getColorCars(@RequestBody List<Car> cars){
		return cars.stream().filter(x -> x.getColor().equalsIgnoreCase("black")).toList();
	}
	@GetMapping(value="/getMaxPrice")
	public Car getMax(@RequestBody List<Car> cars) {
		return cars.stream().max(Comparator.comparing(Car :: getPrice)).get();
	}
	@GetMapping(value="/getMinPrice")
	public Car getMin(@RequestBody List<Car> cars) {
		return cars.stream().min(Comparator.comparing(Car :: getPrice)).get();
	}
	@GetMapping(value="/getLatest")
	public Car getLates(@RequestBody List<Car> cars) {
		return cars.stream().max(Comparator.comparing(Car :: getModel)).get();
	}
	
	@GetMapping(value="/getLatestPrice")
	public List<Car> getLatestPrice(@RequestBody List<Car> cars) {
	 return cars.stream().filter(x -> x.getModel() >= 2018).map((y) -> {y.setPrice(y.getPrice()+y.getPrice()*5/100); return y;}).toList();
	// s.forEach(x -> x.setPrice(x.getPrice()+x.getPrice()* 5 / 100));
	//	return s;
		
	}
	
	@GetMapping(value="/getEmployeeName")
	public List<String> getNameEmp(@RequestBody List<Employee> emp){
		return emp.stream().map(x -> x.getName()).toList();
	}
	

	/*
	 * @GetMapping(value = "/getBrand") public ArrayList<Car>
	 * getBrand(ArrayList<Car> cars,String brand) { return cars.stream().filter(x ->
	 * x.getBrand().equals(brand)).toList();
	 * 
	 * }
	 */

}
