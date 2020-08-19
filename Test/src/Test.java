import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.github.cliftonlabs.json_simple.*;

//Fields: "entity", "year", "type1", "type2", type3", "type4", and amount is blank

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		//take values from a .csv object
		//and converts it into a json Object
		
		
		//initializes the file for parsing
		String fileName = "C:\\Users\\tonbo\\OneDrive\\Documents\\Internship Work\\combined.csv";
		File file = new File(fileName);
		
		//initialize Scanner
		Scanner sc = new Scanner(file);
		sc.nextLine();
		String[] data = new String[] {};
		String line;
		
		//initialize the JSON objects
		JsonObject city = new JsonObject();
		JsonObject year = new JsonObject();
		JsonObject type1 = new JsonObject();
		JsonObject type2 = new JsonObject();
		JsonObject type3 = new JsonObject();
		JsonObject type4 = new JsonObject();
	
		
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			data = line.split(",");
			
			if(!city.containsKey("\"" + data[0] + "\"")) {
				year = new JsonObject();
				type1 = new JsonObject();
				type2 = new JsonObject();
				type3 = new JsonObject();
				type4 = new JsonObject();
			} else if (!((JsonObject) city.get("\"" + data[0] + "\"")).containsKey("\"" + data[1] + "\"")){
				type1 = new JsonObject();
				type2 = new JsonObject();
				type3 = new JsonObject();
				type4 = new JsonObject();
			} else if (!((JsonObject) ((JsonObject) city.get("\"" + data[0] + "\"")).get("\"" + data[1] + "\"")).containsKey("\"" + data[2] + "\"")){
				type2 = new JsonObject();
				type3 = new JsonObject();
				type4 = new JsonObject();
			} else if(!((JsonObject) ((JsonObject) ((JsonObject) city.get("\"" + data[0] + "\"")).get("\"" + data[1] + "\"")).get("\"" + data[2] + "\"")).containsKey("\"" + data[3] + "\"")) {
				type3 = new JsonObject();
				type4 = new JsonObject();
			} else if(!((JsonObject) ((JsonObject) ((JsonObject) ((JsonObject) city.get("\"" + data[0] + "\"")).get("\"" + data[1] + "\"")).get("\"" + data[2] + "\"")).get("\"" + data[3] + "\"")).containsKey("\"" + data[4] + "\"")) {
				type4 = new JsonObject();
			}
			
			type4.put("\"" + data[5] + "\"", "\"" + data[6] + "\"");
			type3.put("\"" + data[4] + "\"", type4);
			type2.put("\"" + data[3]  + "\"",type3);
			type1.put("\"" + data[2]  + "\"",type2);
			year.put("\"" + data[1] + "\"", type1);
			city.put("\"" + data[0] + "\"", year);
			/*
			type4.put(data[5],  data[6]);
			type3.put(data[4] , type4);
			type2.put(data[3] ,type3);
			type1.put( data[2] ,type2);
			year.put( data[1] , type1);
			city.put( data[0] , year);*/
			
		}
		
		String temp = city.toString().replace("="," : ");
		temp = temp.replace("{", "{\n");
		System.out.println(temp);
		/*
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type4 = new JsonObject();
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type4 = new JsonObject();
		line = sc.nextLine();
		data = line.split(",");
		type4.put(data[5], data[6]);
		type3.put(data[4], type4);
		type2.put(data[3], type3);
		type1.put(data[2], type2);
		year.put(data[1], type1);
		city.put(data[0], year);
		
		type4 = new JsonObject();
		for(int i = 0; i < 5; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type3 = new JsonObject();
		type4 = new JsonObject();
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type4 = new JsonObject();
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		
		
		
		
		
		
		
		/*
		
		type4 = new JsonObject();
		line = sc.nextLine();
		data = line.split(",");
		type4.put(data[5], data[6]);
		type3.put(data[4], type4);
		type2.put(data[3], type3);
		type1.put(data[2], type2);
		year.put(data[1], type1);
		city.put(data[0], year);
		
		type4 = new JsonObject();
		for(int i = 0; i < 5; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type3 = new JsonObject();
		type4 = new JsonObject();
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type4 = new JsonObject();
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type4 = new JsonObject();
		line = sc.nextLine();
		data = line.split(",");
		type4.put(data[5], data[6]);
		type3.put(data[4], type4);
		type2.put(data[3], type3);
		type1.put(data[2], type2);
		year.put(data[1], type1);
		city.put(data[0], year);
		
		type4 = new JsonObject();
		for(int i = 0; i < 5; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type3 = new JsonObject();
		type4 = new JsonObject();
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type4 = new JsonObject();
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type4 = new JsonObject();
		line = sc.nextLine();
		data = line.split(",");
		type4.put(data[5], data[6]);
		type3.put(data[4], type4);
		type2.put(data[3], type3);
		type1.put(data[2], type2);
		year.put(data[1], type1);
		city.put(data[0], year);
		
		type4 = new JsonObject();
		for(int i = 0; i < 5; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type3 = new JsonObject();
		type4 = new JsonObject();
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type4 = new JsonObject();
		for(int i = 0; i < 8; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		type4 = new JsonObject();
		line = sc.nextLine();
		data = line.split(",");
		type4.put(data[5], data[6]);
		type3.put(data[4], type4);
		type2.put(data[3], type3);
		type1.put(data[2], type2);
		year.put(data[1], type1);
		city.put(data[0], year);
		
		type4 = new JsonObject();
		for(int i = 0; i < 5; i++) {
			line = sc.nextLine();
			data = line.split(",");
			type4.put(data[5], data[6]);
			type3.put(data[4], type4);
			type2.put(data[3], type3);
			type1.put(data[2], type2);
			year.put(data[1], type1);
			city.put(data[0], year);
		}
		
		//Stopped at 112 rows
		//Finished Governmental Funds
		
		
		String temp = city.toString().replace("="," : ");
		temp = temp.replace("{", "{\n");
		System.out.println(temp);
*/
	}

}
