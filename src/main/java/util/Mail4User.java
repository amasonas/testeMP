package util;

import mail.MailSender;

public class Mail4User implements Runnable {

	private String recipient;
	private String subject;
	private String content;

	public Mail4User(String recipient, String subject, String content) {
		this.recipient = recipient;
		this.subject = subject;
		this.content = content;
	}
	
	public void send(){
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		MailSender sender = new MailSender();
		sender.sendMail(subject, recipient, content);
	}
	 
}
