package de.mirroros.client.model;

public abstract class AbstractModel implements IsModel {

	private LocalStorage localStorage;

	public AbstractModel() {
		localStorage = new LocalStorage();
	}

	public LocalStorage getLocalStorage() {
		return localStorage;
	}
}
