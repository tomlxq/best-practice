package pizzs_store_annotation;

import pizzs_store.Meal;

/**
 * Created by tom on 2016/6/6.
 */
@Factory(
        id = "Margherita",
        type = Meal.class
)
public class MargheritaPizza implements Meal {

    @Override
    public float getPrice() {
        return 6f;
    }
}