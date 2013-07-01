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
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import de.rc.jobticket.entities.Angestellte;
import de.rc.jobticket.entities.Kosten;

/**
 * juni 2012
 * <p>
 * Verwaltungsklasse fŸr die Kosten zwischen Layout und Datenbank
 * </p>
 * 
 * @author janine und atilla
 * 
 */
@ManagedBean
public class KostenBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String kostenInStd;
	private String kostenInEuro;
	private Kosten kosten;
	private Angestellte angestellte;
	private boolean abrechnungInEuro;
	private boolean abrechnungInStd;
	private boolean isSwitched;

	/**
	 * Setzt Standartwerte
	 */
	public KostenBean() {
		abrechnungInEuro = true;// Standart
		abrechnungInStd = false;// Standart
		kostenInEuro = "";
		kostenInStd = "";
		isSwitched = false;
	}

	/**
	 * @return the kostenInStd
	 */
	public String getKostenInStd() {
		System.out.println("get kosten in std " + kostenInStd);
		if (!this.kostenInEuro.replace("€", "").trim().isEmpty() && isSwitched) {
			kostenInStd = ""
					+ Math.round(Float.parseFloat(this.kostenInEuro
							.replace("€", "").replace(",", ".").trim()) / 70f * 10f)
					/ 10f;
			isSwitched = false;
		} else if (kostenInStd.replace("h", "").trim().isEmpty()) {
			return kostenInStd;
		}
		return kostenInStd + " h";
	}

	/**
	 * @param kostenInStd
	 *            the kostenInStd to set
	 */
	public void setKostenInStd(String kostenInStd) {
		System.out.println("set kosten in std " + kostenInStd);
		this.kostenInStd = kostenInStd.replace("h", "").trim();
	}

	/**
	 * @return the kostenInEuro
	 */
	public String getKostenInEuro() {
		System.out.println("get kosten in euro " + kostenInEuro);
		if (!this.kostenInStd.replace("h", "").trim().isEmpty() && isSwitched) {
			this.kostenInEuro = ""
					+ Math.round(Float.parseFloat(this.kostenInStd
							.replace("h", "").replace(",", ".").trim()) * 70f * 10f)
					/ 10;
			isSwitched = false;
		} else if (kostenInEuro.replace("€", "").trim().isEmpty()) {
			return kostenInEuro;
		}

		return kostenInEuro + " €";
	}

	/**
	 * @param kostenInEuro
	 *            the kostenInEuro to set
	 */
	public void setKostenInEuro(String kostenInEuro) {
		System.out.println("set kosten in € " + kostenInEuro);
		this.kostenInEuro = kostenInEuro.replace("€", "").trim();// entfernt
																	// eventuelles
																	// €-Zeichen
	}

	/**
	 * @return the kosten
	 */
	public Kosten getKosten() {
		return kosten;
	}

	/**
	 * @param kosten
	 *            the kosten to set
	 */
	public void setKosten(Kosten kosten) {
		this.kosten = kosten;
	}

	/**
	 * @return the angestellte
	 */
	public Angestellte getAngestellte() {
		return angestellte;
	}

	/**
	 * @param angestellte
	 *            the angestellte to set
	 */
	public void setAngestellte(Angestellte angestellte) {
		this.angestellte = angestellte;
	}

	/**
	 * @return the abrechnungInEuro
	 */
	public boolean isAbrechnungInEuro() {
		return abrechnungInEuro;
	}

	/**
	 * @param abrechnungInEuro
	 *            the abrechnungInEuro to set
	 */
	public void setAbrechnungInEuro(boolean abrechnungInEuro) {
		this.abrechnungInEuro = abrechnungInEuro;
	}

	/**
	 * @return the abrechnungInStd
	 */
	public boolean isAbrechnungInStd() {
		return abrechnungInStd;
	}

	/**
	 * @param abrechnungInStd
	 *            the abrechnungInStd to set
	 */
	public void setAbrechnungInStd(boolean abrechnungInStd) {
		this.abrechnungInStd = abrechnungInStd;
	}

	/**
	 * Bei Buttondruck wird der Abrechnungstyp gewechselt (trigger)
	 * 
	 * @param e
	 *            nicht relevant
	 */
	public void switchKosten(ActionEvent e) {
		abrechnungInEuro = !abrechnungInEuro;
		abrechnungInStd = !abrechnungInStd;
		isSwitched = true;
	}

	/**
	 * †berprŸft die eingegeben Kosten in Euro nach "," und wandelt diesen in
	 * "." um damit ein gŸltiger Zahlenwert entsteht
	 * 
	 * @return kosten in euro
	 */
	public BigDecimal validateKostenEuro() {
		BigDecimal kosten_return = null;
		kostenInEuro = kostenInEuro.replace(",", ".");
		try {
			Integer.parseInt(kostenInEuro);
			kosten_return = new BigDecimal(kostenInEuro);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return kosten_return;
		} catch (Exception e) {
			e.printStackTrace();
			return kosten_return;
		}
		return kosten_return;
	}

	/**
	 * †berprŸft die eingegeben Kosten in Stunden nach "," und wandelt diesen in
	 * "." um damit ein gŸltiger Zahlenwert entsteht
	 * 
	 * @return kosten in Stunden
	 */
	public BigDecimal validateKostenStd() {
		BigDecimal kosten_return = null;
		kostenInStd = kostenInStd.replace(",", ".");
		try {
			Integer.parseInt(kostenInStd);
			kosten_return = new BigDecimal(kostenInStd);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return kosten_return;
		} catch (Exception e) {
			e.printStackTrace();
			return kosten_return;
		}
		return kosten_return;
	}

}
