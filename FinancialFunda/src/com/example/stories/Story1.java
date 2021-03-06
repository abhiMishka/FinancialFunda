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
import android.widget.Toast;

import com.example.aaa.R;
import com.example.financialfunda.StartScreen;
import com.imagezoom.ImageAttacher;
import com.imagezoom.ImageAttacher.OnMatrixChangedListener;
import com.imagezoom.ImageAttacher.OnPhotoTapListener;

public class Story1 extends Activity{
 
   float x1,x2;
	float y1,y2;

	int width1 ;
	int height1 ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page1);
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		getIntent();
		
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		
		height1 = metrics.heightPixels;
		width1 = metrics.widthPixels;
		
		myBitmap = decodeSampledBitmapFromResource(getResources(), R.drawable.im1, height1, width1 );
		
		
		
		
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	String newName = "";
	int i = 1;
	Bitmap myBitmap;
	 
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	   
	    BitmapFactory.decodeResource(res, resId, options);

	    
	    // Calculate inSampleSize
	    options.inSampleSize = 2;

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	    
	    
		
	}
	
	@Override
	public void onBackPressed()
	{
	    super.onBackPressed(); 
	    startActivity(new Intent(Story1.this, StartScreen.class));
	    finish();

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
 		if(i>17)
 			{
 			i = 17;
 			return;
 			}
 		
 		myBitmap.recycle();
 		newName = "im" + i;
 		
 		int resId = getResources().getIdentifier(newName, "drawable", getPackageName());
 	    
 	    myBitmap = decodeSampledBitmapFromResource(getResources(), resId, width1, height1);
 	    image.setImageBitmap(myBitmap);
 	    
 	   usingSimpleImage(image);
 	    
    }
    
    public void prev(View v)
    {
    	ImageView image = (ImageView) findViewById(R.id.imageView1);
    	i--;
 		if(i <1)
 			{
 			i =1;
 			Intent myIntent = new Intent(Story1.this, StartScreen.class);
				Story1.this.startActivity(myIntent);
 			}
 		
 		myBitmap.recycle();
    	
 		newName = "im" + i;
 		int resId = getResources().getIdentifier(newName, "drawable", getPackageName());
 		
 		myBitmap = decodeSampledBitmapFromResource(getResources(), resId, width1, height1);
 	    image.setImageBitmap(myBitmap);

 	   usingSimpleImage(image);
    }

}
