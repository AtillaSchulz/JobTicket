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
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import de.rc.jobticket.entities.KomplexerDatentyp;

/**
 * @author janine und atilla
 * 
 */
@ManagedBean
public class DynamicTestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7634828705060906934L;

	private List<KomplexerDatentyp> liste;
	private List<ColumnModel> columns;
	private String property = "bezeichnung";

	public DynamicTestBean() {
		columns = new ArrayList<ColumnModel>();
		columns.add(new ColumnModel("Bezeichnung", "bezeichnung"));
		columns.add(new ColumnModel("Eingabe", "eingabe"));

		liste = new ArrayList<KomplexerDatentyp>();
		KomplexerDatentyp komp = new KomplexerDatentyp();
		komp.setEingabe("nur hier sonst nirgens");
		komp.setBezeichnung("Kontakter");
		komp.setStandartButton(true);
		liste.add(komp);

		komp = new KomplexerDatentyp();
		komp.setBezeichnung("Grafiker");
		komp.setStandartButton(false);
		liste.add(komp);
	}

	/**
	 * @return the liste
	 */
	public List<KomplexerDatentyp> getListe() {
		return liste;
	}

	/**
	 * @param liste
	 *            the liste to set
	 */
	public void setListe(List<KomplexerDatentyp> liste) {
		this.liste = liste;
	}

	/**
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @param property
	 *            the property to set
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * @return the columns
	 */
	public List<ColumnModel> getColumns() {
		return columns;
	}

	/**
	 * @param columns
	 *            the columns to set
	 */
	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

	static public class ColumnModel implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -6962502002037715573L;
		private String header;
		private String property;

		public ColumnModel(String header, String property) {
			this.header = header;
			this.property = property;
		}

		public String getHeader() {
			return header;
		}

		public String getProperty() {
			return property;
		}
	}

}
