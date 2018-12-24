package com.udacity.sandwichclub.utils;

import android.nfc.Tag;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class JsonUtils {
    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwich = new JSONObject(json);
            JSONObject nameSandwich = sandwich.getJSONObject("name");
            String mainNameSandwich = nameSandwich.getString("mainName");
            JSONArray alsoKnownAsSandwich = nameSandwich.getJSONArray("alsoKnownAs");
            String placeOfOriginSandwich = sandwich.getString("placeOfOrigin");
            String descriptionSandwich = sandwich.getString("description");
            String imageSandwich = sandwich.getString("image");
            JSONArray ingredientsSandwich = sandwich.getJSONArray("ingredients");

            List<String> alsoKnownAsArray = getJSONArray(alsoKnownAsSandwich);
            List<String> ingredientsArray = getJSONArray(ingredientsSandwich);

            Sandwich sandwichModel = new Sandwich();
            sandwichModel.setMainName(mainNameSandwich);
            sandwichModel.setPlaceOfOrigin(placeOfOriginSandwich);
            sandwichModel.setDescription(descriptionSandwich);
            sandwichModel.setImage(imageSandwich);
            sandwichModel.setAlsoKnownAs(alsoKnownAsArray);
            sandwichModel.setIngredients(ingredientsArray);

            return sandwichModel;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getJSONArray (JSONArray list){

        ArrayList<String> Item = new ArrayList<>();
        if (list != null){
            for (int i = 0 ; i < list.length();i++){
                try {
                    Item.add(list.get(i).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return Item;
    }
}
