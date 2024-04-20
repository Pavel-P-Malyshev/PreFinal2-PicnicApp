
/* 


Промежуточная контрольная работа по
блоку Специализация
Задание 2.
Ваше задание на промежуточную аттестацию. Помните, что это не
только проверка ваших знаний, но и шанс показать свои навыки! 😊



Входные данные:
Ваш файл `input.txt` содержит множество слов, разделенных
пробелами. Это слова-фрукты, овощи и другие продукты.
Представьте, что это ваш виртуальный пикник! 🍎🥕🥧


Задания:
1. Осуществить подсчет слов:
Напишите программу, которая подсчитывает количество слов в
файле `input.txt`.


2. Найти самое длинное слово:
Создайте программу, которая находит самое длинное слово в
файле.


3. Вычислить частоту слов:
Напишите программу, которая анализирует, сколько раз каждое
слово встречается в файле. Подумайте об этом как о подсчете того,
какие фрукты и овощи самые популярные на вашем пикнике! 🍇�





 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class HomeWork2 {
    public static void main(String[] args)
     {
        
        
         //ReadFile.readFileInMap("input.txt");
         CheckFoods.countFoods(ReadFile.readFileInMap("input.txt"));
         System.out.println("\n Всего в файле input.txt перечислено "+CheckFoods.getProductsNumber()+" разных продуктов (строк) \n");
         System.out.println("Среди всех продуктов встречается "+CheckFoods.countWords()+" слов, входящих в названия продуктов \n");
         System.out.println("Самое длинное из встречающихся слов -' "+CheckFoods.findLongestWord()+" ' которое содержит " +CheckFoods.findLongestWord().get(0).length()+" букв.\n");

        
           HashMap<String,Integer> words=CheckFoods.countWordOccureneces();
           int maxOccur=Collections.max(words.values());
           int minOccur=Collections.min(words.values());
           ArrayList <String>  mostOftenMet=new ArrayList<>();
           ArrayList <String>  leastOftenMet=new ArrayList<>();

           for (var  entry : words.entrySet()) 
           {
              if (entry.getValue()==maxOccur) mostOftenMet.add(entry.getKey());
              if (entry.getValue()==minOccur) leastOftenMet.add(entry.getKey());
           }

         System.out.println("Наиболее часто встречающиеся слова среди названий продуктов ' "+mostOftenMet+" ' ("+maxOccur+" раз) \n");
         System.out.println("Наименее часто встречающееся слово среди названий продуктов ' "+leastOftenMet+" ' ("+minOccur+" раз) \n");


         //создаем Linked hashmap чтобы сразу отсортировать слова по убыванию количества посторений в файле
         LinkedHashMap<String,Integer> remainingWords = new LinkedHashMap<>();
         int remainingOccur=maxOccur-1;

         while (remainingOccur>minOccur) 
         {
                     
            for (var  entry : words.entrySet()) 
            {
                if((entry.getValue()==remainingOccur) & (remainingOccur>minOccur)) remainingWords.put(entry.getKey(),entry.getValue());
              
            }

            remainingOccur--;
        }

       
        System.out.println("Слова, встречающиеся в названии продуктов менее максимального количества раз но более минимального: \n"+remainingWords);


         
       
    }
}
