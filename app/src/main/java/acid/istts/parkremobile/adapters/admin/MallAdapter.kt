package acid.istts.parkremobile.adapters.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.fragments.admin.AdminMallDetailFragment
import acid.istts.parkremobile.models.Mall
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

class MallAdapter(
    private val daftarmall : ArrayList<Mall>
): RecyclerView.Adapter<MallAdapter.customviewmall>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customviewmall {
        val itemView = LayoutInflater.from(parent.context)
        return MallAdapter.customviewmall(
            itemView.inflate(
                R.layout.admin_recyclerview_mall, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: customviewmall, position: Int) {
        val mll = daftarmall[position]
        holder.bind(mll)
    }

    override fun getItemCount(): Int {
        return daftarmall.size
    }

    class customviewmall(view : View) : RecyclerView.ViewHolder(view){
        private val Detailmall : Button = view.findViewById(R.id.DetailMall)
        private val Blockmall : Button = view.findViewById(R.id.BlockMall)
        private val tvnamamalladmin : TextView = view.findViewById(R.id.tvnamamalladmin)
        private val tvphonemalladmin : TextView = view.findViewById(R.id.tvphonemalladmin)
        private val tvaddresmalladmin : TextView = view.findViewById(R.id.tvaddresmalladmin)
        private val tvparkspaceadmin : TextView = view.findViewById(R.id.tvparkspaceadmin)
        private val tvreservespaceadmin : TextView = view.findViewById(R.id.tvreservespaceadmin)


        fun bind(ann: Mall) {
            Detailmall.setOnClickListener{
                val activity = it!!.context as AppCompatActivity
                val fragment = AdminMallDetailFragment()
                val transaction : FragmentTransaction = activity.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.framelayoutadmin, fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }
}