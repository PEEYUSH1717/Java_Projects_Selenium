package classes1;

public class google_drive {
	    String fileName;
	    int fileSize;
	    String fileType;	 
	    void uploadFile(String name, int size, String type) {
	        fileName = name;
	        fileSize = size;
	        fileType = type;
	        System.out.println("File uploaded successfully.");
	    }	  
	    void downloadFile() {
	        System.out.println("Downloading File...");
	        System.out.println("Name: " + fileName);
	        System.out.println("Size: " + fileSize + " KB");
	        System.out.println("Type: " + fileType);
	    }
	    public static void main(String[] args) {
	    	google_drive f = new google_drive(); 
	        f.uploadFile("project_doc.pdf", 900, "PDF");  
	        f.downloadFile(); 
	    }}
