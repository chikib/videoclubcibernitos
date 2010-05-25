package varios;

public class VideoException extends Exception {

	public VideoException(String mensaje){
		super(mensaje);
		
	}
	
	public String toString(){
		return "El error que ha dado es: "+getMessage();
	}
}
