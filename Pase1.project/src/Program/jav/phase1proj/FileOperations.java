package Program.jav.phase1proj;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
public class FileOperations {

	public String dirpath;
	public FileOperations(String dirpath) {
		// TODO Auto-generated constructor stub
		this.dirpath = dirpath;
	}

	public void beginApplication() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			displayNavigation();
			
			int option = sc.nextInt();
			switch(option) {
			case 1: 
				displayFiles();
				break;
			case 2:
				System.out.print("Please Enter The File Name To Create: ");
				addFile(sc.next());
				break;
			case 3:
				System.out.print("Please Enter The File Name To Delete: ");
				delelteFile(sc.next());
				break;
			case 4:
				System.out.print("Please Enter The New Directory Path: ");
				changePath(sc.next());
			case 5: 
				System.out.println("Application Closed.Thankyou");
				System.exit(0);
				break;
			default: System.out.println("Please Enter The Correct Option");
				
			}
		}
		
	}
	public void displayNavigation() {
		FirstScreen screenDisplay = new FirstScreen();
		System.out.println();
		screenDisplay.displayStar(50);
		
		System.out.println("1. Display all files under the path:"+dirpath);
		System.out.println("2. Add file under the path:"+dirpath);
		System.out.println("3. Remove file from the path:"+dirpath);
		System.out.println("4. Change directory");
		System.out.println("5. Quit the application");
		System.out.print("Please select an option from the above: ");
	}
	
	public void addFile(String fileName ) {
		File file = new File(dirpath,fileName);
		try {
			if(file.createNewFile()) {
				System.out.println("File created successfully");
			}
			else {
				System.out.println("Issue in file creation");
			}
		}
		catch(IOException ex) {
			System.out.println("There is an Exception ocured while creating file:"+ex.getMessage());
		}
		
	}
	
	//remove the file from directory if it exists
	public void delelteFile(String fileName) {
		File file = new File(dirpath,fileName);
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("File successfully deleted");
			}
			else {
				System.out.println("Issuewith File Deletion");
			}
		}
		else {
			System.out.println("File does not exist");
		}
	}
	
	// display all files under same directory in ascending order
	public void displayFiles() {
		File file = new File(dirpath);
		String fileList[] = file.list();
		if(fileList == null || fileList.length == 0) {
			System.out.println("The directory "+dirpath+ " is empty ");
		}
		else {
			List<String> list = Arrays.asList(fileList);
			Collections.sort(list,String.CASE_INSENSITIVE_ORDER);;
			System.out.println("Files in Ascending order under directory:"+dirpath);
			System.out.println(List.of(fileList));
		}
	}
	
	public void changePath(String path) {
		this.dirpath = path;
		beginApplication();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String drive = "E:/";
		FileOperations fop = new FileOperations(drive);
		FirstScreen screenDisplay = new FirstScreen("Phase1","Shereena","shereena.km@gmail.com","Phase-1 project");
		
		screenDisplay.displayScreen();
		fop.beginApplication();
	}
	
}

class FirstScreen {
    
	private String phaseName;
    private String developerName;
    private String developerEmail;
    private String projName;
    
    FirstScreen(){
    	
    }

    public FirstScreen(String phaseName, String developerName, String developerEmail, String projName) {
        this.phaseName = phaseName;
        this.developerName = developerName;
        this.developerEmail = developerEmail;
        this.projName = projName;
    }

    public void displayStar(int length) {
        String line = "";
        for(int i=0; i < length; i++) {
            line += "*";
        }
        System.out.println(line);
    }

    public void displaySpace(int length) {
        String space = "";
        for(int i=0; i < length; i++){
            space += " ";
        }
        System.out.print(space);
    }

    public void displayDetails(int spaceTab) {
        displaySpace(spaceTab);
        System.out.println("Project Phase: "+phaseName.toUpperCase());
        displaySpace(spaceTab);
        System.out.println("Developer: "+developerName.toUpperCase());
        displaySpace(spaceTab);
        System.out.println("Email: "+developerEmail);
        displaySpace(spaceTab);
        System.out.println("Project Name: "+projName.toUpperCase());
    }
    
    //to display Details
    public void displayScreen() {
    	displayStar(50);
    	displayStar(50);
        
        displayDetails(5);
        
        displayStar(50);
        displayStar(50);
    }
	
}
