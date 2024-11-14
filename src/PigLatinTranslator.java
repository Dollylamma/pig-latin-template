import java.lang.*;

public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();

    // Add code here to populate translatedBook with a translation of the input book.
    // Curent do-nothing code will return an empty book.

    return translatedBook;
  }

  public static String translate(String input)
  {
    // System.out.println("Translate String: '" + input + "'");

    // Replace this code to translate a string input.
    // The input to this function could be any English string. 
    // A sentence, paragraph, or a single word. 
    // It should call translateWord at least once.
    String result = translateWord(input);

    return result;
  }

  private static String translateWord(String input)
  {
    if(input.length()<1){
      return input;
    }
    // System.out.println("translateWord: '" + input + "'");
    boolean[] wordOrNot= new boolean[input.length()];
    String letter="abcdefghijklmnopqrstuvwxyz";
    for(int i=0; i<input.length(); i++){
      if(letter.indexOf(input.substring(i, i+1))!=-1){
        wordOrNot[i]=true;
      } else{
        wordOrNot[i]=false;
      }
    }
    // Replace this code to correctly translate a single word.
    // Start here first!
    String result="";
    String regex = "[,\\.\\s\\-]";
    String[] myArray = input.split(regex);
    for (String s : myArray) {
      String addToBack="";
	    for(int i=0; i<s.length(); i++){
        String firstLetter=s.substring(i, i+1);
        if(firstLetter.equals("a") || firstLetter.equals("e") || firstLetter.equals("i") || firstLetter.equals("o") || firstLetter.equals("u")){
          break;
        } else{
          addToBack+=firstLetter;
        }
      }
      result+=s.substring(addToBack.length())+s.substring(0, addToBack.length())+"ay";
    }
    return result;
    // String result = input;
    // if(result.length()<1){
    //   return input;
    // }
    // boolean isVowel=false;
    // String firstLetter = input.substring(0, 1);
    // if(firstLetter.equals("a") || firstLetter.equals("e") || firstLetter.equals("i") || firstLetter.equals("o") || firstLetter.equals("u")){
    //   isVowel=true;
    // }
    // if(isVowel){
    //   result=input+"ay";
    // } else{
    //   result = input.substring(1)+ input.substring(0, 1)+"ay";
    // }
    // return result;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}