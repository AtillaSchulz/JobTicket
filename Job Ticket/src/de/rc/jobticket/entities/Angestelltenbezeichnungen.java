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
 * The persistent class for the angestelltenbezeichnungen database table.
 * 
 */

@Entity
@Table(name = "angestelltenbezeichnungen")
public class Angestelltenbezeichnungen implements Serializable,
		Comparable<Angestelltenbezeichnungen>, Identifizierbar {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Column(length = 50)
	private String bezeichnung;

	// bi-directional many-to-one association to Angestellte
	@OneToMany(mappedBy = "angestelltenbezeichnungen")
	private List<Angestellte> angestelltes;

	public Angestelltenbezeichnungen() {
	}

	public Angestelltenbezeichnungen(String bezeichnung) {
		this.setBezeichnung(bezeichnung);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public List<Angestellte> getAngestelltes() {
		return this.angestelltes;
	}

	public void setAngestelltes(List<Angestellte> angestelltes) {
		this.angestelltes = angestelltes;
	}

	/**
	 * Vergleicht die bezeichungen der Angestellten miteinander. 0 = identische
	 * Bezeichnung gefunden 0 != nicht identisch
	 */
	public int compareTo(Angestelltenbezeichnungen arg0) {
		return this.bezeichnung.trim().toLowerCase().compareTo(arg0.bezeichnung.trim().toLowerCase());
	}

}