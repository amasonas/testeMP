package business;

import models.User;
import util.Mail4User;
import util.UserAnalyzer;

public class UserClassifier {
	private UserAnalyzer analyzer;

	public void classify(User user) {
		analyzer = new UserAnalyzer(user);
		manageMessages();

	}

	public void manageMessages() {
		if (analyzer.isFrontEndDev())
			sendMail("front-end ");
		if (analyzer.isBackEndDev())
			sendMail("Back-end ");
		if (analyzer.isMobileDev())
			sendMail("mobile ");
		if (analyzer.isBeginner())
			sendMail("");
	}

	private void sendMail(String position) {
		new Mail4User(analyzer.getUserToAnalyze().getEmail(), "Obrigado por se candidatar",
				" Obrigado por se candidatar, assim que tivermos uma vaga disponível para programador " + position
						+ "entraremos em contato.").send();

	}

}
