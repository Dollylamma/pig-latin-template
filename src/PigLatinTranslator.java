import java.lang.*;

public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();

    String title = input.getTitle();
    title= translate(title);
    translatedBook.setTitle(title);
    for(int i=0; i<input.getLineCount(); i++){
      String line = input.getLine(i);
      translatedBook.appendLine(translate(line));
    }
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
    String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String result="";
    int letterCnt=0;
    boolean[] isLetter = new boolean[input.length()];
    for (int index=0; index<input.length(); index++){
      // char letter = input.charAt(index);
      if(letters.indexOf(input.substring(index, index+1))==-1){
        isLetter[index]=false;
      } else {
        isLetter[index]=true;
        letterCnt++;
      }
    }
    if(letterCnt==0){
      return input;
    }
    // for(int i=0; i<input.length(); i++){
    //   System.out.print(isLetter[i]);
    // }
    if(input.length()<1){
      return input;
    }
    boolean onChar=isLetter[0];
    String currWord="";
    int nonWordCnt=0;
    int startindex=0;
    for(int index=0; index<input.length(); index++){
      // if(onChar){
      //   if(!isLetter[index]){
      //     result+=translateSingleSection(currWord);
      //     onChar=false;
      //     currWord="";
      //     currWord+=input.substring(index, index+1);
      //   } else{
      //     currWord+=input.substring(index, index+1);
      //   }
      // } else {
      //   result+=translateSingleSection(currWord);
      //   startindex=index;
      //   nonWordCnt=0;
      //   while(!isLetter[index+nonWordCnt]){
      //     nonWordCnt++;
      //   }
      //   result+=input.substring(startindex, startindex+nonWordCnt);
      //   index+=nonWordCnt-1;
      //   onChar=true;
      // }
      if(isLetter[index]){
        currWord+=input.substring(index, index+1);
      } else {
        result+=translateSingleSection(currWord);
        currWord="";
        startindex=index;
        nonWordCnt=0;
        while(index+nonWordCnt<input.length() && !isLetter[index+nonWordCnt]){
          nonWordCnt++;
        }
        result+=input.substring(startindex, startindex+nonWordCnt);
        index+=nonWordCnt-1;
      }
    }
    result+=translateSingleSection(currWord);
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

  private static String translateSingleSection (String input){
    String result = "";
    if(input.length()<1){
      return input;
    } else if (input.length()==1){
      return input+"ay";
    }
    String vowel="aeiouyAEIOUY";
    String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int backLen=0;
    boolean firstUpper=false;
    if(upper.indexOf(input.substring(0, 1))!=-1){
      firstUpper=true;
    }
    for(int i=0; i<input.length(); i++){
      if(vowel.indexOf(input.substring(i, i+1))==-1){
        backLen++;
      } else{
        if(firstUpper){
          result = (input.substring(backLen, backLen+1)).toUpperCase() + input.substring(backLen+1)+(input.substring(0, backLen)).toLowerCase()+ "ay";
          break;
        } else{
          result = (input.substring(backLen, backLen+1)) + input.substring(backLen+1)+(input.substring(0, backLen)).toLowerCase()+ "ay";
          break;
        }
      }
    }
    return result;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}