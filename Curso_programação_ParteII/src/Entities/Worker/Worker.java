package Entities.Worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entities.Worker.Enum.WorkerLevel;

public class Worker {
	
	//ATRIBUTOS 
	private String name;
	private WorkerLevel level;
	private Double basesalary;
	//ASSOCIAÇÕES
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	//CONSTRUTOR PADRÃO
	public Worker() { 
	}
	//CONSTRUTOR COM ARGUMENTOS
//**ATENÇAO** QUANDO TIVER UMA COMPOSIÇÃO QUE TENHA MUITOS NO CASO A LISTA NÃO NCLUI NO CONSTRUTOR COM ARGUMENTOS.
//SIMPLESMENTE INICIA A LISTA VAZIA, INSTANCIANDO NA CLASSE DECLARANDO NEW ARRAYLIST
	public Worker(String name, WorkerLevel level, Double basesalary, Department department) {
		this.name = name;
		this.level = level;
		this.basesalary = basesalary;
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBasesalary() {
		return basesalary;
	}
	public void setBasesalary(Double basesalary) {
		this.basesalary = basesalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<HourContract> getContract() {
		return contracts; 

	}
	//METODOS PARA FAZER OU DESFAZER A ASSOCIAÇÃO DO CONTRATO
    public void addContract(HourContract contract){
    	contracts.add(contract);
    }
    public void removeContract(HourContract contract) {
    	contracts.remove(contract);
    }
    //	METODO PARA CALCULAR A RENDA DO TRABALHADOR
    public double income(int year, int month) {
    	double sum = basesalary;
    	Calendar cal = Calendar.getInstance();
    	for(HourContract c : contracts) {
    		cal.setTime(c.getDate());
    		int c_year = cal.get(Calendar.YEAR);
    		int c_month = 1 + cal.get(Calendar.MONTH);
    		if(year == c_year && month == c_month){
    		sum += c.totalValue();
    	  }
    	}
    	return sum;
    }
}
