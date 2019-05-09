/*********************************************************************************/
/* Faisal Ibrahim                                                      Home Work */
/* CISC 3130                                                                     */
/*                                                                               */
/*********************************************************************************/

package homework_03;

import java.io.FileNotFoundException;
import java.util.*;

public class Concordance {

      private String file;      
      private Map<String, ArrayList<Token>> myMap;

      public Concordance(String file) {

            myMap = new TreeMap<String, ArrayList<Token>>();
            this.file = file;

      }

      public boolean add() throws FileNotFoundException {            
            Tokenizer tz = new Tokenizer(file);

            while (tz.hasNext()) {

                  Token temp = tz.next();

                  if (!myMap.containsKey(temp.getWord())) {

                        ArrayList<Token> newArray = new ArrayList<Token>();
                        newArray.add(temp);
                        myMap.put(temp.getWord(), newArray);

                  }
                  else {

                        myMap.get(temp.getWord()).add(temp);
                  }

            }
            return true;
      }

      public int count (String s) {

            if (!myMap.containsKey(s)) {
                  return -1;
            }

            return  myMap.get(s).size();
      }
      
      public void print() {

            for (String key: myMap.keySet()) {
                  System.out.println("For the word: " + key + " appers: " + myMap.get(key).size() + " times. ");
                  System.out.println(myMap.get(key));

            }

      }

}
