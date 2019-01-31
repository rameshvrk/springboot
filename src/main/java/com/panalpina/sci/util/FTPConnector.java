package com.panalpina.sci.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.panalpina.sci.constants.CommonConstants;

@Component
public class FTPConnector {

	final static Logger logger = LogManager.getLogger(FTPConnector.class);

	@Value("${sci.ftp.host}")
	private String host;

	@Value("${sci.ftp.user}")
	private String user;

	@Value("${sci.ftp.password}")
	private String pwd;

	@Value("${sci.ftp.remoteDir}")
	private String remoteDirectory;
	
	@Value("${sci.ftp.archiveDir}")
	private String archiveDirectory;

	@Value("${sci.ftp.localDir}")
	private String localDirectory;

	private FTPSClient ftpClient = null;

	/**
	 * @throws IOException
	 * @throws SocketException
	 * 
	 */
	@SuppressWarnings("unused")
	private void connect() throws IOException {

		ftpClient = new FTPSClient();
		ftpClient.connect(host, 21);
		ftpClient.enterRemotePassiveMode();
		ftpClient.login(user, pwd);
		ftpClient.enterLocalPassiveMode();
		int reply = ftpClient.getReplyCode();

		if (FTPReply.isPositiveCompletion(reply)) {
			ftpClient.changeWorkingDirectory(remoteDirectory);
			ftpClient.execPBSZ(0);
			ftpClient.execPROT("P");
			ftpClient.type(FTP.BINARY_FILE_TYPE);
			logger.debug("Connected Success");
		} else {
			logger.warn("Connection to ftp server failed: " + host);
			ftpClient.disconnect();
			logger.warn("Disconnected to ftp server: " + host);
		}

	}

	@SuppressWarnings("unused")
	private FTPFile[] getFTPFiles(String prefix) {

		FTPFileFilter filter = new FTPFileFilter() {

			@Override
			public boolean accept(FTPFile ftpFile) {
				String fileName = ftpFile.getName();
				return (ftpFile.isFile() && fileName.startsWith(prefix) && fileName.endsWith(".xml"));
			}
		};

		FTPFile ftpFile = null;
		FTPFile[] ftpFiles = null;
		if (this.ftpClient != null && this.ftpClient.isConnected()) {
			try {
				ftpFiles = ftpClient.listFiles(CommonConstants.BLANK, filter);
			} catch (IOException e) {
				logger.error("Exception occured: ", e);
			}
		}
		logger.debug("FTP file is : " + ftpFile);
		return ftpFiles;
	}

	@SuppressWarnings("unused")
	private String downLoadFile(FTPFile ftpFile) throws IOException {
		String file = CommonConstants.BLANK;

		if (ftpFile != null && !ftpFile.isDirectory()) {
			String fileName = ftpFile.getName();
			file = localDirectory + File.separator + fileName;
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
			boolean success = ftpClient.retrieveFile(fileName, outputStream);
			outputStream.close();

			if (!success) {
				logger.warn("Failed to download the file : " + file);
				file = CommonConstants.BLANK;
			} else {
				ftpClient.changeWorkingDirectory(File.separator);
				boolean directoryExists = ftpClient.changeWorkingDirectory(archiveDirectory);
				if( !directoryExists ) {
					ftpCreateDirectoryTree(archiveDirectory);
				}
				ftpClient.changeWorkingDirectory(File.separator);
				
				String replaceFileName = ftpFile.getName();
				try {
					replaceFileName = replaceFileName.split("\\.")[0];
					replaceFileName += "-"+System.currentTimeMillis()+".csv";
				} catch (Exception e) {
					replaceFileName = System.currentTimeMillis() + ".csv";
				}
				
				boolean fileMoved = ftpClient.rename(remoteDirectory + File.separator + ftpFile.getName(),
						archiveDirectory + File.separator + replaceFileName);
				if( !fileMoved ){
					logger.warn("Unable to archive the file : " + ftpFile.getName());
				}
				ftpClient.changeWorkingDirectory(remoteDirectory);
			}
		}
		return file;
	}
	
	private void ftpCreateDirectoryTree(String dirTree) throws IOException {

		  boolean dirExists = true;

		  String[] directories = dirTree.split("/");
		  for (String dir : directories ) {
		    if (!dir.isEmpty() ) {
		      if (dirExists) {
		        dirExists = ftpClient.changeWorkingDirectory(dir);
		      }
		      if (!dirExists) {
		        if (!ftpClient.makeDirectory(dir)) {
		          throw new IOException("Unable to create remote directory '" + dir + "'.  error='" + ftpClient.getReplyString()+"'");
		        }
		        if (!ftpClient.changeWorkingDirectory(dir)) {
		          throw new IOException("Unable to change into newly created remote directory '" + dir + "'.  error='" + ftpClient.getReplyString()+"'");
		        }
		      }
		    }
		  }     
		}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void disconnect() {
		if (this.ftpClient != null && this.ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException e) {
				logger.error("Exception occured: ", e);
			}
		}
	}

}
