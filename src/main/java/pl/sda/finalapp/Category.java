package pl.sda.finalapp;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
public class Category {

    private String categoryName;
    private Integer id;
    private Integer parentId;
    private Integer depth;
    private static Integer counter = 0;

    public static Category createFromText(String text){
        Category category = new Category();
        category.categoryName = text;
        category.id = ++counter;
        category.depth = text.split("\\S+")[0].length();
        return category;
    }



}
