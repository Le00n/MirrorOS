package de.mirroros.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class AbstractView extends Composite implements IsView {

	private FlowPanel main;

	public AbstractView() {
		main = new FlowPanel();
		init();
		initStyles();
	}

	protected abstract void init();

	protected abstract void initStyles();

	@Override
	public Widget asWidget() {
		return main;
	}

	public FlowPanel getRootPanel() {
		return main;
	}
}
