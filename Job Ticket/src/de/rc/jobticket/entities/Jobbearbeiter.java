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
import de.rc.jobticket.entities.Angestellte;
import static javax.persistence.GenerationType.IDENTITY;



/**
 * The persistent class for the jobbearbeiter database table.
 * 
 */

@Entity
@Table(name="jobbearbeiter")
public class Jobbearbeiter implements Serializable, Identifizierbar {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	//bi-directional many-to-one association to Angestellte
    @ManyToOne
	@JoinColumn(name="angestellte_id", nullable=false)
	private Angestellte angestellte;

	//bi-directional many-to-one association to Job
    @ManyToOne
	@JoinColumn(name="jobs_id", nullable=false)
	private Job job;

    public Jobbearbeiter() {
    }
    
    public Jobbearbeiter(Angestellte angestellte, Job job){
    	this.setAngestellte(angestellte);
    	this.setJob(job);
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Angestellte getAngestellte() {
		return this.angestellte;
	}

	public void setAngestellte(Angestellte angestellte) {
		this.angestellte = angestellte;
	}
	
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
}