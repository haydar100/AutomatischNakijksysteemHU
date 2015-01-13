package fnt.hu.nl.submit.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

public class FileUploader implements Receiver, SucceededListener {
	public File uploadedFile;
	
	
	@Override
	public void uploadSucceeded(SucceededEvent event) {
		//TODO show stuff or something
	}

	@Override
	public OutputStream receiveUpload(String filename, String mimeType) {
		FileOutputStream fos = null;
		try{
			uploadedFile = new File(GlobalConfig.uploadLocation + filename);
            fos = new FileOutputStream(uploadedFile);
		}
		catch(FileNotFoundException e){
			new Notification("Could not open file<br/>", e.getMessage(),
                    Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
			return null;
		}
		return fos;
	}
}
