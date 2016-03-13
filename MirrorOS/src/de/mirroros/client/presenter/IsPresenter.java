package de.mirroros.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

import de.mirroros.client.HasActions;
import de.mirroros.client.model.IsModel;
import de.mirroros.client.view.IsView;

public interface IsPresenter<V extends IsView, M extends IsModel> extends HasActions {

	public void onStart(HasWidgets display);

	public void onStop();

	public void init();

	public M getModel();

	public V getView();

	public void onActivate();

	public void onDeactivate();
}
