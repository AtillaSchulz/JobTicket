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
package de.rc.jobticket.beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import de.rc.DBZugriff;
import de.rc.jobticket.entities.Kunden;

/**
 * 
 */

/**
 * juni 2012
 * <p>
 * Verwaltungsklasse f�r die Kunden zwischen Layout und Datenbank
 * </p>
 * 
 * @author janine & atilla
 * 
 */
@ManagedBean
public class KundenBean implements Serializable {
	private String kunde_kunde;
	private String kunde_adresse;
	private String kunde_telefon;
	private String kunde_kuerzel;
	private boolean showTable;
	private DBZugriff dbAccess;
	private List<Kunden> kunden;
	private boolean dlgShouldBeHidden;
	private boolean emptyField_kunde;
	private boolean emptyField_kundenkuerzel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * erstellt Datenbankzugriff
	 */
	public KundenBean() {
		dbAccess = new DBZugriff();
	}

	/**
	 * Trigger f�r das Anzeigen der Kundentabelle wird im Hauptlayout nicht
	 * verwendet
	 */
	public void zeigeTabelle() {
		showTable = true;
	}

	/**
	 * �berpr�ft die Eingabefelder der Kundeneintr�ge und gibt dazugeh�rige
	 * Fehlermeldungen aus Wenn Eintr�ge vorhanden sind, speichert er diese in
	 * der Datenbank
	 */
	public void erstelleKunden() {
		if (kunde_kunde.trim().compareTo("") == 0) {
			System.err.println("Kunde ist leer.");
			emptyField_kunde = true;
		} else {
			emptyField_kunde = false;
		}
		if (kunde_kuerzel.trim().compareTo("") == 0) {
			System.err.println("K�rzel ist leer.");
			emptyField_kundenkuerzel = true;
		} else {
			emptyField_kundenkuerzel = false;
		}
		if ((kunde_kunde.trim().compareTo("") == 0)
				|| (kunde_kuerzel.trim().compareTo("") == 0)) {
			return;
		}

		Kunden kunde = new Kunden();

		kunde.setKunde(kunde_kunde);
		kunde.setKundenkuerzel(kunde_kuerzel);
		kunde.setTelefon(kunde_telefon);
		kunde.setAdresse(kunde_adresse);
		dbAccess.addElement(kunde, dbAccess.createEntitymanager());
		zeigeTabelle();
		setDlgShouldBeHidden();
	}

	/**
	 * @return the kunde_kunde
	 */
	public String getKunde_kunde() {
		return kunde_kunde;
	}

	/**
	 * @param kunde_kunde
	 *            the kunde_kunde to set
	 */
	public void setKunde_kunde(String kunde_kunde) {
		this.kunde_kunde = kunde_kunde;
	}

	/**
	 * @return the kunde_adresse
	 */
	public String getKunde_adresse() {
		return kunde_adresse;
	}

	/**
	 * @param kunde_adresse
	 *            the kunde_adresse to set
	 */
	public void setKunde_adresse(String kunde_adresse) {
		this.kunde_adresse = kunde_adresse;
	}

	/**
	 * @return the kunde_telefon
	 */
	public String getKunde_telefon() {
		return kunde_telefon;
	}

	/**
	 * @param kunde_telefon
	 *            the kunde_telefon to set
	 */
	public void setKunde_telefon(String kunde_telefon) {
		this.kunde_telefon = kunde_telefon;
	}

	/**
	 * @return the kunde_kuerzel
	 */
	public String getKunde_kuerzel() {
		return kunde_kuerzel;
	}

	/**
	 * @param kunde_kuerzel
	 *            the kunde_kuerzel to set
	 */
	public void setKunde_kuerzel(String kunde_kuerzel) {
		this.kunde_kuerzel = kunde_kuerzel;
	}

	/**
	 * @return the showTable
	 */
	public boolean isShowTable() {
		return showTable;
	}

	/**
	 * @param showTable
	 *            the showTable to set
	 */
	public void setShowTable(boolean showTable) {
		this.showTable = showTable;
	}

	/**
	 * Gibt eine Liste aller Kunden zur�ck wird im Hauptlayout nicht benutzt
	 * 
	 * @return the kunden Liste der Kunden aus der Datenbank
	 */
	public List<Kunden> getKunden() {
		kunden = dbAccess.getDatalist(Kunden.class,
				dbAccess.createEntitymanager());
		return kunden;
	}

	/**
	 * @param kunden
	 *            the kunden to set
	 */
	public void setKunden(List<Kunden> kunden) {
		this.kunden = kunden;
	}

	/**
	 * @return the dlgShouldBeHidden
	 */
	public boolean isDlgShouldBeHidden() {
		return dlgShouldBeHidden;
	}

	/**
	 * @param dlgShouldBeHidden
	 *            the dlgShouldBeHidden to set
	 */
	public void setDlgShouldBeHidden() {
		this.dlgShouldBeHidden = !this.dlgShouldBeHidden;
	}

	/**
	 * @return the emptyField_kunde
	 */
	public boolean isEmptyField_kunde() {
		return emptyField_kunde;
	}

	/**
	 * @param emptyField_kunde
	 *            the emptyField_kunde to set
	 */
	public void setEmptyField_kunde(boolean emptyField_kunde) {
		this.emptyField_kunde = emptyField_kunde;
	}

	/**
	 * @return the emptyField_kundenkuerzel
	 */
	public boolean isEmptyField_kundenkuerzel() {
		return emptyField_kundenkuerzel;
	}

	/**
	 * @param emptyField_kundenkuerzel
	 *            the emptyField_kundenkuerzel to set
	 */
	public void setEmptyField_kundenkuerzel(boolean emptyField_kundenkuerzel) {
		this.emptyField_kundenkuerzel = emptyField_kundenkuerzel;
	}

}
