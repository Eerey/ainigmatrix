package main;

import com.sun.javafx.application.LauncherImpl;

import view.VFrame;
import view.VApplication;

public class Main {

	public static void main(String[] args) {
		LauncherImpl.launchApplication(VApplication.class, args);;
	}

}
