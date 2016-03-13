package de.mirroros.client;

public interface IsAction<P extends Object> {

	public boolean isTrickleDown();

	public void setTrickleDown(boolean trickleDown);

	public P getParam();

	public void setParam(P param);

	public Class<P> getType();
}
