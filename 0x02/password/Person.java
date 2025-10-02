public class Person {

	private String usuario;
	private String senha;

	public Person() {
	}

	public boolean checkUser() {
		boolean contemEspeciais = false;
		boolean atLeast8 = usuario.length() >= 8;

		for (char c : usuario.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				contemEspeciais = true;
				break;
			}
		}

		if (atLeast8 && !contemEspeciais) {
			return true;
		}
		return false;
	}

	public boolean checkPassword() {
		boolean hasNumber = false;
		boolean hasUpperCase = false;
		boolean hasCharSpecial = false;
		boolean atLeast8 = senha.length() >= 8;

		for (char c : senha.toCharArray()) {
			if (Character.isUpperCase(c)) {
				hasUpperCase = true;
			}

			if (Character.isDigit(c)) {
				hasNumber = true;
			}

			if (!Character.isLetterOrDigit(c)) {
				hasCharSpecial = true;
			}
		}

		if (hasNumber && hasUpperCase && hasCharSpecial && atLeast8) {
			return true;
		}
		return false;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
