package com.aldeamo.process;

import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aldeamo.send.SendSms;

@Component
public class TelnetJasmin {

	
	private TelnetClient telnet = new TelnetClient();
	private InputStream in;
	private PrintStream out;
	private String prompt = "jcli :";
	
	
	
	@Scheduled(fixedRateString = "1259000", initialDelayString = "1000")
	public void makeTelnetJasmin() {
		System.out.println("make a telnet to jasmin");
		TelnetJasmin tel = new TelnetJasmin();
		tel.AutomatedTelnetClient("IP_TELNET");
		System.out.println("Got Connection...");
		tel.sendCommand("group -l ");
		/*System.out.println("run command");
		tel.sendCommand("user -l ");
		System.out.println("run command 2");
		tel.disconnect();*/
		System.out.println("DONE");
		

	}



	public void AutomatedTelnetClient(String server) {
		try {
			// Connect to the specified server
			telnet.connect(server, "PORT_TELNET");

			 in = telnet.getInputStream();
	         out = new PrintStream(telnet.getOutputStream());
			
			
			// Get input and output stream references
			String text = readUntil(prompt + " ");
			System.out.println("message " +text);
			
			// Log the user on
			//readUntil("login: ");
			// write(user);
			//readUntil("Password: ");
			// write(password);

			// Advance to a prompt
			//readUntil(prompt + " ");
		} catch (Exception e) {
			SendSms sendsms = new SendSms();
			sendsms.sendSms();
			e.printStackTrace();
		}
	}

	public void su(String password) {
		try {
			write("su");
			readUntil("Password: ");
			write(password);
			prompt = "#";
			readUntil(prompt + " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readUntil(String pattern) {
		try {
			char lastChar = pattern.charAt(pattern.length() - 1);
			StringBuffer sb = new StringBuffer();
			System.out.println("lastChar "+lastChar);
			boolean found = false;
			char ch = (char) in.read();
			System.out.println("antes de while");
			while (true) {
				System.out.print(ch);
				sb.append(ch);
				if (ch == lastChar) {
					System.out.println("sb "+sb.toString());
					System.out.println("pt "+pattern);
					if (sb.toString().endsWith(pattern)) {
						return sb.toString();
					}
				}
				ch = (char) in.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void write(String value) {
		try {
			out.println(value);
			out.flush();
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String sendCommand(String command) {
		try {
			
			write(command);
			return readUntil(prompt + " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void disconnect() {
		try {
			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//    public static void main(String[] args) {
//        try {
//            AutomatedTelnetClient(
//                    "myserver", "userId", "Password");
//            System.out.println("Got Connection...");
//            telnet.sendCommand("ps -ef ");
//            System.out.println("run command");
//            telnet.sendCommand("ls ");
//            System.out.println("run command 2");
//            telnet.disconnect();
//            System.out.println("DONE");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
}
