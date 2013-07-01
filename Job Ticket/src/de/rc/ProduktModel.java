/*
* This file is part of Job Ticket, a software system for managing
* the orders done by the worker.
*
* Copyright (C) 2013 Atilla Schulz & Janine Naumann
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
package de.rc;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import de.rc.DBZugriff;
import de.rc.jobticket.entities.Job;
import de.rc.jobticket.entities.Produkteigenschaften;

/**
 * juni 2012
 * <p>
 * Modelklasse für das Produkt
 * </p>
 * 
 * @author janine und atilla
 * 
 */

public class ProduktModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 441727386364167821L;
	private String format;
	private String farbe;
	private String sonderfarbe;
	private String falzung;
	private int beschnitt;
	private String bindung;
	private int dummy;
	private int proof;
	private String produktbeschreibung;
	private int seitenzahl;
	// private List<SelectItem> falzungsarten;
	private DBZugriff dbAccess;
	private String eingang;
	private boolean emptyField_eingang;
	private String vorlage;
	private String ausgang;
	private boolean showPrint;
	private String printButtonText;

	/**
	 * Erstellt ein Zugriffs-objekt für die Datenbank, außerdem stellt er alle
	 * Werte auf standart.
	 */
	public ProduktModel() {
		dbAccess = new DBZugriff();
		eingang = getCurrentDate();

		vorlage = "";
		ausgang = "";

		showPrint = false;
		printButtonText = "▼";
		// createFalzungsArten();
	}

	/**
	 * Erstellt eine Reihe von Falzungsarten für das Dropdownmenu auf dem
	 * Layout. Falls nötig bitte hier ergänzen. Vielen dank.
	 */
	// private void createFalzungsArten() {
	// falzungsarten = new ArrayList<SelectItem>();
	// SelectItem s = new SelectItem();
	// s.setLabel("Zickzackfalz/Leporellofalz");
	// s.setValue("Zickzackfalz");
	// falzungsarten.add(s);
	// s = new SelectItem();
	// s.setLabel("Altarfalz/Fensterfalz");
	// s.setValue("Altarfalz");
	// falzungsarten.add(s);
	// s = new SelectItem();
	// s.setLabel("Parallelmittelfalz");
	// s.setValue("Parallelmittelfalz");
	// falzungsarten.add(s);
	// s = new SelectItem();
	// s.setLabel("Wickelfalz");
	// s.setValue("Wickelfalz");
	// falzungsarten.add(s);
	// s = new SelectItem();
	// s.setLabel("Asymmetrischer Kreuzbruchfalz");
	// s.setValue("Asymmetrischer Kreuzbruchfalz");
	// falzungsarten.add(s);
	// s = new SelectItem();
	// s.setLabel("Symmetrischer Kreuzbruchfalz");
	// s.setValue("Symmetrischer Kreuzbruchfalz");
	// falzungsarten.add(s);
	// s = new SelectItem();
	// s.setLabel("Sonderfalz");
	// s.setValue("Sonderfalz");
	// falzungsarten.add(s);
	// }

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the farbe
	 */
	public String getFarbe() {
		return farbe;
	}

	/**
	 * @param farbe
	 *            the farbe to set
	 */
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	/**
	 * @return the sonderfarbe
	 */
	public String getSonderfarbe() {
		return sonderfarbe;
	}

	/**
	 * @param sonderfarbe
	 *            the sonderfarbe to set
	 */
	public void setSonderfarbe(String sonderfarbe) {
		this.sonderfarbe = sonderfarbe;
	}

	/**
	 * @return the falzung
	 */
	public String getFalzung() {
		return falzung;
	}

	/**
	 * @param falzung
	 *            the falzung to set
	 */
	public void setFalzung(String falzung) {
		this.falzung = falzung;
	}

	/**
	 * @return the beschnitt
	 */
	public int getBeschnitt() {
		return beschnitt;
	}

	/**
	 * @param beschnitt
	 *            the beschnitt to set
	 */
	public void setBeschnitt(int beschnitt) {
		this.beschnitt = beschnitt;
	}

	/**
	 * @return the bindung
	 */
	public String getBindung() {
		return bindung;
	}

	/**
	 * @param bindung
	 *            the bindung to set
	 */
	public void setBindung(String bindung) {
		this.bindung = bindung;
	}

	/**
	 * @return the dummy
	 */
	public int getDummy() {
		return dummy;
	}

	/**
	 * @param dummy
	 *            the dummy to set
	 */
	public void setDummy(int dummy) {
		this.dummy = dummy;
	}

	/**
	 * @return the proof
	 */
	public int getProof() {
		return proof;
	}

	/**
	 * @param proof
	 *            the proof to set
	 */
	public void setProof(int proof) {
		this.proof = proof;
	}

	/**
	 * @return the produktbeschreibung
	 */
	public String getProduktbeschreibung() {
		return produktbeschreibung;
	}

	/**
	 * @param produktbeschreibung
	 *            the produktbeschreibung to set
	 */
	public void setProduktbeschreibung(String produktbeschreibung) {
		this.produktbeschreibung = produktbeschreibung;
	}

	/**
	 * @return the seitenzahl
	 */
	public int getSeitenzahl() {
		return seitenzahl;
	}

	/**
	 * @param seitenzahl
	 *            the seitenzahl to set
	 */
	public void setSeitenzahl(int seitenzahl) {
		this.seitenzahl = seitenzahl;
	}

	// /**
	// * @return the falzungsarten
	// */
	// public List<SelectItem> getFalzungsarten() {
	// return falzungsarten;
	// }
	//
	// /**
	// * @param falzungsarten
	// * the falzungsarten to set
	// */
	// public void setFalzungsarten(List<SelectItem> falzungsarten) {
	// this.falzungsarten = falzungsarten;
	// }

	/**
	 * @return the dbAccess
	 */
	public DBZugriff getDbAccess() {
		return dbAccess;
	}

	/**
	 * @param dbAccess
	 *            the dbAccess to set
	 */
	public void setDbAccess(DBZugriff dbAccess) {
		this.dbAccess = dbAccess;
	}

	/**
	 * @return the eingang
	 */
	public String getEingang() {
		return eingang;
	}

	/**
	 * @param eingang
	 *            the eingang to set
	 */
	public void setEingang(String eingang) {
		this.eingang = eingang;
	}

	/**
	 * @return the emptyField_eingang
	 */
	public boolean isEmptyField_eingang() {
		return emptyField_eingang;
	}

	/**
	 * @param emptyField_eingang
	 *            the emptyField_eingang to set
	 */
	public void setEmptyField_eingang(boolean emptyField_eingang) {
		this.emptyField_eingang = emptyField_eingang;
	}

	/**
	 * @return the vorlage
	 */
	public String getVorlage() {
		return vorlage;
	}

	/**
	 * @param vorlage
	 *            the vorlage to set
	 */
	public void setVorlage(String vorlage) {
		this.vorlage = vorlage;
	}

	/**
	 * @return the ausgang
	 */
	public String getAusgang() {
		return ausgang;
	}

	/**
	 * @param ausgang
	 *            the ausgang to set
	 */
	public void setAusgang(String ausgang) {
		this.ausgang = ausgang;
	}

	/**
	 * @return the printButtonText
	 */
	public String getPrintButtonText() {
		return printButtonText;
	}

	/**
	 * @param printButtonText
	 *            the printButtonText to set
	 */
	public void setPrintButtonText(String printButtonText) {
		this.printButtonText = printButtonText;
	}

	/**
	 * @return the showPrint
	 */
	public boolean isShowPrint() {
		return showPrint;
	}

	/**
	 * @param showPrint
	 *            the showPrint to set
	 */
	public void setShowPrint(boolean showPrint) {
		this.showPrint = showPrint;
	}

	/**
	 * Verändert das Icon des Printbuttons und merkt sich die letzte Einstellung
	 **/
	public void togglePrint() {
		if (printButtonText.trim().compareTo("▼") == 0) {
			this.printButtonText = "▲";
		} else {
			this.printButtonText = "▼";
		}
		this.showPrint = !this.showPrint;
		 System.out.println("printzeigen: "+this.showPrint+" ...");
	}

	/**
	 * Überprüft das eingegebene Datum auf seine Gültigkeit
	 * 
	 * @param datum
	 * @return das umkonvertierte Datum für die Datenbank
	 * @throws Exception
	 *             wenn das Datum nicht der Norm entspricht
	 */

	private String validateDate(String datum) throws Exception {
		if (datum.trim().length() < 10) {
			throw new Exception(
					"Das eingebene Datum entspricht nicht den Eingabekriterien. Zu kurz.");
		}
		if (datum.trim().contains(".")) {
			String[] split = datum.trim().split("\\.");
			if (split.length < 3) {
				throw new Exception(
						"Das eingebene Datum entspricht nicht den Eingabekriterien. Kann nicht aufgeteilt werden.");
			}
			String tage, monate, jahre;
			tage = split[0];
			monate = split[1];
			jahre = split[2];
			if (Integer.parseInt(tage) > 31) {
				throw new Exception(
						"Das eingebene Datum entspricht nicht den Eingabekriterien. Tage sind falsch");
			}
			if (Integer.parseInt(monate) > 12) {
				throw new Exception(
						"Das eingebene Datum entspricht nicht den Eingabekriterien. Monate sind falsch");
			}
			datum = jahre + "-" + monate + "-" + tage;
		}
		return datum;
	}

	/**
	 * Überprüft die Produkteingabefelder und erstellt, fals möglich das
	 * entsprechende Produkt
	 */
	public void erstelleProdukt() {
		Produkteigenschaften produkt = new Produkteigenschaften();
		if (ausgang.trim().compareTo("") != 0) {
			try {
				produkt.setAusgang(Date.valueOf(validateDate(ausgang)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (vorlage.trim().compareTo("") != 0) {
			try {
				produkt.setVorlage(Date.valueOf(validateDate(vorlage)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (eingang.trim().compareTo("") != 0) {
			try {
				produkt.setEingang(Date.valueOf(validateDate(eingang)));
			} catch (Exception e) {
				emptyField_eingang = true;
				e.printStackTrace();
				return;
			}
		} else {
			emptyField_eingang = true;
			return;
		}
		produkt.setBeschnitt(beschnitt);
		produkt.setBindung(bindung);
		produkt.setDummy(dummy);
		produkt.setFalzung(falzung);
		produkt.setFarbe(farbe);
		produkt.setFormat(format);
		// produkt.setJob(job)
		if (isShowPrint()) {
			produkt.setPrint("ja");
		} else {
			produkt.setPrint("nein");
		}
		produkt.setProduktbeschreibung(produktbeschreibung);
		produkt.setProof(proof);
		produkt.setSeitenzahl(seitenzahl);
		produkt.setSonderfarbe(sonderfarbe);
		produkt.setJob(dbAccess.getDatalist(Job.class,
				dbAccess.createEntitymanager()).get(0));
		dbAccess.addEintrag(produkt, dbAccess.createEntitymanager());
	}

	/**
	 * Überprüft die Produkteingabefelder und erstellt, fals möglich das
	 * entsprechende Produkt. Ausserdem wird das Produkt direkt mit dem
	 * dazugehörigen Job verbunden
	 * 
	 * @param job_db
	 *            Jobpendant aus der Datenbank
	 */
	public void erstelleProdukt(Job job_db) {
		Produkteigenschaften produkt = new Produkteigenschaften();
		if (ausgang.trim().compareTo("") != 0) {
			try {
				produkt.setAusgang(Date.valueOf(validateDate(ausgang)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (vorlage.trim().compareTo("") != 0) {
			try {
				produkt.setVorlage(Date.valueOf(validateDate(vorlage)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (eingang.trim().compareTo("") != 0) {
			try {
				produkt.setEingang(Date.valueOf(validateDate(eingang)));
			} catch (Exception e) {
				emptyField_eingang = true;
				e.printStackTrace();
				return;
			}
		} else {
			emptyField_eingang = true;
			return;
		}
		produkt.setBeschnitt(beschnitt);
		produkt.setBindung(bindung);
		produkt.setDummy(dummy);
		produkt.setFalzung(falzung);
		produkt.setFarbe(farbe);
		produkt.setFormat(format);
		// produkt.setJob(job)
		if (isShowPrint()) {
			produkt.setPrint("ja");
		} else {
			produkt.setPrint("nein");
		}
		produkt.setProduktbeschreibung(produktbeschreibung);
		produkt.setProof(proof);
		produkt.setSeitenzahl(seitenzahl);
		produkt.setSonderfarbe(sonderfarbe);
		produkt.setJob(job_db);
		dbAccess.addEintrag(produkt, dbAccess.createEntitymanager());
	}

	/**
	 * Holt sich das aktuelle Datum
	 * 
	 * @return Das aktuelle Datum in Form der Inputmask auf dem Layout
	 */
	private String getCurrentDate() {
		String datum = "";
		SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
		datum = date.format(new java.util.Date());
		System.out.println(datum);
		return datum;
	}

}
