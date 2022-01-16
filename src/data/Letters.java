package data;

public class Letters implements Clonate{
	/** TITULO/SUJETO DEL DOCUMENTO */
	private final String SUBJECT;
	
	/** DESCRIPCION DEL DOCUMENTO */
	private String descp;
	
	public Letters(final String subj) {
		SUBJECT = subj;
	}
	
	public Letters(final String subj, String descrition) {
		SUBJECT = subj;
		descp = descrition;
	}

	/** OBTENER LA DESCRIPCION */
	public String getDescp() {
		return descp;
	}
	
	/** EDITAR LA DESCRIPCION */
	public void setDescp(String descp) {
		this.descp = descp;
	}

	/** OBTENER EL TITULO */
	public String getSUBJECT() {
		return SUBJECT;
	}
	
	@Override
	public String toString() {
		return String.format("Este recordatorio hace referecia a %s", getSUBJECT());
	}
	
	public Clonate clone() {
		return new Letters(SUBJECT,descp);
	}
	
}
