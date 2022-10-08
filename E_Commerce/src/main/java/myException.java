
public class myException extends Exception {
	String ex;
	public myException(String ex) {
		this.ex = ex;
	}

	public void myException() {
		System.out.println("UserDefined Error "+ ex);
	}
}
