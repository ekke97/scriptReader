import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap; 
import java.util.TreeMap; 
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.List;
import java.util.HashSet;
import java.lang.*;
import java.lang.Iterable;
import java.util.Formatter;

public class scriptReader {
    
    FileReader file;
    BufferedReader buffer;

    // For handling each word in the script
    public static String[] keywordHelper(String text) {
    	String[] ready = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
    	return ready;
    }

    // ------------- MAIN -----------------------------------------------------------
	public static void main(String[] args) {
		if ((args.length < 1) || (args.length > 1)) {
			System.out.println("Usage: java scriptReader <script-to-analyze>");
			System.out.println("Please try again");
			System.exit(0);
		}
		
		try {
			// read csv file to db
			HashMap<String, Item> db = new HashMap<>();
			HashMap<String, Integer> catdb = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader("props.csv"));
			String input = " ";
			br.readLine();
			while ((input = br.readLine()) != null) {
				// split up database columns into 1. item name 2. cost 3. category
				String[] line = input.toLowerCase().split(",");
				String name = line[0];
				int cost = Integer.parseInt(line[1]);
				String category = line[2];
				// create item, add to database
				Item i = new Item (name, cost, category);
				db.put(name, i);
			}

			// READ FILE - Line by line, and if word matches in HashMap, then increment count on that item
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			String in = " ";
			while((in = buf.readLine()) != null) {
				String[] line = keywordHelper(in);
				for (String word : line) {
					if (db.containsKey(word)) {
						Item i = db.get(word);
						i.count++;
						db.replace(word, i);
					}
				}
			}

			// Calculate the total cost of the script
			int total = 0;
			for (Item i : db.values()) {
				if (i.count > 0) {
					total = total + (i.cost * i.count);
					i.totCost = i.totCost + (i.cost * i.count);
					// print cost per item
					System.out.println(i.toString());
				}
			}
			// create category db to calculate cost per category
			for (Item i : db.values()) {
				if (i.count > 0) {
					if(!catdb.containsKey(i.category)) {
						int costcat = (i.cost * i.count);
						catdb.put(i.category, costcat);
					}
					else if(catdb.containsKey(i.category)) {
						int costcat = (catdb.get(i.category));
						costcat = costcat + (i.cost + i.count);
						catdb.replace(i.category, costcat);
					}					
				}
			}
			System.out.println();
			// Print cost per category
			for (String key : catdb.keySet()) {
				System.out.println("Category: " + key + ", Total category cost: $" + catdb.get(key));
			}

			System.out.println();
			// Print total script cost
			System.out.println("Total cost of script: $" + total);
		}
        catch (FileNotFoundException e) {
            System.out.println(".csv File not found.");
        } 
        catch (IOException e) {
            System.out.println("Error reading from .csv file.");
        }
        
        
        
        
    }

		
}

