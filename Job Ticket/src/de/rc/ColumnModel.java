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

/**juni 2012
 * <p>Model zum dynamischen Erstellen der Colums</p>
 * @author janine und atilla
 *
 */
public class ColumnModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -213958105055357340L;
	private String header;
	private String property;

	/**
	 * @param header to set
	 * @param property to set
	 */
	public ColumnModel(String header, String property) {
		this.header = header;
		this.property = property;
	}

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

}
