package pizzs_store_annotation;

import pizzs_store.Meal;

/**
 * Created by tom on 2016/6/6.
 */
@Factory(
        id = "Calzone",
        type = Meal.class
)
public class CalzonePizza implements Meal {

    @Override public float getPrice() {
        return 8.5f;
    }
}