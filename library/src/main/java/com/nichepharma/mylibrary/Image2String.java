package com.nichepharma.mylibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by admin on 12/9/15.
 */
public class Image2String {

    public Image2String() {

    }
    public Bitmap StringToImage(String base64String)
    {
        byte[] imageAsBytes = Base64.decode(base64String.getBytes(), Base64.DEFAULT);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Bitmap x= BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
        return x;
    }
    public String ImageToString(Bitmap image)
    {
        Bitmap immagex=image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }

}
