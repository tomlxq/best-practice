package pizzs_store_annotation;

import pizzs_store.Meal;

/**
 * Created by tom on 2016/6/6.
 */
@Factory(
        id = "Tiramisu",
        type = Meal.class
)
public class TiramisuPizza implements Meal {
    @Override public float getPrice() {
        return 4.5f;
    }
}
