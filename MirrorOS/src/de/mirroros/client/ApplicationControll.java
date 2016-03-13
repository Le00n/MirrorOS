package de.mirroros.client;

import de.mirroros.client.model.IsModel;
import de.mirroros.client.presenter.IsPresenter;
import de.mirroros.client.view.IsView;

public class ApplicationControll {

	private ApplicationControllTree applicationTree;

	public ApplicationControll(IsPresenter<IsView, IsModel> presenter) {
		setApplicationTree(new ApplicationControllTree(presenter, true));
	}

	public ApplicationControllTree getApplicationTree() {
		return applicationTree;
	}

	public void setApplicationTree(ApplicationControllTree applicationTree) {
		this.applicationTree = applicationTree;
	}

	public void setActive(IsPresenter<IsView, IsModel> presenter, boolean isActive) {
		ApplicationControllTree tree = this.applicationTree.getApplicationTree(presenter);

		if (isActive && !tree.isActive()) {
			tree.setIsActive(true);
			presenter.onActivate();
		} else if (!isActive && tree.isActive()) {
			tree.setIsActive(false);
			presenter.onDeactivate();
		}
	}

	/**
	 * Fügt einen Presenter der akutellen AKTIVEN Aufrufshierarchie hinzu
	 * 
	 * @param presenter
	 */
	public void pushApplication(IsPresenter<IsView, IsModel> presenter) {
		IsPresenter<IsView, IsModel> actualActivePresenter = this.applicationTree.getActiveStack().firstElement();
		this.applicationTree.getApplicationTree(actualActivePresenter).addChild(presenter, true);
		// presenter.onStart();
	}

	/**
	 * Nimmt den Presenter aus der Aufrufshierarchie raus
	 * 
	 * @param presenter
	 */
	public void popApplication(IsPresenter<IsView, IsModel> presenter) {
		this.applicationTree.removeChild(presenter);
		presenter.onStop();
	}
}
