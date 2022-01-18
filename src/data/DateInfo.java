package data;

import java.util.*;

public class DateInfo implements Clonate {
	private Date created;
	private Date reminder;

	public DateInfo() {
		created = Calendar.getInstance().getTime();
	}

	public DateInfo(String date) {
		created = Calendar.getInstance().getTime();

		setDateReminder(date);
	}

	/** Devuelve la fecha de creacion en texto */
	public String dateCreated() {
		try {
		return ConvertorDate.get().getDateInfo(created);
		}catch(NullPointerException ex) {
			return "Fecha no asignada!";
		}
		}

	/** Devuelve la fecha de aviso en texto */
	public String dateReminder() {
		try {
			return ConvertorDate.get().getDateInfo(reminder);
		}catch(NullPointerException ex) {
			return "Fecha no asignada!";
		}
	}

	/** Retorna si la fecha de aviso es igual a la fecha actual. */
	public boolean IsToday() {
		String dateA = ConvertorDate.get().getDateInfo(System.nanoTime());
		String dateB = dateReminder();

		return dateA.equals(dateB);
	}

	/** Recupera un clon de la fecha de creacion */
	public Date getCreated() {
		try {
			return (Date) created.clone();
		} catch (NullPointerException e) {
			return null;
		}
	}

	/** Reporta si la fecha de creacion fue editada */
	public boolean setDatecreated() {
		Date data = Calendar.getInstance().getTime();

		if (data != null)
			this.created = data;

		return data != null;
	}

	/** Reporta si la fecha de creacion fue editada */
	public boolean setDatecreated(long created) {
		Date data = ConvertorDate.get().getDateTime(created);

		if (data != null)
			this.created = data;

		return data != null;
	}

	/** Recupera un clon de la fecha de aviso */
	public Date getReminder() {
		try {
			return (Date) reminder.clone();
		} catch (NullPointerException e) {
			return null;
		}
	}

	/** Reporta si la fecha de aviso fue editada */
	public boolean setDateReminder(String reminder) {
		if (reminder == null || !reminder.isBlank())
			return false;

		Date data = ConvertorDate.get().getDateTime(reminder);

		if (data != null)
			this.created = data;

		return data != null;
	}

	/** Reporta si la fecha de aviso fue editada */
	public boolean setDateReminder(long reminder) {
		if (reminder < 0)
			return false;

		Date data = ConvertorDate.get().getDateTime(reminder);

		if (data != null)
			this.created = data;

		return data != null;
	}

	/**
	 * Recupera un clon del Objeto <br>
	 * This case is a object DateInfo.
	 */
	@Override
	public Clonate clone() {
		try {
			return (Clonate) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return String.format("Fecha de creacion: %s\nFecha de aviso:%s", dateCreated(), dateReminder());
	}

}
