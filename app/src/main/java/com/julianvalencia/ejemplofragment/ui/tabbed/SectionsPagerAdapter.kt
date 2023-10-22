package com.julianvalencia.ejemplofragment.ui.tabbed

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.julianvalencia.ejemplofragment.R
import com.julianvalencia.ejemplofragment.ui.batman.BatmanFragment
import com.julianvalencia.ejemplofragment.ui.flash.FlashFragment
import com.julianvalencia.ejemplofragment.ui.superman.SupermanFragment
import com.julianvalencia.ejemplofragment.ui.wonderwoman.WonderWomanFragment

private val TAB_TITLES = arrayOf(
    R.string.batman_name,
    R.string.flash_name,
    R.string.superman_name,
    R.string.wonder_woman_name
)

class SectionsPagerAdapter (private val context: Context, fm:FragmentManager) : FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> BatmanFragment()
            1 -> FlashFragment()
            2 -> SupermanFragment()
            else -> WonderWomanFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

}