package de.mirroros.client;

import java.util.List;

public interface HasActions {

	public List<IsAction<?>> getActions();

	public void launchAction(IsAction<?> action);
}
