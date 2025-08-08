package string_class;

public class string_class{
    public static void main(String[] args) {
        String customerName = "Peeyush Pal Singh";
        
        System.out.println("Length: " + customerName.length());
      
        System.out.println("Uppercase: " + customerName.toUpperCase());
   
        System.out.println("Lowercase: " + customerName.toLowerCase());
      
        System.out.println("Trimmed: '" + customerName.trim() + "'");

        System.out.println("Char at 0: " + customerName.charAt(0));
       
        System.out.println("Equals 'Peeyush Pal Singh': " + customerName.trim().equals("Peeyush Pal Singh"));
  
        System.out.println("Contains 'Pal': " + customerName.contains("Pal"));
        
        System.out.println("Starts with '  Pe': " + customerName.startsWith("  Pe"));
       
        System.out.println("Ends with 'h  ': " + customerName.endsWith("h  "));
     
        System.out.println("Index of 'S': " + customerName.indexOf('S'));
      
        System.out.println("Last index of ' ': " + customerName.lastIndexOf(' '));
       
        System.out.println("Is empty: " + customerName.isEmpty());
      
        System.out.println("Is blank: " + customerName.isBlank());
     
        System.out.println("Substring from 2: " + customerName.substring(2));
  
        System.out.println("Substring(2, 6): " + customerName.substring(2, 6));
       
        System.out.println("Replace 'Peeyush' with 'Aman': " + customerName.replace("Peeyush", "Aman"));
    
        System.out.println("Replace all spaces: " + customerName.replaceAll(" ", "-"));
 
        System.out.println("Replace first space: " + customerName.replaceFirst(" ", "*"));
     
        System.out.println("CompareTo 'Peeyush Pal Singh': " + customerName.trim().compareTo("Peeyush Pal Singh"));
      
        System.out.println("CompareToIgnoreCase: " + customerName.trim().compareToIgnoreCase("peeyush pal singh"));   
    }
}