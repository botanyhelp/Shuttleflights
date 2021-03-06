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

import android.app.ListActivity;
import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.net.Uri;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.util.Log;

public class Flight extends ListActivity {
	static final String TAG = "FLIGHTS";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    displayListView();
	}
	
	private void displayListView() {
        //Log.w(TAG, "In Flight.displayListView(), about to make flightList");
		List<String> flightList = new ArrayList<String>();
        flightList.add("STS_1");
        flightList.add("STS_2");
        flightList.add("STS_3");
        flightList.add("STS_4");
        flightList.add("STS_5");
        flightList.add("STS_6");
        flightList.add("STS_7");
        flightList.add("STS_8");
        flightList.add("STS_9");
        flightList.add("STS_41_B");
        flightList.add("STS_41_C");
        flightList.add("STS_41_D");
        flightList.add("STS_41_G");
        flightList.add("STS_51_A");
        flightList.add("STS_51_C");
        flightList.add("STS_51_D");
        flightList.add("STS_51_B");
        flightList.add("STS_51_G");
        flightList.add("STS_51_F");
        flightList.add("STS_51_I");
        flightList.add("STS_51_J");
        flightList.add("STS_61_A");
        flightList.add("STS_61_B");
        flightList.add("STS_61_C");
        flightList.add("STS_51_L");
        flightList.add("STS_26");
        flightList.add("STS_27");
        flightList.add("STS_29");
        flightList.add("STS_30");
        flightList.add("STS_28");
        flightList.add("STS_34");
        flightList.add("STS_33");
        flightList.add("STS_32");
        flightList.add("STS_36");
        flightList.add("STS_31");
        flightList.add("STS_41");
        flightList.add("STS_38");
        flightList.add("STS_35");
        flightList.add("STS_37");
        flightList.add("STS_39");
        flightList.add("STS_40");
        flightList.add("STS_43");
        flightList.add("STS_48");
        flightList.add("STS_44");
        flightList.add("STS_42");
        flightList.add("STS_45");
        flightList.add("STS_49");
        flightList.add("STS_50");
        flightList.add("STS_46");
        flightList.add("STS_47");
        flightList.add("STS_52");
        flightList.add("STS_53");
        flightList.add("STS_54");
        flightList.add("STS_56");
        flightList.add("STS_55");
        flightList.add("STS_57");
        flightList.add("STS_51");
        flightList.add("STS_58");
        flightList.add("STS_61");
        flightList.add("STS_60");
        flightList.add("STS_62");
        flightList.add("STS_59");
        flightList.add("STS_65");
        flightList.add("STS_64");
        flightList.add("STS_68");
        flightList.add("STS_66");
        flightList.add("STS_63");
        flightList.add("STS_67");
        flightList.add("STS_71");
        flightList.add("STS_70");
        flightList.add("STS_69");
        flightList.add("STS_73");
        flightList.add("STS_74");
        flightList.add("STS_72");
        flightList.add("STS_75");
        flightList.add("STS_76");
        flightList.add("STS_77");
        flightList.add("STS_78");
        flightList.add("STS_79");
        flightList.add("STS_80");
        flightList.add("STS_81");
        flightList.add("STS_82");
        flightList.add("STS_83");
        flightList.add("STS_84");
        flightList.add("STS_94");
        flightList.add("STS_85");
        flightList.add("STS_86");
        flightList.add("STS_87");
        flightList.add("STS_89");
        flightList.add("STS_90");
        flightList.add("STS_91");
        flightList.add("STS_95");
        flightList.add("STS_88");
        flightList.add("STS_96");
        flightList.add("STS_93");
        flightList.add("STS_103");
        flightList.add("STS_99");
        flightList.add("STS_101");
        flightList.add("STS_106");
        flightList.add("STS_92");
        flightList.add("STS_97");
        flightList.add("STS_98");
        flightList.add("STS_102");
        flightList.add("STS_100");
        flightList.add("STS_104");
        flightList.add("STS_105");
        flightList.add("STS_108");
        flightList.add("STS_109");
        flightList.add("STS_110");
        flightList.add("STS_111");
        flightList.add("STS_112");
        flightList.add("STS_113");
        flightList.add("STS_107");
        flightList.add("STS_114");
        flightList.add("STS_121");
        flightList.add("STS_115");
        flightList.add("STS_116");
        flightList.add("STS_117");
        flightList.add("STS_118");
        flightList.add("STS_120");
        flightList.add("STS_122");
        flightList.add("STS_123");
        flightList.add("STS_124");
        flightList.add("STS_126");
        flightList.add("STS_119");
        flightList.add("STS_125");
        flightList.add("STS_127");
        flightList.add("STS_128");
        flightList.add("STS_129");
        flightList.add("STS_130");
        flightList.add("STS_131");
        flightList.add("STS_132");
        flightList.add("STS_133");
        flightList.add("STS_134");
        flightList.add("STS_135");
        flightList.add("INFO");
        //Log.w(TAG, "In Flight.displayListView(), made flightList");
        
        // create an ArrayAdaptar from String Array
 		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.shuttletextview, flightList);
 		setListAdapter(dataAdapter);
 		ListView listView = getListView();
 		// filtering ListView
 		listView.setTextFilterEnabled(true);
 		listView.setOnItemClickListener(new OnItemClickListener() {
 			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
 				//Log.w(TAG, "In Flight.displayListView().listView.setOnItemClickListener().onItemClick()");
 				Intent i = new Intent("");
 				String flightChoice = ((TextView) view).getText().toString();			
 				i.setData(Uri.parse(flightChoice));
 				setResult(RESULT_OK, i);
 				finish();
 			}
 		});
 	}
}
