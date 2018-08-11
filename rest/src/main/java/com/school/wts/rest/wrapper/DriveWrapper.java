/**
 * 
 */
package com.school.wts.rest.wrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

/**
 * @author Youba
 *
 */
public class DriveWrapper {

	private Logger LOGGER = LoggerFactory.getLogger(DriveWrapper.class);
	
	private final String APPLICATION_NAME = "wts-rest";
	private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private final String TOKENS_DIRECTORY_PATH = "tokens";

	/**
	 * Global instance of the scopes required by this quickstart. If modifying these
	 * scopes, delete your previously saved credentials/ folder.
	 */
	private final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_METADATA_READONLY);
	private final String CREDENTIALS_FILE_PATH = "credentials.json";

	
	
	
	
	/**
	 * Creates an authorized Credential object.
	 * 
	 * @param HTTP_TRANSPORT The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOException If the credentials.json file cannot be found.
	 */
	private Credential getCredentials(final NetHttpTransport httpTransport) throws IOException {
		// Load client secrets.
		InputStream in = DriveWrapper.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY,
				clientSecrets, SCOPES)
						.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
	}

	public Drive getDriveService() throws GeneralSecurityException, IOException {
		// Build a new authorized API client service.
		final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		return new Drive.Builder(httpTransport, JSON_FACTORY, getCredentials(httpTransport))
				.setApplicationName(APPLICATION_NAME).build();
	}
	
	public String saveFile(java.io.File file) {
		File fileMetadata = new File();
		fileMetadata.setName(file.getName());
		fileMetadata.setMimeType("application/vnd.google-apps.spreadsheet");

		FileContent mediaContent = new FileContent("audio/mpeg", file);
		File fileSaved;
		try {
			fileSaved = getDriveService().files().create(fileMetadata, mediaContent)
			    .setFields("id")
			    .execute();
			LOGGER.info("File ID: " + fileSaved.getId());
			return fileSaved.getId();
		} catch (IOException | GeneralSecurityException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return "";		
	}
	
	public OutputStream getFile(String fileID){
		
		OutputStream outputStream = new ByteArrayOutputStream();
		try {
			getDriveService().files().get(fileID)
			    .executeMediaAndDownloadTo(outputStream);
			return outputStream;			
		} catch (IOException | GeneralSecurityException e) {
			LOGGER.error(e.getMessage(),e);
		}		
		return null;
	}
	
}
