package util;

import models.User;

public class UserAnalyzer {
	private User userToAnalyze;
	
	private boolean isFrontEndDev = false;
	private boolean isBackEndDev  = false;
	private boolean mobileDev     = false;
	
	public UserAnalyzer(User user){
		
		this.userToAnalyze = user;
		doAnalize();
	}
	public void doAnalize(){
		
		if(userToAnalyze.getHtmlSkill() >= 7 && userToAnalyze.getCssSkill() >= 7 && userToAnalyze.getJavaScriptSkill() >= 7){
			this.isFrontEndDev = true;
		}
		
		if(userToAnalyze.getPythonSkill() >= 7 && userToAnalyze.getDjangoSkill() >=7){
			this.isBackEndDev = true;
		}
		
		if(userToAnalyze.getIosSkill() >=7 || userToAnalyze.getAndroidSkill() >= 7){
			this.mobileDev = true;
		}		
		
	}
	
	public User getUserToAnalyze() {
		
		return userToAnalyze;
		
	}
	public boolean isFrontEndDev() {
		
		return isFrontEndDev;
		
	}
	public boolean isBackEndDev() {
		
		return isBackEndDev;
		
	}
	public boolean isMobileDev() {
		
		return mobileDev;
		
	}
	public boolean isBeginner() {
		return !(mobileDev || isBackEndDev || isFrontEndDev);
	}

}
