package Application.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Worker.Department;
import Entities.Worker.HourContract;
import Entities.Worker.Worker;
import Entities.Worker.Enum.WorkerLevel;

public class program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department´s name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double basesalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), basesalary, new Department(departmentName)); 
		System.out.print("How many contract to this worker? ");
		int n = sc.nextInt();
		 
		for(int i=1;i<=n;i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("duration(hours): ");
			int hours = sc.nextInt(); 
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		} 
		System.out.println(); 
		System.out.print("Enter month and year to claculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Departmnet: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ":" + String.format("%.2f",worker.income(year, month)));
		
		sc.close(); 
	}

}
