import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


class Shell {

	public static void main(String[] args) {


		Scanner myObj = new Scanner(System.in); //create scanner object
		System.out.print("Enter a file name>>>>> ");
		while(myObj.hasNext()) {
			String userInput = myObj.nextLine(); // read user input
			if(userInput.equals("exit")){
				myObj.close();
			}
			String[] inputParts = userInput.split(" ");

			//create list of input words
			ArrayList<String> inputList = new ArrayList<String>();


			//Output user input seperated
			for (int i = 0; i < inputParts.length; i++) {

				inputList.add(inputParts[i]); //add elements to list

			}

			// Create an object of the File class
			// Replace the file path with path of the directory

			File directory = new File(inputList.get(0));
			if(inputList.size() > 1) {
				findFile(directory, inputList.get(1));
			}
			System.out.println("inputList: " + inputList);
		}
	}



	public static void findFile(File directory, String file){
		// store all names with same name
		// with/without extension
		String[] flist = directory.list();
		System.out.println(flist);
		int flag = 0;
		if (flist == null) {
			System.out.println("Empty directory.");
		} else {

			// Linear search in the array
			for (int i = 0; i < flist.length; i++) {
				String filename = flist[i];
				if (filename.equalsIgnoreCase(file)) {
					System.out.println(filename + " found");
					flag = 1;
				}
			}
		}

		if (flag == 0) {
			System.out.println("File Not Found");
		}

	}

	public static void write(){

	}
}
