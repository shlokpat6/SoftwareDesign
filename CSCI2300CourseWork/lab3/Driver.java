import java.util.Scanner;
import java.io.File;
public class Driver{
	public static void main(String[] args) throws Exception{
		if (args.length>0){
			File fileName= new File(args[0]);
			Scanner sc= new Scanner(fileName);
			while (sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
		}else{
			System.out.println("No command line arguments");
		}	
	}	
}
