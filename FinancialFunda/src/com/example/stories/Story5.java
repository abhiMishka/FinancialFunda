package com.example.stories;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

import com.example.aaa.R;
import com.example.financialfunda.StartScreen;
import com.imagezoom.ImageAttacher;
import com.imagezoom.ImageAttacher.OnMatrixChangedListener;
import com.imagezoom.ImageAttacher.OnPhotoTapListener;

public class Story5 extends Activity {

	float x1,x2;
	float y1,y2;

	int width1 ;
	int height1 ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page5);

		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		getIntent();
		
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		height1 = height;
		width1 = width;
		
		myBitmap = decodeSampledBitmapFromResource(getResources(), R.drawable.im501, height1, width1 );
		
		
		
		final ImageView image = (ImageView) findViewById(R.id.imageView1);
		
		image.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
		    @Override
		    public void onGlobalLayout() {
		       image.setImageBitmap(myBitmap);
		       }
		});
	
		usingSimpleImage(image);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.page5, menu);
		return true;
	}
	
	String newName = "";
	int i = 1;
	Bitmap myBitmap;
	
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    
	    // Calculate inSampleSize
	    options.inSampleSize = 2;//calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	
	}
	
	@Override
	public void onBackPressed()
	{
	    super.onBackPressed(); 
	    startActivity(new Intent(Story5.this, StartScreen.class));
	    finish();

	}

	
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    
    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;
        
        
        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}

    public void usingSimpleImage(ImageView imageView) {
    	
    	System.out.println(imageView.getHeight());
        ImageAttacher mAttacher = new ImageAttacher(imageView);
        ImageAttacher.MAX_ZOOM = 2.0f; // Double the current Size
        ImageAttacher.MIN_ZOOM = 0.5f; // Half the current Size
        MatrixChangeListener mMaListener = new MatrixChangeListener();
        mAttacher.setOnMatrixChangeListener(mMaListener);
        PhotoTapListener mPhotoTap = new PhotoTapListener();
        mAttacher.setOnPhotoTapListener(mPhotoTap);
        
        
    }

    private class PhotoTapListener implements OnPhotoTapListener {

        @Override
        public void onPhotoTap(View view, float x, float y) {
        }
    }

    private class MatrixChangeListener implements OnMatrixChangedListener {

        @Override
        public void onMatrixChanged(RectF rect) {

        }
    } 

	public void next(View v)
	    {
	    	ImageView image = (ImageView) findViewById(R.id.imageView1);
	    	
	    	i++;
     		if(i >=10)
     		{
     			if(i > 20)
     				{
     				i =20;
     				return;
     				}
     			
     			newName = "im5" + i;
     		}
     		
     		else
     		newName = "im50" + i;
	 		int resId = getResources().getIdentifier(newName, "drawable", getPackageName());
	 	    
	 	    myBitmap = decodeSampledBitmapFromResource(getResources(), resId, width1, height1);
	 	    image.setImageBitmap(myBitmap);
	 	    
	 	   usingSimpleImage(image);
	 	    
	    }
	    
	public void prev(View v)
	    {
	    	ImageView image = (ImageView) findViewById(R.id.imageView1);
	    	i--;
     		if(i <10)
     		{
     			if(i < 1)
     				{
     				i =1;
     				Intent myIntent = new Intent(Story5.this, StartScreen.class);
     				Story5.this.startActivity(myIntent);
     				}
     			
     			newName = "im50" + i;
     		}
     		
     		else
     		newName = "im5" + i;
     		myBitmap.recycle();
	    	
	 		int resId = getResources().getIdentifier(newName, "drawable", getPackageName());
	 		
	 		myBitmap = decodeSampledBitmapFromResource(getResources(), resId, width1, height1);
	 	    image.setImageBitmap(myBitmap);

	 	   usingSimpleImage(image);
	    }

}
