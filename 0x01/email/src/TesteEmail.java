import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteEmail {

	@Test
	void testar_email_com_arroba() {
		Pessoa pessoa = new Pessoa();
		boolean email = pessoa.emailValid("jhon_doe@mail.com");
		Assertions.assertTrue(email);
	}

	@Test
	void testar_email_sem_arroba() {
		Pessoa pessoa = new Pessoa();
		boolean email = pessoa.emailValid("jhon_doe#mail.com");
		Assertions.assertTrue(!email);
	}

	@Test
	void testar_email_mais_50_caracteres() {
		Pessoa pessoa = new Pessoa();
		boolean email = pessoa.emailValid("jhon_doe_jhon_doe_jhon_doe_jhon_doe_jhon_doe_@mail.com");
		Assertions.assertEquals(false, email);
	}

}
