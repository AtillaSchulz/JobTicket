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
package de.rc.jobticket.entities;

import java.io.Serializable;

import javax.persistence.*;

import de.rc.Identifizierbar;

import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * The persistent class for the kunden database table.
 * 
 */

@Entity
@Table(name = "kunden")
public class Kunden implements Serializable, Comparable<Kunden>,
		Identifizierbar {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Column(length = 50)
	private String adresse;

	@Column(nullable = false, length = 50)
	private String kunde;

	@Column(nullable = false, length = 10)
	private String kundenkuerzel;

	@Column(length = 50)
	private String telefon;

	// bi-directional many-to-one association to Job
	@OneToMany(mappedBy = "kunden")
	private List<Job> jobs;

	public Kunden() {
	}

	public Kunden(String kunde, String kundenkuerzel) {
		this.setKunde(kunde);
		this.setKundenkuerzel(kundenkuerzel);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getKunde() {
		return this.kunde;
	}

	public void setKunde(String kunde) {
		this.kunde = kunde;
	}

	public String getKundenkuerzel() {
		return this.kundenkuerzel;
	}

	public void setKundenkuerzel(String kundenkuerzel) {
		this.kundenkuerzel = kundenkuerzel;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public int compareTo(Kunden o) {
		if ((this.getKunde().trim().toLowerCase()
				.compareTo(o.getKunde().trim().toLowerCase()) != 0)
				|| (this.getKundenkuerzel().trim().toLowerCase()
						.compareTo(o.getKundenkuerzel().trim().toLowerCase()) != 0)) {
			return 1;
		} else {
			return 0;
		}
	}

}