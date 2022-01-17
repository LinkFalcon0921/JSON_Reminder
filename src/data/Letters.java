package data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Letters implements Clonate, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** TITULO/SUJETO DEL DOCUMENTO */
	private final String SUBJECT;

	/** DESCRIPCION DEL DOCUMENTO */
	private String descp;
	private Date dayC;

	public Letters(final String subj) {
		SUBJECT = subj;
	}

	public Letters(final String subj, String descrition) {
		this(subj);
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

	// OBTIENE LA FECHA DE CREACION
	public String createdDate() {
		return new SimpleDateFormat("dd/mm/yyyy").format(dayC);
	}

	public Date getDate() {
		return dayC;
	}

	public void setDate(Long dat) {
		if (dat != null) {
			if(dayC != null) {
				dayC = new Date(dat);
				return;
			}
			dayC.setTime(dat);
		}

	}

	public void setDate() {
		dayC = Calendar.getInstance().getTime();
	}

	@Override
	public String toString() {
		return String.format("Este recordatorio hace referecia a %s", getSUBJECT());
	}

	public Clonate clone() {
		Letters let = new Letters(SUBJECT, descp);
		let.setDate();

		return let;

	}

}
