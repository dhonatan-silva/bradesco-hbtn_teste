import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {

	Person person;

	@BeforeAll
	void setup() {
		person = new Person();
	}

	@ParameterizedTest(name = "O usuário {0}, é válido")
	@ValueSource(strings = { "PaulMcCartney2", "NeilArms2", })
	void check_user_valid(String usr) {
		person.setUsuario(usr);
		boolean checkUser = person.checkUser();
		assertTrue(checkUser);
	}

	@ParameterizedTest(name = "O usuário {0}, é inválido")
	@ValueSource(strings = { "Paul#McCartney", "Neil@Arms", })
	void check_user_not_valid(String usr) {
		person.setUsuario(usr);
		boolean checkUser = person.checkUser();
		assertFalse(checkUser);
	}

	@ParameterizedTest(name = "A senha {0} é invalida, pois não contêm letras!")
	@ValueSource(strings = { "123456789", "#$%1234", })
	void does_not_have_letters(String pwd) {
		person.setSenha(pwd);
		boolean checkPassword = person.checkPassword();
		assertFalse(checkPassword);
	}

	@ParameterizedTest(name = "A senha {0} é invalida, pois não contêm números!")
	@ValueSource(strings = { "Abcabcdefgh@", "#hbtn@%tc", })
	void does_not_have_numbers(String pwd) {
		person.setSenha(pwd);
		boolean checkPassword = person.checkPassword();
		assertFalse(checkPassword);
	}

	@ParameterizedTest(name = "A senha {0} é invalida, pois não contêm 8 números!")
	@ValueSource(strings = { "Abc@123", "12$@hbt", })
	void does_not_have_eight_chars(String pwd) {
		person.setSenha(pwd);
		boolean checkPassword = person.checkPassword();
		assertFalse(checkPassword);
	}

	@ParameterizedTest(name = "A senha {0} é valida!")
	@ValueSource(strings = { "abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123" })
	void check_password_valid(String pwd) {
		person.setSenha(pwd);
		boolean checkPassword = person.checkPassword();
		assertTrue(checkPassword);
	}

}
