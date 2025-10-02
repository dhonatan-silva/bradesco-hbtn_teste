import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {

	private String name;
	private String surname;
	private Date birthDate;
	private boolean anotherCompanyOwner;
	private boolean pensioner;
	private boolean publicServer;
	private float salary;

	public String fullName() {
		return name + " " + surname;
	}

	public float calculateYearlySalary() {
		return salary * 12;
	}

	private int calculateAge() {
		LocalDate nascimentoLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate hoje = LocalDate.now();

		Period periodo = Period.between(nascimentoLocalDate, hoje);

		int idade = periodo.getYears();

		return idade;
	}

	public boolean isMEI() {
		if (calculateYearlySalary() < 130000 && 
				calculateAge() > 18 && 
				anotherCompanyOwner == false && 
				pensioner == false && 
				publicServer == false) {
			return true;
		}
		return false;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isAnotherCompanyOwner() {
		return anotherCompanyOwner;
	}

	public void setAnotherCompanyOwner(boolean anotherCompanyOwner) {
		this.anotherCompanyOwner = anotherCompanyOwner;
	}

	public boolean isPensioner() {
		return pensioner;
	}

	public void setPensioner(boolean pensioner) {
		this.pensioner = pensioner;
	}

	public boolean isPublicServer() {
		return publicServer;
	}

	public void setPublicServer(boolean publicServer) {
		this.publicServer = publicServer;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
