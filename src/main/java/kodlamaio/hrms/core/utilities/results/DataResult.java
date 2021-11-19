package kodlamaio.hrms.core.utilities.results;

public class DataResult<T> extends Result {

	private T data;
	
	public DataResult(T data, boolean success, String message) { //extend ile bunu çektim
		super(success, message);
		this.data = data;
	}

	public DataResult(T data, boolean success) {  // Bunu da mesajsız için source yöntemiyle constructor çektim superclasstan
		super(success);
		this.data = data;
	}
	
	
	public T getData() {  //diğerlerini get etmeye gerek yok ki ana classımızda yaptık
		return this.data;
	}

}
