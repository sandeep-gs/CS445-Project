package hostel.app;


import java.io.IOException;

import org.apache.commons.cli.CommandLine;

public class h21
{

  public static void main(String[] args)
  {
    CommandLine executable;
    if (args.length == 0) {
      System.err.println("Please spcify proper arguments. Refer CS445-Project-Commands.pdf for details.");
      return;
    }
    Command command = new Command(args);
    executable = command.get();
    if (executable == null) {
      System.err.println("h21 : Failed to parse command");
      return;
    }
    try {
      @SuppressWarnings("rawtypes")
      Result result = command.execute(executable);
      if (result != null) {
        result.display();
      }
    }
    catch (IOException e) {
	    System.err.println("h21 : Failed to execute command");
	}
  }
}
