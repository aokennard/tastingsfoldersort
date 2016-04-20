import java.util.*;
import java.io.*;
public class TastingsSort
{
  //Use index of to find either "-" or "_"
  public int currentYear = 2016;
  //Will need to change based on year
  
  public static void topLevelFolderMaking(String path)
  {
    //Should be .
    ArrayList<Integer> years = new ArrayList<Integer>();
    years.add(2013);
    years.add(2014);
    years.add(2015);
    years.add(2016);
    //Bad but too lazy to lookup alternative ^
    File f = new File(path);
    File[] allF = f.listFiles();
    for(int j = 0;j<years.size();j++)
    {
       for(File i : allF)
          {
               if(i.getName().equals(years.get(j)+ " Logos"))
               {
                 years.remove(years.get(j));
               }
          }
    }
    System.out.println(years);
    for(int r = 0;r<years.size();r++)
    {
      File dir = new File(path + "/" + years.get(r)+ " Logos");
      boolean success = dir.mkdir();
      if(success)
      {
        System.out.println("Couldn't find " + years.get(r) + " folder. Creating..");
      }
      else
      {
        System.out.println("Directory failed for " + years.get(r) );
      }
    }
                           
  }
  public static void folderCheck(String path, String folderName)
  {
    //Inputs of the form "./CustomerLogos/(year) Logos/" 
    File f = new File(path); //Current directory
    File [] allF = f.listFiles(); //All files in current dir
    boolean folderExists = false;
    for(int i = 0;i<allF.length;i++)
    {
      if(allF[i].getName().equals(folderName))
      {
        folderExists = true;
      }
    }
    //Finding if there is foldername
    if(!folderExists)
    {
      File dir = new File(path + "/" + folderName + "/");
      boolean success = dir.mkdir();
      if(success)
      {
        System.out.println("Couldn't find " + folderName + " in " + path + ". Creating..");
      }
      else
      {
        System.out.println("Directory failed for " + folderName + " in " + path);
      }
    }
    //Making foldername
  }
  public static void makeFolders(String folderName, boolean inHomeDir)
  {
    ArrayList<Integer> years = new ArrayList<Integer>();
    years.add(2013);
    years.add(2014);
    years.add(2015);
    years.add(2016);
    if(inHomeDir)
    {
    folderCheck("C:/TestFolder/CustomerLogos/", "Misc Folder");
    }
    for(int i = 0;i<years.size();i++)
    {    
       folderCheck("C:/TestFolder/CustomerLogos/" + years.get(i) + " Logos", folderName);
    }
  }
  public static void makeSubFolders(String folderName)
  {
    //Meant for BTI,WBC,etc
    int[] years = {2013,2014,2015,2016};
    String[] subfolders = {"Bronze Logos","Silver Logos","Gold Logos","Platinum Logos"};
    for(int i = 0;i<years.length;i++)
    {
      for(int j = 0;j<subfolders.length;j++)
      {
        folderCheck("C:/TestFolder/CustomerLogos/" + years[i] + " Logos/" + subfolders[j], folderName);
      }
    }
  }
  public static void initializeMedalFolders()
  {
    makeFolders("Misc Folder",true); //47 min
    makeFolders("Bronze Logos", false);
    makeFolders("Silver Logos", false);
    makeFolders("Gold Logos", false);
    makeFolders("Platinum Logos", false);
    
  }
  public static void initializeSubFolders()
  {
    makeSubFolders("BTI");
    makeSubFolders("IRS");
    makeSubFolders("WBC");
    makeSubFolders("WVWC");
    makeSubFolders("WWC");
    makeSubFolders("Custom");
    makeSubFolders("Misc Folder");
  }
  public static String determinePoints(String str) // 5min
  {
    String pointValue = " ";
    int firstDash = str.indexOf("-");
    int firstUnder = str.indexOf("_");
    if(firstDash == -1)
    {
      pointValue = str.substring(firstUnder+1,str.indexOf("_",firstUnder+1));
    }
    if(firstUnder == -1)
    {
      pointValue = str.substring(firstDash+1,str.indexOf("-",firstDash+1));
    }
    return pointValue;
  }
  public static final int firstAlphaNumeric(String s) {
    for (int i = 0; i < s.length(); i++) 
    {
        char c = s.charAt(i);
        if (!Character.isLetter(c) && !Character.isDigit(c))
            return i;
    }
    return -1; 
   }
  public static final int lastAlphaNumeric(String s) {
    for (int i = s.length()-1; i>=0; i--) 
    {
        char c = s.charAt(i);
        if (!Character.isLetter(c) && !Character.isDigit(c))
            return i;
    }
    return -1; 
   }
  public static String determineCompetition(String str) //or : how .equals got its groove back - 20mins
  {
    String compValue = "Misc Folder";
    int endCVal = firstAlphaNumeric(str);
    String prefix = str.substring(0,endCVal);
    if(prefix.length() >= 4 && !prefix.equals("WVWC"))
    {
      compValue = "Custom";
    }
    if(prefix.equals("BTI"))
    {
      compValue = "BTI";
    }
    if(prefix.equals("IRS"))
    {
      compValue = "IRS";
    }
    if(prefix.equals("WBC"))
    {
      compValue = "WBC";
    }
    if(prefix.equals("WVWC"))
    {
      compValue = "WVWC";
    }
    if(prefix.equals("WWC"))
    {
      compValue = "WWC";
    }
    
    return compValue;
  }
  
  public static String determineMedalFolder(String str)
  {
    String ret = "Misc Folder";
    if(Integer.parseInt(str.substring(0,2)) < 85)
    {
      ret = "Bronze Logos";
    }
    if(Integer.parseInt(str.substring(0,2)) < 90 && Integer.parseInt(str.substring(0,2)) > 84)
    {
      ret = "Silver Logos";
    }
    if(Integer.parseInt(str.substring(0,2)) < 96 && Integer.parseInt(str.substring(0,2)) > 89)
    {
      ret = "Gold Logos";
    }
    if(Integer.parseInt(str.substring(0,2)) > 95)
    {
      ret = "Platinum Logos";
    }
    return ret;
  }
  public static String determineYear(String str)
  {
    String ret = "Misc Folder";
    int lastV = lastAlphaNumeric(str);
    if(Integer.valueOf(str.substring(lastV,str.length()-1)) == 2013)
    {
      ret = "2013 Logos";
    }
    if(Integer.valueOf(str.substring(lastV,str.length()-1)) == 2014)
    {
      ret = "2014 Logos";
    }
    if(Integer.valueOf(str.substring(lastV,str.length()-1)) == 2015)
    {
      ret = "2013 Logos";
    }
    if(Integer.valueOf(str.substring(lastV,str.length()-1)) == 2016)
    {
      ret = "2013 Logos";
    }
    return ret;
  }
    
  public static void sortTopLevel() //1 hr 57 min spent
  {
    //Takes customerlogos - it basically determines where to put stuff based on STR_#pts_YEAR - all else goes in Misc
    File f = new File("C:/TestFolder/CustomerLogos/");
    File[] allF = f.listFiles();
    for(File i : allF)
    {
      //Somehow rearrange based on the strings given for each function
    }
  }

    
  public static void main(String [] args)
  {
    //Make sure to only run first once. Works then. - second thought - make a doesExist(String folder) to check stuff
    //topLevelFolderMaking("C:/TestFolder/CustomerLogos/"); //22 min
    initializeMedalFolders();
    initializeSubFolders();
    //To-Do - Put unknown files into each misc folder
    //Sort each file by its heading into respective folder
    //took 1 hr
    
    System.out.println("everything is k");
  }
}