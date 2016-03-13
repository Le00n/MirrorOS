package de.mirroros.client;

public class SpeechAction implements IsAction<String> {

	private boolean trickleDown;
	private String command;

	public SpeechAction(boolean trickleDown) {
		setTrickleDown(trickleDown);
	}

	@Override
	public boolean isTrickleDown() {
		return trickleDown;
	}

	@Override
	public void setTrickleDown(boolean trickleDown) {
		this.trickleDown = trickleDown;
	}

	@Override
	public String getParam() {
		return command;
	}

	@Override
	public void setParam(String param) {
		this.command = param;
	}

	@Override
	public Class<String> getType() {
		return String.class;
	}
}
