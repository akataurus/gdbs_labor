import java.util.Arrays;
import java.util.Scanner;

import static cTools.KernelWrapper.*;

class hello {
  
  public static void main(String[] args) {

    String prompt = "enter stuff>>> ";

    //create scanner object
    Scanner scIn = new Scanner(System.in);
    while(true){
      System.out.print(prompt);

      // read user input
      String userInput = scIn.nextLine();

      if(userInput.equals("exit")){
        break;
      }

      //split the input in seperate words
      String[] inputParts = userInput.split(" ");
      String command = inputParts[0];
      String[] params = inputParts;

      //split in two processes
      int pid = fork();
      int[] status = new int[1];

      //child
      if(pid == 0){
        execv("/bin/" + command, params);
        exit(-1);
      }
      //parentprocess
      else if(pid > 0){
        waitpid(pid, status, 0);
      }
      //error
      else{
        System.out.println("smth went wrong");
        exit(-1);
      }
    }
  }
}