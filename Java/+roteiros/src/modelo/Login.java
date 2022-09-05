package modelo;

public class Login {
	private int idLogin;
	private String tipoLogin;

	public Login(int idLogin, String tipoLogin) {
		this.idLogin = idLogin;
		this.tipoLogin = tipoLogin;
	}

	public Login() {
	}

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

}
