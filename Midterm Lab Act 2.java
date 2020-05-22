import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	private int id;
	private String name;
	private double rate;
	private String birthday;
	private String birthmonth;
	private String birthyear;
    private String address;
    private String JobPosition;

	
	public Employee(final int id, final String name, final double rate ,final String birthday, String birthmonth, 
		String birthyear, final String address, final String JobPosition ) {
		this.id = id;
		this.name = ucfirst(name);
		this.rate = rate;
		this.birthday = birthday;
		this.birthmonth = birthmonth;
		this.birthyear = birthyear;
		this.address = address;
		this.JobPosition = JobPosition;
 	}

	public void setName(final String name) {
		this.name = ucfirst(name);
	}

	public void setRate(final double rate) {
		this.rate = rate;
	}
	public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public void setBirthmonth(String birthmonth){
        this.birthmonth = birthmonth;
    }
    public void setBirthyear(String birthyear){
        this.birthyear = birthyear;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPosition(String JobPosition){
        this.JobPosition = JobPosition;
	}
	
	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getBirthday() {
        return birthday;
    }
    public String getBirthmonth() {
        return birthmonth;
    }
    public String getBirthyear() {
        return birthyear;
    }

    public String getAddress() {
        return address;
    }

    public String getPosition() {
		return JobPosition;
	}

	public double getRate() {
		return rate;
	}

	public double getSalary(double hours) {
		return hours * rate;
	}

	private String ucfirst(String s) {
		return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1, s.length());
	}
}

class MidTerm2{
	public static void main(final String[] args) {
		final Scanner scan = new Scanner(System.in);
		final ArrayList<Employee> employees = new ArrayList<Employee>();
		int id = 0;
		boolean exit = false;
		Employee e;
		
		do {
			System.out.println("Select Activity: ");
			System.out.println("1. Add Employee");
			System.out.println("2. Display all Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Compute Salary");
			System.out.println("6. Exit Console");

			System.out.print("Option: ");
			int option = scan.nextInt();
			
			switch(option) {
				case 1: 
					int last_id = employees.isEmpty() ? 0 : 1 + employees.get(employees.size() - 1).getID();
					employees.add(addEmployee(last_id)); 
				break;
				case 2: displayEmployees(employees); break;
				case 3: 
					id = inputID();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						updateEmployee(e);
					}
				break;
				case 4: 
					id = inputID();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						employees.remove(e);
					}
				break;
				case 5:
					id = inputID();
					e = searchEmployee(id, employees);
					System.out.print("Enter Number of Hours: ");
					double hours = scan.nextDouble();
					System.out.println("Salary: " +  e.getSalary(hours));
					break;
				case 6: exit = true; break;
			}
		} while(!exit);
		scan.close();
	}

	public static Employee addEmployee(final int last_id) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Employee Birthday: ");
        String birthday = scanner.nextLine();

        System.out.print("Employee Birthmonth: ");
        String birthmonth = scanner.nextLine();
        
        if(birthmonth.equals("01")){
        String month = "January";
        birthmonth = month;
        }else if(birthmonth.equals("02")){
        String month = "February";
        birthmonth = month;
        }
        else if(birthmonth.equals("03")){
        String month = "March";
        birthmonth = month;
        }
        else if(birthmonth.equals("04")){
        String month = "April";
        birthmonth = month;
        }
        else if(birthmonth.equals("05")){
        String month = "May";
        birthmonth = month;
        }
        else if(birthmonth.equals("06")){
        String month = "June";
        birthmonth = month;
        }
        else if(birthmonth.equals("07")){
        String month = "July";
        birthmonth = month;
        }
        else if(birthmonth.equals("08")){
        String month = "August";
        birthmonth = month;
        }
        else if(birthmonth.equals("09")){
        String month = "September";
        birthmonth = month;
        }
        else if(birthmonth.equals("10")){
        String month = "October";
        birthmonth = month;
        }
        else if(birthmonth.equals("11")){
        String month = "November";
        birthmonth = month;
        }
        else if(birthmonth.equals("12")){
        String month = "December";
        birthmonth = month;
        }
        
        System.out.print("Employee Birthyear: ");
        String birthyear = scanner.nextLine();

        System.out.print("Employee Address: ");
        String address = scanner.nextLine();

        System.out.print("Employee Job Position: ");
        String JobPosition = scanner.nextLine();

        System.out.print("Employee Rate: ");
        double rate = scanner.nextDouble();

        

        return new Employee(last_id,name, rate, birthday, birthmonth, birthyear, address, JobPosition);
	}

	public static void updateEmployee(final Employee employee) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a variable to update:\n1.Name \n2.Rate \n3.Birthday \n4.Address \n5.Job Position ");
		System.out.print("Option: ");
		final int option = scanner.nextInt();
		
		System.out.print("Enter new value: ");
		String update = scanner.next();
		switch(option) {
			case 1: employee.setName(update); break;
			case 2: employee.setRate(Double.parseDouble(update)); break;
			case 3:
				String month = scanner.next();				
				String year = scanner.next();
				
				if(month.equals("01")){
       			String m = "January";
        		month = month;
        		}else if(month.equals("02")){
        		String m = "February";
        		month = m;
        		}
        		else if(month.equals("03")){
        		String m = "March";
        		month = m;
        		}
        		else if(month.equals("04")){
        		String m = "April";
        		month = m;
        		}
        		else if(month.equals("05")){
        		String m = "May";
        		month = m;
        		}
        		else if(month.equals("06")){
        		String m = "June";
        		month = m;
        		}
        		else if(month.equals("07")){
        		String m = "July";
        		month = m;
        		}
        		else if(month.equals("08")){
        		String m = "August";
        		month = m;
        		}
        		else if(month.equals("09")){
        		String m = "September";
        		month = m;
        		}
        		else if(month.equals("10")){
        		String m = "October";
        		month = m;
        		}
        		else if(month.equals("11")){
        		String m = "November";
        		month = m;
        		}
        		else if(month.equals("12")){
        		String m = "December";
        		month = m;
        		}
				employee.setBirthday(update);
				employee.setBirthmonth(month);
				employee.setBirthyear(year); 
				break;
			case 6: employee.setAddress(update); break;
			case 7: employee.setPosition(update); break;
		}
	}

	public static Employee searchEmployee(final int id, final ArrayList<Employee> employees) {
		for (final Employee employee : employees) {
			if (employee.getID() == id) {
				return employee;
			}
		}
		return null;
	}

	public static int inputID() {
		final Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee ID: ");
		int n = scan.nextInt();
		return n;
	}

	public static void displayEmployees(final ArrayList<Employee> employees) {
		if (employees.isEmpty()) {
			System.out.println("Cannot find employee record.");
			return;
		}
		System.out.println("List of Employees:");
		for (final Employee employee : employees) {
			System.out.println("ID: " + employee.getID() + ", Name: " + employee.getName() + ", Rate: " + employee.getRate() + ", Birthday: " +
			 employee.getBirthmonth() +" "+ employee.getBirthday() + ", " + employee.getBirthyear() + ", Address "
			+ employee.getAddress() + ", Job Position " + employee.getPosition());
		}
	}
}