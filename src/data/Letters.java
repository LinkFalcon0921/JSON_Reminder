package data;

import java.io.Serializable;

public class Letters implements Clonate, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** TITULO/SUJETO DEL DOCUMENTO */
	private final String SUBJECT;

	/** DESCRIPCION DEL DOCUMENTO */
	private String descp;
	private DateInfo days;

	public Letters(final String subj) {
		SUBJECT = subj;
	}

	public Letters(final String subj, String descrition) {
		this(subj);
		descp = descrition;
	}

	public Letters(final String subj, String descrition, long date) {
		this(subj);
		descp = descrition;
		setDateCreated(date);
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

	// OBTIENE LA FECHA DE CREACION
	public String createdDate() {
		return days.dateCreated();
	}

	/**
	 * Recupera una copia de las fechas que maneja el recoradatorio (Creacion y
	 * fecha de aviso).
	 */
	public DateInfo getDate() {
		return (DateInfo) days.clone();
	}

	/** Establece la fecha de creacion */
	public boolean setDateCreated(long date) {
		setObjectDate();

		return days.setDatecreated(date);
	}

	/** Establece la fecha de creacion */
	public boolean setDateCreated() {
		setObjectDate();

		return days.setDatecreated();
	}

	private void setObjectDate() {
		if (days == null)
			days = new DateInfo();
	}

	/** Establece la fecha de aviso */
	public boolean setDateReminder(String date) {
		setObjectDate();

		return days.setDateReminder(date);
	}

	public boolean setDateReminder(long date) {
		setObjectDate();

		return days.setDateReminder(date);
	}

	public void setDate() {
		days = new DateInfo();
	}
	
	public String dateCreated() {
		return days.dateCreated();
	}
	
	public String dateReminder() {
		return days.dateReminder();
	}

	@Override
	public String toString() {
		return String.format("Titulo: %s\nDescripcion: %s\n %s", getSUBJECT(), getDescp(), days.toString());
	}

	/**
	 * Recupera un clon del Objeto <br>
	 * This case is a object Letters.
	 */
	public Clonate clone() {
		Letters let = new Letters(SUBJECT, descp);
		let.setDate();
		let.setDateReminder(serialVersionUID);

		return let;

	}

}
