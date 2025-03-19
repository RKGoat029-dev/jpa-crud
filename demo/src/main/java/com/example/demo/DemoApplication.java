package com.example.demo;

import com.example.demo.DAO.CarDAO;
import com.example.demo.entity.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
				scanner.nextLine();

				switch (choice) {

					case 1: // 1. Crear coche

						System.out.println("Indica la ID:");
						int scId1 = scanner.nextInt();

						System.out.println("Indica la marca:");
						String scManufacter = scanner.nextLine();

						System.out.println("Indica el modelo:");
						String scModel = scanner.nextLine();

						Car car = new Car(scId1, scManufacter, scModel);
						carDAO.save(car);
						break;

					case 2: // 2. Buscar por Id

						System.out.println("Indica la ID:");
						int scId2 = scanner.nextInt();

						carDAO.findById(scId2);
						break;

					case 3: // 3. Todos los coches

						carDAO.findAll();
						break;

					case 4: // 4. Filtrar por marca

						System.out.println("Indica la marca:");
						String scManufacter4 = scanner.nextLine();

						carDAO.findByManufacturer(scManufacter4);
						break;

					case 5: // 5. Filtrar por modelo

						System.out.println("Indica el modelo:");
						String scModel5 = scanner.nextLine();

						carDAO.findByModel(scModel5);
						break;

					case 6: // 6. Actualizar coche

						System.out.println("Indica la ID del coche a actualizar:");
						int scId6 = scanner.nextInt();

						carDAO.update( carDAO.findById(scId6) );
						break;

					case 7: // 7. Eliminar coche

						System.out.println("Indica la ID del coche a eliminar:");
						int scId7 = scanner.nextInt();

						carDAO.delete(scId7);
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

}