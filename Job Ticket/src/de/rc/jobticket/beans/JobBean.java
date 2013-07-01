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
import org.primefaces.event.SelectEvent;
import de.rc.DBZugriff;
import de.rc.jobticket.entities.Job;
import de.rc.jobticket.entities.Jobbearbeiter;
import de.rc.jobticket.entities.Kosten;
import de.rc.jobticket.entities.Kunden;
import de.rc.jobticket.entities.Produkteigenschaften;


/**
 * juni 2012
 * <p>Verwaltungsklasse f�r den Job zwischen Layout und Datenbank</p>
 * @author janine & atilla
 * 
 */
@ManagedBean
public class JobBean implements Serializable {

	private static final long serialVersionUID = -5747251292554950020L;
	private int alte_jobnummer;
	private String job; // alter begriff: Jobbeschreibung
	private String kundenname;
	private String kundenkuerzel;
	private List<Kosten> kostens;
	private List<Produkteigenschaften> produkteigenschaftens;
	private List<Jobbearbeiter> jobbearbeiters;
	private DBZugriff dbAccess;
	private boolean emptyField_job;
	private boolean emptyField_kunde;
	private boolean erledigt;
	private Kunden kunden;
	private List<Job> jobliste;
	private int jobnummer;

	/**
	 * Erstellt den Datenbankzugriff und erzeugt Standartwerte
	 */
	public JobBean() {
		dbAccess = new DBZugriff();
		job = "";
		kundenname = "";
	}

	/**
	 * @return the alte_jobnummer
	 */
	public int getAlte_jobnummer() {
		return alte_jobnummer;
	}

	/**
	 * Autokomplete des Kundennamens
	 * @param str die im Layout eingegebenen Buchstaben
	 * @return eine Liste der �bereinstimmenden Eintr�ge aus der Datenbank
	 */
	public List<String> completeKundennamen(String str) {
		return dbAccess.completeKundennamen(str);
	}

	/**
	 * Autokomplete des Kundenk�rzels
	 * @param str die im Layout eingegebenen Buchstaben
	 * @return eine Liste der �bereinstimmenden Eintr�ge aus der Datenbank
	 */
	public List<String> completeKundenkuerzel(String str) {
		return dbAccess.completeKundenkuerzel(str);
	}

	/**
	 * @param alte_jobnummer
	 *            the alte_jobnummer to set
	 */
	public void setAlte_jobnummer(int alte_jobnummer) {
		this.alte_jobnummer = alte_jobnummer;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		this.job = job;
		System.out.println(job);
	}

	/**
	 * @return the kundenname
	 */
	public String getKundenname() {
		return kundenname;
	}

	/**
	 * @param kundenname
	 *            the kundenname to set
	 */
	public void setKundenname(String kundenname) {
		this.kundenname = kundenname;
	}

	/**
	 * @return the kundenkuerzel
	 */
	public String getKundenkuerzel() {
		return kundenkuerzel;
	}

	/**
	 * @param kundenkuerzel
	 *            the kundenkuerzel to set
	 */
	public void setKundenkuerzel(String kundenkuerzel) {
		this.kundenkuerzel = kundenkuerzel;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the kostens
	 */
	public List<Kosten> getKostens() {
		return kostens;
	}

	/**
	 * @param kostens
	 *            the kostens to set
	 */
	public void setKostens(List<Kosten> kostens) {
		this.kostens = kostens;
	}

	/**
	 * @return the produkteigenschaftens
	 */
	public List<Produkteigenschaften> getProdukteigenschaftens() {
		return produkteigenschaftens;
	}

	/**
	 * @param produkteigenschaftens
	 *            the produkteigenschaftens to set
	 */
	public void setProdukteigenschaftens(
			List<Produkteigenschaften> produkteigenschaftens) {
		this.produkteigenschaftens = produkteigenschaftens;
	}

	/**
	 * @return the jobbearbeiters
	 */
	public List<Jobbearbeiter> getJobbearbeiters() {
		return jobbearbeiters;
	}

	/**
	 * @param jobbearbeiters
	 *            the jobbearbeiters to set
	 */
	public void setJobbearbeiters(List<Jobbearbeiter> jobbearbeiters) {
		this.jobbearbeiters = jobbearbeiters;
	}

	/**
	 * @return the emptyField_job
	 */
	public boolean isEmptyField_job() {
		return emptyField_job;
	}

	/**
	 * @param emptyField_job
	 *            the emptyField_job to set
	 */
	public void setEmptyField_job(boolean emptyField_job) {
		this.emptyField_job = emptyField_job;
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
	 * @return the erledigt
	 */
	public boolean isErledigt() {
		return erledigt;
	}

	/**
	 * @param erledigt
	 *            the erledigt to set
	 */
	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}

	/**
	 * @return the jobnummer
	 */
	public int getJobnummer() {
		return jobnummer;
	}

	/**
	 * @param jobnummer the jobnummer to set
	 */
	public void setJobnummer(int jobnummer) {
		this.jobnummer = jobnummer;
	}

	/**
	 * @return the kunden
	 */
	public Kunden getKunden() {
		kunden = dbAccess.findKundenWithName(this.kundenname);
		return kunden;
	}

	
	/**Erstellt mit den eingebenen Weten, falls m�glich ein Jobticket
	 * wenn Pflichtfelder leer sind wird eine Fehlermeldung ausgegeben
	 * @return job_db jobpendant aus der Datenbank
	 */
	public Job erstelleJob(){
		Job job_db = null;
		if (this.job.trim().compareTo("") == 0) {
			System.err.println("Jobfeld ist leer.");
			emptyField_job = true;
			// throw (new Exception("JobFeld ist leer"));
		} else {
			emptyField_job = false;

		}
		Kunden kunde = getKunden();
		if (kunde == null) {
			emptyField_kunde = true;
			// throw (new Exception("Kunde konnte nicht bestimmt werden"));
		} else {
			emptyField_kunde = false;
		}

		if (emptyField_kunde || emptyField_job) {
			System.err.println("Kunde- oder JobFeld wurden fehlerhaft ausgef�llt");
			return null;
		}

		Job jobTicket = new Job();
		jobTicket.setAlteJobnummer(alte_jobnummer);
		System.out.println("erledigt");
		if (erledigt) {
			jobTicket.setErledigt(1);
		} else {
			jobTicket.setErledigt(0);
		}
		if (this.jobbearbeiters != null) {
			jobTicket.setJobbearbeiters(jobbearbeiters);
		}
		if (this.job.trim().compareTo("") != 0) {
			jobTicket.setJobbeschreibung(this.job);
		}
		if (this.kostens != null) {
			jobTicket.setKostens(kostens);
		}
		System.err.println("kunde");
		jobTicket.setKunden(getKunden());
		System.out.println("produkt");
		if (this.produkteigenschaftens != null) {
			jobTicket.setProdukteigenschaftens(produkteigenschaftens);
		}

		try {
			dbAccess.addJob(jobTicket, dbAccess.createEntitymanager());

			List<Job> list = dbAccess.getDatalist(Job.class,
					dbAccess.createEntitymanager());
			jobTicket = list.get(list.size() - 1);
			jobTicket.generateName();// wird ben�tigt damit der richtige name
										// generiert wird
			job_db = dbAccess.updateJob(jobTicket,
					dbAccess.createEntitymanager());
		} catch (Exception e) {
			e.printStackTrace();
			return job_db;
		}
		return job_db;
	}

	/**Erstellt eine Liste der Jobs aus der Datenbank
	 * wird im Hauptlayout nicht verwendet
	 * @return the jobliste Liste alle Jobs aus der Datenbank
	 */
	public List<Job> getJobliste() {

		jobliste = dbAccess.getDatalist(Job.class,
				dbAccess.createEntitymanager());
		//System.out.println(jobliste.get(0).getJobbeschreibung());
		return jobliste;
	}

	/**
	 * @param jobliste
	 *            the jobliste to set
	 */
	public void setJobliste(List<Job> jobliste) {
		this.jobliste = jobliste;
	}

	/**Auf Buttondruck wird zum  Kundennamen ein dazugeh�riges Kundenk�rzel gesucht
	 * @param event das zum Kundenname dazugeh�rige Kundenk�rzel
	 */
	public void findKundenKuerzel(SelectEvent event) {
		Kunden kunde = dbAccess.findKundenWithName(this.getKundenname());
		this.kundenkuerzel = kunde.getKundenkuerzel();
	}

	/**Auf Buttondruck wird zum kundenk�rzel ein dazugeh�riger Kundenname gesucht
	 * @param event der zum Kundenk�rzel dazugeh�rige Kundenname
	 */
	public void findKundenname(SelectEvent event) {
		Kunden kunde = dbAccess.findKundenWithKuerzel(this.getKundenkuerzel());
		this.kundenname = kunde.getKunde();
	}

}
