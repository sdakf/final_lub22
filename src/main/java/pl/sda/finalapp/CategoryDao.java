package pl.sda.finalapp;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CategoryDao {//Dao- Data Access Object

    private CategoryDao() {
    }

    private static CategoryDao INSTANCE;

    public static CategoryDao getInstance() {
        if (INSTANCE == null) {
            synchronized (CategoryDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CategoryDao();
                }
            }
        }
        return INSTANCE;
    }

    private void populateCategories(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource("kategorie.txt");
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(resource.toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            lines = Collections.EMPTY_LIST;
        }
        List<Category> categories = lines.stream()
                .map(x -> Category.createFromText(x))
                .collect(Collectors.toList());
        Map<Integer, List<Category>> categoriesMap = new HashMap<>();
        for (Category category : categories) {
            List<Category> innerList = new ArrayList<>();
            innerList.add(category);
            categoriesMap.put(category.getDepth(), innerList);
        }
    }


}
