package com.example.demo;

import com.example.demo.DAO.CarDAO;
import com.example.demo.entity.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CarDAO carDAO) {
		return runner -> {
			Scanner scanner = new Scanner(System.in);
			int choice;

			do {
				System.out.println("--- Menú ---");
				System.out.println("1. Crear coche");
				System.out.println("2. Buscar coche por ID");
				System.out.println("3. Listar todos los coches");
				System.out.println("4. Buscar coches por fabricante");
				System.out.println("5. Buscar coches por modelo");
				System.out.println("6. Actualizar coche");
				System.out.println("7. Borrar coche");
				System.out.println("0. Salir");
				System.out.print("Elige una opción: ");
				choice = scanner.nextInt();
				scanner.nextLine(); // Consumir la nueva línea

				switch (choice) {
					case 1:
						createCar(scanner, carDAO);
						break;
					case 2:
						findCarById(scanner, carDAO);
						break;
					case 3:
						findAllCars(carDAO);
						break;
					case 4:
						findByManufacturer(scanner, carDAO);
						break;
					case 5:
						findByModel(scanner, carDAO);
						break;
					case 6:
						updateCar(scanner, carDAO);
						break;
					case 7:
						deleteCar(scanner, carDAO);
						break;
					case 0:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opción no válida.");
				}
			} while (choice != 0);
		};
	}

	private void createCar(Scanner scanner, CarDAO carDAO) {
		System.out.print("Fabricante: ");
		String manufacturer = scanner.nextLine();
		System.out.print("Modelo: ");
		String model = scanner.nextLine();
		Car car = new Car();
	}
}