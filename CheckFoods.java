import java.util.*;

public class CheckFoods 
{
    private static HashMap<String, Integer> foods = new HashMap<>();

    //подсчет количества продуктов (каждый продукт это одна уникальная строка) - Запись в Hashmap
    public static void countFoods(List<String> lines)
    {
        //HashMap<String, Integer> foods = new HashMap<>();

                    for (String entry: lines) 
                    {
                        if(foods.containsKey(entry))
                        {
                            foods.put(entry,foods.get(entry)+1);
                        }
                        else
                        {
                            foods.put(entry,1);
                        }
                       
                    }
    }

    // 1. Осуществить подсчет слов:
    // Напишите программу, которая подсчитывает количество слов в
    // файле `input.txt`.
    public static int countWords()
    {
        int wordsCount=0;
        for (var entry: foods.entrySet()) 
        {
           wordsCount+=entry.getKey().split("\s+").length;
        }

        return wordsCount;

    }

    // 2. Найти самое длинное слово:
    // Создайте программу, которая находит самое длинное слово в
    // файле. 
    public static  ArrayList <String> findLongestWord()
    {
        //ArrayList<String> words =new ArrayList<>();
       // String LongestWord=null;
        int LongestWordLength=0;
        ArrayList <String> LongestWords=new ArrayList<>();

        for (var entry: foods.entrySet()) 
        {
           String[] curStr=entry.getKey().split("\s+");
           for (String iterable_element : curStr) 
           {
               if (iterable_element.length() > LongestWordLength) 
               {
                  LongestWordLength=iterable_element.length();
                 // LongestWord=iterable_element;
               }
            }            

        }

        //проходим по списку продуктов еще раз и сохраняем все слова наибольшей длины, если их количество больще 1
        for (var entry: foods.entrySet()) 
        {
            String[] curStr=entry.getKey().split("\s+");
            for (String iterable_element : curStr) 
            {
                if (iterable_element.length() == LongestWordLength) 
                {
                   LongestWords.add(iterable_element);
                }
             }      
        }


        return LongestWords;

    }


    //     3. Вычислить частоту слов:
    // Напишите программу, которая анализирует, сколько раз каждое
    // слово встречается в файле. Подумайте об этом как о подсчете того,
    // какие фрукты и овощи самые популярные на вашем пикнике! 
    public static HashMap<String, Integer> countWordOccureneces()
    {
        HashMap<String, Integer> words = new HashMap<>();        

        for (var entry: foods.entrySet()) 
        {
           String[] curStr=entry.getKey().split("\s+");
           for (String iterable_element : curStr) 
           {
                if(words.containsKey(iterable_element))
                {
                    words.put(iterable_element,words.get(iterable_element)+1);
                }
                else
                {
                    words.put(iterable_element,1);
                }
           }
        }

        return words;

    }    



    public static void ShowFoods(List<String> lines)
    {
        for (String entry: lines)
        {
            System.out.println("Next string is: "+entry);
        }
    }


    public static int getProductsNumber()
    {
        return foods.size();
    }






}
