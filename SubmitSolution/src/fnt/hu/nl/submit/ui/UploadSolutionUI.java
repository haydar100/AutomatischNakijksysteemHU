package fnt.hu.nl.submit.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

import fnt.hu.nl.submit.utils.FileUploader;

@SuppressWarnings("serial")
@Theme("submitsolution")
public class UploadSolutionUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = UploadSolutionUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		FileUploader fileUploader = new FileUploader();
		Upload solutionUpload = new Upload("Submit", fileUploader);
		solutionUpload.addSucceededListener(fileUploader);
		layout.addComponent(solutionUpload);
	}

}