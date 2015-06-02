package com.greenpixels.birdsofcostarica.db;

import android.database.Cursor;

import com.greenpixels.birdsofcostarica.models.Bird;
import com.squareup.sqlbrite.SqlBrite;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;

/**
 * Queries and access tables for the bird entiry
 *
 * @author PiXeL16
 * @date 5/27/15
 */
public class BirdDBManager {

    public static final String TABLE = "members";

    public static final String ID = "id";
    public static final String CREATED = "created";
    public static final String MODIFIED = "modified";
    public static final String DESCRIPTION = "description";
    public static final String ENGLISH_NAME = "english_name";
    public static final String SPANISH_NAME = "spanish_name";
    public static final String SCIENTIFIC_NAME = "scientific_name";
    public static final String STATUS = "status";
    public static final String THUMBNAIL = "thumbnail";
    public static final String MIN_ALTITUD = "min_altitud";
    public static final String MAX_ALTITUD = "max_altitud";
    public static final String SIZE = "size";
    public static final String DESCRIPTION_YEAR = "description_year";
    public static final String PAST_SCIENTIFIC_NAMES = "past_scientific_names";
    public static final String SEASONALITY_SPANISH = "seasonality_spanish";
    public static final String DIAGNOSTIC_DESCRIPTION_SPANISH = "diagnostic_description_spanish";
    public static final String RELATIONSHIPS_SPANISH = "relationships_spanish";
    public static final String DISTRIBUTION_COSTARICA_SPANISH = "distribution_costarica_spanish";
    public static final String DISTRIBUTION_OUTSIDE_COSTARICA_SPANISH = "distribution_outside_costarica_spanish";
    public static final String NEST_SPANISH = "nest_spanish";
    public static final String HABITAS_SPANISH = "habitas_spanish";
    public static final String FEEDING_HABITS_SPANISH = "feeding_habits_spanish";
    public static final String CONSERVATION_AREAS_DISTRIBUTION_SPANISH = "conservation_areas_distribution_spanish";
    public static final String BEHAVIOR_SPANISH = "behavior_spanish";
    public static final String MYTHS_SPANISH = "myths_spanish";
    public static final String CONSERVATION_STATUS = "conservation_status";
    public static final String AUTHOR_TAX = "author_tax";
    public static final String TERRITORY_SPANISH = "territory_spanish";

    public static String QUERY = ""
            + "SELECT *"
            + " FROM " + TABLE;



    public static final Func1<SqlBrite.Query, List<Bird>> MAP = new Func1<SqlBrite.Query, List<Bird>>() {
        @Override public List<Bird> call(SqlBrite.Query query) {
            Cursor cursor = query.run();
            try {
                List<Bird> values = new ArrayList<>(cursor.getCount());
                while (cursor.moveToNext()) {
                    long id = DBUtil.getLong(cursor, ID);
                    String description = DBUtil.getString(cursor, DESCRIPTION);
                    String english_name = DBUtil.getString(cursor,ENGLISH_NAME);
                    String scientific_name = DBUtil.getString(cursor,SCIENTIFIC_NAME);

                    //TODO: Add the rest of the fields

                    Bird bird = new Bird();
                    bird.setId(id);
                    bird.setDescription(description);
                    bird.setEnglishName(english_name);
                    bird.setScientificName(scientific_name);

                    values.add(bird);
                }
                return values;
            } finally {
                cursor.close();
            }
        }
    };
}
