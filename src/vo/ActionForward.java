package vo;

public class ActionForward {
	private String path;
	private boolean isredirect;

	public ActionForward() {};
	
	public ActionForward(String path, boolean redirect) {
		this.path = path;
		this.isredirect = redirect;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isredirect;
	}

	public void setRedirect(boolean redirect) {
		this.isredirect = redirect;
	}

}
