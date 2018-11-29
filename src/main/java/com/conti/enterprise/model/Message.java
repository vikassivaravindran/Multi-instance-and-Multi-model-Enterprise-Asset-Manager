/**
 * 
 */
package com.conti.enterprise.model;

/**
 * @author Vikas Siva Ravindran
 *
 */
public class Message {

	private String status;

	private String messages;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public Message(String status, String messages) {
		super();
		this.status = status;
		this.messages = messages;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Message [" + (status != null ? "status=" + status + ", " : "")
				+ (messages != null ? "messages=" + messages : "") + "]";
	}

	
	
}
