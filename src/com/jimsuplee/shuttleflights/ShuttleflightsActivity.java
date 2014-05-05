/**Copyright (C) 2013 Thomas Maher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.jimsuplee.shuttleflights;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Button;

//This sometimes dodges a bug ala stackoverflow.com/questions/6251319/extract-text-between-link-tags-in-python-using-beautifulsoup+&cd=1&hl=en&ct=clnk&gl=us
//import com.jimsuplee.shuttleflights.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.Toast;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.Map;

public class ShuttleflightsActivity extends Activity {
	static final String TAG = "FLIGHTS";
	HashMap<String,Integer> flightMap = new HashMap<String,Integer>();
	HashMap<String,Integer> photoMap = new HashMap<String,Integer>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		photoMap.put("STS_1", R.drawable.sts_1);
	    photoMap.put("STS_2", R.drawable.sts_2);
	    photoMap.put("STS_3", R.drawable.sts_3);
	    photoMap.put("STS_4", R.drawable.sts_4);
	    photoMap.put("STS_5", R.drawable.sts_5);
	    photoMap.put("STS_6", R.drawable.sts_6);
	    photoMap.put("STS_7", R.drawable.sts_7);
	    photoMap.put("STS_8", R.drawable.sts_8);
	    photoMap.put("STS_9", R.drawable.sts_9);
	    photoMap.put("STS_41_B", R.drawable.sts_41_b);
	    photoMap.put("STS_41_C", R.drawable.sts_41_c);
	    photoMap.put("STS_41_D", R.drawable.sts_41_d);
	    photoMap.put("STS_41_G", R.drawable.sts_41_g);
	    photoMap.put("STS_51_A", R.drawable.sts_51_a);
	    photoMap.put("STS_51_C", R.drawable.sts_51_c);
	    photoMap.put("STS_51_D", R.drawable.sts_51_d);
	    photoMap.put("STS_51_B", R.drawable.sts_51_b);
	    photoMap.put("STS_51_G", R.drawable.sts_51_g);
	    photoMap.put("STS_51_F", R.drawable.sts_51_f);
	    photoMap.put("STS_51_I", R.drawable.sts_51_i);
	    photoMap.put("STS_51_J", R.drawable.sts_51_j);
	    photoMap.put("STS_61_A", R.drawable.sts_61_a);
	    photoMap.put("STS_61_B", R.drawable.sts_61_b);
	    photoMap.put("STS_61_C", R.drawable.sts_61_c);
	    photoMap.put("STS_51_L", R.drawable.sts_51_l);
	    photoMap.put("STS_26", R.drawable.sts_26);
	    photoMap.put("STS_27", R.drawable.sts_27);
	    photoMap.put("STS_29", R.drawable.sts_29);
	    photoMap.put("STS_30", R.drawable.sts_30);
	    photoMap.put("STS_28", R.drawable.sts_28);
	    photoMap.put("STS_34", R.drawable.sts_34);
	    photoMap.put("STS_33", R.drawable.sts_33);
	    photoMap.put("STS_32", R.drawable.sts_32);
	    photoMap.put("STS_36", R.drawable.sts_36);
	    photoMap.put("STS_31", R.drawable.sts_31);
	    photoMap.put("STS_41", R.drawable.sts_41);
	    photoMap.put("STS_38", R.drawable.sts_38);
	    photoMap.put("STS_35", R.drawable.sts_35);
	    photoMap.put("STS_37", R.drawable.sts_37);
	    photoMap.put("STS_39", R.drawable.sts_39);
	    photoMap.put("STS_40", R.drawable.sts_40);
	    photoMap.put("STS_43", R.drawable.sts_43);
	    photoMap.put("STS_48", R.drawable.sts_48);
	    photoMap.put("STS_44", R.drawable.sts_44);
	    photoMap.put("STS_42", R.drawable.sts_42);
	    photoMap.put("STS_45", R.drawable.sts_45);
	    photoMap.put("STS_49", R.drawable.sts_49);
	    photoMap.put("STS_50", R.drawable.sts_50);
	    photoMap.put("STS_46", R.drawable.sts_46);
	    photoMap.put("STS_47", R.drawable.sts_47);
	    photoMap.put("STS_52", R.drawable.sts_52);
	    photoMap.put("STS_53", R.drawable.sts_53);
	    photoMap.put("STS_54", R.drawable.sts_54);
	    photoMap.put("STS_56", R.drawable.sts_56);
	    photoMap.put("STS_55", R.drawable.sts_55);
	    photoMap.put("STS_57", R.drawable.sts_57);
	    photoMap.put("STS_51", R.drawable.sts_51);
	    photoMap.put("STS_58", R.drawable.sts_58);
	    photoMap.put("STS_61", R.drawable.sts_61);
	    photoMap.put("STS_60", R.drawable.sts_60);
	    photoMap.put("STS_62", R.drawable.sts_62);
	    photoMap.put("STS_59", R.drawable.sts_59);
	    photoMap.put("STS_65", R.drawable.sts_65);
	    photoMap.put("STS_64", R.drawable.sts_64);
	    photoMap.put("STS_68", R.drawable.sts_68);
	    photoMap.put("STS_66", R.drawable.sts_66);
	    photoMap.put("STS_63", R.drawable.sts_63);
	    photoMap.put("STS_67", R.drawable.sts_67);
	    photoMap.put("STS_71", R.drawable.sts_71);
	    photoMap.put("STS_70", R.drawable.sts_70);
	    photoMap.put("STS_69", R.drawable.sts_69);
	    photoMap.put("STS_73", R.drawable.sts_73);
	    photoMap.put("STS_74", R.drawable.sts_74);
	    photoMap.put("STS_72", R.drawable.sts_72);
	    photoMap.put("STS_75", R.drawable.sts_75);
	    photoMap.put("STS_76", R.drawable.sts_76);
	    photoMap.put("STS_77", R.drawable.sts_77);
	    photoMap.put("STS_78", R.drawable.sts_78);
	    photoMap.put("STS_79", R.drawable.sts_79);
	    photoMap.put("STS_80", R.drawable.sts_80);
	    photoMap.put("STS_81", R.drawable.sts_81);
	    photoMap.put("STS_82", R.drawable.sts_82);
	    photoMap.put("STS_83", R.drawable.sts_83);
	    photoMap.put("STS_84", R.drawable.sts_84);
	    photoMap.put("STS_94", R.drawable.sts_94);
	    photoMap.put("STS_85", R.drawable.sts_85);
	    photoMap.put("STS_86", R.drawable.sts_86);
	    photoMap.put("STS_87", R.drawable.sts_87);
	    photoMap.put("STS_89", R.drawable.sts_89);
	    photoMap.put("STS_90", R.drawable.sts_90);
	    photoMap.put("STS_91", R.drawable.sts_91);
	    photoMap.put("STS_95", R.drawable.sts_95);
	    photoMap.put("STS_88", R.drawable.sts_88);
	    photoMap.put("STS_96", R.drawable.sts_96);
	    photoMap.put("STS_93", R.drawable.sts_93);
	    photoMap.put("STS_103", R.drawable.sts_103);
	    photoMap.put("STS_99", R.drawable.sts_99);
	    photoMap.put("STS_101", R.drawable.sts_101);
	    photoMap.put("STS_106", R.drawable.sts_106);
	    photoMap.put("STS_92", R.drawable.sts_92);
	    photoMap.put("STS_97", R.drawable.sts_97);
	    photoMap.put("STS_98", R.drawable.sts_98);
	    photoMap.put("STS_102", R.drawable.sts_102);
	    photoMap.put("STS_100", R.drawable.sts_100);
	    photoMap.put("STS_104", R.drawable.sts_104);
	    photoMap.put("STS_105", R.drawable.sts_105);
	    photoMap.put("STS_108", R.drawable.sts_108);
	    photoMap.put("STS_109", R.drawable.sts_109);
	    photoMap.put("STS_110", R.drawable.sts_110);
	    photoMap.put("STS_111", R.drawable.sts_111);
	    photoMap.put("STS_112", R.drawable.sts_112);
	    photoMap.put("STS_113", R.drawable.sts_113);
	    photoMap.put("STS_107", R.drawable.sts_107);
	    photoMap.put("STS_114", R.drawable.sts_114);
	    photoMap.put("STS_121", R.drawable.sts_121);
	    photoMap.put("STS_115", R.drawable.sts_115);
	    photoMap.put("STS_116", R.drawable.sts_116);
	    photoMap.put("STS_117", R.drawable.sts_117);
	    photoMap.put("STS_118", R.drawable.sts_118);
	    photoMap.put("STS_120", R.drawable.sts_120);
	    photoMap.put("STS_122", R.drawable.sts_122);
	    photoMap.put("STS_123", R.drawable.sts_123);
	    photoMap.put("STS_124", R.drawable.sts_124);
	    photoMap.put("STS_126", R.drawable.sts_126);
	    photoMap.put("STS_119", R.drawable.sts_119);
	    photoMap.put("STS_125", R.drawable.sts_125);
	    photoMap.put("STS_127", R.drawable.sts_127);
	    photoMap.put("STS_128", R.drawable.sts_128);
	    photoMap.put("STS_129", R.drawable.sts_129);
	    photoMap.put("STS_130", R.drawable.sts_130);
	    photoMap.put("STS_131", R.drawable.sts_131);
	    photoMap.put("STS_132", R.drawable.sts_132);
	    photoMap.put("STS_133", R.drawable.sts_133);
	    photoMap.put("STS_134", R.drawable.sts_134);
	    photoMap.put("STS_135", R.drawable.sts_135);
	    photoMap.put("INFO", R.drawable.shuttle27);
		
	    flightMap.put("STS_1", R.string.STS_1);
	    flightMap.put("STS_2", R.string.STS_2);
	    flightMap.put("STS_3", R.string.STS_3);
	    flightMap.put("STS_4", R.string.STS_4);
	    flightMap.put("STS_5", R.string.STS_5);
	    flightMap.put("STS_6", R.string.STS_6);
	    flightMap.put("STS_7", R.string.STS_7);
	    flightMap.put("STS_8", R.string.STS_8);
	    flightMap.put("STS_9", R.string.STS_9);
	    flightMap.put("STS_41_B", R.string.STS_41_B);
	    flightMap.put("STS_41_C", R.string.STS_41_C);
	    flightMap.put("STS_41_D", R.string.STS_41_D);
	    flightMap.put("STS_41_G", R.string.STS_41_G);
	    flightMap.put("STS_51_A", R.string.STS_51_A);
	    flightMap.put("STS_51_C", R.string.STS_51_C);
	    flightMap.put("STS_51_D", R.string.STS_51_D);
	    flightMap.put("STS_51_B", R.string.STS_51_B);
	    flightMap.put("STS_51_G", R.string.STS_51_G);
	    flightMap.put("STS_51_F", R.string.STS_51_F);
	    flightMap.put("STS_51_I", R.string.STS_51_I);
	    flightMap.put("STS_51_J", R.string.STS_51_J);
	    flightMap.put("STS_61_A", R.string.STS_61_A);
	    flightMap.put("STS_61_B", R.string.STS_61_B);
	    flightMap.put("STS_61_C", R.string.STS_61_C);
	    flightMap.put("STS_51_L", R.string.STS_51_L);
	    flightMap.put("STS_26", R.string.STS_26);
	    flightMap.put("STS_27", R.string.STS_27);
	    flightMap.put("STS_29", R.string.STS_29);
	    flightMap.put("STS_30", R.string.STS_30);
	    flightMap.put("STS_28", R.string.STS_28);
	    flightMap.put("STS_34", R.string.STS_34);
	    flightMap.put("STS_33", R.string.STS_33);
	    flightMap.put("STS_32", R.string.STS_32);
	    flightMap.put("STS_36", R.string.STS_36);
	    flightMap.put("STS_31", R.string.STS_31);
	    flightMap.put("STS_41", R.string.STS_41);
	    flightMap.put("STS_38", R.string.STS_38);
	    flightMap.put("STS_35", R.string.STS_35);
	    flightMap.put("STS_37", R.string.STS_37);
	    flightMap.put("STS_39", R.string.STS_39);
	    flightMap.put("STS_40", R.string.STS_40);
	    flightMap.put("STS_43", R.string.STS_43);
	    flightMap.put("STS_48", R.string.STS_48);
	    flightMap.put("STS_44", R.string.STS_44);
	    flightMap.put("STS_42", R.string.STS_42);
	    flightMap.put("STS_45", R.string.STS_45);
	    flightMap.put("STS_49", R.string.STS_49);
	    flightMap.put("STS_50", R.string.STS_50);
	    flightMap.put("STS_46", R.string.STS_46);
	    flightMap.put("STS_47", R.string.STS_47);
	    flightMap.put("STS_52", R.string.STS_52);
	    flightMap.put("STS_53", R.string.STS_53);
	    flightMap.put("STS_54", R.string.STS_54);
	    flightMap.put("STS_56", R.string.STS_56);
	    flightMap.put("STS_55", R.string.STS_55);
	    flightMap.put("STS_57", R.string.STS_57);
	    flightMap.put("STS_51", R.string.STS_51);
	    flightMap.put("STS_58", R.string.STS_58);
	    flightMap.put("STS_61", R.string.STS_61);
	    flightMap.put("STS_60", R.string.STS_60);
	    flightMap.put("STS_62", R.string.STS_62);
	    flightMap.put("STS_59", R.string.STS_59);
	    flightMap.put("STS_65", R.string.STS_65);
	    flightMap.put("STS_64", R.string.STS_64);
	    flightMap.put("STS_68", R.string.STS_68);
	    flightMap.put("STS_66", R.string.STS_66);
	    flightMap.put("STS_63", R.string.STS_63);
	    flightMap.put("STS_67", R.string.STS_67);
	    flightMap.put("STS_71", R.string.STS_71);
	    flightMap.put("STS_70", R.string.STS_70);
	    flightMap.put("STS_69", R.string.STS_69);
	    flightMap.put("STS_73", R.string.STS_73);
	    flightMap.put("STS_74", R.string.STS_74);
	    flightMap.put("STS_72", R.string.STS_72);
	    flightMap.put("STS_75", R.string.STS_75);
	    flightMap.put("STS_76", R.string.STS_76);
	    flightMap.put("STS_77", R.string.STS_77);
	    flightMap.put("STS_78", R.string.STS_78);
	    flightMap.put("STS_79", R.string.STS_79);
	    flightMap.put("STS_80", R.string.STS_80);
	    flightMap.put("STS_81", R.string.STS_81);
	    flightMap.put("STS_82", R.string.STS_82);
	    flightMap.put("STS_83", R.string.STS_83);
	    flightMap.put("STS_84", R.string.STS_84);
	    flightMap.put("STS_94", R.string.STS_94);
	    flightMap.put("STS_85", R.string.STS_85);
	    flightMap.put("STS_86", R.string.STS_86);
	    flightMap.put("STS_87", R.string.STS_87);
	    flightMap.put("STS_89", R.string.STS_89);
	    flightMap.put("STS_90", R.string.STS_90);
	    flightMap.put("STS_91", R.string.STS_91);
	    flightMap.put("STS_95", R.string.STS_95);
	    flightMap.put("STS_88", R.string.STS_88);
	    flightMap.put("STS_96", R.string.STS_96);
	    flightMap.put("STS_93", R.string.STS_93);
	    flightMap.put("STS_103", R.string.STS_103);
	    flightMap.put("STS_99", R.string.STS_99);
	    flightMap.put("STS_101", R.string.STS_101);
	    flightMap.put("STS_106", R.string.STS_106);
	    flightMap.put("STS_92", R.string.STS_92);
	    flightMap.put("STS_97", R.string.STS_97);
	    flightMap.put("STS_98", R.string.STS_98);
	    flightMap.put("STS_102", R.string.STS_102);
	    flightMap.put("STS_100", R.string.STS_100);
	    flightMap.put("STS_104", R.string.STS_104);
	    flightMap.put("STS_105", R.string.STS_105);
	    flightMap.put("STS_108", R.string.STS_108);
	    flightMap.put("STS_109", R.string.STS_109);
	    flightMap.put("STS_110", R.string.STS_110);
	    flightMap.put("STS_111", R.string.STS_111);
	    flightMap.put("STS_112", R.string.STS_112);
	    flightMap.put("STS_113", R.string.STS_113);
	    flightMap.put("STS_107", R.string.STS_107);
	    flightMap.put("STS_114", R.string.STS_114);
	    flightMap.put("STS_121", R.string.STS_121);
	    flightMap.put("STS_115", R.string.STS_115);
	    flightMap.put("STS_116", R.string.STS_116);
	    flightMap.put("STS_117", R.string.STS_117);
	    flightMap.put("STS_118", R.string.STS_118);
	    flightMap.put("STS_120", R.string.STS_120);
	    flightMap.put("STS_122", R.string.STS_122);
	    flightMap.put("STS_123", R.string.STS_123);
	    flightMap.put("STS_124", R.string.STS_124);
	    flightMap.put("STS_126", R.string.STS_126);
	    flightMap.put("STS_119", R.string.STS_119);
	    flightMap.put("STS_125", R.string.STS_125);
	    flightMap.put("STS_127", R.string.STS_127);
	    flightMap.put("STS_128", R.string.STS_128);
	    flightMap.put("STS_129", R.string.STS_129);
	    flightMap.put("STS_130", R.string.STS_130);
	    flightMap.put("STS_131", R.string.STS_131);
	    flightMap.put("STS_132", R.string.STS_132);
	    flightMap.put("STS_133", R.string.STS_133);
	    flightMap.put("STS_134", R.string.STS_134);
	    flightMap.put("STS_135", R.string.STS_135);
	    flightMap.put("INFO", R.string.INFO);
	    //Log.w(TAG, "In Shuttleflights.onCreate(), about to setContentView():");
	    setContentView(R.layout.activity_shuttleflights);
	}
	
	public void onClickFlight(View view) {
		//Log.w(TAG, "In Shuttleflights.onClickFlight()");
		Intent iFlight = new Intent("com.jimsuplee.shuttleflights.Flight");
		startActivityForResult(iFlight, 0);
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// ---check if the request code is 0 1 2 3 4 5---
		//Log.w(TAG, "In Shuttleflights.onActivityResult(), checking reqCod");
		// onClickLocation startActivityForResult section
		if (requestCode == 0) {
			//Log.w(TAG, "In Shuttleflights.onActivityResult(int-reqCode=0,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				String flight = data.getData().toString();
				TextView tv = (TextView) findViewById(R.id.txt_Shuttleflightsdata);
				tv.setVisibility(View.VISIBLE);
				tv.setText(flightMap.get(flight));
				ImageView iv = (ImageView) findViewById(R.id.imagedetail);
				iv.setImageResource(photoMap.get(flight));
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.shuttleflights, menu);
		return true;
	}

}
