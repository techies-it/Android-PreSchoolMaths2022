package techies.it.preschoolmaths.utils;

import android.content.Context;

/**
 * Created by Compaq123 on 19-Apr-16.
 */
public class HelperFunction
{

    public static int convertPixelIntoDP(Context context, int pixel)
    {
        float density = context.getResources().getDisplayMetrics().density;
        int densityPixel = (int) (pixel * density);

        return densityPixel;
    }

    public static int convertDPIntoPixel(Context context, int densityPixel)
    {
        float density = context.getResources().getDisplayMetrics().density;
        int pixel = (int) (densityPixel / density);

        return pixel;
    }

}
