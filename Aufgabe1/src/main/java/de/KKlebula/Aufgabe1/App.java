package de.KKlebula.Aufgabe1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class App {

    public static void main(String[] args) {
        
        List<Article> existingArticles = new ArrayList<>();

        
        Article AA1 = new Article("AA", 0, 20.00);
        Article AA2 = new Article("AA", 0, 100.00);
        Article AA3 = new Article("AA", 1, 20.00);
        Article AA4 = new Article("AA", 1, 100.00);
        Article BB1 = new Article("BB", 1, 50.00);
        Article BB2 = new Article("BB", 2, 75.00);
        Article CC1 = new Article("CC", 2, 75.00);
        Article CC2 = new Article("CC", 2, 80.00);

        existingArticles.add(AA1);
        existingArticles.add(AA2);
        existingArticles.add(AA3);
        existingArticles.add(AA4);
        existingArticles.add(BB1);
        existingArticles.add(BB2);
        existingArticles.add(CC1);
        existingArticles.add(CC2);

        HashMap<Integer, List<Article>> articlesMap = new HashMap<>();

        // Create a HashMap mapping groups to Articles
        for (Article existingArticle : existingArticles) {
            boolean containsKey = articlesMap.containsKey(existingArticle.getGroup());
            if (containsKey) {
                List<Article> groupArticles = articlesMap.get(existingArticle.getGroup());
                groupArticles.add(existingArticle);
            } else {
                articlesMap.put(existingArticle.getGroup(), new ArrayList<Article>());
                articlesMap.get(existingArticle.getGroup()).add(existingArticle);
            }
        }

        System.out.println(articlesMap);

        System.out.println(" Name  | Gruppe  | Preis");
        
        for (Map.Entry<Integer, List<Article>> entry :
        	articlesMap.entrySet()) {
            if (entry.getKey() == 0) {
                // nicht gruppieren
                for (Article article : entry.getValue()) {
                    System.out.println("  " + article.getName() + "   |    " + article.getGroup() + "    |  " + article.getPrice());
                }
            } else {
                // gruppieren
                String groupedName = "";
                double totalPrice = 0d;

                for (Article article : entry.getValue()) {
                    if (!groupedName.contains(article.getName())) {
                        groupedName = groupedName + ", " + article.getName();
                    }
                    totalPrice += article.getPrice();
                }
                
                System.out.println(groupedName.substring(2,	groupedName.length()) + " |    " + entry.getKey() + "    |  " + totalPrice);
            }
        }
    }
}
