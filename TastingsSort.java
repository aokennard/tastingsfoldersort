import java.util.*;
import java.io.*;
public class TastingsSort 
{
  
  /*
   * 
   * 
   * My god, this is terrible. I made this for a one time use in a few hours. However, I should probbbbbably go back and make it a general file organizer
   * 5/4/2016
   * 
   */
  
  
  public String basePath = "C:/TestFolder/CustomerLogos/";
  //Will need to change based on year
  
  public static void topLevelFolderMaking(String path) //Made specifically for only years. When I make this better: adjust by making an input array of folders
  {
    //Should be .
    ArrayList<Integer> folderss = new ArrayList<Integer>();
    folderss.add(2013);
    folderss.add(2014);
    folderss.add(2015);
    folderss.add(2016);
    //Bad but too lazy to lookup alternative ^
    File f = new File(path);
    File[] allF = f.listFiles();
    for(int j = 0;j<folderss.size();j++)
    {
       for(File i : allF)
          {
               if(i.getName().equals(folderss.get(j)+ " Logos")) //Adjust
               {
                 folderss.remove(folderss.get(j));
               }
          }
    }
    System.out.println(folderss);
    for(int r = 0;r<folderss.size();r++)
    {
      File dir = new File(path + "/" + folderss.get(r)+ " Logos"); //Adjust
      boolean success = dir.mkdir();
      if(success)
      {
        System.out.println("Couldn't find " + folderss.get(r) + " folder. Creating.."); 
      }
      else
      {
        System.out.println("Directory failed for " + folderss.get(r) );
      }
    }
                           
  }
  public static void folderCheck(String path, String folderName)
  {
    //Inputs of the form "./CustomerLogos/(year) Logos/" 
    File f = new File(path); 
    File [] allF = f.listFiles(); 
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
  public static void makeFolders(String folderName, boolean inHomeDir) //Currently done
  {
    ArrayList<Integer> folders = new ArrayList<Integer>();
    folders.add(2013);
    folders.add(2014);
    folders.add(2015);
    folders.add(2016);
    if(inHomeDir)
    {
    folderCheck(basePath, "Misc Folder");
    }
    for(int i = 0;i<folders.size();i++)
    {    
       folderCheck(basePath + folders.get(i) + " Logos", folderName);
    }
  }
  public static void makeSubFolders(String folderName) //Make adjustab;e
  {
    //Meant for BTI,WBC,etc
    int[] years = {2013,2014,2015,2016};
    String[] subfolders = {"Bronze Logos","Silver Logos","Gold Logos","Platinum Logos"};
    for(int i = 0;i<years.length;i++)
    {
      for(int j = 0;j<subfolders.length;j++)
      {
        folderCheck(basePath + years[i] + " Logos/" + subfolders[j], folderName);
      }
    }
  }
  public static void initializeMedalFolders() //Make adjustable
  {
    makeFolders("Misc Folder",true); //47 min
    makeFolders("Bronze Logos", false);
    makeFolders("Silver Logos", false);
    makeFolders("Gold Logos", false);
    makeFolders("Platinum Logos", false);
    
  }
  public static void initializeSubFolders() //Make adjustable
  {
    makeSubFolders("BTI");
    makeSubFolders("IRS");
    makeSubFolders("WBC");
    makeSubFolders("WVWC");
    makeSubFolders("WWC");
    makeSubFolders("Custom");
    makeSubFolders("Misc Folder");
  }
  public static String determinePoints(String str) //Make more specific : for all non alphanumerics
  {
    String pointValue = " ";
    int firstDash = str.indexOf("-");
    int firstUnder = str.indexOf("_");
    int secondDash = str.indexOf("-",firstDash+1);
    int secondUnder = str.indexOf("_",firstUnder+1);
    if(secondDash == -1)
    {
      secondDash = str.lastIndexOf('.');
    }
    if(secondUnder == -1)
    {
      secondUnder = str.lastIndexOf('.');
    }
    if(firstDash == -1)
    {
      pointValue = str.substring(firstUnder+1,secondUnder);
    }
    if(firstUnder == -1)
    {
      pointValue = str.substring(firstDash+1,secondDash);
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
        if (!Character.isLetter(c) && !Character.isDigit(c) && !(c == '.'))
            return i;
    }
    return -1; 
   }
  public static String determineCompetition(String str) //Make adjustable
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
  public static boolean isIntegerParseInt(String str) { //thanks stackoverflow
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {}
        return false;
    }
  public static String determineMedalFolder(String str) //use with determinePoints(str) - make adjustable
  {
    String ret = "Misc Folder";
    int len = str.length();
    boolean isNumber = isIntegerParseInt(str.substring(0,2));
    if(isNumber)
    {
    if(Integer.parseInt(str.substring(0,2)) < 85)
    {
      ret = "Bronze Logos";
    }
    if(Integer.parseInt(str.substring(0,2)) < 90 && Integer.parseInt(str.substring(0,2)) > 84 )
    {
      ret = "Silver Logos";
    }
    if(Integer.parseInt(str.substring(0,2)) < 96 && Integer.parseInt(str.substring(0,2)) > 89 )
    {
      ret = "Gold Logos";
    }
    if(Integer.parseInt(str.substring(0,2)) > 95 )
    {
      ret = "Platinum Logos";
    }
    }
    if(!isNumber)
    {
      if(str.substring(0,len).equals("Bronze"))
      {
        ret = "Bronze Logos";
      }
      if(str.substring(0,len).equals("Silver"))
      {
        ret = "Silver Logos";
      }
      if(str.substring(0,len).equals("Gold"))
      {
        ret = "Gold Logos";
      }
      if(str.substring(0,len).equals("Platinum"))
      {
        ret = "Platinum Logos";
      }
    }
    return ret;
  }
  public static String determineYear(String str) //doesnt account for not year endings - make adjustable
  {
    String ret = "Misc Folder";
    int lastV = lastAlphaNumeric(str);
    boolean isNumber = isIntegerParseInt(str.substring(lastV+1,str.lastIndexOf('.')));
    if(isNumber)
    {
    if(Integer.valueOf(str.substring(lastV+1,str.lastIndexOf('.'))) == 2013)
    {
      ret = "2013 Logos";
    }
    if(Integer.valueOf(str.substring(lastV+1,str.lastIndexOf('.'))) == 2014)
    {
      ret = "2014 Logos";
    }
    if(Integer.valueOf(str.substring(lastV+1,str.lastIndexOf('.'))) == 2015)
    {
      ret = "2015 Logos";
    }
    if(Integer.valueOf(str.substring(lastV+1,str.lastIndexOf('.'))) == 2016)
    {
      ret = "2016 Logos";
    }
    }
    if(!isNumber)
    {
      ret = "Misc Folder";
    }
    return ret;
  }
    
  public static void sortTopLevel() //1 hr 57 min spent - make adjustable
  {
    //Takes customerlogos - it basically determines where to put stuff based on STR_#pts_YEAR - all else goes in Misc
    File f = new File(basePath);
    File[] allF = f.listFiles();
    for(File i : allF)
    {
      
      if(!i.isDirectory())
      {
        String name = i.getName();
        String year = determineYear(name); //currently all = 2013 logos Adjust
        if(year.equals("Misc Folder")) //Adjust
        {
          i.renameTo(new File(basePath + "/Misc Folder/" + name)); //Adjust
        }
        if(!(year.equals("Misc Folder"))) //Adjust
        {
          i.renameTo(new File(basePath + year + "/" + name)); //Adjust
        }
      }
    }
    System.out.println("Top directory sorted!");
  } //Works as of 175 mins
  public static void sortYearFolders(String yearpath) //make adjustable
  {
    File f = new File(yearpath);
    File[] allF = f.listFiles();
    for(File i : allF)
    {
      if(!i.isDirectory())
      {
        String name = i.getName();
        String medal = determineMedalFolder(determinePoints(name));
        if(medal.equals("Misc Folder")) //Adjust
        {
          i.renameTo(new File(yearpath + "/Misc Folder/" + name)); //Adjust
        }
        if(!(medal.equals("Misc Folder"))) //Adjust
        {
          i.renameTo(new File(yearpath + "/" + medal + "/" + name));
        }
      }
    }
    System.out.println("Sorted " + f.getName());
  }
  public static void sortAllYears() //Make adjustable
  {
    sortYearFolders("C:/TestFolder/CustomerLogos/2013 Logos");
    sortYearFolders("C:/TestFolder/CustomerLogos/2014 Logos");
    sortYearFolders("C:/TestFolder/CustomerLogos/2015 Logos");
    sortYearFolders("C:/TestFolder/CustomerLogos/2016 Logos");
    System.out.println("Should be sorted in years..");
  }
  public static void sortByMedal(String medalpath) //Make adjustable
  {
    File f = new File(medalpath);
    File[] allF = f.listFiles();
    for(File i : allF)
    {
      if(!i.isDirectory())
      {
        String name = i.getName();
        String comp = determineCompetition(name);
        if(comp.equals("Misc Folder")) 
        {
          i.renameTo(new File(medalpath + "/Misc Folder/" + name));
        }
        if(!(comp.equals("Misc Folder")))
        {
          i.renameTo(new File(medalpath + "/" + comp + "/" + name));
        }
      }
    }
    System.out.println("Sorted the " + f.getName());
  }
  public static void sortAllMedals() //holy cow make adjustable
  {
    sortByMedal("C:/TestFolder/CustomerLogos/2013 Logos/Bronze Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2013 Logos/Silver Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2013 Logos/Gold Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2013 Logos/Platinum Logos/");
    System.out.println("2013 sorted.");
    sortByMedal("C:/TestFolder/CustomerLogos/2014 Logos/Bronze Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2014 Logos/Silver Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2014 Logos/Gold Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2014 Logos/Platinum Logos/");
    System.out.println("2014 sorted.");
    sortByMedal("C:/TestFolder/CustomerLogos/2015 Logos/Bronze Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2015 Logos/Silver Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2015 Logos/Gold Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2015 Logos/Platinum Logos/");
    System.out.println("2015 sorted.");
    sortByMedal("C:/TestFolder/CustomerLogos/2016 Logos/Bronze Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2016 Logos/Silver Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2016 Logos/Gold Logos/");
    sortByMedal("C:/TestFolder/CustomerLogos/2016 Logos/Platinum Logos/");
    System.out.println("2016 sorted.");
    System.out.println("Everything should be in order!");
  }
    

    
  public static void main(String [] args)
  {
    //Make sure to only run first once. Works then. - second thought - make a doesExist(String folder) to check stuff
    //topLevelFolderMaking(basePath); //22 min
    initializeMedalFolders();
    initializeSubFolders();
    sortTopLevel();
    sortAllYears(); //Finished sort year at 193 mins
    sortAllMedals();
    //Total time - 1hr 57 min first day, 1hr 38 min second day
    System.out.println("everything is k");
  }
}