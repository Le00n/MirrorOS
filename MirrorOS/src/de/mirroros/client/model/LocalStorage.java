package de.mirroros.client.model;

import com.google.gwt.storage.client.Storage;

/**
 * @author xgadscj
 *
 */
public class LocalStorage {

	private Storage localStorage;

	public LocalStorage() {
		if (Storage.isLocalStorageSupported()) {
			localStorage = Storage.getLocalStorageIfSupported();
		} else {
		}
	}

	/**
	 * Setzt das Attribut im LocalStorage
	 *
	 */
	public void setAttribute(String attribute, String value) {
		if (Storage.isLocalStorageSupported()) {
			localStorage.removeItem(attribute);
			localStorage.setItem(attribute, value);
		} else {
		}
	}

	/**
	 * Holt das Attribut aus dem LocalStorage
	 *
	 * @return String
	 */
	public String getAttribute(String attribute) {
		if (Storage.isLocalStorageSupported()) {
			String item = localStorage.getItem(attribute);
			if (item == null) {
				return "";
			}
			return item;
		} else {
			return null;
		}
	}
}
