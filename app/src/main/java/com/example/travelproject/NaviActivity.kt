import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.travelproject.*
import com.example.travelproject.databinding.ActivityNaviBinding

private const val TAG_HOME = "home_fragment"
private const val TAG_LOCATION = "location_fragment"
private const val TAG_MY_LIST = "my_list_fragment"
private const val TAG_SETTING="setting_fragment"

class NaviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.locationFragment -> setFragment(TAG_LOCATION, LocationFragment())
                R.id.myListFragment-> setFragment(TAG_MY_LIST, MyListFragment())
                R.id.settingFragment-> setFragment(TAG_SETTING, SettingFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME)
        val location = manager.findFragmentByTag(TAG_LOCATION)
        val mylist = manager.findFragmentByTag(TAG_MY_LIST)
        val setting = manager.findFragmentByTag(TAG_SETTING)

        if (home != null){
            fragTransaction.hide(home)
        }

        if (location != null){
            fragTransaction.hide(location)
        }

        if (mylist != null) {
            fragTransaction.hide(mylist)
        }

        if (setting != null) {
            fragTransaction.hide(setting)
        }

        if (tag == TAG_LOCATION) {
            if (location!=null){
                fragTransaction.show(location)
            }
        }
        else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        }

        else if (tag == TAG_MY_LIST){
            if (mylist != null){
                fragTransaction.show(mylist)
            }
        }
        else if (tag == TAG_SETTING) {
            if (setting!=null) {
                fragTransaction.show(setting)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}