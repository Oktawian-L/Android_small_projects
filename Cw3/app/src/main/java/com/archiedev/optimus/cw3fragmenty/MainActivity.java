package com.archiedev.optimus.cw3fragmenty;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment1.OnWyborOpcjiListener{
    Fragment11 f11;
    Fragment12 f12;
    Values1 v1;
    Values2 v2;
    static Boolean pressed = false;
    FragmentTransaction transakcja;
    Bundle bundle = new Bundle();



    private static final String TAG_F11 = "Fragment11";
    private static final String TAG_F12 = "Fragment12";
    private static final String TAG_V1 = "Values1";
    private static final String TAG_V2 = "Values2";
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        return false;
    }

    public void addList1(View v) {
        EditText editText = (EditText) findViewById(R.id.List1EditText);
        EditText editText2 = (EditText) findViewById(R.id.List1EditText2);
        SeekBar seekBar = (SeekBar) findViewById(R.id.List1SeekBar);

        bundle.putString("name", editText2.getText().toString());
        bundle.putInt("age", Integer.parseInt(editText.getText().toString()));
        bundle.putInt("priority", Integer.parseInt(String.valueOf(seekBar.getProgress() + 1)));
        bundle.putInt("getThirdData", 1);
        bundle.putInt("getThirdData2", 0);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), bundle);
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        //bundle.putString("params", "My String data");
        mViewPager.setCurrentItem(1);
    }

    public void addList2(View v) {
        pressed = true;
        EditText List2EditText = (EditText) findViewById(R.id.List2EditText);
        EditText List2EditText2 = (EditText) findViewById(R.id.List2EditText2);
        SeekBar List2SeekBar = (SeekBar) findViewById(R.id.List2SeekBar);
        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.opcjeData);
        int id = radioGroup.getCheckedRadioButtonId();
        char gatunekValue = 'N';
        switch (id) {
            case R.id.petRadioButton: gatunekValue = 'P';
                break;
            case R.id.petRadioButton2: gatunekValue = 'K';
                break;
            default:
                break;
        }
        bundle.putString("name2", List2EditText2.getText().toString());
        bundle.putInt("age2", Integer.parseInt(List2EditText.getText().toString()));
        bundle.putInt("priority2", Integer.parseInt(String.valueOf(List2SeekBar.getProgress() + 1)));
        bundle.putChar("gatunek", gatunekValue);
        bundle.putInt("getThirdData", 0);
        bundle.putInt("getThirdData2", 1);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), bundle);
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        //bundle.putString("params", "My String data");
        mViewPager.setCurrentItem(2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            v1 = new Values1();
            v2 = new Values2();
            f12 = new Fragment12();
            transakcja = getSupportFragmentManager().beginTransaction();
            transakcja.add(R.id.kontener, v1, TAG_V1);
            transakcja.detach(v1);
            transakcja.add(R.id.kontener, v2, TAG_V2);
            transakcja.detach(v2);
            transakcja.commit();
        }
        else {
            v1=(Values1) getSupportFragmentManager().findFragmentByTag(TAG_V1);
            v2=(Values2) getSupportFragmentManager().findFragmentByTag(TAG_V2);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), bundle);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onWyborOpcji(int opcja) {

        FragmentTransaction transakcja =
                getSupportFragmentManager().beginTransaction();

        switch (opcja) {
            case 1:
                transakcja.detach(v2);
                transakcja.attach(v1);
                break;
            case 2:
                transakcja.detach(v1);
                transakcja.attach(v2);
                break;
            default:
                break;
        }

        transakcja.commit();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final Bundle fragmentBundle;

        public SectionsPagerAdapter(FragmentManager fm, Bundle data) {
            super(fm);
            fragmentBundle = data;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            List1 lista = new List1();
            List2 lista2 = new List2();

            switch (position) {
                case 0:
                    Fragment1 fragment1 = new Fragment1();
                    return fragment1;
                case 1:
                    lista.setArguments(this.fragmentBundle);
                    return lista;
                case 2:
                    lista2.setArguments(this.fragmentBundle);
                    return lista2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
