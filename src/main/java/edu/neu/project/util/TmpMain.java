package edu.neu.project.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		retrieveTokenFromPropFile();
		System.out.println("COMPLETED");
	}

	public static String retrieveTokenFromPropFile() {

		System.out.println("retrieveTokenFromPropFile");
		try {

			String tokenFromConfigString = "";
			FileInputStream in = new FileInputStream("src\\config.properties");
			Properties props = new Properties();
			props.load(in);
			tokenFromConfigString = props.getProperty("token");
			in.close();
			return tokenFromConfigString;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
