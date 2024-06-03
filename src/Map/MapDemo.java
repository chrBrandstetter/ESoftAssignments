package Map;
class MapDemo{
	public static void main(String [] args) {

		Out.print("\nMapDemo");
		Out.print("\n=======");
		Map map = new Map();
		Out.print("\nmap: " + map.toString());		// empty Map
			
		if (map.store("1", "A")) Out.print("\n   stored (1,A)");
		Out.print("\nmap: " + map.toString());		// (1,A)
		
		if (map.store("2", "B")) Out.print("\n   stored (2,B)");
		Out.print("\nmap: " + map.toString());		// (1,A)(2,B)
		
		if (!map.store("2", "X")) Out.print("\n   (2,X) cannot be stored!");	
		Out.print("\nmap: " + map.toString());		// (1,A)(2,B)
		
		if (map.remove("2")) Out.print("\n   deleted (2,B)");	
		Out.print("\nmap: " + map.toString());		// (1,A)
		
		if (!map.remove("2")) Out.print("\n   (2,B) cannot be deleted !");
		Out.print("\nmap: " + map.toString());		// (1,A)
		
		if (!map.store("3", "C")) Out.print("\n   (3,C) cannot be stored !");						
		Out.print("\nmap: " + map.toString());		// (1,A)(3,C)
		
		Out.print("\nmap size: " + map.size());		// 2
		
		Out.print("\nmap valueOf 2: " + map.value("2"));		// null
		Out.print("\nmap valueOf 3: " + map.value("3"));		// C
		Out.print("\nmap valueOf 1: " + map.value("1"));		// A
		Out.print("\nmap valueOf null: " + map.value(null));	// null
		
		String [] keys = map.keys();
		Out.print("\nmap keys: ");					
		for (int i = 0; i < keys.length; i++) {
			Out.print("\n   " + keys[i]);						// 1, 3
			Out.print("   " + map.value(""+keys[i]));			// A, C
		}

		
	} 
} 
