package de.mirroros.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

import de.mirroros.client.model.IsModel;
import de.mirroros.client.view.IsView;

public abstract class AbstractPresenter<V extends IsView, M extends IsModel> implements IsPresenter<IsView, IsModel> {

	private V view;
	private M model;
	private HasWidgets display;

	public AbstractPresenter(V view, M model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void onStart(HasWidgets display) {
		this.display = display;
		display.clear();
		display.add(view.asWidget());
	}

	@Override
	public void onStop() {
		getDisplay().clear();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public M getModel() {
		return model;
	}

	public HasWidgets getDisplay() {
		return display;
	}

	public V getView() {
		return view;
	}
}
