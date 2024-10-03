package com.template.api_for_template_angular.infra.utils;

import java.util.Base64;

public class Base64Utils {
    public static int calculateBase64SizeInBytes(String base64String) {
        if (base64String.startsWith("data:")) {
            int base64Index = base64String.indexOf("base64,") + 7;
            base64String = base64String.substring(base64Index);
        }

        byte[] decodedBytes = Base64.getDecoder().decode(base64String);

        return decodedBytes.length;
    }
}
