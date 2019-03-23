package com.stackflow.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			fis.close();
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getSignUpURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getEmail() {
		String email = pro.getProperty("email");
		return email;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getGmailURL() {
		String url = pro.getProperty("gmailUrl");
		return url;
	}

	public String getEmailSubject() {
		String emailsub = pro.getProperty("emailSubject");
		return emailsub;
	}

	public String getLogoPath() {
		String logopath = pro.getProperty("logopath");
		return logopath;
	}
	
	public String getLoginUsrName() {
		String loginusrname = pro.getProperty("loginUserName");
		return loginusrname;
	}
	
	public String getEmailSentText() {
		String esenttext= pro.getProperty("emailSntText");
		return esenttext;
	}
	
	public String getDisplayName() {
		String displayNme= pro.getProperty("name");
		return displayNme;
	}
	
	public String getLoginEmailID() {
		String lgusrname = pro.getProperty("loginEmailId");
		return lgusrname;
	}
	
	public void tempWriteConfiguration(String logineId) {
		
		OutputStream output = null;
		try {

			output = new FileOutputStream("./Configuration/temp.properties");

			// set the properties value
			pro.setProperty("loginEmailId", logineId);

			// save properties to project root folder
			pro.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
