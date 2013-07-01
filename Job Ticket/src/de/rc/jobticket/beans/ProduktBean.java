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
import javax.faces.event.ActionEvent;
import de.rc.ProduktModel;

/**
 *  juni 2012
 * <p>Verwaltungsklasse f�r das Produkt zwischen Layout und Datenbank</p>
 * 
 * @author janine und atilla
 *
 */
@ManagedBean
public class ProduktBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5760974394614810997L;
	
	private List<ProduktModel> produktSammlung;
	private boolean showMinusProduktButton;
	
	/**
	 *  Initiiert die ProduktBean  
	 */
	public ProduktBean(){
		
		produktSammlung = new ArrayList<ProduktModel>();
		ProduktModel p = new ProduktModel();
		produktSammlung.add(p);
	}
	
	/**
	 * @return the produktSammlung
	 */
	public List<ProduktModel> getProduktSammlung() {
		return produktSammlung;
	}

	/**
	 * @param produktSammlung the produktSammlung to set
	 */
	public void setProduktSammlung(List<ProduktModel> produktSammlung) {
		this.produktSammlung = produktSammlung;
	}

	/**
	 * @return the minusProduktButton
	 */
	public boolean isShowMinusProduktButton() {
		return showMinusProduktButton;
	}
	/**
	 * Trigger f�r den MinusProduktButton
	 */

	public void renderMinusProduktButton() {
		showMinusProduktButton = !showMinusProduktButton;
	}
	/**
	 * f�gt ein leeres Produkt hinzu
	 */
	
	public void addProdukt() {
		ProduktModel p = new ProduktModel();
		produktSammlung.add(p);
	}
	
	/**
	 * L�scht ein ausgew�hltes Produkt
	 */
	public void deleteProdukt(ActionEvent e) {
		produktSammlung.remove(Integer.parseInt(e.getComponent()
				.getClientId().split(":")[2]));

	}
	
	
}
