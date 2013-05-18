package edu.skaggs.ela;

import org.sketchel.Molecule;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
DemoView dm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dm = new DemoView(this);
		setContentView(dm);
		
	

	}
	private class DemoView extends View{
		public DemoView(Context context){
			super(context);
		}

		@Override protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			Paint p = new Paint();
		
			p.setStyle(Paint.Style.FILL);
			p.setColor(Color.WHITE);
			canvas.drawPaint(p);
			
			p.setColor(Color.BLACK);
			DashPathEffect dashPath =
                    new DashPathEffect(new float[]{20,5}, 1);
	p.setPathEffect(dashPath);
	//p.setStrokeWidth(8);
	//canvas.drawLine(0, 300 , 320, 300, p);

			Paint p2 = new Paint();
			//canvas.drawLine(0, 0, 80, 80, p2);
			p2.setColor(Color.BLACK); 
			p2.setTextSize(20); 
			
		
			Molecule mol=new Molecule();
			mol.addAtom("N",0,0);
			mol.addAtom("C",1.2,0);
			mol.addAtom("O",2,0.8);
			mol.addAtom("H",3,-0.8);
			mol.addAtom("H",4,0);
			mol.addBond(1,2,1);
			mol.addBond(2,3,2);
			mol.addBond(3,4,1);
			mol.addBond(4,5,0);
			DrawMolecule dr = new DrawMolecule(mol, canvas, 50);
			dr.draw();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
