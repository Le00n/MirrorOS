package de.mirroros.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import de.mirroros.client.model.IsModel;
import de.mirroros.client.presenter.IsPresenter;
import de.mirroros.client.view.IsView;

public class ApplicationControllTree {

	private IsPresenter<IsView, IsModel> presenter;
	private boolean isActive;
	private List<ApplicationControllTree> children;
	private ApplicationControllTree parent;

	public ApplicationControllTree(IsPresenter<IsView, IsModel> presenter, boolean isActive) {
		this.presenter = presenter;
		this.setIsActive(isActive);
		this.setParent(parent);
		this.children = new ArrayList<ApplicationControllTree>();
	}

	public ApplicationControllTree getApplicationTree(IsPresenter<IsView, IsModel> presenter) {
		if (this.presenter.equals(presenter)) {
			return this;
		}

		for (ApplicationControllTree child : children) {
			return child.getApplicationTree(presenter);
		}

		return null;
	}

	public void addChild(IsPresenter<IsView, IsModel> presenter, boolean isActive) {
		ApplicationControllTree child = new ApplicationControllTree(presenter, isActive);
		child.parent = this;
		children.add(child);
	}

	public void removeChild(IsPresenter<IsView, IsModel> presenter) {
		children.remove(getApplicationTree(presenter));
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;

		for (ApplicationControllTree child : children) {
			child.setIsActive(isActive);
		}
	}

	public ApplicationControllTree getParent() {
		return parent;
	}

	public void setParent(ApplicationControllTree parent) {
		this.parent = parent;
	}

	public Stack<IsPresenter<IsView, IsModel>> getActiveStack() {
		Stack<IsPresenter<IsView, IsModel>> activeStack = new Stack<IsPresenter<IsView, IsModel>>();
		return getActiveStackHelper(activeStack);
	}

	private Stack<IsPresenter<IsView, IsModel>> getActiveStackHelper(Stack<IsPresenter<IsView, IsModel>> activeStack) {
		activeStack.add(presenter);
		for (ApplicationControllTree child : children) {
			if (child.isActive) {
				return child.getActiveStackHelper(activeStack);
			}
		}
		return activeStack;
	}
}
