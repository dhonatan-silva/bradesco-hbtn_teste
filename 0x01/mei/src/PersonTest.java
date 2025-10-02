import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
	Person person = new Person();

	@BeforeEach
	void setup() {
		person.setName("Paul");
		person.setSurname("McCartney");
		person.setBirthDate(Date.from(LocalDate.of(2000, 10, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		person.setAnotherCompanyOwner(true);
		person.setPensioner(true);
		person.setPublicServer(true);
	}

	@Test
	void show_full_name() {
		String fullName = person.fullName();
		Assertions.assertEquals("Paul McCartney", fullName);
	}

	@Test
	void test_calculateYearlySalary() {
		person.setSalary(1200);

		float yearlySalary = person.calculateYearlySalary();
		Assertions.assertEquals(14400, yearlySalary);
	}

	@Test
	void person_is_MEI() {
		Date date = Date.from(LocalDate.of(2005, 10, 10).atStartOfDay(ZoneId.systemDefault()).toInstant());
		person.setBirthDate(date);
		person.setAnotherCompanyOwner(false);
		person.setPensioner(false);
		person.setPublicServer(false);

		boolean mei = person.isMEI();

		Assertions.assertTrue(mei);
	}

	@Test
	void person_is_not_MEI() {
		Date date = Date.from(LocalDate.of(2010, 10, 10).atStartOfDay(ZoneId.systemDefault()).toInstant());
		person.setBirthDate(date);

		boolean mei = person.isMEI();

		Assertions.assertFalse(mei);
	}

}
