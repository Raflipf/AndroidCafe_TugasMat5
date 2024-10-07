package lat.pam.droidcafe

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import lat.pam.droidcafe.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment() : Fragment(), Parcelable {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //tambahkan bagian ini
        view.findViewById<ImageView>(R.id.donut)
            .setOnClickListener(View.OnClickListener {
                displayToast(getResources().getString(R.string.donut_order_message))
            })


        view.findViewById<ImageView>(R.id.ice_cream)
            .setOnClickListener(View.OnClickListener {
                displayToast(getString(R.string.ice_cream_order_message))
            })


        view.findViewById<ImageView>(R.id.froyo)
            .setOnClickListener(View.OnClickListener {
                displayToast(getString(R.string.froyo_order_message))
            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
    fun displayToast(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FirstFragment> {
        override fun createFromParcel(parcel: Parcel): FirstFragment {
            return FirstFragment(parcel)
        }

        override fun newArray(size: Int): Array<FirstFragment?> {
            return arrayOfNulls(size)
        }
    }

}