package org.example;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {

    public static boolean compareJsons(String expectedJson, String actualJson) {
        try {
            JSONObject expected = new JSONObject(expectedJson);
            JSONObject actual = new JSONObject(actualJson);
            return compareJsonObject(expected, actual);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean compareJsonObject(JSONObject expected, JSONObject actual) {
        boolean result = true;

        for (String key : expected.keySet()) {
            if (key.equals("ignore")) {
                // Si la clave es "ignore" en el objeto esperado, la ignoramos.
                continue;
            }

            if (!actual.has(key)) {
                System.out.println("El atributo '" + key + "' no existe en el objeto actual.");
                result = false;
            } else {
                Object expectedValue = expected.get(key);
                Object actualValue = actual.get(key);

                if (!expectedValue.equals(actualValue)) {
                    System.out.println("Diferencia en el atributo '" + key + "':");
                    System.out.println("   Valor esperado: " + expectedValue);
                    System.out.println("   Valor actual: " + actualValue);
                    result = false;
                }
            }
        }

        return result;
    }
}