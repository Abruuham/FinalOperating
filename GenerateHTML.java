import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileSystems;
import java.util.*;

public class GenerateHTML{


	private static List<String> exclusionList = Arrays.asList(".git", ".idea", "out", "README.md", "src", "myDir.html", "404.html", "404.css");
	
	public GenerateHTML(){

	}

	public static void createFile(){
		try{
			File myDir = new File(".\\myDir.html");
		 	if (myDir.createNewFile()) {
        		System.out.println("File created");
      	} else{
			
			 
		}
	} catch(IOException e){
			e.printStackTrace();
		}
	}




	public static void generateHTML(){
		try{
			// Add code below to the head part of the file if we want CSS to work with our page
			// <link rel=\"shortcut icon\" href=\"#\"><link rel=\"stylesheet\" href=\"/style.css\">
			FileWriter myWriter = new FileWriter(".\\myDir.html");
			myWriter.write("<!DOCTYPE html><html><head></head><link rel=\"shortcut icon\" href=\"#\"><link rel=\"stylesheet\" href=\"/style.css\"><body><div id=\"container\"><h1>Directory Contents</h1>");
			myWriter.write("<table class=\"sortable\"><thead><tr><th>Name</th><th>Size <small>(bytes)</small></th><th>Date Modified</th></tr></thead><tbody>");
			File directoryPath = new File(".\\");
        //List of all files and directories
        String contents[] = directoryPath.list();
        if(contents == null) {
            System.out.println("Nothing to see...");

        } else {
            System.out.println();
            for (int i = 0; i < contents.length; i++) {
            	//if (!exclusionList.contains(contents[i])) {
            	myWriter.write("<tr class=\"$class\">");
                	// String ext = contents[i].substring(contents[i].lastIndexOf('.') + 1, contents[i].length());
                	File f = new File(".\\"+contents[i]);
                	long lastModifiedMillis = f.lastModified();
					Date date = new Date(lastModifiedMillis);
					String ext = contents[i].substring(contents[i].lastIndexOf('.') + 1, contents[i].length());
	                    myWriter.write("<td><a href=" + contents[i] +">" + contents[i] +"</a></td>");
	                    // myWriter.write("<td>" + ext +"</td>");
	                    myWriter.write("<td>" + (double) f.length() / 1000 + " kB" + "</td>");
	                    myWriter.write("<td>" + date + "</td>");
	                	myWriter.write("</tr>");
	               // }
                
            }
            
            System.out.println();
        }
        	myWriter.write("</tbody>");
			myWriter.write("</table></div></body></html>");
			myWriter.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}


}